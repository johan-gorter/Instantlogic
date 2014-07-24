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
    
    channel.on("placeUpdated", function(message) {
      debugger
      message.rootFragment;
    });
    channel.on("presenceUpdated", function(message) {
      debugger
      message.rootFragment;
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