function userManager(tabId) {
	var cm = new Ext.grid.ColumnModel([{
		header:'id',dataIndex:'loginname'
	},{
		header:'用户名称',dataIndex:'regionCode'
	}]);
	var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy({
			url: './userAction!findAllUser.shtml',
			method: 'post'
		}),
		reader: new Ext.data.JsonReader({
			root:'list',
			totalProperty: 'totalProperty',
			fields : ['loginname','regionCode']
		})
	});
	store.load();
	var grid = new Ext.grid.GridPanel({
		cm: cm,
		store: store,
		renderTo: tabId,
		autoHeight: true,
		bbar : new Ext.PagingToolbar({
			pageSize : 10, // 每页显示的条数
			store : store,
			displayInfo : true,
			displayMsg : '显示第{0}条到{1}条记录,一共{2}条',
			emptyMsg : "没有记录"
		}),
		viewConfig : {
			forceFit: true
		}
	});
	return grid;
}