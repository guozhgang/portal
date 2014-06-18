Ext.onReady(function() {
	var viewport = new Ext.Viewport({
		layout: 'border',
		items: [{
			region: 'north',
			height:100,
			collapsible: true,
			html: '<h1>www.family168.com</h1>'
		},{
			region: 'west',
			width: 200,
			collapsible: true,			
			html: '<div id="tree"></div>'
		},{
			region: 'center',
			collapsible: true,
			html: '<div id="grid"></div>'
		}]
	});
	viewport.show();
	
	var Tree = Ext.tree;
    var tree = new Tree.TreePanel({
        useArrows: true,
        autoScroll: true,
        animate: true,
        enableDD: true,
        containerScroll: true,
        border: false,
        // auto create TreeLoader
        dataUrl: './menuAction!findMenu.shtml',
        renderTo:'tree',
        root: {
            nodeType: 'async',
            text: 'Ext JS',
            draggable: false,
            id: 'null'
        },
        listeners: {
        	'click': function(node) {
        		if(node.text == "用户管理") {
        			userManager();
        		}
        	}
        }
    });
});