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
    
    var fragmentFactory = window.fragment.createFragmentFactory([
      window.fragment.coreFragmentLibrary, 
      window.htmlFragmentLibrary, 
      window.basicFragmentLibrary, 
      window.presenceFragmentLibrary
    ]);

    var fragmentEventHandler = {
      handleEvent: function(eventObj) {
        channel.send(eventObj);
      }
    };
    
    var placeRoot = fragmentFactory.createRoot(placeElement, fragmentEventHandler);
    var presenceRoot = fragmentFactory.createRoot(presenceElement, fragmentEventHandler);
    
    channel.on("placeUpdated", function(message) {
      if (location !== message.location) {
        location = message.location;
        document.location = "#location="+message.location;
      }
      placeRoot.update(message.rootFragment);
    });
    channel.on("presenceUpdated", function(message) {
      presenceRoot.update(message.rootFragment);
    });
    
    return {
      start: function() {
        var enterLocation = /location=([^&]*)/g.exec(window.location.hash);
        channel.send({message:"start", location: enterLocation?enterLocation[1]:null});
      },
      goTo: function(newLocation) {
        channel.send({message:"start", location: newLocation});
      },
      exit: function() {
        location = null;
        channel.send({message:"stop"});
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