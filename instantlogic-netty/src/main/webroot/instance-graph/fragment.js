/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  var svg = $.element.svg;

  // private utitlity functions

  var accessorFunction = function (propertyName) {
    return function (data) {
      return data[propertyName];
    };
  };

  var identityFunction = function (val) {
    return val;
  };

  function indexOfItemWithId(items, id, start) {
    for (var i = start; i < items.length; i++) {
      if (items[i].id === id) {
        return i;
      }
    }
    return -1;
  };

  var createFragmentFactory = function (fragmentTypeLibraries) {
    var api;
    return api = {
      createFragment: function (name, appendFunction, id, parentFragment) {
        for (var i = 0; i < fragmentTypeLibraries.length; i++) {
          var library = fragmentTypeLibraries[i];
          if (library[name]) {
            return library[name](appendFunction, id, parentFragment, api);
          }
        }
        return staticMessage(appendFunction, id, parentFragment, api, { message: 'No fragmentnamespace provides a fragment called ' + name, severity: 'error' });
      },
      createRootFragment: function (appendFunction, type) {
        var rootFragment = api.createFragment(type, appendFunction, null, api);
        return rootFragment;
      }
    };
  };

  var createFragmentHolder = function (appendFunction, insertBeforeFunction, id, parentFragment, fragmentFactory) {
    var startElement = document.createComment("fragment start " + id);
    var endElement = document.createComment("fragment end " + id);
    var fragmentType = null;

    var api = {
      fragment: null,
      remove: function (diff) {
        clear(diff);
        startElement.parentNode.removeChild(startElement);
        endElement.parentNode.removeChild(endElement);
      },

      insertBeforeMe: function (element) {
        // Is only called from another FragmentHolder
        startElement.parentNode.insertBefore(element, startElement);
      },

      init: function (data) {
        fragmentType = data.type;
        api.fragment = fragmentFactory.createFragment(fragmentType, append, id, parentFragment, fragmentFactory);
        api.fragment.init(data);
      },

      registerNodesAsAdded: function (diff) {
        var nextElement = startElement.nextSibling;
        while (nextElement !== endElement) {
          var element = nextElement;
          nextElement = nextElement.nextSibling;
          diff.nodeAdded($(element));
        }
      },

      update: function (newModel, diff) {
        if (fragmentType != newModel.type) {
          recreateFragment(newModel, diff);
        } else {
          api.fragment.update(newModel, diff);
        }
      },

      destroy: function () {
        // The nodes are left behind for animation purposes
        api.fragment.destroy();
      },

      toString: function () {
        return 'FragmentHolder#' + id;
      }
    };

    if (insertBeforeFunction) {
      insertBeforeFunction(endElement);
      endElement.parentNode.insertBefore(startElement, endElement);
    } else {
      appendFunction(startElement);
      appendFunction(endElement);
    }

    var clear = function (diff) {
      var nextElement = startElement.nextSibling;
      while(nextElement !== endElement) {
        var element = nextElement;
        nextElement = nextElement.nextSibling;
        if(diff) {
          diff.nodeToRemove(element);
        } else {
          element.parentNode.removeChild(element);
        }
      }
    };

    var recreateFragment = function (newModel, diff) {
      fragment.destroy();
      clear(null);
      diff.nodeUpdated($(startElement.parentNode));
      fragment = fragmentFactory.createFragment(newModel.type, append, id, parentFragment, fragmentFactory);
      fragment.init(newModel);
    };

    var append = function (node) {
      // This is the only function that is exposed to the Fragment within
      $(node).insertBefore(endElement);
    };

    return api;
  };

  var bindingTypes = {
    // the value of an attribute
    attribute: function (propertyOrAccessor, translator) {
      var bindingFactory = this;
      if (typeof propertyOrAccessor !== "function") {
        propertyOrAccessor = accessorFunction(propertyOrAccessor);
      }
      if(!translator) {
        translator = identityFunction;
      }
      return function (element, propertyName) {
        var oldValue = null;
        bindingFactory.addBinding(function (data) {
          var newValue = translator(propertyOrAccessor(data)) || "";
          if (oldValue !== newValue) {
            element[0].setAttribute(propertyName, newValue);
            // JGO: animating this change is not yet implemented (but this is easy to do)
            oldValue = newValue;
          }
        });
      };
    },
    // the inner text of an element
    text: function (propertyOrAccessor) {
      var bindingFactory = this;
      if (typeof propertyOrAccessor !== "function") {
        propertyOrAccessor = accessorFunction(propertyOrAccessor);
      }
      return function (element) {
        var oldValue = null;
        bindingFactory.addBinding(function (data) {
          var newValue = propertyOrAccessor(data) || "";
          if (oldValue !== newValue) {
            element.text(newValue);
            oldValue = newValue;
          }
        });
      };
    },
    // maintains a fragment for each item in the array in the data
    fragmentPerItem: function (propertyOrAccessor, parentFragment, fragmentFactory, getChildFragmentsCallback) {
      var bindingFactory = this;
      if (typeof propertyOrAccessor !== "function") {
        propertyOrAccessor = accessorFunction(propertyOrAccessor);
      }
      return function (element) {
        var items = [];
        var holders = [];
        if(getChildFragmentsCallback) {
          getChildFragmentsCallback(function () {
            return holders.map(function (holder) { return holder.fragment; });
          }, element);
        }
        var append = function (child) {
          element.append(child);
        };
        bindingFactory.addBinding({
          init: function (data) {
            items = propertyOrAccessor(data) || [];
            for(var i = 0; i < items.length; i++) {
              var fragmentHolder = createFragmentHolder(append, null, items[i].id, parentFragment, fragmentFactory);
              fragmentHolder.init(items[i]);
              holders.push(fragmentHolder);
            }
          },
          update: function (newData, diff) {
            // The magical algorithm
            var oldItems = items;
            var newItems = propertyOrAccessor(newData) || [];
            if(oldItems.length != holders.length) {
              throw new Error('oldItems/holders mismatch');
            }
            items = newItems;
            var oldIndex = 0;
            var newIndex = 0;
            var i;
            while(newIndex < newItems.length) {
              var oldModel = (oldIndex < oldItems.length) ? oldItems[oldIndex] : {};
              var newModel = newItems[newIndex];
              if(oldModel.id != newModel.id) {
                var findOldIndex = indexOfItemWithId(oldItems, newModel.id, oldIndex + 1);
                if(findOldIndex >= 0) {
                  // remove child fragments
                  for(i = newIndex; i < newIndex + findOldIndex - oldIndex; i++) {
                    holders[i].destroy();
                    holders[i].remove(diff);
                  }
                  holders.splice(newIndex, findOldIndex - oldIndex);
                  oldIndex = findOldIndex + 1;
                  holders[newIndex].update(newModel, diff);
                } else {
                  // New fragmentHolder
                  var appendFunction = null;
                  var insertBeforeFunction = null;
                  // where to insert?
                  if(holders.length > newIndex) {
                    insertBeforeFunction = function (newElement) {
                      holders[newIndex].insertBeforeMe(newElement);
                    };
                  } else {
                    appendFunction = append;
                  }
                  // create and register
                  var fragmentHolder = createFragmentHolder(appendFunction, insertBeforeFunction, newModel.id, parentFragment, fragmentFactory);
                  holders.splice(newIndex, 0, fragmentHolder);
                  fragmentHolder.init(newModel);
                  fragmentHolder.registerNodesAsAdded(diff);
                }
              } else {
                holders[newIndex].update(newModel, diff);
                oldIndex++;
              }
              newIndex++;
            }
            if(holders.length > newIndex) {
              // Remove child fragments
              for(i = newIndex; i < holders.length; i++) {
                holders[i].destroy();
                holders[i].remove(diff);
              }
              holders.length = newIndex;
            }
          }
        });
      };
    }

  };

  var createBindingFactory = function(bindings) {
    var result = Object.create(bindingTypes);
    result.addBinding = function (binding) {
      if(typeof binding === "function") {
        bindings.push({
          init: binding,
          update: binding
        });
      } else {
        bindings.push(binding);
      }
    };
    return result;
  };

  // fragmentType: function(appendFunction, id, parentFragment, fragmentFactory) -> fragment
  // fragment: {init(data), update(newData, diff), destroy()}
  // binding: {init(data), update(newData, diff), destroy()}

  var createFragmentType = function (onCreate) {
    return function (appendFunction, parentFragment, id, fragmentFactory, options) {
      var bindings = [];
      var fragment = {
        id: id,
        parentFragment: parentFragment,
        init: function (data) {
          callbacks.prepareData && callbacks.prepareData(data);
          bindings.forEach(function (binding) {
            binding.init && binding.init(data);
          });
          callbacks.postInit && callbacks.postInit(data);
        },
        update: function (newData, diff) {
          callbacks.prepareData && callbacks.prepareData(newData);
          bindings.forEach(function (binding) {
            binding.update && binding.update(newData, diff);
          });
          callbacks.postUpdate && callbacks.postUpdate(newData, diff);
        },
        destroy: function () {
          bindings.forEach(function (binding) {
            binding.destroy && binding.destroy();
          });
          callbacks.destroy && callbacks.destroy();
        }
      };
      var callbacks = onCreate(appendFunction, fragment, fragmentFactory, createBindingFactory(bindings), options) || {};
      return fragment;
    };
  };

  //fieldSet :: function (appendTo, parentFragment, id, fragmentFactory, options) -> {init, update, destroy}
  var fieldSet = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    // custom binding
    var oldSelected = false;
    bindingFactory.addBinding(function (data) {
      var newSelected = !!data.selected;
      if (newSelected !== oldSelected) {
        markup.toggleClass("selected", newSelected);
        oldSelected = newSelected;
      }
    });

    // normal bindings
    var markup = html.fieldset({ className: "" },
      html.legend(bindingFactory.text("title")),
      bindingFactory.fragmentPerItem("content", fragment, fragmentFactory)
    );

    appendFunction(markup);

    return {
      destroy: function () {}
    };
  });

  var staticMessage = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory, staticOptions) {
    var markup = html.div({ className: "message " + staticOptions.severity },
      staticOptions.message
    );
    appendFunction(markup);
  });

  var createDiff = function () {
    var nodesAdded = [];
    var nodesToRemove = [];
    var nodesUpdated = [];
    return {
      nodeAdded: function (node) {
        nodesAdded.push(node);
      },
      nodeToRemove: function (node) {
        nodesToRemove.push(node);
      },
      nodeUpdated: function (node) {
        nodesUpdated.push(node);
      },
      applyNow: function () {
        for(var i = 0; i < nodesToRemove.length; i++) {
          nodesToRemove[i].remove();
        }
      }
    };
  };

  var immediateDiff = {
    nodeAdded: function (node) {
    },
    nodeToRemove: function (node) {
      node.remove();
    },
    nodeUpdated: function (node) {
    }
  };

  window.fragment = {
    createFragmentFactory: createFragmentFactory,
    createFragmentType: createFragmentType,
    coreFragmentLibrary: {
      name: "core",
      fieldSet: fieldSet,
      staticMessage: staticMessage
    },
    createBindingFactory: createBindingFactory,
    bindingTypes: bindingTypes,
    createDiff: createDiff,
    immediateDiff: immediateDiff,
  };

}());