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
    		return html.div({className: 'shopping animate-vertically'},
    			html.span('Shopping for '),
    			this.relationNameSpan = html.span(),
    			html.span(' (for '),
    			this.instanceNameSpan = html.span(),
    			html.span('), items: '),
    			this.itemCountSpan = html.span(),
    			this.addButton = html.button('add to cart'),
    			this.readyButton = html.button('ready')
    		);
    	},
    	postInit: function(model) {
    		this.addButton.on('click', this.addClicked, this);
    		this.readyButton.on('click', this.readyClicked, this);
    		if (!model.addCurrent) {
    			this.addButton.hide();
    		}
    	},
    	postUpdate: function(newModel) {
    	},
    	texts: function(model) {
    		return [[this.relationNameSpan, model.relationName], [this.instanceNameSpan, model.instanceName], [this.itemCountSpan, model.itemCount]];
    	},
    	overrides: {
    		addClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-addItem');
    		},
			readyClicked: function(evt) {
                evt.preventDefault();
                this.engine.sendSubmit(this.model.id+'-finished');
			}
    	}
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });