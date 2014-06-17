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
			html: '主要内容'
		}]
	});
	viewport.show();
	
	var Tree = Ext.tree;
	//定义根节点的Loader
	var treeloader = new Tree.TreeLoader({
		dataUrl:'./menuAction!getMenu.shtml',
		baseParams: {
			id:'null'
		}
	});
	//异步加载根节点
	var rootnode = new Tree.AsyncTreeNode({
		id:'null',
		text:'ExtJs'		
	});
	var treepanel = new Tree.TreePanel({
		el:'tree',
		loader:treeloader
	});
	//设置根节点
	treepanel.setRootNode(rootnode);
	
	treeloader.on('beforeload',function(loader, node) {
		alert(node.id);
		loader.id = node.id;
	});
	treeloader.on('load',function(){
		alert("load");
	});
	/*treepane.on('load', function(responseText) {
		alert(responseText);
	});*/
	treepanel.render();
	rootnode.expand(false, false);
	/*var Tree = Ext.tree;
    var tree = new Tree.TreePanel({
        useArrows: true,
        autoScroll: true,
        animate: true,
        enableDD: true,
        containerScroll: true,
        border: false,
        // auto create TreeLoader
        dataUrl: './menuAction!getMenu.shtml',
        renderTo:'tree',
        listeners:{
        	'beforeload':function(node){
        		tree.dataUrl = "./menuAction!getMenu.shtml?id=" + node.id;
        		alert(tree.dataUrl);
        		
        	}
        },
        root: {
            nodeType: 'async',
            text: 'Ext JS',
            draggable: false,
            id: 'src'
        }
    });*/
});