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
      this.graphic = new Y.Graphic({
        render: markup
      });

      var pointer1toX = 200;
      var pointer1toY = 200;

      var pointer1 = this.graphic.addShape({
        type: 'path',
        fill: {
          color: "#00009f"
        },
        stroke: {
          weight: 0,
          color: "#ff0000"
        }
      });
      pointer1.moveTo(90, 100);
      pointer1.lineTo(100, 0);
      pointer1.lineTo(110, 100);
      pointer1.end();

      var circle1 = this.graphic.addShape({
        type: 'circle',
        x: 70, y: 70,
        radius: 30,
        fill: {
          color: "#0000ff",
          opacity: 1
        },
        stroke: {
          weight: 0,
          color: "#ff0000"
        }
      });
      Y.one(circle1.node).setStyle('cursor', 'pointer');

      this.parentNode.appendChild(markup);
      new Y.DD.Drag({
        node: circle1
      }).plug(Y.Plugin.DDConstrained, {
        constrain2node: markup
      });

      var redrawPointers = function(dragEvent) {
        var offset = markup.get('region');
        var xy = dragEvent.target.actXY;
        var pointer1fromX = xy[0] - offset.left + 30;
        var pointer1fromY = xy[1] - offset.top + 30;

        var pointerLength = Math.sqrt(sqr(pointer1fromX - pointer1toX) + sqr(pointer1fromY - pointer1toY));
        var radiusX = ((pointer1fromY - pointer1toY) / pointerLength) * 10;
        var radiusY = -((pointer1fromX - pointer1toX) / pointerLength) * 10;

        pointer1.clear();
        pointer1.moveTo(pointer1fromX+radiusX, pointer1fromY+radiusY);
        pointer1.lineTo(pointer1toX, pointer1toY);
        pointer1.lineTo(pointer1fromX - radiusX, pointer1fromY - radiusY);
        pointer1.end();
      };

      Y.DD.DDM.on("drag:drag", redrawPointers);
    },

  update: function(newModel, diff) {
    if (!this.libraryLoaded) return;
  }
});

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'graphics'] });