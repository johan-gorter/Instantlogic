/*globals $ */
/*jslint browser: true, vars: true, indent: 2 */


(function () {

  // definitions
  var html = $.element.html;
  
  var createFragmentType = window.fragment.createFragmentType;
  
  var confirmActions = createFragmentType(function(appendFunction, bindingFactory) {
    var actionsUl = html.ul();
    var oldActions = null;
    bindingFactory.addBinding(function(data){
      if (data.actions !== oldActions) {
        oldActions = data.actions;
        actionsUl.empty();
        data.actions.split("\n").forEach(function(actionText){
          if (actionText) {
            actionsUl.append(html.li(actionText));
          }
        });
      }
    });
    appendFunction(actionsUl);
    appendFunction(
      html.div(
        html.button("ok").on("click", function(evt){
          evt.preventDefault();
          bindingFactory.fragment.handleEvent({message:'submit', id:bindingFactory.fragment.data.id+"-ok"});
        }), 
        html.button("cancel").on("click", function(evt){
          evt.preventDefault();
          bindingFactory.fragment.handleEvent({message:'submit', id:bindingFactory.fragment.data.id+"-cancel"});
        })
      )
    );
  });
  
  window.dataExplorerFragmentLibrary = {
    confirmActions: confirmActions
  };

}());