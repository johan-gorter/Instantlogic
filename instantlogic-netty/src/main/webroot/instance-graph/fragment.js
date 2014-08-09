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
    for (var i=0;i<fragmentTypeLibraries.length;i++) {
      if (!fragmentTypeLibraries[i]) {
        throw new Error("FragmentLibrary at index "+i+" was undefined.");
      }
    }
    var api;
    return api = {
      createFragment: function (name, appendFunction, id, parentFragment, options) {
        for (var i = 0; i < fragmentTypeLibraries.length; i++) {
          var library = fragmentTypeLibraries[i];
          if (library[name]) {
            return library[name](appendFunction, parentFragment, id, api, options || {});
          }
        }
        return staticMessage(appendFunction, id, parentFragment, api, { message: 'No fragmentlibrary provides a fragment called ' + name, severity: 'error' });
      },
      createRootFragment: function (appendFunction, type, eventHandler) {
        var rootFragment = api.createFragment(type, appendFunction, "", eventHandler);
        return rootFragment;
      },
      createRoot: function(element, eventHandler) {
        var rootFragment = null;
        var appendFunction = function(newElement) {
          element.append(newElement);
        };
        return {
          update: function(newData) {
            if (rootFragment === null) {
              rootFragment = api.createFragment(newData.type, appendFunction, newData.id, eventHandler, {});
              rootFragment.init(newData);
            } else {
              rootFragment.update(newData, window.fragment.immediateDiff);
            }
          }
        };
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
        startElement["data-data"]=data;
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

      update: function (newData, diff) {
        startElement["data-data"]=newData;
        if (fragmentType != newData.type) {
          recreateFragment(newData, diff);
        } else {
          api.fragment.update(newData, diff);
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

    var append = function (node) {
        // This is the only function that is exposed to the Fragment within
        $(node).insertBefore(endElement);
      };

    var recreateFragment = function (newModel, diff) {
      fragment.destroy();
      clear(null);
      diff.nodeUpdated($(startElement.parentNode));
      fragment = fragmentFactory.createFragment(newModel.type, append, id, parentFragment, fragmentFactory);
      fragment.init(newModel);
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
        var textNode = document.createTextNode("");
        element.append(textNode);
        var oldValue = "";
        bindingFactory.addBinding(function (data) {
          var newValue = propertyOrAccessor(data) || "";
          if (oldValue !== newValue) {
            textNode.nodeValue = newValue;
            oldValue = newValue;
          }
        });
      };
    },
    toggleClass: function(className, propertyOrAccessor) {
      var bindingFactory = this;
      if (typeof propertyOrAccessor !== "function") {
        propertyOrAccessor = accessorFunction(propertyOrAccessor);
      }
      return function(element) {
        var oldValue = null;
        bindingFactory.addBinding(function (data) {
          var newValue = propertyOrAccessor(data) || false;
          if (oldValue !== newValue) {
            element.toggleClass(className, newValue);
            oldValue = newValue;
          }
        });
      };
    },
    // maintains a fragment for each item in the array in the data
    fragmentPerItem: function (propertyOrAccessor, fragmentFactory, getChildFragmentsCallback) {
      var bindingFactory = this;
      var parentFragment = bindingFactory.fragment;
      if (!fragmentFactory) {
        fragmentFactory = bindingFactory.fragment.fragmentFactory;
      }
      if (typeof propertyOrAccessor !== "function") {
        propertyOrAccessor = accessorFunction(propertyOrAccessor);
      }
      return function (element) {
        var endComment = document.createComment("fragmentPerItemEnd");
        element.append(endComment);
        var items = [];
        var holders = [];
        if(getChildFragmentsCallback) {
          getChildFragmentsCallback(function () {
            return holders.map(function (holder) { return holder.fragment; });
          });
        }
        var append = function (child) {
          $(child).insertBefore(endComment);
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

  var createBindingFactory = function(bindings, fragment) {
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
    result.fragment = fragment;
    return result;
  };

  // fragmentType: function(appendFunction, id, parentFragment, fragmentFactory) -> fragment
  // fragment: {init(data), update(newData, diff), destroy(), handleEvent(eventObj)}
  // binding: {init(data), update(newData, diff), destroy()}

  var createFragmentType = function (onCreate) {
    return function (appendFunction, parentFragment, id, fragmentFactory, options) {
      if (!options) {
        throw new Error("Missing argument(s)");
      }
      var bindings = [];
      var fragment = {
        id: id,
        parentFragment: parentFragment,
        data: null, /*filled during init and update*/
        fragmentFactory: fragmentFactory,
        init: function (data) {
          callbacks.prepareData && callbacks.prepareData(data);
          fragment.data = data;
          bindings.forEach(function (binding) {
            binding.init && binding.init(data);
          });
          callbacks.postInit && callbacks.postInit(data);
        },
        update: function (newData, diff) {
          callbacks.prepareData && callbacks.prepareData(newData);
          fragment.data = newData;
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
        },
        handleEvent: function(eventObj) {
          var handled = callbacks.handleEvent && callbacks.handleEvent(eventObj);
          if (!handled && parentFragment) {
            handled = parentFragment.handleEvent(eventObj);
          }
          return !!handled;
        }
      };
      var callbacks = onCreate(appendFunction, createBindingFactory(bindings, fragment), options) || {};
      return fragment;
    };
  };

  var group = createFragmentType(function (appendFunction, bindingFactory) {
    var element = {append: appendFunction};
    var createBinding = bindingFactory.fragmentPerItem("content");
    createBinding(element);
  });
  
  //fieldSet :: function (appendTo, parentFragment, id, fragmentFactory, options) -> {init, update, destroy}
  var fieldSet = createFragmentType(function (appendFunction, bindingFactory) {
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
      bindingFactory.fragmentPerItem("content")
    );

    appendFunction(markup);
  });

  var staticMessage = createFragmentType(function (appendFunction, bindingFactory, staticOptions) {
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
      group: group,
      fieldSet: fieldSet,
      staticMessage: staticMessage
    },
    createBindingFactory: createBindingFactory,
    bindingTypes: bindingTypes,
    createDiff: createDiff,
    immediateDiff: immediateDiff,
  };

}());