/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  var svg = $.element.svg;
  
  var createFragmentType = window.fragment.createFragmentType;

  var divWithClass = function(className) {
    return createFragmentType(function (appendFunction, bindingFactory) {
      appendFunction(html.div({className: className},
        bindingFactory.fragmentPerItem("content"),
        bindingFactory.text("text")
      ));
    });
  };
  
  var htmlElement = function(tagName) {
    return createFragmentType(function (appendFunction, bindingFactory) {
      appendFunction(html[tagName](
        bindingFactory.fragmentPerItem("content"),
        bindingFactory.text("text")
      ));
    });
  };

  var page = createFragmentType(function (appendFunction, bindingFactory) {
    appendFunction(
      html.div({"class":"page"},
        bindingFactory.fragmentPerItem("mainContent")
      )
    );
  });
  
  var icon = createFragmentType(function (appendFunction, bindingFactory) {
    function iconPath(element, attribute) {
      var oldIcon = null;
      bindingFactory.addBinding(
        function(data) {
          var icon = data.icon;
          if (!icon && data.styleNames) {
            icon = data.styleNames[0].substr(data.styleNames[0].indexOf("-")+1);
          }
          if (oldIcon !== icon) {
            var path = "M0,0";
            switch(icon) {
            case "plus": path="M60,10 l0,30 l30,0 l0,20 l-30,0 l0,30 l-20,0 l0,-30 l-30,0 l0,-20 l30,0 l0,-30 Z";
            }
            element.attr(attribute, path);
            oldIcon = icon;
          }
        }
      );
    }
    appendFunction(
      html.span({"class":"icon"},
        svg.svg({viewBox: "0,0 100,100"},
          svg.path({d:iconPath})
        )
      )
    );
  });
  
  window.basicFragmentLibrary = {
    Block: divWithClass("block"),
    Page: page,
    Button: htmlElement("button"),
    Heading1: htmlElement("h1"),
    Heading2: htmlElement("h2"),
    Heading3: htmlElement("h3"),
    Heading4: htmlElement("h4"),
    Icon: icon,
    Table: htmlElement("table"),
    Row: htmlElement("tr"),
    Cell: htmlElement("td")
  };

}());