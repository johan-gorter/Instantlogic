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
  var repelFactor = 10;
  var accFactor = speed / 1000000;

  edgeTypes = {
    inherits: { // subclass -> superclass
      preferredDx: 0,
      preferredDy: -200, // from below
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 100, // repel hard
      dyShrink: 30, // attract
      renderPath: function (fromNode, toNode) {
        var dx = fromNode.x - toNode.x;
        return "M" + toNode.x + "," + (toNode.getBottom() + 10)
          + "l-5,0 l5,-10 l5,10 l-5,0 l0,10 "
          + "l"+dx+",0 "
          + "L" + fromNode.x + "," + fromNode.getTop();
      }
    },
    one: { 
      preferredDx: 200,
      preferredDy: -200,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 10);
        var toX = toNode.getLeft() + 10;
        var dx = toX - fromX;
        var dy = toNode.y - fromNode.y;
        return "M" + fromX + "," + fromNode.y
          + "c 100,-100 " + (dx - 100) + "," + dy + " " + dx + "," + dy;
      }
    },
    many: { 
      preferredDx: 300,
      preferredDy: 150,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 10);
        var toX = toNode.getLeft() + 10;
        var dx = toX - fromX;
        var dy = toNode.y - fromNode.y;
        return "M" + fromX + "," + fromNode.y
          + "c 100,50 " + (dx - 100) + "," + dy + " " + dx + "," + dy;
      }
    },
    ownsOne: { 
      preferredDx: 200,
      preferredDy: 200,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10,
      renderPathX: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 20);
        var fromY = fromNode.getBottom();
        var toX = toNode.getLeft() + 20;
        var toY = toNode.getTop();
        var dx = toX - fromX;
        var dy = toY - fromY;
        var length = Math.sqrt(dx * dx + dy * dy);
        var ndx = dx / length;
        var ndy = dy / length;
        return "M" + (fromX-4*ndx) + "," + (fromY-4*ndy)
          + " L"+toX +","+toY;
      }
    },
    ownsMany: { 
      preferredDx: 0,
      preferredDy: 300,
      dxGrow: 10,
      dxShrink: 10,
      dyGrow: 10,
      dyShrink: 10,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 20);
        var fromY = fromNode.getBottom();
        var toX = toNode.getLeft() + 20;
        var toY = toNode.getTop();
        var dx = toX - fromX;
        var dy = toY - fromY;
        var length = Math.sqrt(dx * dx + dy * dy);
        var ndx = dx / length;
        var ndy = dy / length;
        return "M" + (fromX + 10 * ndx) + "," + (fromY + 10 * ndy)
          + " l" + (-5 * ndx + 20 * ndy) + "," + (-5 * ndy + 20 * ndx)
          + " l" + (-5 * ndx - 20 * ndy) + "," + (-5 * ndy - 20 * ndx)
          + " L" + toX + "," + toY;
      }
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
        this.bottomRect = svg.rect({ stroke: 'black', 'stroke-width': 1, fill: '#666666', width: this.width, height: this.height, rx: 5, ry: 5 }),
        this.textElement = svg.text({ 'font-family': '"Helvetica Neue", Helvetica, Arial, sans-serif', 'font-size': '15px', fill: 'white', y:15, x:2.5}, this.text)
      );
      this.moveTo(x, y);
      this.graph.nodesContainer.appendChild(this.node);
      var textLength = this.textElement._node.getComputedTextLength();
      if (textLength > this.width - 10) {
        this.adjustWidth(textLength + 10);
      }
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
    adjustWidth: function (width) {
      this.width = width;
      this.node.setAttribute("width", this.width);
      this.bottomRect.setAttribute("width", this.width);
      this.renderXY();
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
    },
    getBottom: function () {
      return this.y + this.height / 2;
    },
    getTop: function () {
      return this.y - this.height / 2;
    },
    getLeft: function () {
      return this.x - this.width / 2;
    },
    getRight: function () {
      return this.x + this.width / 2;
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
      this.node = svg.path({ stroke: 'black', 'stroke-width': this.type.strokeWidth || 1, fill: 'none' });
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
      if (this.node) {
        if(this.type.renderPath) {
          this.node.setAttribute("d", this.type.renderPath(this.fromNode, this.toNode));
        } else {
          this.node.setAttribute("d", "M" + this.fromNode.x + "," + this.fromNode.y+ " L"+this.toNode.x+","+this.toNode.y);
        }
      }
    }
  };

  ns.Graph = createFragment({
    createMarkup: function () {
      this.viewBox = { // height extends the viewport deliberately
        width: 2000,
        height: 4000,
        minX: -1000,
        minY: -2000
      };
      var result = html.div({ className: 'graph'},
        this.node = svg.svg({ viewBox: [this.viewBox.minX, this.viewBox.minY, this.viewBox.width, this.viewBox.height].toString(), preserveAspectRatio: "xMidYMid slice" },
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
          var factor = 0;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
            factor = 2;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
            factor = -2;
          }
          if (otherNode) {
            if(!otherNode.isVisible()) {
              otherNode.appear(node.x + (edge.type.preferredDx / factor)+(factor * offset++), node.y + (edge.type.preferredDy / factor));
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
	      var ratio = this.viewBox.width / this.drag.graphWidth;
    		deltaX = deltaX * ratio;
    		deltaY = deltaY * ratio;
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
    			graphWidth: this.node.get('clientWidth'),
    			graphHeight: this.node.get('clientHeight')
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