function createTabs(title, tabId) {
	var tabs = Ext.getCmp("content");
	var subtab = Ext.getCmp(tabId);
	if(subtab != null) {
		tabs.setActiveTab(subtab);  //激活选项卡
		return;
	}
	tabs.add({title: title, id: tabId, html: '<div id = "'+tabId+'"></div>'});
    tabs.setActiveTab(Ext.getCmp(tabId));
    if(title == "用户管理") {
    	 userManager(tabId);
    }
   
}