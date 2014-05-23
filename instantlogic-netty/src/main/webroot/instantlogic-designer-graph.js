YUI.add('instantlogic-designer-graph', function(Y) {
	
  var ns = Y.namespace('instantlogic.designer.graph');
  var html = Y.html;
  var createFragment = Y.instantlogic.createFragment;

  ns.Graph = createFragment({
    createMarkup: function () {
      var result = html.div({ className: 'entity-graph'});
      this.entityGraph = window.createEntityGraph(result._node);
      return result;
    },
    postInit: function (model) {
      this.entityGraph.init(model);
    },
    postUpdate: function (newModel, diff) {
      this.entityGraph.update(newModel);
    },    
    overrides: {
    }
  });

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'dd'] });