/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {
  window.addPresenceControls = function(fragmentTypes, renderFragment) {

    fragmentTypes.Presence = function(context, data) {
      return m("div.presence", [
        m("a.home-link",{href: "#"}, [
          m("span", [data.applicationName]),
          m("span", " - "),
          m("span", [data.caseName])
        ]),
        m("div.controls", [ 
          data.content.map(renderFragment.bind(undefined, context))
        ])
      ]);
    };
    
    fragmentTypes.Me = function(context, data) {
      var onClick = function(evt) {
        context.notify({message:"presence", command: "logout"});
        evt.preventDefault();
      };
      
      return m("div.me", [
        m("span", ["Logged in as: "]),
        m("img.avatar", {src: data.avatarUrl}),
        m("span.username", [data.name]),
        m("a.logout", {href: "#", onclick: onClick}, ["Log out"])
      ]);
    };

    var createFragmentType = function(){};
    
    var me = createFragmentType(function (appendFunction,  bindingFactory) {
      function logout(evt) {
        bindingFactory.fragment.handleEvent({message:"presence", command: "logout"});
        evt.preventDefault();
      }
      var markup = html.div({"class": "me"},
        html.span('Logged in as: '),
        html.img({"class": "avatar", src: bindingFactory.attribute("avatarUrl")}),
        html.span({"class": "username"}, 
          bindingFactory.text("name")
        ),
        this.logoutButton = html.a({"class": "logout", href:"#"}, "Log out").on("click", logout)
      );
      appendFunction(markup);
    }); 
  
    var communicator = createFragmentType(function (appendFunction, bindingFactory) {
      var userListVisible = false;
      var userList = null;
      function showHide(evt) {
        evt.preventDefault();
        userListVisible = !userListVisible;
        userList.css("display", userListVisible?"":"none");
      }
      appendFunction(html.button({"class":"communicator-show-hide"}, "Communicator").on("click", showHide));
      var userList = html.div({"class":"communicator-user-list"},
            bindingFactory.fragmentPerItem("users")
          ).css("display", "none");
       appendFunction(userList);
    });
    
    var user = createFragmentType(function (appendFunction, bindingFactory) {
      appendFunction(
        html.div({"class":"user"},
          html.img({"class": "avatar", src: bindingFactory.attribute("avatarUrl")}),
          html.div({"class": "username"}, bindingFactory.text("name")),
          html.div({"class": "travelers"}, 
            bindingFactory.fragmentPerItem("travelers")
          )
        )
      );
    });
  
    var traveler = createFragmentType(function (appendFunction, bindingFactory) {
      function placeToUrl(place) {
        if (!place) {
          return "#";
        }
        return "#location="+place.url;
      }
      appendFunction(
        html.a({"class":"traveler", href: bindingFactory.attribute("place", placeToUrl)}, bindingFactory.text("placeTitle"))
      );
    });
    
    var toggleBookmarks = createFragmentType(function (appendFunction, bindingFactory) {
      function toggle(evt) {
        evt.preventDefault();
        bindingFactory.fragment.handleEvent({message:"presence", command:"toggleBookmarks"});
      };
      appendFunction(html.button({"class": "toggle-bookmarks"}, "Bookmarks").on("click", toggle));
    });
    
    var debugVisibleToggle = createFragmentType(function (appendFunction, bindingFactory) {
      function toggle(evt) {
        evt.preventDefault();
        bindingFactory.fragment.handleEvent({message:"presence", command:"setDebugVisible", "value": !bindingFactory.fragment.data.value});
      }
      appendFunction(html.button({"class":"toggle-debug"}, "Debug", bindingFactory.toggleClass("pressed", "value")).on("click", toggle));
    });

  };
  
}());