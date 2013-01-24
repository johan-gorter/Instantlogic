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
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });