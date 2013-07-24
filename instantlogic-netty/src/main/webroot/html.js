YUI.add('html', function(Y) {
	
    // Internet explorer 6 or 7?
    var ie67mode = Y.UA.ie >= 6 && Y.UA.ie < 8;
    var previousDocumentStack = [];
    var currentDocument = document;

    // Private utility functions

    // Adds attributes to an HTML Element
    var setAttributes = function(element, attributes) {
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    element.setAttribute(attribute, value);
                }
            }
        }
    };

    // IE<=7 does not implement the standard way of creating elements and adding attributes like 'name'
    var createIE67Element = function(tagName, attributes) {
        var string = '<' + tagName + ' ';
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    var attName = attribute;
                    if (attName == 'className') { attName = 'class'; }
                    if (attName == 'htmlFor') { attName = 'for'; }
                    if (attName == 'checked' && value === false) { continue; }
                    string += attName + '="' + value + '" ';
                }
            }
        }
        string += '>';
        return Y.Node.one(document.createElement(string));
    };

    // Recursive function which adds attributes and childnodes to an HTML Element
    var addChildNodes = function(element, content, isRoot) {
        for (var i = 0; i < content.length; i++) {
            var child = content[i];
            if (child === null || child === undefined) {
                // Nothing
            } else if (Y.Lang.isString(child)) { // Textnode
                element.appendChild(document.createTextNode(child));
            } else if (Y.Lang.isArray(child)) { // Recursion
                addChildNodes(element, child, false);
            } else if (child instanceof Y.Node) {
            	element.appendChild(child);
            } else if (i === 0 && !child.nodeName && isRoot) { // Attributes object
                if (ie67mode) {
                    element = createIE67Element(element.tagName.toLowerCase(), child);
                } else {
                    setAttributes(element, child);
                }
            } else if (child.nodeName) { // HTMLElement
                element.appendChild(child);
            } else {
                throw new Error('Cannot create child node from "' + child + '"');
            }
        }
        return element;
    };
	
	Y.html = {
        // Returns a function which can be used to create elements with a specific tagName.
        // The returned function can handle the following:
        // - (Optional first argument) object containing attributes for the element
        //       Note: Use 'className' instead of 'class'. Also use 'htmlFor' instead of 'for'
        // - Other HTMLElements
        // - String, will be converted to a textNode
        // - Array, will be recursed
	  createElementFactory: function(tagName) {
	    return function() {
	      var result = Y.Node.one(currentDocument.createElement(tagName));
	      result = addChildNodes(result, arguments, true);
	      return result;
	    };
	  },

	  createElementFactoryNS: function(namespaceURI, tagName) {
	    return function() {
	      var result = Y.Node.one(currentDocument.createElementNS(namespaceURI, tagName));
	      result = addChildNodes(result, arguments, true);
	      return result;
	    };
	  },

	  pushDocument: function(doc) {
        	previousDocumentStack.push(currentDocument);
        	currentDocument = doc;
        },
        
        popDocument: function() {
        	currentDocument = previousDocumentStack.pop();
        }
	};
	
	var tagNames = ['a','abbr','acronym','address','area','b','base','bdo','big','blockquote','body','br','button','caption','cite','code','col','colgroup','dd','del','dfn','div','dl','dt','em','fieldset','form','frame','frameset','h1','h2','h3','h4','h5','h6','head','hr','html','i','iframe','img','input','ins','kbd','label','legend','li','link','map','meta','noframes','noscript','object','ol','optgroup','option','p','param','pre','q','samp','script','select','small','span','strong','style','sub','sup','table','tbody','td','textarea','tfoot','th','thead','title','tr','tt','u','ul','var'];
	
	for (var i=0;i<tagNames.length;i++) {
		var name = tagNames[i];
		Y.html[name] = Y.html.createElementFactory(name);
	}

  var svgTagNames = ['svg', 'circle', 'ellipse', 'g', 'path', 'text'];

  Y.svg = {};
  
  for(var ii = 0; ii < svgTagNames.length; ii++) {
    var svgName = svgTagNames[ii];
    Y.svg[svgName] = Y.html.createElementFactoryNS('http://www.w3.org/2000/svg', svgName);
  }

}, '0.7.0', {requires: ['node']});