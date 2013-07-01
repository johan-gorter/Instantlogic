YUI.add('instantlogic-designer-diagram', function (Y) {

    var ns = Y.namespace('instantlogic.designer.diagram');
    var html = Y.html;

    ns.DeductionScheme = function (parentNode, parentFragment, engine) {
        ns.DeductionScheme.superclass.constructor.apply(this, arguments);
    };
    
    Y.extend(ns.DeductionScheme, Y.instantlogic.Fragment, {
    	init: function(model) {
            ns.DeductionScheme.superclass.init.call(this, model);
            var markup = html.div({className:'deduction-scheme'});
            markup
	            .setStyle('width','600px')
	            .setStyle('height', '400px')
	            .setStyle('position', 'relative')
            	.setStyle('border', 'solid 1px black');
            this.graphic = new Y.Graphic({
                render: markup
            });
            
            var pointer1 = this.graphic.addShape({
            	type: 'path',
            	fill: {
                    color: "#0000ff"
                },
                stroke: {
                    weight: 0,
                    color: "#ff0000"
                }
            });
            pointer1.moveTo(90, 100)
            pointer1.lineTo(100, 0)
            pointer1.lineTo(110, 100)
            pointer1.end();
            
            var circle1 = this.graphic.addShape({
            	type: 'circle',
            	x: 70, y:70,
            	radius: 30,
            	fill: {
                    color: "#0000ff"
                },
                stroke: {
                    weight: 0,
                    color: "#ff0000"
                }
            });
            Y.one(circle1.node).setStyle('cursor','pointer');
            
            this.parentNode.appendChild(markup);
            new Y.DD.Drag({
            	node:circle1
            }).plug(Y.Plugin.DDConstrained, {
                constrain2node: markup
            });
            
            var redrawPointers = function(dragEvent) {
            	var offset = markup.get('region');
            	var xy = dragEvent.target.actXY;
            	var x = xy[0]-offset.left+30;
            	var y = xy[1]-offset.top+30;
            	pointer1.clear();
                pointer1.moveTo(x-10, y)
                pointer1.lineTo(100, 0)
                pointer1.lineTo(x+10, y)
            	pointer1.end();
            };
            
            Y.DD.DDM.on("drag:drag", redrawPointers);
    	},
    	
    	update: function (newModel, diff) {
    	}
    });
    
}, '0.7.0', { requires: ['dd-drag', 'dd-constrain', 'instantlogic', 'html', 'instantlogic-fragments', 'graphics'] });