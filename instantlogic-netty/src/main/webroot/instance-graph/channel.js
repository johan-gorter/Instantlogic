/// <reference path="~/lib/d3.js" />

/*globals $, d3 */
/*jslint browser: true, vars: true, indent: 2 */

(function () {

  window.createChannel = function(application, caseId, travelerId) {
    var observersPerEvent = {placeUpdated: [], presenceUpdated: []};
    var standOff = 100;
    var ws = null;
    var ready = false;
    var subscriptions = [];
    var queued = [];
    var autoRefreshEnabled = false;
    
    var notify = function(eventName, args) {
      var observers = observersPerEvent[eventName];
      if (observers) {
        observers.forEach(function(observer){
          observer.apply(null, args);
        });
      }
    };
    var notifyStatusChanged = function() {
      notify("statusChanged", [ready]);
    };
    
    var onOpen = function() {
      standOff = 100;
      if (queued.length>0) {
        ws.send(JSON.stringify(queued));
        queued = [];
      }
      subscriptions.forEach(function(subscription) {
        subscription.sendStartFrame();
      });
      ready = true;
      notifyStatusChanged();
    };
    var onMessage = function(evt) {
      var messages = JSON.parse(evt.data);
      messages.forEach(function(message) {
        if (message.name === "subscription") {
          var data = message.rootFragment;
          subscriptions.forEach(function(subscription) {
            if (data.id === subscription.id) {
              console.log("received subscription "+data.id, data);
              subscription.onUpdate(data);
            }
          });
        } else if (message.name === "place") {
          console.log("received place ", message);
          notify("placeUpdated", [message]);
        } else if (message.name === "presence") {
          console.log("received presence ", message);
          notify("presenceUpdated", [message]);
        } else if (message.name === "cssFilesUpdated") {
          notify(message.name, [message]);
          if (autoRefreshEnabled) {
            var i,a,s;a=document.getElementsByTagName('link'); // Code taken from ReCSS
            for(i=0;i<a.length;i++){
              s=a[i];
              if(s.rel.toLowerCase().indexOf('stylesheet')>=0&&s.href) {
                var h=s.href.replace(/(&|%5C?)forceReload=\d+/,'');
                s.href=h+(h.indexOf('?')>=0?'&':'?')+'forceReload='+(new Date().valueOf());
              }
            }
          }
        } else if (message.name === "filesUpdated") {
          notify(message.name, [message]);
          if (autoRefreshEnabled) {
            document.location.reload();
          }
        } else if (message.name === "exception") {
          debugger
          alert(JSON.stringify(message));
        }
      });
    };
    var onError = function(evt) {
      ready = false;
      notifyStatusChanged();
      if (standOff < 1000) {
        standOff = standOff + 100;
      }
    };
    var onClose = function(evt) {
      if (evt.target === ws) {
        ready = false;
        notifyStatusChanged();
        setTimeout(start, standOff);
      }
    };
    var start = function() {
      ready = false;
      notifyStatusChanged();
      if (ws) {
        ws.close();
        ws = null;
      }
      ws = new WebSocket("ws://localhost:7080/api?application="+application+"&case="+caseId+"&travelerId=" + travelerId);
      ws.onopen = onOpen;
      ws.onmessage = onMessage;
      ws.onclose = onClose;
      ws.onerror = onError;
    };
    return {
      send: function(message) {
        if (!ws) {
          start();
        }
        if (ready) {
          ws.send(JSON.stringify([message]));
        } else {
          queued.push(message);
        }
      },
      enableAutoRefresh: function(){
        if (!ws) {
          start();
        }
        autoRefreshEnabled = true;
      },
      on: function(eventName, observer) {
        var list = observersPerEvent[eventName];
        if (!list) {
          list = observersPerEvent[eventName] = [];
        }
        list.push(observer);
      },
      getStatus: function() {
        return ready?"open":"connecting";
      },
      subscribe: function(instanceId, dataCallback) {
        if (!ws) {
          start();
        }
        var location = "_InstanceGraph-instance(instance:" + instanceId + ")";
        var sendStartFrame = function() {
          ws.send(JSON.stringify([{message: "subscribe", location: location}]));
        };
        var subscription = {
          sendStartFrame: sendStartFrame,
          id: instanceId,
          onUpdate: function(data) {
            dataCallback(data);
          }
        };
        subscriptions.push(subscription);
        if (ready) {
          sendStartFrame();
        }
        return {
          dispose: function() {
            if (ready) {
              ws.send(JSON.stringify([{message: "unsubscribe", location: location}]));
            }
            subscriptions.splice(subscriptions.indexOf(subscription), 1);
          }
        };
      }
    };
  };
  

}());