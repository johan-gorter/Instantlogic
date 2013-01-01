YUI.add('instantlogic-designer', function (Y) {

    var ns = Y.namespace('instantlogic.designer');
    var html = Y.html;
    var FragmentList = Y.instantlogic.FragmentList;

    // OldElementEditor (uses a new node, next to the designer styled node)
    ns.OldElementEditor = function(parentNode, parentFragment, engine) {
    	ns.OldElementEditor.superclass.constructor.apply(this, arguments);
    }
    
    Y.extend(ns.OldElementEditor, Y.instantlogic.Fragment, {
    	init: function (model) {
    		var pageRootNode = this.parentNode.ancestor('.designer');
    		this.node = editorRoot = html.div({className:'element-editor'});
    		pageRootNode.ancestor().appendChild(editorRoot);
            this.contentFragmentList = new FragmentList(this.node, this, this.engine);
            this.contentFragmentList.init(model.content);
    	},
    	
    	update: function(newModel, diff) {
            ns.OldElementEditor.superclass.update.call(this, newModel, diff);
            this.contentFragmentList.update(newModel.content, diff);
    	},
    	
    	destroy: function() {
    		ns.OldElementEditor.superclass.destroy.call(this);
    		this.contentFragmentList.destroy();
    		this.node.remove();
    	}
    });
    
    // ElementEditor
    ns.ElementEditor = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.fragments.Block
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
    			this.frame = html.iframe({src:'about:blank'})
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
    		Y.one(this.frameDocument.body).appendChild(this.contentDiv);
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