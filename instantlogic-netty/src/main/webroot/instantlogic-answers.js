YUI.add('instantlogic-answers', function (Y) {

    var ns = Y.namespace('instantlogic.answers');
    var html = Y.html;
    
    // An Answer should contain the following methods
	// createMarkup: function() This method should return a Node
	// updateValue: function(newValue) This method should update the markup to reflect the new value
	// getValue: function() This method should return the current value
    
    ns.createAnswer = function(model) {
    	if (model.dataType) {
	    	if (model.dataType.multiLine) {
	    		return new ns.TextareaAnswer(model);
	    	}
	    	if (model.dataType.category == 'boolean') {
	    		return new ns.CheckboxAnswer(model);
	    	}
    	}
    	if (model.options) {
    		return new ns.DropdownAnswer(model);
    	}
    	return new ns.TextAnswer();
    };
    
    ns.TextAnswer = function() {
    }
    ns.TextAnswer.prototype = {
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
    };

    ns.TextareaAnswer = function() {
    	ns.TextareaAnswer.superclass.constructor.apply(this, arguments);
    }
    Y.extend(ns.TextareaAnswer, ns.TextAnswer, {
    	createMarkup: function() {
    		this.input = html.textarea();
    		return this.input;
    	}
    });
    
    ns.CheckboxAnswer = function() {
    }
    ns.CheckboxAnswer.prototype = {
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
    };
    
    ns.DropdownAnswer = function(model) {
    	this.model = model;
    }
    ns.DropdownAnswer.prototype = {
    	createMarkup: function() {
    		this.input = html.select({ 
                id: this.model.id, 
                name: this.model.id, 
                disabled: this.model.readonly
            }, this.createOptions(this.model.options));
    		return this.input;
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

}, '0.7.0', { requires: ['instantlogic', 'html'] });