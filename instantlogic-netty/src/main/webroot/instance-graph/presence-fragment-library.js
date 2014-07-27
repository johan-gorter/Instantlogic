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
      html.img({className: "avatar", src: bindingFactory.attribute("avatarUrl"), width:"23px", height:"23px;"}),
      html.span({className: "username"}, 
        bindingFactory.text("name")
      ),
      this.logoutButton = html.a({className: "logout", href:"#"}, "Log out").on("click", logout)
    );
    appendFunction(markup);
  }); 
    
  
  window.presenceFragmentLibrary = {
    Group: window.fragment.coreFragmentLibrary.group,
    Presence: presence,
    Me: me
  };

}());