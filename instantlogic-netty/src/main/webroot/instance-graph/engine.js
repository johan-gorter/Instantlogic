/// <reference path="~/lib/d3.js" />

/*globals $, d3 */
/*jslint browser: true, vars: true, indent: 2 */

(function () {

  window.createEngine = function(application, caseId, travelerId, channel, presenceElement, placeElement, configuration) {
    var location = null;
    
    var observersPerEvent = {locationChanged: []};
    var notify = function(eventName, args) {
      var observers = observersPerEvent[eventName];
      if (observers) {
        observers.forEach(function(observer){
          observer.apply(null, args);
        });
      }
    };
    
    var fragmentFactory = window.fragment.createFragmentFactory([window.fragment.coreFragmentLibrary, window.presenceFragmentLibrary]);

    var eventHandler = {
      handleEvent: function(eventObj) {
        channel.send(eventObj);
      }
    };
    
    var placeRoot = fragmentFactory.createRoot(placeElement, eventHandler);
    var presenceRoot = fragmentFactory.createRoot(presenceElement, eventHandler);
    
    
    channel.on("placeUpdated", function(message) {
      placeRoot.update(message.rootFragment);
    });
    channel.on("presenceUpdated", function(message) {
      presenceRoot.update(message.rootFragment);
    });
    
    return {
      enter: function(newLocation) {
        location = newLocation;
        channel.send({message:'start', location: location});
      },
      exit: function() {
        location = null;
        channel.send({message:'stop'});
      },
      on: function(eventName, observer) {
        var list = observersPerEvent[eventName];
        if (!list) {
          list = observersPerEvent[eventName] = [];
        }
        list.push(observer);
      }
    }
  };
  

}());