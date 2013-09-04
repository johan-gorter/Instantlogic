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
  
  var toGrid = function(x) {
	  return 10*Math.round(x/10);
  }
  
  var differentXYWidthHeight = function(oldModel, newModel) {
	  return (oldModel.xy.top!=newModel.xy.top || 
			  oldModel.xy.left!=newModel.xy.left ||
			  oldModel.width!=newModel.width ||
			  oldModel.height!=newModel.height);
  }

  var setXYWidthHeight = function(elements, x, y, width, height) {
    elements.forEach(function(element) {
    	element.setAttribute('x', x);
    	element.setAttribute('y', y);
    	element.setAttribute('width', width);
    	element.setAttribute('height', height);
    });
  };
  
  var getInputXY = function(deductionModel, inputModel) {
	  if (inputModel.diagramPosition==='primary') {
		  return [deductionModel.xy.left, deductionModel.xy.top+deductionModel.height+3];
	  } else if (inputModel.diagramPosition==='control') {
		  return [deductionModel.xy.left-deductionModel.width/2-3, deductionModel.xy.top+deductionModel.height/2];
	  } else { // secondary
		  return [deductionModel.xy.left+deductionModel.width/4, deductionModel.xy.top+deductionModel.height+3];
	  }
  }

  ns.DeductionScheme = createFragment({
    createMarkup: function() {
      this.width = 500;
      this.height = 500;
      this.draggingRect = svg.rect({fill:'none', stroke:'gray', 'stroke-width':2, 'stroke-dasharray':'4,2', rx:10, ry:10});
      var result = html.div({ className: 'deduction-scheme'},
        this.node = svg.svg({ viewBox: [-this.width/2, 0, this.width, this.height].toString() })
      );
      this.node.on("mouseup", this.onMouseup, this);
      this.node.on("mousemove", this.onMousemove, this);
      return result;
    },
    fragmentLists: function(model) {
      return [[this.node, model.deductions, svgFragmentListOptions]];
    },
    overrides: {
    	toSVGXY: function(pageX, pageY) {
    		var deltaX = pageX - this.drag.originalPageX;
    		var deltaY = pageY - this.drag.originalPageY;
    		deltaX = deltaX * this.width / this.drag.nodeWidth;
    		deltaY = deltaY * this.height / this.drag.nodeHeight;
    		return [toGrid(this.drag.originalX + deltaX), toGrid(this.drag.originalY + deltaY)];
    	},
    	select: function(deductionId) {
    		this.engine.sendChange(this.model.id, deductionId);
    	},
    	startDrag: function(deduction, evt) {
    		this.drag = {
    			deductionFragment: deduction,
    			originalX: deduction.model.xy.left,
    			originalY: deduction.model.xy.top,
    			originalPageX: evt.pageX,
    			originalPageY: evt.pageY,
    			nodeWidth: this.node.get('clientWidth'),
    			nodeHeight: this.node.get('clientHeight')
    		};
    		setXYWidthHeight([this.draggingRect], deduction.model.xy.left-deduction.model.width/2-2, deduction.model.xy.top-2, deduction.model.width+4, deduction.model.height+4);
    		this.node.appendChild(this.draggingRect);
    	},
    	onMouseup: function(evt) {
    		if (this.drag) {
    			this.drag.deductionFragment.draggedTo(this.toSVGXY(evt.pageX, evt.pageY));
    			this.drag = null;
    			this.node.removeChild(this.draggingRect);
    		}
    	},
    	onMousemove: function(evt) {
    		if (this.drag) {
    			var xy = this.toSVGXY(evt.pageX, evt.pageY);
    			this.draggingRect.setAttribute('x', xy[0]-this.drag.deductionFragment.model.width/2-2);
    			this.draggingRect.setAttribute('y', xy[1]-2);
    		}
    	}
    }
  });

  ns.Deduction = createFragment({
    createMarkup: function() {
      this.selectionBorder = svg.rect({fill:'none', stroke:'blue', 'stroke-width':3, 'stroke-dasharray':'5,5', rx:16, ry:16});
      return this.node = svg.g(
        this.bottomRect = svg.rect({stroke:'black', 'stroke-width': 5, rx:10, ry:10}),
        this.outputsBackgroundGroup = svg.g(),
        this.inputsGroup = svg.g(),
        this.outputsGroup = svg.g(),
        this.rect = svg.rect({fill:'red', rx:10, ry:10}),
        this.svgTextBox = svg.svg(
          this.nameText = svg.text({'font-family':'"Helvetica Neue", Helvetica, Arial, sans-serif', 'font-size':'15px', y:18})
        )
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
      if (model.selected) {
    	  this.toggleSelected(true);
      }
      this.rect.on('click', this.onClick, this);
      this.svgTextBox.on('click', this.onClick, this);
      this.rect.on('mousedown', this.onMousedown, this);
      this.svgTextBox.on('mousedown', this.onMousedown, this);
    },
    postUpdate: function(newModel, diff) {
      if(differentXYWidthHeight(newModel, this.oldModel)) {
        this.setDimensions(newModel);
      }
      if (newModel.selected != this.oldModel.selected) {
    	  this.toggleSelected(newModel.selected);
      }
    },
    overrides: {
      setDimensions: function (model) {
    	setXYWidthHeight([this.rect, this.bottomRect, this.svgTextBox], model.xy.left-model.width/2, model.xy.top, model.width, model.height);
    	setXYWidthHeight([this.selectionBorder], model.xy.left-model.width/2-6, model.xy.top-6, model.width+12, model.height+12);
//        this.nameText.setAttribute('x', model.xy.left-model.width/2+1);
//        this.nameText.setAttribute('y', model.xy.top+2);
      },
      onClick: function(evt) {
    	  evt.preventDefault();
    	  this.parentFragment.select(this.model.deductionId);
      },
      onMousedown: function(evt) {
    	  evt.preventDefault();
    	  this.parentFragment.startDrag(this, evt);
      },
      draggedTo: function(xy) {
    	  this.engine.sendChange(this.model.id, {left:xy[0], top:xy[1]});
      },
      toggleSelected: function(newValue) {
    	  if (newValue) {
    		  this.node.prepend(this.selectionBorder);
    	  } else {
    		  this.node.removeChild(this.selectionBorder);
    	  }
      }
    }
  });
  
  ns.DeductionInput = createFragment({
    createMarkup: function() {
      return this.node = svg.circle({fill:'red', stroke:'black', 'stroke-width':3, r:5});
    },
    postInit: function(model) {
    	this.oldDeductionModel = this.getDeductionModel();
    	this.setDimensions(model, this.oldDeductionModel);
      },
      postUpdate: function(newModel, diff) {
    	  var deductionModel = this.getDeductionModel();
    	  if (differentXYWidthHeight(deductionModel, this.oldDeductionModel) || newModel.diagramPosition != this.oldModel.diagramPosition) {
    		  this.setDimensions(newModel, deductionModel);
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
      this.backgroundNode = svg.path({stroke:'black', 'stroke-width':3});
      return this.node = svg.path({fill:'red'});
    },
    postInit: function(model) {
      this.parentFragment.outputsBackgroundGroup.appendChild(this.backgroundNode);
      this.oldSourceDeductionModel = this.getSourceDeductionModel(); 
      this.oldTargetModels = this.getTargetDeductionAndInputModel(model.toDeductionInputId);
      this.setDimensions(this.oldSourceDeductionModel, this.oldTargetModels[0], this.oldTargetModels[1])
    },
    postUpdate: function(newModel, diff) {
    	var sourceDeductionModel = this.getSourceDeductionModel();
        var targetModels = this.getTargetDeductionAndInputModel(newModel.toDeductionInputId);
        if (differentXYWidthHeight(sourceDeductionModel, this.oldSourceDeductionModel) ||
            differentXYWidthHeight(targetModels[0], this.oldTargetModels[0]) || 
            targetModels[1].diagramPostion != this.oldTargetModels[1].diagramPosition) {
        	this.setDimensions(sourceDeductionModel, targetModels[0], targetModels[1]);
        }
        this.oldSourceDeductionModel = sourceDeductionModel;
        this.oldTargetModels = targetModels;
    },
    destroy: function() {
    	this.backgroundNode.remove();
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
    		var sourceXY = [sourceDeductionModel.xy.left, sourceDeductionModel.xy.top+sourceDeductionModel.height/2];

            var pointerLength = Math.sqrt(sqr(sourceXY[0] - targetXY[0]) + sqr(sourceXY[1] - targetXY[1]));
            var radiusX = ((sourceXY[1] - targetXY[1]) / pointerLength) * 10;
            var radiusY = -((sourceXY[0] - targetXY[0]) / pointerLength) * 10;
    		var path = [ 'M', [sourceXY[0] + radiusX, sourceXY[1] + radiusY], 
    	    		     'L', targetXY,
    	    		     'L', [sourceXY[0] - radiusX, sourceXY[1] - radiusY],
    	    		     'Z'].join('')
    		this.node.setAttribute('d', path);
    		this.backgroundNode.setAttribute('d', path);
    	}
    }
  });

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'dd'] });