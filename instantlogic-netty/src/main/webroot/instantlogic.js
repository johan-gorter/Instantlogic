YUI.add('instantlogic', function (Y) {

	// Prettier url's
	Y.HistoryHash.encode = Y.HistoryHash.decode = function(str) {return str;};
	
    var ns = Y.namespace('instantlogic');

  ns.createBaseConfiguration = function (YUI) {
    return {
      fragmentNamespaces: [YUI.instantlogic.fragments, YUI.instantlogic.presence, YUI.instantlogic.designer, YUI.instantlogic.designer.diagram],
      createAnswer: YUI.instantlogic.answers.createAnswer
    };
  };
    
    ns.Engine = function (application, caseId, travelerId, presenceNode, placeNode, configuration) {
    	this.configuration = configuration;
    	this.application = application;
    	this.caseId = caseId;
    	this.presenceNode = presenceNode;
        this.placeNode = placeNode;
        this.travelerId = travelerId;
        if (!configuration.fragmentNamespaces || configuration.fragmentNamespaces.length == 0) Y.error('No fragment namespaces');
        Y.each(configuration.fragmentNamespaces, function (fns) {
            if (!fns) Y.error('Undefined namespace');
        });
        this.fragmentNamespaces = configuration.fragmentNamespaces;
        if (!configuration.createAnswer) {
        	Y.error('undefined createAnswer');
        }
        this.createAnswerFunction = configuration.createAnswer;
        this.state = 'not started';
        this.outstandingRequestCount = 0;
        this.outstandingRequests = {};
        this.messagesQueue = [];
        this.placeFragmentHolder = null;
        this.presenceFragmentHolder = null;

        var h = Y.html;
        
        
        this.oneMomentPleasePanel = 
        	h.div({className:'modal'}, 
	        	h.div({className:'modal-dialog modal-sm'}, 
    	        	h.div({className:'modal-content'},
				    	h.div({className:'modal-header'},
				    		h.h4({className:'modal-title'}, "One moment please...")
				    	)
			    	)
	        	)
        	);

        presenceNode.insert(this.oneMomentPleasePanel, 'before');
                
        this.errorPanel = 
        	h.div({className:'modal'}, 
	        	h.div({className:'modal-dialog modal-sm'}, 
    	        	h.div({className:'modal-content'},
	    	        	h.div({className:'modal-header'},
	    	        		h.h4({className:'modal-title'}, 'Error')
	    	        	),
    	        		h.div({className:'modal-body'}, 'Sorry, an error has occurred on the server')
    	        	)
	        	)
        	);
        
        presenceNode.insert(this.errorPanel, 'before');

    };

    ns.Engine.prototype = {
        // API
        start: function () {
        	this.history = new Y.HistoryHash();
        	this.history.on('locationChange', this.onLocationChange, this);
        	this.history.on('locationRemove', this.onLocationChange, this);
            this.location = null;
            this.presenceNode.setContent('One moment...');
            this.setState('connecting');
            this.sendStart(this.history.get('location'));
            var me = this;
            window.onbeforeunload = function() {
            	me.stop();
            };
            window.onerror = function(e) {
            	alert('Unexpected javascript error '+e);
              debugger;
            };
        },
        
        stop: function() {
        	this.setState('stopped');
        	for (var id in this.outstandingRequests) {
        		this.outstandingRequests[id].abort();
        		this.outstandingRequestCount--;
        	}
        	// TODO: send leave message immediately
        },
        
        onLocationChange: function(e) {
        	if (e.src !== Y.HistoryBase.SRC_ADD && e.src !== Y.HistoryBase.SRC_REPLACE && 
        			this.location != this.history.get('location')) {
        		this.sendStart(e.newVal);
        	}
        },

        recomposePlace: function () {
        	var model = this.placeFragmentHolder.fragment.model;
        	this.placeFragmentHolder.destroy();
        	var diff = new ns.Diff();
        	this.placeFragmentHolder.remove(diff);
        	diff.applyNow();
            this.placeFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, null, this);
            this.placeFragmentHolder.appendTo(this.placeNode);
            this.placeFragmentHolder.init(model);
        },

        // Private functions
        setState: function (state) {
            if (this.state == state) return;
            this.state = state;
            if (state == 'connected' || state == 'error') {
                this.oneMomentPleasePanel.hide();
            };
            if (state == 'connecting' || state == 'disconnected') {
                this.oneMomentPleasePanel.setStyle('display', 'block');
                this.placeNode.setContent('');
                if (this.placeFragmentHolder) {
                    this.placeFragmentHolder.destroy();
                    this.placeFragmentHolder = null;
                }
                this.presenceNode.setContent('');
                if (this.presenceFragmentHolder) {
                    this.presenceFragmentHolder.destroy();
                    this.presenceFragmentHolder = null;
                }
            }
            if (state == 'error') {
            	this.errorPanel.setStyle('display', 'block');
            } else {
            	this.errorPanel.hide();
            }
        },

        processUpdates: function (updates) {
            var messages = Y.JSON.parse(updates);
            for (var i = 0; i < messages.length; i++) {
                var message = messages[i];
                switch (message.name) {
                    case 'place':
                    	if (this.location!=message.location) {
	                    	this.location = message.location;
	                    	this.history.addValue('location', this.location);
                    	}
                        this.updatePlace(message.rootFragment);
                        break;
                    case 'presence':
                    	this.updatePresence(message.rootFragment);
                    	break;
                    case 'filesUpdated':
                        document.location.reload();
                        break;
                    case 'cssFilesUpdated':
                		var i,a,s;a=document.getElementsByTagName('link'); // Code taken from ReCSS
                		for(i=0;i<a.length;i++){
                			s=a[i];
                			if(s.rel.toLowerCase().indexOf('stylesheet')>=0&&s.href) {
                				var h=s.href.replace(/(&|%5C?)forceReload=\d+/,'');
                				s.href=h+(h.indexOf('?')>=0?'&':'?')+'forceReload='+(new Date().valueOf());
                			}
                		}
                        break;
                    case 'exception':
                    	this.setState('error');
                        break;
                    default:
                        Y.error('Unknown message ' + message.name);
                }
            }
        },

        updatePresence: function (model) {
            var diff = new ns.Diff();
            if (!this.presenceFragmentHolder) {
                this.presenceFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, null, this);
                this.presenceFragmentHolder.appendTo(this.presenceNode);
                this.presenceFragmentHolder.init(model);
                this.presenceFragmentHolder.registerNodesAsAdded(diff);
                diff.apply(false);
            } else {
                this.presenceFragmentHolder.update(model, diff);
                diff.apply(!this.configuration.noAnimation);
            }
        },

        updatePlace: function (model) {
            var diff = new ns.Diff();
            if (!this.placeFragmentHolder || this.placeFragmentHolder.id != model.id) {
                if (this.placeFragmentHolder) {
                    this.placeFragmentHolder.destroy();
                	this.placeFragmentHolder.remove(diff);
                }
                this.placeFragmentHolder = new Y.instantlogic.FragmentHolder(model.id, null, this);
                this.placeFragmentHolder.appendTo(this.placeNode);
                this.placeFragmentHolder.init(model);
                this.placeFragmentHolder.registerNodesAsAdded(diff);
                diff.apply(false);
                this.initializeFocus(this.placeNode);
            } else {
                this.placeFragmentHolder.update(model, diff);
                diff.apply(!this.configuration.noAnimation);
            }
        },

        createFragment: function (name, fragmentHolder, parentFragment, engine) {
        	if (!engine) Y.error();
            for (var i = 0; i < this.fragmentNamespaces.length; i++) {
                var fns = this.fragmentNamespaces[i];
                if (fns[name]) {
                    return new fns[name](fragmentHolder, parentFragment, engine || this);
                }
            }
            return new ns.MessageFragment(fragmentHolder, parentFragment, engine || this, 'No fragmentnamespace provides a fragment called ' + name, 'error');
        },
        
        createAnswer: function(model, parentNode, parentFragment, engine) {
        	return this.createAnswerFunction(model, parentNode, parentFragment, engine);
        },
        
        initializeFocus: function(node) {
        	var firstNode = node.one("input, select, textarea");
        	if (firstNode) {
        		firstNode.focus();
        	}
        },
        
        sendStart: function(location) {
    		this.enqueueMessage({message:'start', location: location});
        },
        
        sendSubmit: function(id) {
        	this.enqueueMessage({message:'submit', id:id});
        },
        
        sendChange: function(id, value) {
        	this.enqueueMessage({message:'change', id:id, value:value});
        },
        
        enqueueMessage: function(message) {
        	this.messagesQueue.push(message);
        	this.triggerMessagesTransport();
        },
        
        triggerMessagesTransport: function() {
        	if (this.state=='connected' || this.state=='connecting') {
	        	if (this.outstandingRequestCount<2) { // No more than 2 requests should be underway
	        		if (this.messagesQueue.length>0 || this.outstandingRequestCount==0) {
	        			this.transportMessages(); // Send a new (maybe empty) request
	        		}
	        	}
        	}
        },

        transportMessages: function () {
        	var messages = this.messagesQueue;
        	this.messagesQueue = [];
        	var data = (messages && messages.length>0) ? JSON.stringify(messages) : null;
        	var transaction = Y.io('/place?application='+this.application+'&case='+this.caseId+'&travelerId=' + travelerId, {
            	data: data,
                method: 'POST',
                on: {
                    success: function (transactionid, response) {
                    	this.outstandingRequestCount--;
                    	if (!this.outstandingRequests[transactionid]) Y.error();
                    	delete this.outstandingRequests[transactionid];
                        this.setState('connected');
                        this.processUpdates(response.responseText);
                        this.triggerMessagesTransport();
                    },
                    failure: function (transactionid, response) {
                    	this.outstandingRequestCount--;
                    	delete this.outstandingRequests[transactionid];
                        if (!response || !response.status || response.status > 600) {
                            this.setState('disconnected');
                            var me = this;
                        	setTimeout(function () {
                        		me.setState('connecting');
                        		me.sendStart(me.history.get('location')); 
                        	}, 300);
                        } else {
                        	this.setState('error');
                        }
                    }
                },
                context: this
            });
        	this.outstandingRequests[transaction.id]=transaction;
        	this.outstandingRequestCount++;
        }
    };

    // Diff
    ns.Diff = function () {
        this.nodesAdded = [];
        this.nodesToRemove = [];
        this.nodesUpdated = [];
    };

    ns.Diff.prototype = {
        nodeAdded: function (node) {
            this.nodesAdded.push(node);
        },
        nodeToRemove: function (node) {
            this.nodesToRemove.push(node);
        },
        nodeUpdated: function (node) {
            this.nodesUpdated.push(node);
        },
        apply: function(usingAnimation) {
        	if (usingAnimation) {
        		this.applyUsingAnimation();
        	} else {
        		this.applyNow();
        	}
        },
        applyNow: function () {
            for (var i = 0; i < this.nodesToRemove.length; i++) {
                this.nodesToRemove[i].remove(true);
            }
        },
        applyUsingAnimation: function() {
            var me = this;
        	// Deletes
            for (var i = 0; i < this.nodesToRemove.length; i++) {
            	this.scanNodeForRemoval(this.nodesToRemove[i]);
            }
            setTimeout(function(){
                for (var i = 0; i < me.nodesToRemove.length; i++) {
                	me.nodesToRemove[i].remove();
                }
            }, 1000);
            // Additions
            for (var i = 0; i < this.nodesAdded.length; i++) {
            	this.scanNodeForAdditions(this.nodesAdded[i]);
            }
        },
        scanNodeForRemoval: function(node) {
        	var deleteMe=true;
        	if (node.hasClass('animate-vertically')) {
				node.transition({duration:1, easing:'ease-out', height:0, opacity:0});
				deleteMe = false;
        	}
        	node.get('children').each(function(subNode) {
        		if (subNode.get('nodeType')!=1) {
        			subNode.remove();
        		} else { // An element
    				var deleteSubNode = this.scanNodeForRemoval(subNode);
    				if (deleteSubNode) {
    					subNode.remove();
    				} else {
    					deleteMe = false;
    				}
        		}
        	}, this);
    		return deleteMe;
        },
        scanNodeForAdditions: function(node) {
        	if (node.hasClass('animate-vertically')) {
        		var height = node.get('clientHeight');
        		var oldHeight = node.getStyle('height');
        	  node.setStyle('height', '0px');
        		node.transition({duration:1, easing:'ease-out', height:height+'px'}, function() {
        			node.setStyle('height', null);
        		});
        	} else {
            	node.get('children').each(function(subNode) {
            		if (subNode.get('nodeType')==1) {
            			this.scanNodeForAdditions(subNode);
            		}
            	}, this);
        	}
        },
        toString: function () {
            return 'Diff';
        }
    };

    // FragmentHolder
    ns.FragmentHolder = function (id, parentFragment, engine, options) {
    	if (!id) Y.error();
    	if (!engine) Y.error();
        this.id = id;
        this.engine = engine;
        this.parentFragment = parentFragment;
        this.options = options || {};
        this.fragment = null;
        this.startElement = document.createComment("fragment start "+id);
        this.endElement  = document.createComment("fragment end "+id);
    };

    ns.FragmentHolder.prototype = {
    		
    	appendTo: function(parentNode) {
    		// Must be called before init()
    		parentNode.appendChild(this.startElement);
    		parentNode.appendChild(this.endElement);
    	},
    	
    	insertBefore: function(fragmentHolder) {
    		// Must be called before init()
    		fragmentHolder.insertBeforeMe(this.endElement);
    		this.endElement.parentNode.insertBefore(this.startElement, this.endElement)
    	},
    	
    	clear: function(diff) {
    		var nextElement = this.startElement.nextSibling;
    		while (nextElement !== this.endElement) {
    			var element = nextElement;
    			nextElement = nextElement.nextSibling;
    			if (diff) {
    				diff.nodeToRemove(Y.one(element));
    			} else {
    				element.parentNode.removeChild(element);
    			}
    		} 
    	},
    	
    	remove: function(diff) {
    		this.clear(diff);
    		this.startElement.parentNode.removeChild(this.startElement);
    		this.endElement.parentNode.removeChild(this.endElement);
    	},
    	
    	insertBeforeMe: function(element) {
    		// Is only called from another FragmentHolder
    		this.startElement.parentNode.insertBefore(element, this.startElement);
    	},
    	
    	appendChild: function(node) {
    		// This is the only function that may be called from the Fragment within
    		Y.one(this.endElement.parentNode).insertBefore(node, this.endElement);
    	},
    	
        init: function (model) {
            this.fragmentType = model.type;
            if (this.engine.configuration.debug) this.addDebugTool();
            this.fragment = this.engine.createFragment(this.fragmentType, this, this.parentFragment, this.engine);
            this.fragment.init(model);
        },
        
        registerNodesAsAdded: function(diff) {
    		var nextElement = this.startElement.nextSibling;
    		while (nextElement !== this.endElement) {
    			var element = nextElement;
    			nextElement = nextElement.nextSibling;
    			diff.nodeAdded(Y.one(element));
    		} 
        },

        update: function (newModel, diff) {
        	this.fragment.oldModel = this.fragment.model;
            if (this.fragmentType != newModel.type || !this.fragment.canUpdateFrom(newModel)) {
                this.recreateFragment(newModel, diff);
            } else {
                this.fragment.update(newModel, diff);
            }
        },

        recreateFragment: function (newModel, diff) {
            this.fragment.destroy();
            this.clear(null);
            diff.nodeUpdated(Y.one(this.startElement.parentNode));
            this.fragment = this.engine.createFragment(newModel.type, this, this.parentFragment, this.engine);
            this.fragment.init(newModel);
        },

        destroy: function () {
        	// The nodes are purposely left behind for animation purposes
            this.fragment.destroy();
        },
        
        addDebugTool: function() {
        	var h = Y.html;
        	var button;
        	var openMenu;
        	var hoverMenu = false;
        	function checkMenuClose() {
        		setTimeout(function(){
	        		if (!debugTool.hasClass('hover') && !hoverMenu) { 
		        		if (openMenu) {
		        			debugTool.removeClass('openMenu');
		        			openMenu.destroy(true);
		        			openMenu = null;
		        		}
		        	}
        		});
        	}
        	var me = this;
        	var debugTool = 
        		h.div({className: 'fragment-debug'},
        			h.div({className: 'fragment-debug-info-outer'}, 
        				h.div({className: 'fragment-debug-info'}, this.fragmentType)
        			),
        			button = h.div({className: 'fragment-debug-button'}, this.fragmentType.substr(0,1).toLowerCase())
        		);
        	this.appendChild(debugTool);
        	if (this.fragmentType === 'Page') {
        		var engine = this.engine;
        		var dataExplorer = h.div({className: 'explore-data-button'}, h.span({className: 'inner'}, 'Explore data'));
        		dataExplorer.on('click', function(e) {
        			e.preventDefault();
        			e.stopPropagation();
        			var tail = ')';
        			var index = engine.location.lastIndexOf(':');
        			if (index>=0) {
        				tail = 'instance'+engine.location.substr(index);
        			}
        			engine.sendStart('_DataExplorer-explore('+tail);
        		});
        		Y.one(this.startElement).insert(dataExplorer, 'after');
        	}
        	button.on('hover', function() { debugTool.addClass('hover'); }, function() { debugTool.removeClass('hover'); checkMenuClose();});
        	button.on('click', function(e) {
    			e.preventDefault();
    			e.stopPropagation();
        		if (openMenu) {
        			debugTool.removeClass('openMenu');
        			openMenu.destroy(true);
        			openMenu = null;
        			return;
        		}
        		var logLink, locateLink, editLink, insertAboveLink, insertBelowLink, menuBody;
        		var appName = Y.one('.application-name').get('text');
        		var designerUrl = '?application=Designer&case='+appName+'#location=';
        		var id = me.id;
        		if (id.lastIndexOf('+')>=0) {
        			id = id.substr(id.lastIndexOf('+')+1);
        		}
        		var placeTemplateId = me.fragment.findAncestor('Page').model.placeTemplateId;
        		openMenu = new Y.Overlay({
        			bodyContent:
	        			menuBody = h.div({className: 'fragment-debug-menu'},
	        				h.ul(
	        					h.li(logLink = h.a({href:'#'}, 'Log fragment data')),
	        					h.li(locateLink = h.a({href:designerUrl+'PlaceTemplateDetails(PlaceTemplateDesign:'+placeTemplateId+')', target:'designer'}, 'Go to template')),
	        					h.li(editLink = h.a({href:designerUrl+'OpenEditor(ElementDesign:'+id+')', target:'designer'}, 'Edit')),
	        					/*h.li(insertAboveLink = h.a({href:'TODO', target:'designer'}, 'Insert above')),*/
	        					// TODO Insert inside: (start of) each fragmentList
	        					h.li(insertBelowLink = h.a({href:designerUrl+'InsertFragmentTemplateBelow(ElementDesign:'+id+')', target:'designer'}, 'Insert below'))
	        				)
	        			),
	        		align: {node: button, points: [Y.WidgetPositionAlign.TL, Y.WidgetPositionAlign.TR]},
	        		zIndex: 10001
	        	});
        		openMenu.render();
        		menuBody.on('hover', function() { hoverMenu = true; }, function(){hoverMenu=false;checkMenuClose();});
    			logLink.on('click', function(ev){
    				window.console.log('Fragment:', me.fragment.model);
    				window.console.log(JSON.stringify(me.fragment.model, null, ' '));
    				ev.preventDefault();
    				hoverMenu=false;
    				checkMenuClose();
    			});
    			debugTool.addClass('openMenu');
        	});
        },

        toString: function () {
            return 'FragmentHolder#' + this.id;
        }
    };

    // FragmentList
    ns.FragmentList = function (parentNode, parentFragment, engine, options) {
    	if (!engine) Y.error();
        this.engine = engine;
        this.parentFragment = parentFragment;
        this.parentNode = parentNode; // Note: ParentNode may be anything with an appendChild function (so also a FragmentHolder)
        this.options = options || {};
    };

    ns.FragmentList.prototype = {
        init: function (models) {
            if (!models) models = [];
            this.models = models;
            this.fragmentHolders = [];
            for (var i = 0; i < models.length; i++) {
                var fragmentHolder = new ns.FragmentHolder(models[i].id, this.parentFragment, this.engine, this.options.fragmentHolderOptions);
                fragmentHolder.appendTo(this.parentNode);
                fragmentHolder.init(models[i]);
                this.fragmentHolders.push(fragmentHolder);
            }
        },

        update: function (newModels, diff) {

            function indexOfModelWithId(models, id, start) {
                for (var i = start; i < models.length; i++) {
                    if (models[i].id == id) {
                        return i;
                    }
                }
                return -1;
            };
            
            if (!newModels) newModels = [];
            if (this.models.length != this.fragmentHolders.length) {
                throw new Error('model/fragments mismatch');
            }
            var oldModels = this.models;
            this.models = newModels;
            var oldIndex = 0;
            var newIndex = 0;
            var i;
            while (newIndex < newModels.length) {
                var oldModel = (oldIndex < oldModels.length) ? oldModels[oldIndex] : {};
                var newModel = newModels[newIndex];
                if (oldModel.id != newModel.id) {
                    var findOldIndex = indexOfModelWithId(oldModels, newModel.id, oldIndex + 1);
                    if (findOldIndex >= 0) {
                        // remove child fragments
                        for (i = newIndex; i < newIndex + findOldIndex - oldIndex; i++) {
                            this.fragmentHolders[i].destroy();
                        	this.fragmentHolders[i].remove(diff);
                        }
                        this.fragmentHolders.splice(newIndex, findOldIndex - oldIndex);
                        oldIndex = findOldIndex + 1;
                        this.fragmentHolders[newIndex].update(newModel, diff);
                    } else {
                        // New fragmentHolder
                        var fragmentHolder = new ns.FragmentHolder(newModel.id, this.parentFragment, this.engine, this.options.fragmentHolderOptions);
                        this.fragmentHolders.splice(newIndex, 0, fragmentHolder);
                        if (this.fragmentHolders.length > newIndex + 1) {
                        	fragmentHolder.insertBefore(this.fragmentHolders[newIndex + 1]);
                        } else {
                        	fragmentHolder.appendTo(this.parentNode);
                        }
                        fragmentHolder.init(newModel);
                        fragmentHolder.registerNodesAsAdded(diff);
                    }
                } else {
                    this.fragmentHolders[newIndex].update(newModel, diff);
                    oldIndex++;
                }
                newIndex++;
            }
            if (this.fragmentHolders.length > newIndex) {
                // Remove child fragments
                for (i = newIndex; i < this.fragmentHolders.length; i++) {
                    this.fragmentHolders[i].destroy();
                    this.fragmentHolders[i].remove(diff);
                }
                this.fragmentHolders.length = newIndex;
            }
        },

        destroy: function () {
            for (var i = 0; i < this.fragmentHolders.length; i++) {
                this.fragmentHolders[i].destroy();
            }
        },

        toString: function () {
            return 'FragmentList';
        }
    };

    // Fragment
    ns.Fragment = function (fragmentHolder, parentFragment, engine) {
    	if (!fragmentHolder) Y.error();
    	if (!engine) Y.error();
        this.engine = engine;
        this.parentFragment = parentFragment;
        this.oldModel = {};
        this.parentNode = fragmentHolder; // deprecated
        this.fragmentHolder = fragmentHolder;
        this.model = null;
    };

    ns.Fragment.prototype = {
        init: function (model) {
            this.model = model;
        },

        canUpdateFrom: function (newModel) {
            return this.model.type == newModel.type;
        },

        update: function (newModel, diff) {
            this.oldModel = this.model;
            this.model = newModel;
        },
        
        findAncestor: function(fragmentTypeName) {
        	if (this.model!=null && this.model.type == fragmentTypeName) {
        		return this;
        	}
        	if (this.parentFragment) {
        		return this.parentFragment.findAncestor(fragmentTypeName);
        	}
        	return null;
        },

        // Remove listeners, but leave the dom-tree intact
        destroy: function () {
        }
    };
    
    // Extends Fragment, is used as part of an Input
    ns.Answer = function(parentNode, parentFragment, engine) {
    	ns.Answer.superclass.constructor.apply(this, arguments);
    };
    Y.extend(ns.Answer, ns.Fragment, {
    	init: function(model) {
    		ns.Answer.superclass.init.call(this, model);
    		this.markup = this.createMarkup();
    		if (!this.markup) Y.error('no markup');
    		this.markup.setAttribute('data-fragment-id', model.id);
    		this.parentNode.appendChild(this.markup);
        	this.updateValue(model.value); // Convenient
        	if (model.readOnly) this.updateReadOnly(true);
    		if (model.styleNames) {
    			for (var i=0;i<model.styleNames.length;i++) {
    				var name = model.styleNames[i];
    				if (name.substr(0,7)=='answer-') {
    					this.markup.removeClass(name);
    					this.markup.addClass(name.substr(7));
    				}
    			}
    		}
    	},
    	update: function(newModel, diff) {
    		ns.Answer.superclass.update.call(this, newModel, diff);
    		if (this.oldModel.value!=newModel.value) {
    			this.updateValue(newModel.value);
    		}
    		if (this.oldModel.readOnly!=newModel.readOnly) {
    			this.updateReadOnly(newModel.readOnly);
    		}
    		if (!ns.util.arrayEquals(this.oldModel.styleNames, newModel.styleNames)) {
	    		if (this.oldModel.styleNames) {
	    			for (var i=0;i<this.oldModel.styleNames.length;i++) {
	    				var name = this.oldModel.styleNames[i];
	    				if (name.substr(0,7)=='answer-') {
	    					this.markup.removeClass(name.substr(7));
	    				}
	    			}
	    		}
	    		if (newModel.styleNames) {
	    			for (var i=0;i<newModel.styleNames.length;i++) {
	    				var name = newModel.styleNames[i];
	    				if (name.substr(0,7)=='answer-') {
	    					this.markup.removeClass(name);	    					
	    					this.markup.addClass(name.substr(7));
	    				}
	    			}
	    		}
	    		diff.nodeUpdated(this.markup);
    		}
    	},
    	updateReadOnly:function(readOnly) {
    		// only works if this.input is set to an input node, otherwise, override this method
    		if (this.input && this.input.set) {
    			if (readOnly) {
    				this.input.set("disabled", "disabled");
    			} else {
    				this.input.set("disabled", null);
    			}
    		}
    	},
    	createMarkup: function() {
    		Y.error('not implemented');
    	},
    	// Should update the markup to reflect the new value
    	updateValue: function(newValue) {
    		Y.error('not implemented');
    	},
    	getValue: function() {
    		Y.error('not implemented');
    	}
    });
    
    ns.MessageFragment = function (parentNode, parentFragment, engine, message, messageclassName) {
        ns.MessageFragment.superclass.constructor.apply(this, arguments);
        this.message = message;
        this.messageclassName = messageclassName;
    };

    Y.extend(ns.MessageFragment, ns.Fragment, {
        init: function (model) {
        	ns.MessageFragment.superclass.init.call(this, model);
        	var markup = Y.html.div({className:'message '+this.messageclassName}, 
        		Y.html.div({className:'icon'}),
        		Y.html.p(this.message)
        	);
        	this.parentNode.appendChild(markup);
        },
        
        canUpdateFrom: function (newModel) {
        	return false;
        }
    });
    
    /*
     * Create a subclass of Fragment or one of its subclasses, the options parameter can contain the following:
     * - baseClass: optional, choose another baseClass than Y.instantlogic.Fragment
     * - overrides: optional, object containing methods to be overridden in/added to the baseClass 
     * - createMarkup: function for creating the markup, this markup will be appended to this.parentNode
     * - texts: function(model), optional, must return an array of tuples with [0]: the div from the markup
     * and [1]: the text from the model to render there
     * - styles: function(model), optional, must return an array of triples with [0]: the div from the markup
     * [1] the css property and [2]: the value for this property
     * - fragmentLists: function(model), optional, must return an array of tuples with [0]: the div from the markup 
     * and [1]: the list of elements in the model to render there
     * - postInit: function(model), optional, runs after the init phase has been completed
     * - postUpdate: function(newModel, diff), optional, runs after the update phase has been completed
     * - destroy: function(), called when the fragment is destoyed
     * */
    ns.createFragment = function(options) {
      var constructor = function (fragmentHolder, parentFragment, engine) {
        constructor.superclass.constructor.apply(this, arguments);
        this.statePerSubclass = { next: this.statePerSubclass };
      };
    	Y.extend(constructor, options.baseClass || Y.instantlogic.Fragment, options.overrides);
    	
    	constructor.prototype.init = function(model, nextState) {
    		var state = nextState || this.statePerSubclass;
    		constructor.superclass.init.call(this, model, state.next);
    		if (options.createMarkup) {
    			if (this.markup!=null) {
    				this.markup.remove();
    			}
	    		this.markup = options.createMarkup.apply(this);
	    		if (model.styleNames) {
	    			for (var i=0;i<model.styleNames.length;i++) {
	    				this.markup.addClass(model.styleNames[i]);
	    			}
	    		}
	    		this.fragmentHolder.appendChild(this.markup);
    		}
    		if (options.fragmentLists) {
    			state.fragmentLists = []; // Scope: this subclass only
    			var results = options.fragmentLists.call(this, model);
    			for (var i=0;i<results.length;i++) {
    				var list = new ns.FragmentList(results[i][0], this, this.engine, results[i][2]);
    				list.init(results[i][1]);
    				state.fragmentLists.push(list);
    			}
    		}
    		if (options.texts) {
    			var results = options.texts.call(this, model);
    			for (var i=0;i<results.length;i++) {
    				var text = results[i][1];
    				if (text==null) text = '';
    				results[i][0].set('text', text);
    			}
    		}
    		if (options.styles) {
    			var results = options.styles.call(this, model);
    			for (var i=0;i<results.length;i++) {
    				var value = results[i][2];
    				results[i][0].setStyle(results[i][1], value);
    			}
    		}
    		if (options.postInit) {
    			options.postInit.call(this, model);
    		}
    	};

      constructor.prototype.update = function (newModel, diff, nextState) {
        var state = nextState || this.statePerSubclass;
        constructor.superclass.update.call(this, newModel, diff, state.next);
        if(state.fragmentLists) {
          var results = options.fragmentLists.call(this, newModel);
          for(var i = 0; i < results.length; i++) {
            state.fragmentLists[i].update(results[i][1], diff);
          }
        }
        if(options.texts) {
          var newResults = options.texts.call(this, newModel);
          var oldResults = options.texts.call(this, this.oldModel);
          for(var i = 0; i < newResults.length; i++) {
            if(newResults[i][1] != oldResults[i][1]) {
              newResults[i][0].set('text', newResults[i][1] || '');
            }
          }
        }
        if(options.styles) {
            var newResults = options.styles.call(this, newModel);
            var oldResults = options.styles.call(this, this.oldModel);
            for(var i = 0; i < newResults.length; i++) {
              if(newResults[i][2] != oldResults[i][2]) {
                newResults[i][0].setStyle(newResults[i][1], newResults[i][2]);
              }
            }
          }
        if(!ns.util.arrayEquals(this.oldModel.styleNames, newModel.styleNames)) {
          if(this.oldModel.styleNames) {
            for(var i = 0; i < this.oldModel.styleNames.length; i++) {
              this.markup.removeClass(this.oldModel.styleNames[i]);
            }
          }
          if(newModel.styleNames) {
            for(var i = 0; i < newModel.styleNames.length; i++) {
              this.markup.addClass(newModel.styleNames[i]);
            }
          }
          diff.nodeUpdated(this.markup);
        }
        if(options.postUpdate) {
          options.postUpdate.call(this, newModel, diff);
        }
      };

    	constructor.prototype.destroy = function(nextState) {
    		if (options.destroy) {
    			options.destroy.call(this);
    		}    		
    		var state = nextState || this.statePerSubclass;
    		constructor.superclass.destroy.call(this, state.next);
    		if (state.fragmentLists) {
    			for (var i=0;i<this.fragmentLists;i++) {
    				state.fragmentLists[i].destroy();
    			}
    		}
    	};
    	
    	return constructor;
    };
    
    ns.util = {
    	// Shallow equals on all properties of an array
    	arrayEquals: function(a1, a2) {
    		if (a1==null) return (a2==null);
    		if (a2==null) return false;
    		if (a1.length!=a2.length) return false;
    		for (var i=0;i<a1.length;i++) {
    			if (a1[i]!=a2[i]) return false;
    		}
    		return true;
    	},

    	// Checks deep equality for two data(json) objects
    	equals: function(x, y) {
		  if(x === y) return true;
		  if(!(x instanceof Object) || !(y instanceof Object)) return false;
		  for(var p in x) {
		    if(!x.hasOwnProperty(p)) continue;
		    if(!y.hasOwnProperty(p)) return false;
		    if(x[p] === y[p]) continue;
		    if(typeof(x[p]) !== "object") return false;
		    if(!ns.util.equals(x[p], y[p])) return false;
		  }
		  for(p in y) {
		    if(y.hasOwnProperty(p) && !x.hasOwnProperty(p)) return false;
		  }
		  return true;
		}
    };
    
}, '0.7.0', { requires: ['io-base', 'node', 'oop', 'json', 'event', 'html', 'history', 'transition', 'widget-position-align','overlay'] });