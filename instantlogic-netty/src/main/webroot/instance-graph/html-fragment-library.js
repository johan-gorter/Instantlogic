/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  var html = $.element.html;
  var createFragmentType = window.fragment.createFragmentType;

  var htmlElement = function(tagName) {
    return createFragmentType(function (appendFunction, bindingFactory) {
      appendFunction(html[tagName](
        bindingFactory.fragmentPerItem("content"),
        bindingFactory.text("text"),
        bindingFactory.cssClasses("styleNames")
      ));
    });
  };
 
  window.htmlFragmentLibrary = {
    // These will be renamed to their normal lowercase html tagnames.
    Button: htmlElement("button"),
    Heading1: htmlElement("h1"),
    Heading2: htmlElement("h2"),
    Heading3: htmlElement("h3"),
    Heading4: htmlElement("h4"),
    Cell: htmlElement("td"),
    Text: htmlElement("span"),
    Div: htmlElement("div")
  };

}());