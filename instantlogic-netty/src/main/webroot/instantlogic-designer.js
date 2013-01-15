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
    			this.frame = html.iframe({src:'preview.html'})
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
    		Y.one(this.frameDocument.body).one('#place').appendChild(this.contentDiv);
            this.contentFragmentList = new FragmentList(this.contentDiv, this, this.engine);
            this.contentFragmentList.init(this.model.content);
            
            html.popDocument();
    	},
    	
    	update: function (newModel, diff) {
    		ns.Preview.superclass.update.call(this, newModel, diff);
    		html.pushDocument(this.frameDocument);
            this.contentFragmentList.update(newModel.content, diff);
            html.popDocument();
    	}
    	
    });
    
}, '0.7.0', { requires: ['instantlogic', 'html', 'instantlogic-fragments'] });