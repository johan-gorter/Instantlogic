YUI.add('instantlogic-answers', function (Y) {

    var ns = Y.namespace('instantlogic.answers');
    var html = Y.html;
    
    // An Answer should override the following methods
	// createMarkup: function() This method should return a Node
	// updateValue: function(newValue) This method should update the markup to reflect the new value
	// getValue: function() This method should return the current value
    
    ns.createAnswer = function(model, parentNode, parentFragment, engine) {
    	if (model.options) {
    		return new ns.DropdownAnswer(parentNode, parentFragment, engine);
    	}
    	if (model.dataType) {
	    	if (model.dataType.multiLine) {
	    		return new ns.TextareaAnswer(parentNode, parentFragment, engine);
	    	}
	    	if (model.dataType.category == 'boolean') {
	    		return new ns.CheckboxAnswer(parentNode, parentFragment, engine);
	    	}
	    	if (model.dataType.category == 'text' && !model.multivalue) {
	    		return new ns.TextAnswer(parentNode, parentFragment, engine);
	    	}
    	}
    	return new ns.JsonAnswer(parentNode, parentFragment, engine);
    };
    
    ns.TextAnswer = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.Answer,
    	overrides: {
        	createMarkup: function() {
        		this.input = html.input({type:'text', value: ''});
        		return this.input;
        	},
	    	updateValue: function(newValue) {
	    		this.input.set('value', newValue || '');
	    	},
	    	getValue: function() {
	    		return this.input.get('value');
	    	}
    	}
    });
    
    ns.JsonAnswer = Y.instantlogic.createFragment({
    	baseClass: ns.TextAnswer,
    	overrides: {
	    	updateValue: function(newValue) {
	    		this.input.set('value', JSON.stringify(newValue));
	    	},
	    	getValue: function() {
	    		return JSON.parse(this.input.get('value'));
	    	}
    	}
    });
    
    

    ns.TextareaAnswer = Y.instantlogic.createFragment({
    	baseClass: ns.TextAnswer,
    	overrides: {
	    	createMarkup: function() {
	    		this.input = html.textarea();
	    		return this.input;
	    	}
    	}
    });
    
    ns.CheckboxAnswer = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.Answer,
    	overrides: {
	    	createMarkup: function() {
	    		this.input = html.input({type: 'checkbox'});
	    		return this.input;
	    	},
	    	updateValue: function(newValue) {
	    		if (newValue) {
	    			this.input.set('checked', true);
	    		} else {
	    			this.input.set('checked', false);
	    		}
	    	},
	    	getValue: function() {
	    		return this.input.get('checked');
	    	}
	    }
    });
    
    ns.DropdownAnswer = Y.instantlogic.createFragment({
    	baseClass: Y.instantlogic.Answer,
    	postUpdate: function(newModel, diff) {
    		if (!this.sameOptions(this.oldModel.options, newModel.options)) {
    			this.input.get('children').remove();
    			var options = this.createOptions(newModel.options);
    			for (var i=0;i<options.length;i++) {
    				this.input.appendChild(options[i]);
    			}
    		}
    	},
    	overrides: {
	    	createMarkup: function() {
	    		this.input = html.select({ 
	                id: this.model.id, 
	                name: this.model.id, 
	                disabled: this.model.readonly
	            }, this.createOptions(this.model.options));
	    		return this.input;
	    	},
	    	sameOptions: function(oldOptions, newOptions) {
	    		if (oldOptions.length!=newOptions.length) {
	    			return false;
	    		}
	    		for (var i=0;i<oldOptions.length;i++) {
	    			if (oldOptions[i].id!=newOptions[i].id || oldOptions[i].text!=newOptions[i].text) {
	    				return false;
	    			}
	    		}
	    		return true;
	    	},
	        createOptions: function(options) {
	            var result = [];
	            result.push(html.option({value: ''}, ''));
	            for (var i=0;i<options.length;i++) {
	                var entry = options[i];
	                result.push(html.option({value: entry.id}, entry.text));
	            }
	            return result;
	        },
	    	updateValue: function(newValue) {
	    		return this.input.set('value', newValue);
	    	},
	    	getValue: function() {
	    		return this.input.get('value');
	    	}
	    }
    });

}, '0.7.0', { requires: ['instantlogic', 'html'] });