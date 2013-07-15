YUI.add('instantlogic-designer-diagram', function(Y) {

  // First considered YUI graphics
  // Then considered raphael: support for text, move to front/back, more natural positioning, more mature library
  // Then considered D3
  // Finally, moved to native SVG

  var ns = Y.namespace('instantlogic.designer.diagram');
  var html = Y.html;

  var sqr = function (a) {
    return a * a;
  };

  ns.DeductionScheme = function(parentNode, parentFragment, engine) {
    ns.DeductionScheme.superclass.constructor.apply(this, arguments);
  };

  Y.extend(ns.DeductionScheme, Y.instantlogic.Fragment, {

    init: function(model) {
      ns.DeductionScheme.superclass.init.call(this, model);
      var markup = Y.Node.one(document.createElementNS("http://www.w3.org/2000/svg", "svg"));
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