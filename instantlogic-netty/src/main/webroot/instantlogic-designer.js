YUI.add('instantlogic-designer', function (Y) {

    var ns = Y.namespace('instantlogic.designer');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // ElementEditor
    ns.ElementEditor = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.fragments.Block,
    	postInit: function() {
    		this.markup.addClass('element-editor');
    	}
    });

    // PreviewLine
    ns.PreviewLine = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.fragments.Block,
    	postInit: function() {
    		this.markup.addClass('preview-line');
    	}
    });

    // Preview
    ns.Preview = function (parentNode, parentFragment, engine) {
        ns.Preview.superclass.constructor.apply(this, arguments);
    };
    Y.extend(ns.Preview, Y.instantlogic.Fragment, {
    	init: function(model) {
            ns.Preview.superclass.init.call(this, model);
    		this.previewContainer = html.div({className:'preview-container'},
    			this.frame = html.iframe({src:'preview.html', frameborder:'0',scrolling:'no'})
    		);
    		this.frame.on('load', this.iframeLoaded, this);
            this.parentNode.appendChild(this.previewContainer);
    	},
    	
    	iframeLoaded: function() {
    		this.frameDocument = (this.frame._node.contentDocument || this.frame._node.contentWindow);
    		if (this.frameDocument.document) {
    			this.frameDocument = this.frameDocument.document;
    		}
    		html.pushDocument(this.frameDocument);

    		this.contentDiv = html.div({className: 'preview'});
    		this.placeDiv = Y.one(this.frameDocument.body).one('#place'); 
    		this.placeDiv.appendChild(this.contentDiv);
            this.contentFragmentList = new FragmentList(this.contentDiv, this, this.engine);
            this.contentFragmentList.init(this.model.content);
            
            html.popDocument();
            var me = this;
            setTimeout(function() {me.updateFrameHeight();});
    	},
    	
    	update: function (newModel, diff) {
    		ns.Preview.superclass.update.call(this, newModel, diff);
    		if (this.contentFragmentList) {
	    		html.pushDocument(this.frameDocument);
	            this.contentFragmentList.update(newModel.content, diff);
	            html.popDocument();
    		}
    	},
    	
    	updateFrameHeight: function() {
    		var height = Y.one(this.frameDocument.body).get('docHeight');
    		this.frame.setStyle('height', height);
    	}
    });
    
    // Shopping (shops for instances to add to a relation in the data-explorer)
    ns.Shopping = Y.instantlogic.createFragment({
    	createMarkup: function() {
    		return html.div({className: 'animate-vertically'},
    			html.div({className:'shopping'},
	    			html.span('Finding '),
	    			this.relationNameLink = html.a({href:'#'}),
	    			html.span(' for '),
	    			this.instanceNameLink = html.a({href:'#'}),
	    			this.itemLabelSpan = html.span(', items: '),
	    			this.itemCountSpan = html.b(),
	    			this.addButton = html.button('add this'),
	    			this.setToButton = html.button('set to this'),
	    			this.removeButton = html.button('remove this'),
	    			this.readyButton = html.button('stop')
	    		)
	    	);
    	},
    	postInit: function(model) {
    		this.addButton.on('click', this.addClicked, this);
    		this.setToButton.on('click', this.addClicked, this);
    		this.removeButton.on('click', this.removeClicked, this);
    		this.readyButton.on('click', this.readyClicked, this);
    		this.instanceNameLink.on('click', this.instanceNameClicked, this);
    		this.relationNameLink.on('click', this.relationNameClicked, this);
    	},
    	postUpdate: function(newModel) {
    	},
    	texts: function(model) {
    		return [[this.relationNameLink, model.relationName], [this.instanceNameLink, model.instanceName], [this.itemCountSpan, model.itemCount]];
    	},
    	styles: function(model) {
    		return [[this.itemLabelSpan, 'display', (!model.single)?'inline':'none'],
    		        [this.itemCountSpan, 'display', (!model.single)?'inline':'none'],
    		        [this.addButton, 'display', (model.thisCanBeAdded && !model.single)?'inline':'none'],
    		        [this.setToButton, 'display', (model.thisCanBeAdded && model.single)?'inline':'none'],
    		        [this.removeButton, 'display', (model.thisCanBeRemoved)?'inline':'none']
    		        ];
    	},
    	overrides: {
    		addClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-addItem');
    		},
    		removeClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-removeItem');
    		},
			readyClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-finished');
    		},
			relationNameClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-gotoRelation');
    		},
			instanceNameClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-gotoInstance');
			}
    	}
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });