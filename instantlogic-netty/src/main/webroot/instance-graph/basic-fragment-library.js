/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  var svg = $.element.svg;
  
  var createFragmentType = window.fragment.createFragmentType;

  var divWithClass = function(className) {
    return createFragmentType(function (appendFunction, bindingFactory) {
      appendFunction(html.div({"class": className},
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

  var button = createFragmentType(function (appendFunction, bindingFactory) {
    function onClick(evt) {
      bindingFactory.fragment.handleEvent({message:'submit', id:bindingFactory.fragment.data.id});
      evt.preventDefault();
    }    
    appendFunction(html.button(
      bindingFactory.text("text"),
      bindingFactory.fragmentPerItem("content"),
      bindingFactory.cssClasses("styleNames")      
    ).on("click", onClick));
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
  
  var keyValue = createFragmentType(function (appendFunction, bindingFactory) {
    appendFunction(html.div({"class": "key-value"},
      html.div({"class": "key"}, bindingFactory.fragmentPerItem("keyContent")),
      html.div({"class": "value"}, bindingFactory.fragmentPerItem("valueContent"))
    ));
  });
  
  var submitOnBlurAndEnter = function(inputEl, submitFunction) {
    inputEl.on("blur", submitFunction);
    inputEl.on("keyup", function(evt){
      if (evt.which===13) {
        submitFunction();
        evt.preventDefault();
        evt.stopPropagation();
      }
    });
    return inputEl;
  };
  
  var jsonTextBox = createFragmentType(function(appendFunction, bindingFactory) {
    var input = html.input({type:"text", value: bindingFactory.attribute("value", JSON.stringify)});
    function submitValue() {
      bindingFactory.fragment.handleEvent({message:'change', id:bindingFactory.fragment.data.id, value: input.val()});
    }    
    submitOnBlurAndEnter(input, submitValue);
    appendFunction(input);
  });
  
  var textBox = createFragmentType(function(appendFunction, bindingFactory) {
    var input = html.input({type:"text", value: bindingFactory.attribute("value")});
    function submitValue(evt) {
      var value = input.val();
      if (value === "") {
        value = null;
      }
      bindingFactory.fragment.handleEvent({message:'change', id:bindingFactory.fragment.data.id, value: value});
    }    
    submitOnBlurAndEnter(input, submitValue);
    appendFunction(input);
  });
  
  var textArea = createFragmentType(function(appendFunction, bindingFactory) {
    var input = html.textarea({rows: 4}, bindingFactory.text("value"));
    function submitValue(evt) {
      bindingFactory.fragment.handleEvent({message:'change', id:bindingFactory.fragment.data.id, value: input.val()});
    }    
    submitOnBlurAndEnter(input, submitValue);
    appendFunction(input);
  });
  
  var answerFragmentTypes = [
    {
      match: function(dataType) {
        return dataType.category === "text" && dataType.multiLine;
      },
      fragmentType: textArea
    },
    {
      match: function(dataType) {
        return dataType.category === "text";
      },
      fragmentType: textBox
    },
    {
      match: function(dataType) {
        return true;
      },
      fragmentType: jsonTextBox
    }
  ];
  
  var inputField = createFragmentType(function (appendFunction, bindingFactory) {
    var valueDiv = null;
    var answerFragmentType = null;
    var answerFragment = null;
    bindingFactory.addBinding(function(data, diff){
      var newAnswerFragmentType = null;
      for (var i=0; i<answerFragmentTypes.length; i++) {
        if (answerFragmentTypes[i].match(data.dataType)) {
          newAnswerFragmentType = answerFragmentTypes[i];
          break;
        }
      }
      if (answerFragmentType !== newAnswerFragmentType) {
        if (answerFragment) {
          answerFragment.destroy();
          valueDiv.children().forEach(function(childNode){
            diff.nodeToRemove(childNode);
          });
        }
        answerFragmentType = newAnswerFragmentType;
        answerFragment = newAnswerFragmentType.fragmentType(
          function(element) {valueDiv.append(element);}, 
          bindingFactory.fragment, bindingFactory.fragment.id, bindingFactory.fragment.fragmentFactory, {}
        );
        answerFragment.init(data);
      } else {
        answerFragment.update(data, diff);
      }
    });
    
    appendFunction(html.div({"class": "key-value"},
        html.label({"class": "key"}, bindingFactory.text("questionText")),
        valueDiv = html.div({"class": "value"})
      ));
    });
  
  window.basicFragmentLibrary = {
    Block: divWithClass("block"),
    Button: button,
    Page: page,
    Icon: icon,
    Table: table,
    Column: column,
    Row: row,
    Link: link,
    
    inputField: inputField,
    keyValue: keyValue
  };

}());