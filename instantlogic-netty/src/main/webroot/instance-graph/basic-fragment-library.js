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
  
  var table = createFragmentType(function (appendFunction, bindingFactory) {
    appendFunction(html.table(
      html.tr(
        bindingFactory.fragmentPerItem("columns")
      ),
      bindingFactory.fragmentPerItem("rows")
    ));
  });
  
  var column = createFragmentType(function (appendFunction, bindingFactory) {
    appendFunction(html.th(
      bindingFactory.text("header")
    ));
  });

  var row = createFragmentType(function (appendFunction, bindingFactory) {
    var rowElement = html.tr(
      bindingFactory.fragmentPerItem("cells")
    );
    bindingFactory.fragment.rowElement = rowElement;
    appendFunction(rowElement);
  });
  
  var link = createFragmentType(function (appendFunction, bindingFactory) {
    function onClick(evt) {
      bindingFactory.fragment.handleEvent({message:'submit', id:bindingFactory.fragment.data.id});
      evt.preventDefault();
    }    
    var parentFragment = bindingFactory.fragment.parentFragment;
    if (parentFragment.rowElement) {
      // Make the row clickable instead of creating an <a href>
      rowElement.on("click", onClick).addClass("clickable");
      var element = {append: appendFunction};
      var createContentBinding = bindingFactory.fragmentPerItem("content");
      createContentBinding(element);
    } else {
      appendFunction(html.a({href: "#"},
        bindingFactory.text("text"),
        bindingFactory.fragmentPerItem("content")
      ).on("click", onClick));
    }
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
    Table: table,
    Column: column,
    Row: row,
    Link: link,
    Cell: htmlElement("td"),
    Text: htmlElement("span"),
    Div: htmlElement("div")
  };

}());