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
			width: 100,
			collapsible: true,
			html: 'this is west'
		},{
			region: 'center',
			collapsible: true,
			html: '主要内容'
		}]
	});
	viewport.show();
});