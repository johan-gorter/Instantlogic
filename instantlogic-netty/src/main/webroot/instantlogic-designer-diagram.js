YUI.add('instantlogic-designer-diagram', function(Y) {

  var ns = Y.namespace('instantlogic.designer.diagram');
  var html = Y.html;

  var sqr = function (a) {
    return a * a;
  };

  ns.DeductionScheme = function(parentNode, parentFragment, engine) {
    ns.DeductionScheme.superclass.constructor.apply(this, arguments);
    this.libraryLoaded = false;
    var me = this;
    // The reason for choosing raphael over yui grahics are: support for text, move to front/back, more natural positioning, more mature library
    Y.Get.script(['../raphael.js'], { //TODO
      onSuccess: function () {
        me.libraryLoad();
      }
    });
  };

  Y.extend(ns.DeductionScheme, Y.instantlogic.Fragment, {
    libraryLoad: function() {
      this.libraryLoaded = true;
      if (this.model) {
        this.init(this.model);
      }
    },
    init: function(model) {
      ns.DeductionScheme.superclass.init.call(this, model);
      if (!this.libraryLoaded) return;
      var markup = html.div({ className: 'deduction-scheme' });
      markup
        .setStyle('width', '600px')
        .setStyle('height', '400px')
        .setStyle('position', 'relative')
        .setStyle('border', 'solid 1px black');
      this.paper = Raphael(markup._node, 600, 400);

      var pointer1toX = 200;
      var pointer1toY = 200;

      var pointer1 = this.paper.path('M90,100L100,0L110,100Z');
      pointer1.attr('fill', '#00009f');

      var circle1 = this.paper.circle(100, 100, 30);
      circle1.attr('fill', '#0000ff');
      Y.one(circle1.node).setStyle('cursor', 'pointer');

      this.parentNode.appendChild(markup);

      var redrawPointers = function (x, y) {
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

      var circle1start = function() {
        this.ox = this.attr("cx");
        this.oy = this.attr("cy");
      };
      
      var circle1move = function (dx, dy) {
        this.attr({ cx: this.ox + dx, cy: this.oy + dy });
        redrawPointers(this.ox + dx, this.oy + dy);
      };

      circle1.drag(circle1move, circle1start);
//      new Y.DD.Drag({
//        node: circle1
//      }).plug(Y.Plugin.DDConstrained, {
//        constrain2node: markup
//      });

    },

  update: function(newModel, diff) {
    if (!this.libraryLoaded) return;
  }
});

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'graphics'] });