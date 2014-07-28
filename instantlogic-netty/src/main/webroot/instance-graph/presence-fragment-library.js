/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  
  var createFragmentType = window.fragment.createFragmentType;

  var presence = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    var markup = html.div({ className: "presence"},
      html.a({className: "home-link", href:"#"},
        html.span(bindingFactory.text("applicationName")),
        html.span(" - "),
        html.span(bindingFactory.text("caseName"))
      ),
      html.div({className: "controls"},
        bindingFactory.fragmentPerItem("content", fragment, fragmentFactory)
      )
    );
    appendFunction(markup);
  });
  
  var me = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    function logout(evt) {
      fragment.handleEvent("message", [{message: "presence", command: "logout"}]);
      evt.preventDefault();
    }
    var markup = html.div({className: "me"},
      html.span('Logged in as: '),
      html.img({className: "avatar", src: bindingFactory.attribute("avatarUrl"), width:"23px", height:"23px"}),
      html.span({className: "username"}, 
        bindingFactory.text("name")
      ),
      this.logoutButton = html.a({className: "logout", href:"#"}, "Log out").on("click", logout)
    );
    appendFunction(markup);
  }); 

  var communicator = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    var userListVisible = false;
    var userList = null;
    function showHide(evt) {
      evt.preventDefault();
      userListVisible = !userListVisible;
      userList.css("display", userListVisible?"":"none");
    }
    appendFunction(
      html.div({className:"communicator"},
        html.button({className:"show-hide"}, "Communicator").on("click", showHide),
        userList = html.div({className:"user-list"},
          bindingFactory.fragmentPerItem("users", fragment, fragmentFactory)
        ).css("display", "none")
      )
    );
  });
  
  var user = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    appendFunction(
      html.div({className:"user"},
        html.img({className: "avatar", width:"23px", height:"23px", src: bindingFactory.attribute("avatarUrl")}),
        html.div({className: "username"}, bindingFactory.text("name")),
        html.div({className: "travelers"}, 
          bindingFactory.fragmentPerItem("travelers", fragment, fragmentFactory)
        )
      )
    );
  });

  var traveler = createFragmentType(function (appendFunction, fragment, fragmentFactory, bindingFactory) {
    function placeToUrl(place) {
      if (!place) {
        return "#";
      }
      return "#location="+place.url;
    }
    appendFunction(
      html.div({className:"traveler"},
        html.a({href: bindingFactory.attribute("place", placeToUrl)}, bindingFactory.text("placeTitle")),
        html.div({className: "username"}, bindingFactory.text("name")),
        html.div({className: "travelers"}, 
          bindingFactory.fragmentPerItem("travelers", fragment, fragmentFactory)
        )
      )
    );
  });

  
  window.presenceFragmentLibrary = {
    Group: window.fragment.coreFragmentLibrary.group,
    Presence: presence,
    Me: me,
    Communicator: communicator,
    User: user,
    Traveler: traveler
  };

}());