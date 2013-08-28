YUI.add('instantlogic-designer-diagram', function(Y) {

  // First considered YUI graphics
  // Then considered raphael: support for text, move to front/back, more natural positioning, more mature library
  // Then considered D3
  // Finally, moved to native SVG

  var ns = Y.namespace('instantlogic.designer.diagram');
  var html = Y.html;
  var createFragment = Y.instantlogic.createFragment;

  var svg = Y.svg;
  
  var svgFragmentListOptions = { fragmentHolderOptions: { elementFactory: svg.g } };

  var sqr = function (a) {
    return a * a;
  };
  
  var differentXYWidthHeight = function(oldModel, newModel) {
	  return (oldModel.xy.top!=newModel.xy.top || 
			  oldModel.xy.left!=newModel.xy.left ||
			  oldModel.width!=newModel.width ||
			  oldModel.height!=newModel.height);
  }
  
  var getInputXY = function(deductionModel, inputModel) {
	  // TODO: use input type
	  return [deductionModel.xy.left, deductionModel.xy.top+deductionModel.height+0.4];
  }

  ns.DeductionScheme = createFragment({
    createMarkup: function() {
      return html.div({ className: 'deduction-scheme'},
        this.node = svg.svg({ viewBox: '-25 0 50 50' })
      );
    },
    fragmentLists: function(model) {
      return [[this.node, model.deductions, svgFragmentListOptions]];
    }
  });

  ns.Deduction = createFragment({
    createMarkup: function() {
      return this.node = svg.g(
        this.inputsGroup = svg.g(),
        this.outputsGroup = svg.g(),
        this.rect = svg.rect({fill:'red', rx:1, ry:1}),
        this.nameText = svg.text({'font-family':'"Helvetica Neue", Helvetica, Arial, sans-serif', 'font-size':'1.5px'})
      );
    },
    texts: function(model) {
      return [[this.nameText, model.operationName]];
    },
    fragmentLists: function(model) {
      return [[this.outputsGroup, model.outputs, svgFragmentListOptions], [this.inputsGroup, model.inputs, svgFragmentListOptions]];
    },
    postInit: function(model) {
      this.setDimensions(model);
    },
    postUpdate: function(newModel, diff) {
      if(differentXYWidthHeight(newModel, this.oldModel)) {
        this.setDimensions(newModel);
      }
    },
    overrides: {
      setDimensions: function (model) {
        this.rect.setAttribute('x', model.xy.left-model.width/2);
        this.rect.setAttribute('y', model.xy.top);
        this.rect.setAttribute('width', model.width);
        this.rect.setAttribute('height', model.height);
        this.nameText.setAttribute('x', model.xy.left-model.width/2+1);
        this.nameText.setAttribute('y', model.xy.top+2);
      }
    }
  });
  
  ns.DeductionInput = createFragment({
    createMarkup: function() {
      return this.node = svg.circle({fill:'red', r:0.5});
    },
    postInit: function(model) {
    	this.oldDeductionModel = this.getDeductionModel();
    	this.setDimensions(model, this.oldDeductionModel);
      },
      postUpdate: function(newModel, diff) {
    	  var deductionModel = this.getDeductionModel();
    	  if (differentXYWidthHeight(deductionModel, this.oldDeductionModel)) {
    		  this.setDimensions(model, deductionModel);
    	  }
    	  this.oldDeductionModel = deductionModel;
      },
      overrides: {
    	setDimensions: function(model, deductionModel) {
    		var xy = getInputXY(deductionModel, model);
    		this.node.setAttribute("cx", xy[0]);
    		this.node.setAttribute("cy", xy[1]);
    	},
      	getDeductionModel: function() {
      	  return this.parentFragment.model;
      	}
      }
  });

  ns.Output = createFragment({
    createMarkup: function() {
      return this.node = svg.path({stroke:'red', 'stroke-width': 0.3});
    }, 
    postInit: function(model) {
      this.oldSourceDeductionModel = this.getSourceDeductionModel(); 
      this.oldTargetModels = this.getTargetDeductionAndInputModel(model.toDeductionInputId);
      this.setDimensions(this.oldSourceDeductionModel, this.oldTargetModels[0], this.oldTargetModels[1])
    },
    postUpdate: function(newModel, diff) {
    	var sourceDeductionModel = this.getSourceDeductionModel();
        var targetModels = this.getTargetDeductionAndInputModel(newModel.toDeductionInputId);
        if (differentXYWidthHeight(sourceDeductionModel, this.oldSourceDeductionModel) ||
            differentXYWidthHeight(targetModels[0], this.oldTargetModels[0])) {
        	this.setDimensions(sourceDeductionModel, targetModels[0], targetModels[1]);
        }
        this.oldSourceDeductionModel = sourceDeductionModel;
        this.oldTargetModels = targetModels;
    },
    overrides: {
    	getSchemeModel: function() {
    		return this.parentFragment.parentFragment.model;
    	},
    	getSourceDeductionModel: function() {
    		return this.parentFragment.model;
    	},
    	getTargetDeductionAndInputModel: function(toDeductionInputId) {
    		var deductions = this.getSchemeModel().deductions;
    		for (var i=0;i<deductions.length;i++) {
    			var candidateDeduction = deductions[i];
    			for (var ii=0;ii<candidateDeduction.inputs.length;ii++) {
    				var candidateInput = candidateDeduction.inputs[ii];
    				if (candidateInput.deductionInputId == toDeductionInputId) {
    					return [candidateDeduction, candidateInput];
    				}
    			}
    		}
    		throw new Error("DeductionInputId not found: "+toDeductionInputId);
    	},
    	setDimensions: function(sourceDeductionModel, targetDeductionModel, targetInputModel) {
    		var targetXY = getInputXY(targetDeductionModel, targetInputModel);
    		this.node.setAttribute('d', ['M', [sourceDeductionModel.xy.left, sourceDeductionModel.xy.top], 'L', targetXY, 'Z'].join(''))
    	}
    }
  });

  ns.DeductionSchemeOld = function(parentNode, parentFragment, engine) {
    ns.DeductionScheme.superclass.constructor.apply(this, arguments);
  };

  Y.extend(ns.DeductionSchemeOld, Y.instantlogic.Fragment, {

    init: function(model) {
      ns.DeductionScheme.superclass.init.call(this, model);
      var markup = svg.svg();
      markup.set('version', '1.1');
      
      this.parentNode.appendChild(markup);

      var redrawPointers = function(x, y) {

        var pointer1, pointer1toX, pointer1toY;

        var pointer1fromX = x;
        var pointer1fromY = y;

        var pointerLength = Math.sqrt(sqr(pointer1fromX - pointer1toX) + sqr(pointer1fromY - pointer1toY));
        var radiusX = ((pointer1fromY - pointer1toY) / pointerLength) * 10;
        var radiusY = -((pointer1fromX - pointer1toX) / pointerLength) * 10;

        pointer1.attr('path', [
          'M', pointer1fromX + radiusX, ',', pointer1fromY + radiusY,
          'L', pointer1toX, ',', pointer1toY,
          'L', pointer1fromX - radiusX, ',', pointer1fromY - radiusY,
          'Z'
        ].join());
      };

    },

  update: function(newModel, diff) {
    if (!this.libraryLoaded) return;
  }
});

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments'] });