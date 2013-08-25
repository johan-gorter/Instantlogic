YUI.add('instantlogic-designer-diagram', function(Y) {

  // First considered YUI graphics
  // Then considered raphael: support for text, move to front/back, more natural positioning, more mature library
  // Then considered D3
  // Finally, moved to native SVG

  var ns = Y.namespace('instantlogic.designer.diagram');
  var html = Y.html;
  var createFragment = Y.instantlogic.createFragment;

  var svg = Y.svg;

  var sqr = function (a) {
    return a * a;
  };

  ns.DeductionScheme = createFragment({
    createMarkup: function() {
      return html.div({ className: 'deduction-scheme'},
        this.node = svg.svg({ viewBox: '-50 0 50 100' })
      );
    },
    fragmentLists: function(model) {
      return [[this.node, model.deductions, { fragmentHolderOptions: { elementFactory: svg.g } }]];
    }
  });

  ns.Deduction = createFragment({
    createMarkup: function() {
      return this.node = svg.g(
        this.outputsGroup = svg.g(),
        this.circle = svg.ellipse({fill:'red'}),
        this.nameText = svg.text()
      );
    },
    texts: function(model) {
      return [[this.nameText, model.operationName]];
    },
    fragmentLists: function(model) {
      return [[this.outputsGroup, model.outputs]];
    },
    postInit: function(model) {
      this.setDimensions(model);
    },
    postUpdate: function(newModel, diff) {
      if(
        newModel.xy.left != this.oldModel.xy.left ||
        newModel.xy.top != this.oldModel.xy.top
      ) {
        this.setDimensions(newModel);
      }
    },
    overrides: {
      setDimensions: function (model) {
        this.circle.setAttribute('cx', model.xy.left);
        this.circle.setAttribute('cy', model.xy.top);
        this.circle.setAttribute('rx', 8.0);
        this.circle.setAttribute('ry', 4.0);
      }
    }
  });

  ns.Output = createFragment({
    createMarkup: function() {
      return this.node = svg.path();
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