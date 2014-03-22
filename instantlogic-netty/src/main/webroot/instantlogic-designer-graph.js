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
  var dragFactor = 0.06; // damping
  var repelFactor = 10;
  var accFactor = speed / 1000000;
  var speedLimit = 0.7;
  var speedThreshold = 0.01;

  var renderPathWithDiamond = function (fromX, fromY, toX, toY) {
    var dx = toX - fromX;
    var dy = toY - fromY;
    var length = Math.sqrt(dx * dx + dy * dy);
    var ndx = dx / length;
    var ndy = dy / length;
    return "M" + (fromX + 16 * ndx) + "," + (fromY + 16 * ndy)
      + " l" + (-8 * ndx + 4 * ndy) + "," + (-8 * ndy - 4 * ndx)
      + " l" + (-8 * ndx - 4 * ndy) + "," + (-8 * ndy + 4 * ndx)
      + " l" + (8 * ndx - 4 * ndy) + "," + (8 * ndy + 4 * ndx)
      + " l" + (8 * ndx + 4 * ndy) + "," + (8 * ndy - 4 * ndx)
      + " L" + toX + "," + toY;
  };

  edgeTypes = {
    inherits: { // subclass -> superclass
      preferredDx: 0,
      preferredDy: -100, // from below
      dxGrow: 2,
      dxShrink: 2,
      dyGrow: 100, // repel hard
      dyShrink: 5, // attract
      renderPath: function (fromNode, toNode) {
        var dx = fromNode.x - toNode.x;
        return "M" + toNode.x + "," + (toNode.getBottom() + 10)
          + "l-5,0 l5,-10 l5,10 l-5,0 l0,10 "
          + "l"+dx+",0 "
          + "L" + fromNode.x + "," + fromNode.getTop();
      }
    },
    one: { 
      preferredDx: -200,
      preferredDy: -100,
      dxGrow: 2,
      dxShrink: 2,
      dyGrow: 2,
      dyShrink: 2,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getLeft() + fromNode.width / 4);
        var fromY = fromNode.y;
        var toX = toNode.getRight() - toNode.width / 4;
        var toY = toNode.y;
        var dx = toX - fromX;
        var dy = toY - fromY;
        var halfY = dy / 2;
        return "M" + fromX + "," + fromY
          + "c 0,"+halfY +" "+ dx + "," + halfY + " " + dx + "," + dy;
      }
    },
    many: { 
      preferredDx: -200,
      preferredDy: 100,
      dxGrow: 2,
      dxShrink: 2,
      dyGrow: 5,
      dyShrink: 5,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 10);
        var toX = toNode.getLeft() + 10;
        var dx = toX - fromX;
        var dy = toNode.y - fromNode.y;
        return "M" + fromX + "," + fromNode.y
          + "c 40,20 " + (dx - 40) + "," + dy + " " + dx + "," + dy;
      }
    },
    ownsOne: { 
      preferredDx: 200,
      preferredDy: 0,
      dxGrow: 5,
      dxShrink: 5,
      dyGrow: 10,
      dyShrink: 50, // push down hard
      strokeWidth: 2,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 20);
        var fromY = fromNode.getBottom();
        var toX = toNode.getLeft() + 20;
        var toY = toNode.getTop();
        return renderPathWithDiamond(fromX, fromY, toX, toY);
      }
    },
    ownsMany: { 
      preferredDx: 150,
      preferredDy: 150,
      dxGrow: 5,
      dxShrink: 5,
      dyGrow: 10,
      dyShrink: 50, // push down hard
	    strokeWidth: 2,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 40);
        var fromY = fromNode.getBottom();
        var toX = toNode.getLeft() + 20;
        var toY = toNode.getTop();
        return renderPathWithDiamond(fromX, fromY, toX, toY);
      }
    },
    parts: {
      preferredDx: 0,
      preferredDy: 150,
      dxGrow: 5,
      dxShrink: 5,
      dyGrow: 10,
      dyShrink: 50, // push down hard
      strokeWidth: 2,
      fill: true,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getRight() - 40);
        var fromY = fromNode.getBottom();
        var toX = toNode.getLeft() + 20;
        var toY = toNode.getTop();
        return renderPathWithDiamond(fromX, fromY, toX, toY)+"Z";
      }
    },
    role: {
      preferredDx: -200,
      preferredDy: 0,
      dxGrow: 50,
      dxShrink: 5,
      dyGrow: 5,
      dyShrink: 5, 
      strokeWidth: 1,
      renderPath: function (fromNode, toNode) {
        var fromX = (fromNode.getLeft());
        var fromY = fromNode.y;
        var toX = toNode.getRight();
        var toY = toNode.y;
        return "M" + (toX+8) + "," + toY
          + "l0,4 l-8,0 l0,-8 l8,0 l0,4 "
          + "L" + fromX + "," + fromY;
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

  window.Physics.behavior('speedLimit', function (parent) {
    return {
      init: function (options) {
        parent.init.call(this, options);
      },
      connect: function (world) {
        world.subscribe('integrate:velocities', this.applySpeedLimit, this);
      },
      disconnect: function (world) {
        world.unsubscribe('integrate:velocities', this.applySpeedLimit);
      },
      applySpeedLimit: function (data) {
        var bodies = data.bodies;
        for(var i = 0; i < bodies.length; i++) {
          var body = bodies[i];
          var vel = body.state.vel;
          if(vel.norm() > speedLimit) {
            vel.normalize().mult(speedLimit);
          } else if(vel.norm() < speedThreshold) {
            vel.set(0, 0);
          }
        }
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
    this.expanded = false;
    this.frozen = false;
    this.selected = false;
  };

  var fontFamily = '"Helvetica Neue", Helvetica, Arial, sans-serif';
  var fontSize = '15px';

  Node.prototype = {
    appear: function (x, y) {
      this.node = svg.svg({ width: this.width, height: this.height, x: -this.width / 2, y: -this.height / 2 },
        this.bottomRect = svg.rect({ stroke: 'black', 'stroke-width': 1, fill: '#666666', width: this.width, height: this.height, rx: 8, ry: 8 }),
        this.textElement = svg.text({ 'font-family': fontFamily, 'font-size': fontSize, fill: 'white', y: 15, x: 4 }, this.text),
        this.expandRect = svg.svg({ x: this.width - 20, y: 0, width: 20, height: 40, cursor: 'pointer' },
          this.expandText = svg.text({ 'font-family': fontFamily, 'font-size': fontSize, fill: 'white', y: 25, x: 5 }, this.expanded ? '-' : '+')
        )
      );
      this.moveTo(x, y);
      this.graph.nodesContainer.appendChild(this.node);
      this.adjustDimensions();
      this.renderXY();

      this.expandRect.on('mousedown', this.onExpand, this);
      this.node.on('mousedown', this.onMousedown, this);
      this.point = window.Physics.body("point", { x: x, y: y });
      this.graph.world.add(this.point);
    },
    adjustDimensions: function () {
      var textLength = this.textElement._node.getComputedTextLength();
      this.width = Math.max(100, textLength + (this.selected ? 40 : 10));
      this.height = this.selected ? 40 : 20;
      this.node.setAttribute("width", this.width);
      this.node.setAttribute("height", this.height);
      this.bottomRect.setAttribute("width", this.width);
      this.bottomRect.setAttribute("height", this.height);
      this.bottomRect.setAttribute('fill', this.selected ? 'blue' : "#666666");
      this.textElement.setAttribute("y", this.selected ? 25 : 15);
      this.textElement.setAttribute("x", this.selected ? 14 : 4);
      this.expandRect.setAttribute("display", this.selected ? "" : "none");
      this.expandRect.setAttribute("x", this.width - 20);
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
      return this.expanded;
    },
    freeze: function () {
      this.frozen = true;
      this.point.fixed = true;
    },
    unfreeze: function () {
      this.frozen = false;
      this.point.fixed = false;
    },
    setSelected: function (selected) {
      this.selected = selected;
      this.adjustDimensions();
      this.renderXY();
    },
    onExpand: function (evt) {
      evt.preventDefault();
      this.expanded = !this.expanded;
      this.expandText.set('text', this.expanded ? '-' : '+');
      if(this.expanded) {
        this.graph.addRelatedNodes(this);
      } else {
        this.graph.removeUnrelatedNodes(this);
      }
    },
    onMousedown: function (evt) {
      if(!evt._event.defaultPrevented) {
        evt.preventDefault();
        this.selectedBeforeMousedown = this.selected;
        this.setSelected(true);
        this.point.fixed = true;
        this.graph.startDrag(this, evt);
      }
    },
    endDrag: function (moved) {
      if (this.point.fixed) {
        if(moved) {
          this.freeze();
        } else {
          if(this.frozen) {
            this.unfreeze();
          } else {
            this.point.fixed = false;
            this.setSelected(!this.selectedBeforeMousedown);
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
      this.node = svg.path({ stroke: 'black', 'stroke-width': this.type.strokeWidth || 1, fill: this.type.fill?'black':'none' });
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
        height: 2000,
        minX: -1000,
        minY: -1000
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
      startNode.setSelected(true);
      startNode.freeze();
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
            factor = 4;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
            factor = -4;
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
        //this.adjustNodeVisibility(node);
        for(var i = 0; i < this.edges.length; i++) {
          var otherNode = null;
          var edge = this.edges[i];
          if (edge.fromNode === node) {
            otherNode = edge.toNode;
          } else if (edge.toNode === node) {
            otherNode = edge.fromNode;
          }
          if(otherNode && otherNode !== node && otherNode.isVisible() && !otherNode.isExpanded()) {
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
        this.world.add(window.Physics.behavior('speedLimit', { }));
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