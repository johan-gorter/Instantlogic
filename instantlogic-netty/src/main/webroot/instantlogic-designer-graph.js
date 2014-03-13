YUI.add('instantlogic-designer-graph', function(Y) {

  var test = {
		  "type": "Graph",
		  "id": "graph1",
		  "nodes": [
		   {
		    "id": "EntityDesign_comment",
		    "text": "comment"
		   },
		   {
		    "id": "EntityDesign_issue",
		    "text": "issue"
		   },
		   {
		    "id": "EntityDesign_issueStatus",
		    "text": "issueStatus"
		   },
		   {
		    "id": "EntityDesign_project",
		    "text": "project"
		   },
		   {
		    "id": "EntityDesign_user",
		    "text": "user"
		   }
		  ],
		  "edges": {
		   "inherits": [],
		   "ownsMany": [
		    {
		     "id": "RelationDesign_comments",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_comment"
		    },
		    {
		     "id": "RelationDesign_issues",
		     "from": "EntityDesign_project",
		     "to": "EntityDesign_issue"
		    },
		    {
		     "id": "RelationDesign_users",
		     "from": "EntityDesign_project",
		     "to": "EntityDesign_user"
		    }
		   ],
		   "ownsOne": [],
		   "one": [
		    {
		     "id": "RelationDesign_by",
		     "from": "EntityDesign_comment",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_assignee",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_reporter",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_user"
		    },
		    {
		     "id": "RelationDesign_status",
		     "from": "EntityDesign_issue",
		     "to": "EntityDesign_issueStatus"
		    }
		   ],
		   "many": []
		  },
		  "startNodeId": "EntityDesign_project"
		 };	
	
  var ns = Y.namespace('instantlogic.designer.graph');
  var html = Y.html;
  var createFragment = Y.instantlogic.createFragment;

  var svg = Y.svg;
  
  var sqr = function (a) {
    return a * a;
  };

  var speed = 5;
  var dragFactor = 0.08;
  var repelFactor = 4;
  var accFactor = speed / 1000000;

  edgeTypes = {
    inherits: { // subclass -> superclass
      preferredDx: 0,
      preferredDy: -100, // from below
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 100, // repel hard
      dyShrink: 30 // attract
    },
    one: { 
      preferredDx: 100,
      preferredDy: -100,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    many: { 
      preferredDx: 100,
      preferredDy: 50,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    ownsOne: { 
      preferredDx: 50,
      preferredDy: 50,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    },
    ownsMany: { 
      preferredDx: 0,
      preferredDy: 75,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10
    }
  };

  window.Physics.behavior('edge', function (parent) {
    return {

      init: function (options) {
        parent.init.call(this, options);
        this.graph = options.graph;
      },
      behave: function (data) {
        var scratch = window.Physics.scratchpad();
        var edges = this.graph.edges;
        var vector = scratch.vector();
        for(var i = 0; i < edges.length; i++) {
          var edge = edges[i];
          if(edge.isVisible()) {
            var from = edge.fromNode.point;
            var to = edge.toNode.point;
            var type = edge.type;
            var dx = to.state.pos.get(0) - from.state.pos.get(0);
            var dy = to.state.pos.get(1) - from.state.pos.get(1);
            var xDeviation = dx - type.preferredDx;
            var yDeviation = dy - type.preferredDy;
            var addX, addY;
            if(xDeviation < 0) {
              addX = -xDeviation * type.dxShrink * accFactor;
            } else {
              addX = -xDeviation * type.dxGrow * accFactor;
            }
            if(yDeviation < 0) {
              addY = -yDeviation * type.dyShrink * accFactor;
            } else {
              addY = -yDeviation * type.dyGrow * accFactor;
            }
            vector.set(addX, addY);
            to.accelerate(vector);
            from.accelerate(vector.negate());
          }
        }
        scratch.done();
      }
    };
  });

  // Node

  var Node = function (id, text, graph) {
    this.id = id;
    this.text = text;
    this.graph = graph;
    this.width = 100;
    this.height = 20;
    this.frozenBeforeDrag = false;
  };

  Node.prototype = {
    appear: function (x, y) {
      this.node = svg.svg({ width: this.width, height: this.height, x: -this.width/2, y: -this.height/2},
        this.bottomRect = svg.rect({ stroke: 'black', 'stroke-width': 1, fill: '#666666', width: 100, height: 20, rx: 10, ry: 10 }),
        svg.text({ 'font-family': '"Helvetica Neue", Helvetica, Arial, sans-serif', 'font-size': '15px', fill: 'white', y:15, x:2.5}, this.text)
      );
      this.moveTo(x, y);
      this.graph.nodesContainer.appendChild(this.node);
      this.node.on('mousedown', this.onMousedown, this);
      this.point = window.Physics.body("point", { x: x, y: y });
      this.graph.world.add(this.point);
    },
    disappear: function () {
      this.graph.world.remove(this.point);
      this.node.remove();
      this.node = this.point = null;
    },
    isVisible: function () {
      return !!this.node;
    },
    isExpanded: function () {
      return this.point && this.point.fixed;
    },
    freeze: function () {
      this.point.fixed = true;
      this.bottomRect.setAttribute('fill', 'blue');
    },
    unfreeze: function () {
      this.point.fixed = false;
      this.bottomRect.setAttribute('fill', '#666666');
    },
    onMousedown: function (evt) {
      evt.preventDefault();
      this.frozenBeforeDrag = this.point.fixed;
      this.graph.startDrag(this, evt);
      this.freeze();
    },
    endDrag: function (moved) {
      if (this.point.fixed) {
        if(moved) {
          this.freeze();
          this.graph.addRelatedNodes(this);
        } else {
          if(this.frozenBeforeDrag) {
            this.unfreeze();
            this.graph.removeUnrelatedNodes(this);
          } else {
            this.graph.addRelatedNodes(this);
          }
        }
      }
    },
    moveTo: function (x, y) {
      this.x = x;
      this.y = y;
      this.renderXY();
      if (this.point) {
        this.point.state.pos.clone(window.Physics.vector(x, y));
      }
    },
    render: function () {
      if(this.point && !this.point.fixed) {
        this.x = this.point.state.pos.get(0);
        this.y = this.point.state.pos.get(1);
        this.renderXY();
      }
    },
    renderXY: function () {
      this.node.setAttribute("x", this.x - this.width / 2);
      this.node.setAttribute("y", this.y - this.height / 2);
    }
  };

  var Edge = function (graph, fromNode, toNode, type) {
    this.graph = graph;
    this.fromNode = fromNode;
    this.toNode = toNode;
    this.type = edgeTypes[type];
    if(!this.type) {
      throw new Error("unknown edge type: " + type);
    }
  };

  Edge.prototype = {
    appear: function () {
      if(this.node) throw new Error("already visible");
      this.node = svg.line({ stroke: 'black', 'stroke-width': 1 });
      this.render();
      this.graph.edgesContainer.appendChild(this.node);
    },
    disappear: function () {
      this.node.remove();
      this.node = null;
    },
    adjustVisibility: function () {
      var desiredVisibility = this.fromNode.isVisible() && this.toNode.isVisible();
      if(this.isVisible()) {
        if(!desiredVisibility) {
          this.disappear();
        }
      } else {
        if (desiredVisibility) {
          this.appear();
        }
      }
    },
    isVisible: function () {
      return !!this.node;
    },
    render: function () {
      if(this.node) {
        this.node.setAttribute("x1", this.fromNode.x);
        this.node.setAttribute("y1", this.fromNode.y);
        this.node.setAttribute("x2", this.toNode.x);
        this.node.setAttribute("y2", this.toNode.y);
      }
    }
  };

  ns.Graph = createFragment({
    createMarkup: function() {
      this.width = 800;
      this.height = 500;
      var result = html.div({ className: 'graph'},
        this.node = svg.svg({ viewBox: [-this.width / 2, -this.height/2, this.width, this.height].toString() },
          this.background = svg.rect({x:-this.width/2+0.5,y:-this.height/2+0.5, width:this.width-1, height: this.height-1, fill: 'white', stroke:'black', 'stroke-width':1}),
          this.edgesContainer = svg.g(),
          this.nodesContainer = svg.g()
        )
      );
      this.node.on("click", this.onClick, this);
      this.node.on("mouseup", this.onMouseup, this);
      this.node.on("mousemove", this.onMousemove, this);
      return result;
    },
    postInit: function (model) {
      this.nodes = {};
      this.edges = [];
      this.startPhysics();
      for (var i = 0; i < model.nodes.length; i++) {
        var modelNode = model.nodes[i];
        this.nodes[modelNode.id] = new Node(modelNode.id, modelNode.text, this);
      }
      for (var edgeType in model.edges) {
        var edgeArray = model.edges[edgeType];
        for(var j = 0; j < edgeArray.length; j++) {
          var modelEdge = edgeArray[j];
          var edge = new Edge(this, this.nodes[modelEdge.from], this.nodes[modelEdge.to], edgeType);
          this.edges.push(edge);
        }
      }
      var startNode = this.nodes[model.startNodeId];
      startNode.appear(0, 0);
      startNode.freeze();
      this.addRelatedNodes(startNode);
    },
    postUpdate: function (newModel, diff) {
	  },    
    overrides: {
      addRelatedNodes: function (node) {
        var offset = 0;
        for (var i = 0; i < this.edges.length; i++) {
          var otherNode = null;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if (otherNode) {
            if(!otherNode.isVisible()) {
              otherNode.appear(this.width / 2, offset++ * this.height / 10);
            }
            if(!edge.isVisible()) {
              edge.appear();
            }
          }
        }
        this.adjustEdgeVisibilities();
      },
      adjustNodeVisibility: function (node) {
        for (var j = 0; j < this.edges.length; j++) {
          var otherNode = null;
          var edge = this.edges[j];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if(otherNode && otherNode.isExpanded()) return;
        }
        node.disappear();
      },
      removeUnrelatedNodes: function (node) {
        // node is no longer expanded, remove all surrounding nodes that are not visible for any other reason
        this.adjustNodeVisibility(node);
        for(var i = 0; i < this.edges.length; i++) {
          var otherNode = null;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if(otherNode && otherNode.isVisible() && !otherNode.isExpanded()) {
            this.adjustNodeVisibility(otherNode);
          }
        }
        this.adjustEdgeVisibilities();
      },
      adjustEdgeVisibilities: function () {
        for(var i = 0; i < this.edges.length; i++) {
          this.edges[i].adjustVisibility();
        }
      },
      startPhysics: function () {
        this.world = new window.Physics({
          timestep: 1000.0 / 160,
          maxIPF: 16
        });
        this.world.add(window.Physics.integrator('verlet', { drag: dragFactor }));
        this.world.add(window.Physics.behavior('newtonian', { strength: -repelFactor }));
        this.world.add(window.Physics.behavior('edge', { graph: this }));
        var me = this;
        window.Physics.util.ticker.subscribe(function (time, dt) {
          try {
            me.world.step(time);
            me.render();
          } catch(exception) {
            debugger;
            window.Physics.util.ticker.stop();
          }
        });
        window.Physics.util.ticker.start();
      },
      render: function () {
        for(var id in this.nodes) {
          this.nodes[id].render();
        }
        for(var i = 0; i < this.edges.length; i++) {
          this.edges[i].render();
        }
      },
    	toSVGXY: function(pageX, pageY) {
    		var deltaX = pageX - this.drag.originalPageX;
    		var deltaY = pageY - this.drag.originalPageY;
    		deltaX = deltaX * this.width / this.drag.nodeWidth;
    		deltaY = deltaY * this.height / this.drag.nodeHeight;
    		return [this.drag.originalX + deltaX, this.drag.originalY + deltaY];
    	},
    	startDrag: function(node, evt) {
    		this.drag = {
    			node: node,
    			originalX: node.x,
    			originalY: node.y,
    			originalPageX: evt.pageX,
    			originalPageY: evt.pageY,
          moved: false,
    			nodeWidth: this.node.get('clientWidth'),
    			nodeHeight: this.node.get('clientHeight')
    		};
    	},
    	onClick: function(evt) {
    		if (evt.target.compareTo(this.background)) {
    			this.engine.sendChange(this.model.id, null);
    		}
    	},
    	// onMousedown part of Node
    	onMouseup: function(evt) {
    	  if (this.drag) {
	        this.drag.node.endDrag(this.drag.moved);
    			this.drag = null;
    		}
    	},
    	onMousemove: function(evt) {
    		if (this.drag) {
    		  var xy = this.toSVGXY(evt.pageX, evt.pageY);
    		  if (!this.drag.moved && (evt.pageX !== this.drag.originalPageX || evt.pageY !== this.drag.originalPageY)) {
    		    this.drag.moved = true;
		      }
		      this.drag.node.moveTo(xy[0], xy[1]);
    		}
    	}
    }
  });

}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'dd'] });