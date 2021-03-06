/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  
  var createFragmentType = window.fragment.createFragmentType;

  var presence = createFragmentType(function (appendFunction, bindingFactory) {
    var markup = html.div({ "class": "presence"},
      html.a({"class": "home-link", href:"#"},
        html.span(bindingFactory.text("applicationName")),
        html.span(" - "),
        html.span(bindingFactory.text("caseName"))
      ),
      html.div({"class": "controls"},
        bindingFactory.fragmentPerItem("content")
      )
    );
    appendFunction(markup);
  });
  
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

  
  window.presenceFragmentLibrary = {
    Group: window.fragment.coreFragmentLibrary.group,
    Presence: presence,
    Me: me,
    Communicator: communicator,
    User: user,
    Traveler: traveler,
    ToggleBookmarks: toggleBookmarks,
    DebugVisibleToggle: debugVisibleToggle,
    Avatar: /*TODO*/ window.fragment.coreFragmentLibrary.group
  };

}());