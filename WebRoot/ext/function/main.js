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
			title: '门户网站管理系统',
			html: '<div id="tree"></div>'
		},{
			region: 'center',
			collapsible: true,
			html: '<div id="tabs" ></div>'
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
        		createTabs(node.text, node.id);
        	}
        }
    });
    
  //创建tab
    var tabs = new Ext.TabPanel({
        renderTo: 'tabs',
        width:'100%',
        activeTab: 0,
        id: 'content',
        frame:true,
        defaults:{autoHeight: true, closable: true},
        items:[
            {title: '首页', html: '欢迎进入首页', layout: 'fit', bodyStyle: 'padding:0px;margin:0px;'}
        ]
    });
});