YUI.add('instantlogic-presence', function (Y) {

    var ns = Y.namespace('instantlogic.presence');
    var html = Y.html;
    var util = Y.instantlogic.util;
    var FragmentList = Y.instantlogic.FragmentList;

    // Presence
    ns.Presence = function (parentNode, parentFragment, engine) {
        ns.Presence.superclass.constructor.apply(this, arguments);
    };

    Y.extend(ns.Presence, Y.instantlogic.Fragment, {
    	init: function(model) {
            ns.Presence.superclass.init.call(this, model);
            var markup = html.nav({ className: 'navbar navbar-inverse navbar-static-top' },
        		html.div({className:'container'},
            		html.div({className: 'navbar-header'},
            			this.homeLink = html.a({className: 'navbar-brand', href: '#'}, 
            				this.applicationNameSpan = html.span({className: 'application-name'}, model.applicationName || ''),
            				html.span(' - '),
            				this.caseNameSpan = html.span({className: 'case-name'}, model.caseName || '')
            			)
            		)
    			),
        		this.contentDiv = html.div({className: 'collapse navbar-collapse top-right'})
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
    		this.model = model;
    		ns.Me.superclass.init.call(this, model);
    		this.parentNode.appendChild(html.p({className: 'navbar-text navbar-left me'},
    			html.span('Logged in as: '),
    			html.img({className: 'avatar', src: model.avatarUrl, width:'23px', height:'23px;'}),
    			this.loginNameSpan = html.span({className: 'username'}, model.name || ''),
    			this.logoutButton = html.a({className: ''}, 'Log out')
    		));
    		this.logoutButton.on('click', this.logoutClick, this);
    	},
    	logoutClick: function(evt) {
    		this.engine.enqueueMessage({message: 'presence', command: 'logout'});
    		evt.preventDefault();
    	}
    });
    
    // Communicator
    ns.Communicator = Y.instantlogic.createFragment({
    	createMarkup: function() {
            var markup = html.ul({className: 'nav navbar-nav navbar-left'},
            	this.dropdown = html.li({className: 'communicator dropdown'},
                	this.usersDiv = html.div({className:'communicator-userlist'}),
            		this.showHideButton = html.a({href: '#', className:'dropdown-toggle'}, 'Communicator ', html.b({className:'caret'}))
            	)
            );
            this.visible = false;
    		this.showHideButton.on('click', this.onShowHideClick, this);
    		this.usersDiv.hide();
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
        	onShowHideClick: function(evt) {
        		this.visible = !this.visible;
        		if (this.visible) {
            		this.dropdown.addClass('active');
            		this.usersDiv.show();
        		} else {
            		this.dropdown.removeClass('active');
            		this.usersDiv.hide();
        		}
        		evt.preventDefault();
        	},
        	findTravelersInPlace: function(instanceId) { // returns list of objects who are visiting a place which contains the instanceId
        		var result = [];
        		var placeUrlSubstring = ':'+instanceId;
        		for (var i=0;i<this.model.users.length;i++) {
        			var user = this.model.users[i];
        			for (var ii=0;ii<user.travelers.length;ii++) {
        				var traveler = user.travelers[ii];
        				if (traveler.place && traveler.place.url.indexOf(placeUrlSubstring)>=0) {
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
    			this.avatarImg = html.img({className: 'avatar', width:'23px', height:'23px;'}),
    			this.usernameDiv = html.div({className:'username'}),
    			this.travelersDiv = html.div({className: 'travelers'})
    		);
    	},
    	postInit: function(model) {
    		this.avatarImg.set('src', model.avatarUrl);
    	},
    	postUpdate: function(newModel, diff) {
    		if (newModel.avatarUrl !== this.oldModel.avatarUrl) {
    			this.avatarImg.set('src', newModel.avatarUrl);
    		}
    	},
    	texts: function(model) {
    		return [[this.usernameDiv, model.name]];
    	},
    	fragmentLists: function(model) {
    		return [[this.travelersDiv, model.travelers]];
    	}
    });

    var getUrl = function(place) {
    	return place?place.url:null;
    };
    
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
    		this.link.set('href', '#location='+getUrl(model.place));
    	},
    	postUpdate: function(newModel, diff) {
    		if (getUrl(this.oldModel.place)!=getUrl(newModel.place)) {
    			this.link.set('href', '#location='+getUrl(newModel.place));
    		}
    	}
    	
    });
    
    // Avatar
    ns.Avatar = Y.instantlogic.createFragment({
    	createMarkup: function() {
    		return this.focusBar = html.div({className:'focus-bar'},
    			this.avatarDiv = html.div({className:'floating-avatar'}),
    			this.pointerDiv = html.div({className:'floating-pointer'},
        			html.div({className:'arrow-top'}),
        			html.div({className:'arrow-bottom'})
    			)
    		);
    	},
    	postInit: function(model) {
    		if (model.isMe === true) {
    			this.focusBar.addClass('me');
    		}
    		this.updateAvatarImage(model);
    		var me = this;
    		setTimeout(function(){me.positionAvatar(false);})
    		this.resizeSubscription = Y.on('windowresize', function(e) {
    			me.positionAvatar(false);
    		});
    	},
    	postUpdate: function(newModel, diff) {
    		if (this.oldModel.username != newModel.username) {
    			this.updateAvatarImage(newModel);
    		}
    		var me = this;
    		setTimeout(function(){me.positionAvatar(true);})
    	},
    	destroy: function() {
    		this.resizeSubscription.detach();
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
    				this.focusBar.transition({duration:0.3, easing:'ease-out', top: (y-14)+'px'})
    				this.avatarDiv.transition({duration:0.3, easing:'ease-out', left: (x+2)+'px' /*, top: (y-10)+'px' */});    				
    				this.pointerDiv.transition({duration:0.3, easing:'ease-out', left: x+'px' /*, top: (y-12)+'px' */});    				
    			} else {
    				this.focusBar.setStyle('top', (y-14)+'px');
					this.avatarDiv.setStyle('left',(x+2)+'px');
//					this.avatarDiv.setStyle('top', (y-10)+'px');
					this.pointerDiv.setStyle('left',x+'px');
//					this.pointerDiv.setStyle('top',(y-12)+'px');
    			}
    		}
    	}
    });
    
    ns.ToggleBookmarks = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		this.button = html.a({className: ''}, 'Bookmarks');
    		this.button.on("click", this.click, this);
    		return html.ul({className: 'nav navbar-nav  navbar-left'}, html.li(this.button));
    	},
    	overrides: {
	    	click: function(evt) {
	    		this.engine.enqueueMessage({message: 'presence', command: 'toggleBookmarks'});
	    		evt.preventDefault();
	    	}
    	}
    });
    
    ns.BookmarksPopup = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		this.markup = html.div({className: 'modal'}, 
	    		html.div({className: 'modal-dialog'},
	    			html.div({className: 'modal-content'},
    	    			html.div({className: 'modal-body'},
    	    				this.addButton = html.button({className:'btn btn-primary bookmark-add'}, 
    	    					'Add bookmark: ', 
    	    					this.currentPlaceTitleSpan = html.span()
    	    				),
    	    				this.bookmarksDiv = html.div()
    	    			)
	    			)
	    		)
    		);
    		this.markup.on("click", this.markupClicked, this);
    		this.markup.setStyle("display", "block");
    		this.addButton.on("click", this.addClicked, this);
    		return this.markup;
    	},
    	texts: function(model) {
    		return [[this.currentPlaceTitleSpan, model.currentPlaceTitle]];
    	},
    	postInit: function(model) {
    		this.renderBookmarks(model.bookmarksData);
    	},
    	postUpdate: function(newModel) {
    		if (!util.equals(this.oldModel.bookmarksData, newModel.bookmarksData)) {
    			this.bookmarksDiv.empty();
    			this.renderBookmarks(newModel.bookmarksData);
    		}
    	},
    	overrides: {
    		markupClicked: function(evt) {
    			var linkTo = evt.target.get('href');
				this.engine.enqueueMessage({message: 'presence', command: 'toggleBookmarks'});
    			if (!linkTo) {
    				evt.preventDefault();
    			}
	    	},
	    	addClicked: function(evt) {
	    		this.engine.enqueueMessage({message: 'presence', command: 'addBookmark'});
	    		evt.preventDefault();
	    	},
	    	renderBookmarks: function(data) {
	    		var me = this;
	    		data.forEach(function(bookmark, index) {
	    			var removeLink;
	    			var bookmarkDiv = html.div({className: 'bookmark'},
	    				html.a({href:'#location='+bookmark.url}, bookmark.title),
	    				removeLink = html.a({className: 'bookmark-remove'}, 'Remove')
	    			)
					removeLink.on('click', function(evt){
			    		me.engine.enqueueMessage({message: 'presence', command: 'removeBookmark', value: index});
			    		evt.preventDefault();
			    		evt.stopPropagation();
					});
	    			me.bookmarksDiv.append(bookmarkDiv);
	    		}, this);
	    	}
    	}
    });
    
    ns.DebugVisibleToggle = Y.instantlogic.createFragment({
    	createMarkup: function(model) {
    		this.button = html.a({className: ''}, 'Debug');
    		this.button.on("click", this.click, this);
    		return html.ul({className: 'nav navbar-nav  navbar-left'}, 
    			this.li = html.li(this.button)
    		);    		
    	},
    	postInit: function(model) {
    		if (model.value) {
    			this.li.addClass('active');
    		}
    		this.setDebug(model.value);
    	},
    	postUpdate: function(newModel, diff) {
    		if (newModel.value!=this.oldModel.value) {
    			if (newModel.value) {
    				this.li.addClass('active');
    			} else {
    				this.li.removeClass('active');
    			}
        		this.setDebug(newModel.value);
    		}
    	},
    	overrides: {
            click: function() {
            	this.engine.enqueueMessage({message: 'presence', command: 'setDebugVisible', value: !this.model.value});
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
    	createMarkup: function() {
    		var markup = html.form({ action: '.', className: 'form-inline' },
//    			html.div({className:'input-append'},
					this.usernameInput = html.input({type:'text'}),
					this.loginButton = html.button({className:'btn btn-default navbar-btn'}, 'Login')
//				)
    		);
    		this.usernameInput.on('focus', this.inputFocus, this);
    		this.loginButton.on('click', this.loginClick, this);
    		return markup;
    	},
    	overrides: {
        	loginClick: function(evt) {
        		this.engine.enqueueMessage({message: 'presence', command: 'login', value: this.usernameInput.get('value')});
        		evt.preventDefault();
        	},
            inputFocus: function() {
            	this.engine.enqueueMessage({message: 'presence', command: 'setFocus', value: this.model.id});
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