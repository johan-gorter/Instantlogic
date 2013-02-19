YUI.add('instantlogic-presence', function (Y) {

    var ns = Y.namespace('instantlogic.presence');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // Presence
    ns.Presence = function (parentNode, parentFragment, engine) {
        ns.Presence.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Presence, Y.instantlogic.Fragment, {
    	init: function(model) {
            ns.Presence.superclass.init.call(this, model);
            var markup = html.div({ className: 'navbar navbar-inverse navbar-fixed-top' },
            	html.div({className: 'navbar-inner'},
            		html.div({className:'container'},
	            		html.p({className: 'navbar-text pull-left'},
	            			this.applicationNameSpan = html.span({className: 'application-name'}, model.applicationName || ''),
		            		html.span({className: 'minus'}, ' - '),
		            		html.span({className: 'case-name'},
		            			this.caseNameSpan = html.span(model.caseName || '')
		            		)
	            		)
        			),
            		this.contentDiv = html.p({className: 'navbar-text top-right'})
                )
            );
            this.parentNode.appendChild(markup);
            
            this.contentFragmentList = new FragmentList(this.contentDiv, this, this.engine);
            this.contentFragmentList.init(model.content);
    	},
    	
    	update: function (newModel, diff) {
    		ns.Presence.superclass.update.call(this, newModel, diff);
    		if (this.oldModel.caseName != newModel.caseName) {
    			this.caseNameSpan.set('text', newModel.caseName);
    		}

            ns.Presence.superclass.update.call(this, newModel, diff);
            this.contentFragmentList.update(newModel.content, diff);
    	}
    });
    
    // Me
    ns.Me = function (parentNode, parentFragment, engine) {
        ns.Me.superclass.constructor.apply(this, arguments);
    };
    
    Y.extend(ns.Me, Y.instantlogic.Fragment, {
    	init: function(model) {
    		ns.Me.superclass.init.call(this, model);
    		var markup = html.span({className: 'me'},
				this.avatarDiv = html.span({className: 'avatar'}, html.img({src: model.avatarUrl, width:'23px', height:'23px;'})),
				this.loginNameSpan = html.span({className: 'username'}, model.name || ''),
				this.logoutButton = html.a({className: 'btn btn-inverse'}, 'Log out')
    		)
    		this.logoutButton.on('click', this.logoutClick, this);
    		this.parentNode.appendChild(markup);
    	},
    	logoutClick: function(evt) {
    		this.engine.enqueueMessage({message: 'presence', command: 'logout'});
    		evt.preventDefault();
    	}
    });
    
    // Communicator
    ns.Communicator = Y.instantlogic.createFragment({
    	createMarkup: function() {
    		var markup = html.span(
    			html.div({className:'communicator-space'}),
    			this.communicatorDiv = html.div({className:'communicator'},
    				html.ul({className:'nav'},
    					this.dropdown = html.li({className:'dropdown'},
			    			this.showButton = html.a({className:'dropdown-toggle'},'Communicator ', html.b({className:'caret'})),
			    			this.hideButton = html.a({className:'dropdown-toggle'},'Communicator ', html.b({className:'caret'})),
			    			this.usersDiv = html.div()
			    		)
			    	)
	    		)
	    	);
    		this.showButton.on('click', this.onShowClick, this);
    		this.hideButton.on('click', this.onHideClick, this);
    		this.usersDiv.hide();
    		this.hideButton.hide();
            return markup;
    	},
    	fragmentLists: function(model) {
    		return [[this.usersDiv, model.users]];
    	},
    	postInit: function(model) {
    		this.engine.communicator = this;
    	},
    	postUpdate: function(newModel, diff) {
    		for (var i=0;i<this.subscribers.length;i++) {
    			this.subscribers[i]();
    		}
    	},
    	overrides: {
    		subscribers : [],
        	onHideClick: function() {
        		this.dropdown.removeClass('active');
        		this.communicatorDiv.setStyle('height', '40px');
        		this.communicatorDiv.setStyle('background-color', null);
        		this.hideButton.hide();
        		this.showButton.show();
        		this.usersDiv.hide();
        	},
        	onShowClick: function() {
        		this.dropdown.addClass('active');
        		this.communicatorDiv.setStyle('height', '100%');
        		this.communicatorDiv.setStyle('background-color', '#111');
        		this.showButton.hide();
        		this.hideButton.show();
        		this.usersDiv.show();
        	},
        	findTravelersInPlace: function(instanceId) { // returns list of objects who are visiting a place which contains the instanceId
        		var result = [];
        		var placeUrlSubstring = '/'+instanceId+'/';
        		for (var i=0;i<this.model.users.length;i++) {
        			var user = this.model.users[i];
        			for (var ii=0;ii<user.travelers.length;ii++) {
        				var traveler = user.travelers[ii];
        				if (traveler.placeUrl.indexOf(placeUrlSubstring)>=0) {
        					result.push({username: user.username, name: user.name, avatarUrl: user.avatarUrl});
        				}
        			}
        		}
        		return result;
        	},
        	subscribe: function(callback) {
        		this.subscribers.push(callback);
        	},
        	unsubscribe: function(callback) {
        		this.subscribers.splice(subscribers.indexOf(callback),1);
        	},
        	destroy: function() {
        		this.engine.communicator = null;
        	}
    	}
    });

    // User
    ns.User = Y.instantlogic.createFragment({ 
    	createMarkup: function() {
    		return html.div({className:'user'},
    			this.usernameDiv = html.div({className:'username'}),
    			this.travelersDiv = html.div({className: 'travelers'})
    		);
    	},
    	texts: function(model) {
    		return [[this.usernameDiv, model.username]];
    	},
    	fragmentLists: function(model) {
    		return [[this.travelersDiv, model.travelers]];
    	}
    });

    // Traveler
    ns.Traveler = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		return html.div({className:'traveler'},
    			this.link = html.a({href:'#'})
    		)
    	},
    	texts: function(model) {
    		return [[this.link, model.placeTitle]];
    	},
    	postInit: function(model) {
    		this.link.set('href', '#location='+model.placeUrl);
    	},
    	postUpdate: function(newModel, diff) {
    		if (this.oldModel.placeUrl!=newModel.placeUrl) {
    			this.link.set('href', '#location='+newModel.placeUrl);
    		}
    	}
    	
    });
    
    // Avatar
    ns.Avatar = Y.instantlogic.createFragment({
    	createMarkup: function() {
    		return html.span(
    			this.avatarDiv = html.div({className:'floating-avatar'}),
    			this.pointerDiv = html.div({className:'floating-pointer'},
        			html.div({className:'arrow-top'}),
        			html.div({className:'arrow-bottom'})
    			)
    		);
    	},
    	postInit: function(model) {
    		this.updateAvatarImage(model);
    		var me = this;
    		setTimeout(function(){me.positionAvatar(false);})
    	},
    	postUpdate: function(newModel, diff) {
    		if (this.oldModel.username != newModel.username) {
    			this.updateAvatarImage(newModel);
    		}
    		var me = this;
    		setTimeout(function(){me.positionAvatar(true);})
    	},
    	overrides: {
    		updateAvatarImage: function(model) {
    			this.avatarDiv.get('children').remove();
        		this.avatarDiv.appendChild(
        			html.img({src:(model.avatarUrl || '/avatar/anonymous.jpg'), width:'50px', height:'50px;'})
        		);
    		},
    		positionAvatar: function(useAnimation) {
    			var x = 830;
    			var y = 50;
    			var page = Y.one('.page');
    			if (page) {
    				var region = page.get('region');
    				x = region.right-80;
    				y=region.top+50;
    			}
    			if (this.model.focus) {
    				var node = Y.one('[data-fragment-id="'+this.model.focus+'"]');
    				if (node && node.get('firstChild')) {
    					var region = node.get('firstChild').get('region');
    					y = region.top;
    				}
    			}
    			// TODO: change X if other avatars are also at the same Y
    			if (useAnimation) {
    				this.avatarDiv.transition({duration:0.5, easing:'ease-out', left: (x+2)+'px', top: (y-10)+'px'});    				
    				this.pointerDiv.transition({duration:0.5, easing:'ease-out', left: x+'px', top: (y-12)+'px'});    				
    			} else {
					this.avatarDiv.setStyle('left',(x+2)+'px');
					this.avatarDiv.setStyle('top', (y-10)+'px');
					this.pointerDiv.setStyle('left',x+'px');
					this.pointerDiv.setStyle('top',(y-12)+'px');
    			}
    		}
    	}
    });
    
    ns.DebugVisibleToggle = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		var markup = html.form({ action: '.', className: 'form-inline debug-visible' },
    			html.label({className:'checkbox'},
    				this.input = html.input({type:'checkbox'}), 'Debug'
    			)
    		);
    		this.input.on('change', this.inputChange, this);
    		return markup;
    	},
    	postInit: function(model) {
    		this.input.set('checked', model.value);
    		this.setDebug(model.value);
    	},
    	postUpdate: function(newModel, diff) {
    		if (newModel.value!=this.oldModel.value) {
    			this.input.set('checked', newModel.value);
        		this.setDebug(newModel.value);
    		}
    	},
    	overrides: {
            inputChange: function() {
            	this.engine.enqueueMessage({message: 'presence', command: 'setDebugVisible', value: this.input.get('checked')});
            },
            setDebug:function(newValue) {
            	var engine = this.engine;
            	if (engine.configuration.debug!=newValue) {
            		engine.configuration.debug = newValue;
            		setTimeout(function(){
            			engine.recomposePlace();
            		});
            	}
            }
    	}
    }); 
    
    // Login
    ns.Login = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		var markup = html.form({ action: '.', className: 'form-inline' },
//    			html.div({className:'input-append'},
					this.usernameInput = html.input({type:'text'}),
					this.loginButton = html.button({className:'btn'}, 'Login')
//				)
    		);
    		this.loginButton.on('click', this.loginClick, this);
    		return markup;
    	},
    	overrides: {
        	loginClick: function(evt) {
        		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
        		evt.preventDefault();
        	}
    	}
    });

    // LoginOld
    ns.LoginOld = function(parentNode, parentFragment, engine) {
    	ns.LoginOld.superclass.constructor.apply(this, arguments);
    }
    
    Y.extend(ns.LoginOld, Y.instantlogic.Fragment, {
    	init: function(model) {
    		ns.LoginOld.superclass.init.call(this, model);
    		var markup = html.div({className: 'login'},
				html.div({className: 'window'},
					html.h2('Please login'),
	    			html.div({className: 'input'},
		    			html.div({className: 'question'}, 'Username'),
		    			html.div({className: 'answer'},
		    				this.usernameInput = html.input({type: 'text'})
		    			)
	    			),
	    			html.div({className: 'buttons'},
	    				this.loginButton = html.button('Login')
	    			)
	    		)
    		);
    		this.loginButton.on('click', this.loginClick, this);
    	},
    	
    	loginClick: function() {
    		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
    	}
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });