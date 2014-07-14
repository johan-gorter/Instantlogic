/*jslint vars: true, white: true, browser: true */

(function ($) {

  "use strict";

  var previousDocumentStack = [];
  var currentDocument = document;

  // Private utility functions

  // Adds attributes to an HTML Element
  var setAttributes = function(element, attributes) {
    for (var attribute in attributes) {
      if (attributes.hasOwnProperty(attribute)) {
        var value = attributes[attribute];
        if(typeof value === "function") {
          value(element, attribute); // call this function on us
        } else if (value !== null && value !== undefined) {
          element[0].setAttribute(attribute, value);
        }
      }
    }
  };

  // Recursive function which adds attributes and childnodes to an HTML Element
  var addChildNodes = function(element, content, isRoot) {
    for (var i = 0; i < content.length; i++) {
      var child = content[i];
      if (child === null || child === undefined) {
        // Nothing
      } else if ($.type(child) === "string") { // Textnode
        element.append(currentDocument.createTextNode(child));
      } else if ($.type(child) === "array") { // Recursion
        addChildNodes(element, child, false);
      } else if (child instanceof $) {
      	element.append(child);
      } else if (typeof child === "function") {
        child(element); // call this function on us
      } else if (i === 0 && !child.nodeName && isRoot) { // Attributes object
        setAttributes(element, child);
      } else if(child.nodeName) { // HTMLElement
        element.append(child);
      } else {
        throw new Error('Cannot create child node from "' + child + '"');
      }
    }
    return element;
  };

  $.element = {
    // Returns a function which can be used to create elements with a specific tagName.
    // The returned function can handle the following:
    // - (Optional first argument) object containing attributes for the element
    //     Note: Use 'className' instead of 'class'. Also use 'htmlFor' instead of 'for'
    // - Other HTMLElements
    // - String, will be converted to a textNode
    // - Array, will be recursed
    // - $ selector
    createElementFactory: function(tagName) {
      return function() {
        var result = $(currentDocument.createElement(tagName));
        result = addChildNodes(result, arguments, true);
        return result;
      };
    },
    
    createElementFactoryNS: function(namespaceURI, tagName) {
      return function() {
        var result = $(currentDocument.createElementNS(namespaceURI, tagName));
        result = addChildNodes(result, arguments, true);
        return result;
      };
    },
	
    // Use this function when temporarily creating elements inside a different document (an iframe for example)
    pushDocument: function(doc) {
      previousDocumentStack.push(currentDocument);
      currentDocument = doc;
    },
    
    // Use in symmetry with pushDocument
    popDocument: function() {
      currentDocument = previousDocumentStack.pop();
    }
  };
	
  $.element.html = {};
  var htmlElementNames = ['a','abbr','acronym','address','area','b','base','bdo','big','blockquote','body','br','button','caption','cite','code','col','colgroup','dd','del','dfn','div','dl','dt','em','fieldset','form','frame','frameset','h1','h2','h3','h4','h5','h6','head','hr','html','i','iframe','img','input','ins','kbd','label','legend','li','link','map','meta','noframes','noscript','object','ol','optgroup','option','p','param','pre','q','samp','script','select','small','span','strong','style','sub','sup','table','tbody','td','textarea','tfoot','th','thead','title','tr','tt','u','ul','var'];
  for (var i=0;i<htmlElementNames.length;i++) {
    var name = htmlElementNames[i];
    $.element.html[name] = $.element.createElementFactory(name);
  }
  
  $.element.svg = {};
  var svgTagNames = ['a', 'altglyph', 'altglyphdef', 'altglyphitem', 'animate', 'animatecolor', 'animatemotion', 'animatetransform', 'circle', 'clipPath', 'color-profile', 'cursor', 'defs', 'desc', 'ellipse', 'feblend', 'fecolormatrix', 'fecomponenttransfer', 'fecomposite', 'feconvolvematrix', 'fediffuselighting', 'fedisplacementmap', 'fedistantlight', 'feflood', 'fefunca', 'fefuncb', 'fefuncg', 'fefuncr', 'fegaussianblur', 'feimage', 'femerge', 'femergenode', 'femorphology', 'feoffset', 'fepointlight', 'fespecularlighting', 'fespotlight', 'fetile', 'feturbulence', 'filter', 'font', 'font-face', 'font-face-format', 'font-face-name', 'font-face-src', 'font-face-uri', 'foreignobject', 'g', 'glyph', 'glyphref', 'hkern', 'image', 'line', 'linearGradient', 'marker', 'mask', 'metadata', 'missing-glyph', 'mpath', 'path', 'pattern', 'polygon', 'polyline', 'radialgradient', 'rect', 'script', 'set', 'stop', 'style', 'svg', 'switch', 'symbol', 'text', 'textpath', 'title', 'tref', 'tspan', 'use', 'view', 'vkern'];
  for(var ii = 0; ii < svgTagNames.length; ii++) {
    var svgName = svgTagNames[ii];
    $.element.svg[svgName] = $.element.createElementFactoryNS('http://www.w3.org/2000/svg', svgName);
  }


})($);
