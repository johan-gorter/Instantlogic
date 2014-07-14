/// <reference path="~/lib/d3.js" />

/*globals $, d3 */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  var svg = $.element.svg;
  var stopPropagation = function (evt) {
    evt.stopPropagation();
  };

  // Using zepto, borrowing from d3 when needed.
  var initZoom = function (handleZoom, visualization, onRescale) {

    var rescale = function () {
      var trans = window.d3.event.translate;
      var scale = window.d3.event.scale;
      visualization
        .attr("transform",
          "translate(" + trans + ")"
          + " scale(" + scale + ")");
      onRescale(scale, trans);
    };

    window.d3.select(handleZoom[0])
      .call(window.d3.behavior.zoom().on("zoom", rescale))
      .on("dblclick.zoom", null);
  };

  function toSVGCoordinates(element, clientX, clientY) {
    var svgElement = element.ownerSVGElement;
    var point = svgElement.createSVGPoint();
    point.x = clientX, point.y = clientY;
    point = point.matrixTransform(svgElement.getScreenCTM().inverse());
    return [point.x, point.y];
  }



  // INSTANCE /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



  var createInstance = function (appendTo, id, graph, dataSource, pos) {
    var focussed = false;
    var getReverseRelations;
    var getRelations;
    var getAttributes ;
    var afterLoad = {};
    var x = pos ? pos[0] : 0;
    var y = pos ? pos[1] : 0;
    var data = null;
    var bindings = [];
    var bindingFactory = window.fragment.createBindingFactory(bindings);
    var layoutData = {
      width: 160,
      visibleReverseRelationsCount: 0,
      visibleRelationsCount: 0,
      visibleAttributesCount: 0,
      totalHeight: 45
    };
    var layoutBindings = [];
    var layoutBindingFactory = window.fragment.createBindingFactory(layoutBindings);

    var api = {
      id: id,
      getPosition: function () {
        return [x, y];
      },
      getRelations: function () {
        return getRelations(); // temporary for testing
      }, 
      render: function () {
        updateLayoutData();
        layoutEverything();
      },
      getId: function () {
        return id;
      },
      getGraph: function () {
        return graph;
      },
      setFocus: function (focus) {
        focussed = focus;
        if (focus) {
          rootGroup.addClass("focus");
          expandCollapsePath.attr("transform", "rotate(180 10 4)");
        } else {
          rootGroup.removeClass("focus");
          expandCollapsePath.attr("transform", "");
        }
        updateLayoutData();
        layoutEverything();
        graph.renderRelations();
      },
      selectReverseOf: function (relation, relationIsReverse) {
        if (data) {
          selectReverseOf(relation, relationIsReverse);
        } else {
          afterLoad.selectReverseOf = relation;
          afterLoad.selectReverseOfIsReverse = relationIsReverse;
        }
      },
      getRelationPosition: function (relation, relationIsReverse, anchor) {
        if (!data) {
          return [x, y];
        }
        var offset = relationIsReverse ? 31 : 33;
        if (!relationIsReverse) {
          getReverseRelations().forEach(function (reverseRelation) {
            if (focussed || reverseRelation.isSelected()) {
              offset += 20;
            }
          });
        }
        if(relation.getIndex() !== -1) {
          offset = offset + relation.getIndex() * 20 + 10;
        }
        return [x + (anchor === "right" ? layoutData.width/2 : -layoutData.width/2), y + offset];
      },
      forEachRelationValue: function (callback) {
        getRelations().forEach(function (relation) {
          relation.forEachValue(function (value) {
            callback(relation, value, false);
          });
        });
        getReverseRelations().forEach(function (relation) {
          relation.forEachValue(function (value) {
            callback(relation, value, true);
          });
        });
      },
      dispose: function () {
        rootGroup.remove();
        subscription.dispose();
      }
    };

    var createAttributeFactory = function (attributeType) {
      return {
        createFragment: function (dummyType, append, id, instance) {
          return createAttribute(append, id, attributeType, instance);
        }
      };
    };

    var close = function () {
      graph.hideInstance(id);
    };

    // the bindings and markup
    var separator2Y = layoutBindingFactory.attribute(function (d) { return (d.visibleReverseRelationsCount * 20 + 32); });
    var relationsGroupTransform = layoutBindingFactory.attribute(function (d) { return "translate(0, " + (d.visibleReverseRelationsCount * 20 + 33) + ")"; });
    var separator3Y = layoutBindingFactory.attribute(function (d) { return ((d.visibleReverseRelationsCount + d.visibleRelationsCount) * 20 + 34); });
    var attributesGroupTransform = layoutBindingFactory.attribute(function (d) { return "translate(0, " + ((d.visibleReverseRelationsCount + d.visibleRelationsCount)*20 + 35) + ")"; });
    var expandCollapseTransform = layoutBindingFactory.attribute(function (d) { return "translate(-10, " + (d.totalHeight - 9) + ")"; });
    var backgroundX = layoutBindingFactory.attribute(function (d) { return -d.width/2; });
    var textStartX = layoutBindingFactory.attribute(function (d) { return 10 - d.width / 2;});
    var textColumnWidth = layoutBindingFactory.attribute(function (d) { return d.width / 2 - 15; });
    var textWidth = layoutBindingFactory.attribute(function (d) { return d.width - 27; });
    var width = layoutBindingFactory.attribute("width");
    var totalHeight = layoutBindingFactory.attribute("totalHeight");
    var lineStartX = layoutBindingFactory.attribute(function (d) { return -d.width/2; });
    var lineEndX = layoutBindingFactory.attribute(function (d) { return d.width / 2; });
    var closeTranform = layoutBindingFactory.attribute(function (d) { return "translate(" + (d.width / 2 - 20) + ", 0)"; });

    var expandCollapsePath, expandCollapseGroup, resizeRect;
    var rootGroup = svg.g({ "class": "instance" },
      svg.rect({
        "class": "background", x: backgroundX, y: "0",
        width: width, height: layoutBindingFactory.attribute("totalHeight"), rx: "10", ry: "10"
      }),
      svg.g({transform: closeTranform},
        svg.rect({ x: 0, y: 0, width: 20, height: 20, cursor: "pointer", fill: "transparent" })
          .on("click", close)
          .on("mousedown", stopPropagation),
        svg.path({stroke: "white", "stroke-width": 1.5, "pointer-events": "none", d: "M7,5 l 8,8 m -8,0 l 8,-8"})
      ),
      svg.clipPath({ id: "clip-" + id }, svg.rect({ x: textStartX, y: "0", width: textWidth, height: totalHeight })),
      svg.clipPath({ id: "clip-key-" + id }, svg.rect({ x: textStartX, y: "0", width: textColumnWidth, height: totalHeight })),
      svg.clipPath({ id: "clip-value-" + id }, svg.rect({ x: "5", y: "0", width: textColumnWidth, height: totalHeight })),
      svg.text({ "class": "title", "clip-path": "url(#clip-" + id + ")", "text-anchor": "left", x: textStartX, y: "4", dy: "15", "pointer-events": "none" },
        bindingFactory.text("title")
      ),
      svg.line({ x1: lineStartX, y1: "30", "x2": lineEndX, y2: "30", "class": "separator" }),
      svg.g({ "transform": "translate(0,31)" },
        bindingFactory.fragmentPerItem("reverseRelations", api, createAttributeFactory("reverseRelation"), function (getChildFragments) { getReverseRelations = getChildFragments; })
      ),
      svg.line({ x1: lineStartX, y1: separator2Y, "x2": lineEndX, y2: separator2Y, "class": "separator" }),
      svg.g({ "transform": relationsGroupTransform },
        bindingFactory.fragmentPerItem("relations", api, createAttributeFactory("relation"), function (getChildFragments) { getRelations = getChildFragments; })
      ),
      svg.line({ x1: lineStartX, y1: separator3Y, "x2": lineEndX, y2: separator3Y, "class": "separator" }),
      svg.g({ "transform": attributesGroupTransform },
        bindingFactory.fragmentPerItem("attributes", api, createAttributeFactory("attribute"), function (getChildFragments) { getAttributes = getChildFragments; })
      ),
      resizeRect = svg.rect({x: lineEndX, y: 0, width: 5, height: totalHeight, fill: "transparent", cursor: "ew-resize"}),
      expandCollapseGroup = svg.g({ transform: expandCollapseTransform },
        expandCollapsePath = svg.path({ "class": "expand-collapse", d: "M5,3 l 5,3 l 5,-3" }),
        svg.rect({ "class": "button", x: "0", y: "0", width: "20", height: "8" })
      )
    );

    var updateLayoutData = function () {
      if(!getReverseRelations) return;
      layoutData.visibleReverseRelationsCount = 0;
      getReverseRelations().forEach(function (item) {
        if (focussed || item.isSelected()) {
          item.setIndex(layoutData.visibleReverseRelationsCount++);
        } else {
          item.setIndex(-1);
        }
      });
      layoutData.visibleRelationsCount = 0;
      getRelations().forEach(function (item) {
        if (focussed || item.isSelected()) {
          item.setIndex(layoutData.visibleRelationsCount++);
        } else {
          item.setIndex(-1);
        }
      });
      layoutData.visibleAttributesCount = 0;
      getAttributes().forEach(function (item) {
        if (focussed || item.isSelected()) {
          item.setIndex(layoutData.visibleAttributesCount++);
        } else {
          item.setIndex(-1);
        }
      });
      layoutData.totalHeight =
        (layoutData.visibleReverseRelationsCount + layoutData.visibleRelationsCount + layoutData.visibleAttributesCount) * 20 + 45;
    };

    function renderPosition() {
      // moves the group into x,y
      rootGroup.attr("transform", "translate(" + x + "," + y + ")");
      graph.renderRelations();
    }

    function layoutEverything() {
      // positions everything inside the group
      layoutBindings.forEach(function (binding) {
        binding.update(layoutData, window.fragment.immediateDiff);
      });
    };

    function click(evt) {
      graph.requestFocus(api);
    };

    function beginDrag(fromX, fromY, touchIdentifier) {
      var oldX = x;
      var oldY = y;
      var moved = false;
      var scale = graph.getScale();
      var from = toSVGCoordinates(rootGroup[0], fromX, fromY);
      var svg = $(rootGroup[0].ownerSVGElement);
      function moveTo(toX, toY) {
        var to = toSVGCoordinates(rootGroup[0], toX, toY);
        x = oldX + (to[0] - from[0]) / scale;
        y = oldY + (to[1] - from[1]) / scale;
        renderPosition();
      };
      function mouseMoved(evt) {
        moved = true;
        moveTo(evt.clientX, evt.clientY);
      };
      function dragEnd(evt) {
        if(!moved) {
          click(evt);
        }
      }
      if(touchIdentifier) {
        svg.on("touchmove", function (evt) {
          for(var i = 0; i < evt.changedTouches.length; i++) {
            var touch = evt.changedTouches[i];
            if(touch.identifier === touchIdentifier) {
              moveTo(touch.clientX, touch.clientY);
            }
          }
        });
        //TODO: touchend
      } else {
        svg.on("mousemove", mouseMoved);
        svg.one("mouseup", function (evt) {
          svg.off("mousemove", mouseMoved);
          dragEnd(evt);
        });
      }
    };

    function updateWidth(item) {
      item.setWidth(layoutData.width);
    }

    function setWidth(newWidth) {
      layoutData.width = newWidth;
      if(getReverseRelations) {
        getReverseRelations().forEach(updateWidth);
        getRelations().forEach(updateWidth);
        getAttributes().forEach(updateWidth);
      }
    };

    function beginResize(fromX, fromY) {
      var oldWidth = layoutData.width;
      var oldX = x;
      var scale = graph.getScale();
      var from = toSVGCoordinates(rootGroup[0], fromX, fromY);
      var svg = $(rootGroup[0].ownerSVGElement);
      function moveTo(toX, toY) {
        var to = toSVGCoordinates(rootGroup[0], toX, toY);
        var newWidth = oldWidth + (to[0] - from[0]) / scale;
        if(newWidth < 80) {
          newWidth = 80;
        }
        setWidth(newWidth);
        x = oldX + (newWidth - oldWidth) / 2;
        renderPosition();
        layoutEverything();
      };
      function mouseMoved(evt) {
        moveTo(evt.clientX, evt.clientY);
      };
      svg.on("mousemove", mouseMoved);
      svg.one("mouseup", function (evt) {
        svg.off("mousemove", mouseMoved);
      });
    };

    resizeRect.on("mousedown", function (evt) {
      beginResize(evt.clientX, evt.clientY, null);
      evt.stopPropagation();
    });

    rootGroup.on("mousedown", function (evt) {
      beginDrag(evt.clientX, evt.clientY, null);
      evt.stopPropagation();
    });

    rootGroup.on("touchstart", function (evt) {
      beginDrag(evt.clientX, evt.clientY, evt.targetTouches[0].identifier);
      evt.stopPropagation();
    });

    expandCollapseGroup.on("mousedown touchstart", stopPropagation);
    expandCollapseGroup.on("click", function (evt) {
      click(evt);
    });

    appendTo.append(rootGroup);

    var selectReverseOf = function (otherRelation, otherRelationIsReverse) {
      if(otherRelationIsReverse) {
        var reverseId = otherRelation.getReverseOf();
        getRelations().forEach(function (relation) {
          if(relation.id === reverseId) {
            relation.setSelected(true);
          }
        });
      } else {
        getReverseRelations().forEach(function (relation) {
          if (relation.getReverseOf() === otherRelation.id) {
            relation.setSelected(true);
          }
        });
      }
    };

    // Initialization

    renderPosition();
    layoutEverything();

    // listen to the dataSource
    var subscription = dataSource.subscribe(id, function (newData) {
      data = newData;
      if(!newData) {
        graph.hideInstance(id); // calls our dispose()
      } else {
        bindings.forEach(function (binding) {
          binding.update(newData, window.fragment.immediateDiff);
        });
        if(afterLoad.selectReverseOf) {
          selectReverseOf(afterLoad.selectReverseOf, afterLoad.selectReverseOfIsReverse);
          afterLoad = {};
        }
        updateLayoutData();
        layoutEverything();
        graph.renderRelations();
      }
    });


    return api;
  };



  // ATTRIBUTE ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



  var createAttribute = function (append, id, type, instance) {
    var data = {}; // format { id: "project", reverse: "issues", owner: true, stored: "project1" }
    var bindings = [];
    var bindingFactory = window.fragment.createBindingFactory(bindings);
    var layoutData = {
      width: 160
    };
    var layoutBindings = [];
    var layoutBindingFactory = window.fragment.createBindingFactory(layoutBindings);

    var index = -1;
    var selected = false;

    var api = {
      id: id,
      isReverseRelation: function () {
        return !!data.reverse;
      },
      getReverseOf: function () {
        return data.reverse;
      },
      init: function (initData) {
        data = initData;
        if(type !== "attribute") {
          var graph = instance.getGraph();
          api.forEachValue(function (value) {
            graph.relationValueAdded(api, value, data.reverse);
          });
        }
        render();
      },
      update: function (newData) {
        var graph = instance.getGraph();
        var oldValues = data.stored;
        if(!oldValues) {
          oldValues = [];
        }
        if(!(oldValues instanceof Array)) {
          oldValues = [oldValues];
        }
        data = newData;
        api.forEachValue(function (newValue) {
          var i = oldValues.indexOf(newValue);
          if(index === -1) {
            oldValues.splice(i, 1);
          } else {
            graph.relationValueAdded(api, newValue, data.reverse);
          }
        });
        oldValues.forEach(function (value) {
          graph.relationValueRemoved(api, value, data.reverse);
        });
        render();
      },
      destroy: function () {
      },
      getIndex: function () {
        return index;
      },
      setIndex: function (newIndex) {
        index = newIndex;
        if (newIndex === -1) {
          rootGroup.attr("display", "none");
        } else {
          rootGroup.attr("display", "");
          rootGroup.attr("transform", "translate(0, " + (20 * index) + ")");
        }
      },
      setSelected: function (newSelected) {
        if (selected !== newSelected) {
          selected = newSelected;
          rootGroup.toggleClass("selected", newSelected);
          instance.render();
          instance.getGraph().renderRelations();
        }
      },
      isSelected: function () {
        return selected;
      },
      getValue: function () {
        return data.stored;
      },
      forEachValue: function (callback) {
        if (data.stored) {
          if (data.stored instanceof Array) {
            data.stored.forEach(callback);
          } else {
            callback(data.stored, 0);
          }
        }
      },
      getInstance: function () {
        return instance;
      },
      setWidth: function (newWidth) {
        layoutData.width = newWidth;
        renderLayout();
      }
    };

    var openEditor = function (evt) {
      instance.getGraph().showDialog(createDialog);
      evt.preventDefault();
      evt.stopPropagation();
    };

    var appendRelationLine = function (appendTo, instanceId, lineIndex) {
      var visible = instance.getGraph().isInstanceVisible(instanceId);
      var toggle = function () {
        visible = !visible;
        if(visible) {
          instance.getGraph().showInstance(instanceId, instance, api, lineIndex, type === "reverseRelation");
        } else {
          instance.getGraph().hideInstance(instanceId);
        }
        showHideButton.text(visible ? "Hide" : "Show");
        line.toggleClass("instance-visible", visible);
      };
      var showHideButton = html.button(visible ? "Hide" : "Show").on("click", toggle);

      var line = html.div({ "class": "line" },
        html.span(instanceId),
        showHideButton
      ).toggleClass("instance-visible", visible).appendTo(appendTo);
    };

    var createDialog = function (appendTo) {
      html.h1(data.name || data.id).appendTo(appendTo);
      if(type === "attribute") {
        html.textarea().val(data.stored).prop('readonly', true).appendTo(appendTo);
      } else {
        if(data.stored instanceof Array) {
          for(var i = 0; i < data.stored.length; i++) {
            appendRelationLine(appendTo, data.stored[i], i);
          }
        } else {
          appendRelationLine(appendTo, data.stored, 0);
        }
      }
      return {
      };
    };

    var toggleSelected = function (evt) {
      evt.preventDefault();
      evt.stopPropagation();
      if (!selected) {
        api.setSelected(true);
      } else {
        api.setSelected(false);
      }
    };

    var render = function () {
      bindings.forEach(function (binding) {
        binding.update(data, window.fragment.immediateDiff);
      });
    };
    var renderLayout = function () {
      layoutBindings.forEach(function (binding) {
        binding.update(layoutData, window.fragment.immediateDiff);
      });
    };

    var nameText = bindingFactory.text(function (d) {
      return (d.name || d.id);
    });
    var valueText = bindingFactory.text(function (d) {
      if (type === "attribute") {
        if (!d.stored) return "";
        if(d.stored instanceof Array) {
          return ""+d.stored.length;
        }
        return "" + d.stored;
      }
      // relation
      if(d.stored instanceof Array) {
        return "" + d.stored.length;
      } else {
        if(!d.stored) {
          return "0";
        }
        return "1";
      }
    });

    var width = layoutBindingFactory.attribute("width");
    var textStartX = layoutBindingFactory.attribute(function (d) { return 10 - d.width / 2; });
    var backgroundStartX = layoutBindingFactory.attribute(function (d) { return -d.width / 2; });
    var columWidth = layoutBindingFactory.attribute(function (d) { return d.width / 2; });

    var rootGroup = svg.g({ "class": "attribute", "display": "none" },
      svg.rect({ "class": "background", x: backgroundStartX, y: 0, width: width, height: 20 })
        .on("click", toggleSelected)
        .on("mousedown", stopPropagation),
      svg.text({
        "class": "name", "text-anchor": "left", "clip-path": "url(#clip-key-" + instance.getId() + ")",
        x: textStartX, y: "0", dy: "15", "pointer-events": "none"
      }, nameText),
      svg.rect({x: 0, y: 0, width: columWidth, height: "20", fill: "transparent", cursor: "pointer" })
        .on("click", openEditor)
        .on("mousedown", stopPropagation),
      svg.text({
        "class": "value", "text-anchor": "left", "clip-path": "url(#clip-value-" + instance.getId() + ")",
        x: "10", y: "0", dy: "15", "pointer-events": "none"
      }, valueText).on("click", openEditor)
    );

    append(rootGroup);
    renderLayout();
    return api;
  };


  // EDGE (relation) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


  var createEdge = function(appendTo, relation, value, reverseRelation, reverseValue) {
    var path = svg.path({ "class": "relation", d: "" });
    
    path.appendTo(appendTo);
    
    var setVisibility = function() {
      path[0].setAttribute("display", (relation && reverseRelation)?"":"none");
    };
    
    return {
      connectTo: function (fromInstance, fromRelation, toValue) {
        if (!relation) {
          if (reverseValue === fromInstance.id 
                && reverseRelation.getInstance().id === toValue
                && reverseRelation.getReverseOf() === fromRelation.id) {
            relation = fromRelation;
            value = toValue;
            setVisibility();
            return true;
          }
        }
        return false;
      },
      connectToReverse: function(toInstance, toReverseRelation, fromValue) {
        if (!reverseRelation) {
          if (value === toInstance.id 
                && fromValue === relation.getInstance().id 
                && toReverseRelation.getReverseOf() === relation.id) {
            reverseRelation = toReverseRelation;
            reverseValue = fromValue;
            setVisibility();
            return true;
          }
        }
        return false;
      },
      removeFrom: function (fromInstance, fromRelation, oldValue) {
        // value was removed from a relation
        if(relation && relation === fromRelation) {
          if (oldValue === value) {
            relation = reverseRelation = null;
            return false; // indicates that we should be removed now
          }
        }
        return true;
      },
      removeFromReverse: function () {
        throw new Error("not yet implemented");
      },
      instanceHidden: function(id) {
        if (relation && relation.getInstance().id === id) {
          relation = null;
          value = null;
          setVisibility();
          return !!reverseRelation;
        }
        if (reverseRelation && reverseRelation.getInstance().id === id) {
          reverseRelation = null;
          reverseValue = null;
          setVisibility();
          return !!relation;
        }
        return true;
      },
      render: function () {
        if (reverseRelation && relation) {
          var from = relation.getInstance().getRelationPosition(relation, false, "right");
          var to = reverseRelation.getInstance().getRelationPosition(reverseRelation, true, "left");
          path[0].setAttribute("d", "M"+from+" L"+to);
        }
      },
      dispose: function () {
        path.remove();
      }
    };
  };



  // INSTANCE GRAPH //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



  window.createInstanceGraph = function (appendTo, id, dataSource /*{subscribe(id, function)}*/, startInstanceId) {

    // state
    var instances = [];
    var edges = [];
    var scale = 1;
    var onRescale = function (newScale) {
      scale = newScale;
    };

    var hideRelations = function (instance) {
      for(var i = 0; i < edges.length;) {
        if(!edges[i].instanceHidden(instance.id)) {
          edges[i].dispose();
          edges.splice(i, 1);
        } else {
          i++;
        }
      }
    };

    // Initialization
    var handleZoom, visualization, instancesGroup, relationsGroup;
    var focussedInstance = null;
    var defs = html.div({ "class": "svg-defs"},
      svg.svg(
        svg.defs(
          svg.linearGradient({ id: "instance-gradient", x1: "0%", y1: "0%", x2: "0%", y2: "100%" },
            svg.stop({offset: "0%", "class": "instance-gradient-from"}),
            svg.stop({offset: "100%", "class": "instance-gradient-to"})
          ),
          svg.linearGradient({ id: "selected-instance-gradient", x1: "0%", y1: "0%", x2: "0%", y2: "100%" },
            svg.stop({ offset: "0%", "class": "selected-instance-gradient-from" }),
            svg.stop({ offset: "100%", "class": "selected-instance-gradient-to" })
          )
        )
      )
    );
    var chartSvg = html.div({ "class": "chart" },
      svg.svg({preserveAspectRatio: "xMidYMid slice", viewBox: "-600 -600 1200 1200", "pointer-events": "all" },
        handleZoom = svg.g({ "class": "handle-zoom"},
          svg.rect({"class": "background", x: "-600", y: "-600", width: "1200", height: "1200", fill: "transparent"}),
          visualization = svg.g({"class": "visualization"},
            relationsGroup = svg.g(),
            instancesGroup = svg.g()
          )
        )
      )
    );
    appendTo.append(defs);
    appendTo.append(chartSvg);

    initZoom(handleZoom, visualization, onRescale);

    // API
    var parentApi = {
      getScale: function () {
        return scale;
      },
      requestFocus: function (instance) {
        if(focussedInstance) {
          focussedInstance.setFocus(false);
        }
        if(instance === focussedInstance) {
          focussedInstance = null;
          instance.setFocus(false);
        } else {
          focussedInstance = instance;
          focussedInstance.setFocus(true);
        }
      },
      showDialog: function (callback) {
        var dialog = $("<div class='overlay'><div class='dialog'><div class='close'>&times;</div></div></div>")
          .on("click", function (evt) {
            var target = $(evt.target); 
            if(target.closest(".close").length === 1 || target.closest(".dialog").length === 0) {
              evt.preventDefault();
              dialog.remove();
            }
          })
          .appendTo(chartSvg);
        callback(chartSvg.find(".dialog"));
      },
      removeDialog: function () {
        chartSvg.find(".overlay").remove();
      },
      isInstanceVisible: function (instanceId) {
        for(var i = 0; i < instances.length; i++) {
          if (instances[i].id === instanceId) {
            return true;
          }
        }
        return false;
      },
      showInstance: function (instanceId, fromInstance, relation, itemNr, relationIsReverse) {
        var x = 0;
        var y = 0;
        if(fromInstance && relation) {
          var pos = fromInstance.getPosition();
          x = pos[0] + (300 * (relationIsReverse ? -1 : 1));
          y = pos[1] + relation.getIndex() * 20 + itemNr * 40;
        }
        var instance = createInstance(instancesGroup, instanceId, parentApi, dataSource, [x, y]);
        instances.push(instance);
        instance.selectReverseOf(relation, relationIsReverse);
      },
      hideInstance: function (instanceId) {
        for(var i = 0; i < instances.length; i++) {
          var instance = instances[i];
          if(instance.id === instanceId) {
            instance.dispose();
            instances.splice(i, 1);
            hideRelations(instance);
            return;
          }
        }
        throw new Error("instance not found: " + instanceId);
      },
      renderRelations: function () {
        edges.forEach(function (relation) {
          relation.render();
        });
      },
      relationValueAdded: function (attribute, value, reverseOf) {
        var instance = attribute.getInstance();
        var found = false;
        if(reverseOf) {
          edges.forEach(function (edge) {
            found = found || edge.connectToReverse(instance, attribute, value);
          });
          if (!found) {
            edges.push(createEdge(relationsGroup, null, null, attribute, value));
          }
        } else {
          edges.forEach(function (edge) {
            found = found || edge.connectTo(instance, attribute, value);
          });
          if (!found) {
            edges.push(createEdge(relationsGroup, attribute, value, null, null));
          }
        }
      },
      relationValueRemoved: function (attribute, value, reverseOf) {
        var instance = attribute.getInstance();
        var edgeToRemove = null;
        if (reverseOf) {
          edges.forEach(function (edge) {
            if(!edge.removeFrom(instance, attribute, value)) {
              edgeToRemove = edge;
            }
          });
        } else {
          edges.forEach(function (edge) {
            if(!edge.removeFromReverse(instance, attribute, value)) {
              edgeToRemove = edge;
            }
          });
        }
        if(edgeToRemove) {
          edges.splice(edges.indexOf(edgeToRemove), 1);
          edgeToRemove.dispose();
        }
      }
    };
    parentApi.showInstance(startInstanceId, null, null);
    return {
      test: function () {
        setTimeout(function () {
          parentApi.requestFocus(instances[0]);
          instances[0].getRelations().forEach(function (relation, index) {
            relation.setSelected(true);
            var value = relation.getValue();
            if (value instanceof Array) {
              value.forEach(function (instanceId) {
                parentApi.showInstance(instanceId, instances[0], relation, index, false);
              });
            } else {
              parentApi.showInstance(value, instances[0], relation, index, false);
            }
          });
        }, 50);
      }
    };
  };

}());