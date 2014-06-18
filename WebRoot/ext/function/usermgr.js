function userManager() {
	
	var cm = new Ext.grid.ColumnModel([{
		header:'id',dataIndex:'loginname'
	},{
		header:'用户名称',dataIndex:'username'
	}]);
	
	var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy({
			url: './userAction!findAllUser.shtml',
			method: 'post'
		}),
		reader: new Ext.data.JsonReader({
			root:'list',
			totalProperty: 'totalProperty'
		},[
		   {name: 'loginname'},
		   {name: 'username'}
		])
	});
	store.load({
		url: './userAction!findAllUser.shtml',
		method: 'post'
	});
	var grid = new Ext.grid.GridPanel({
		store: store,
		cm: cm,
		renderTo: 'grid',
		title:'center'
	});
	return grid;
}