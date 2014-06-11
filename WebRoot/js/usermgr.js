function userManager(){
	
	var columns = [{field:'ck',checkbox:true},
	               {field:'loginname',title:'登录名称',align:'center',width:300},
	               {field:'username',title:'用户名称',align:'center',width:300}];
	buildEasyUI.datagridID = "usermgr";
	buildEasyUI.toolbar = [{text:'添加',iconCls:'icon-add',handler:function(){		
		url = contextPath + "/userAction!save.shtml";
		buildEasyUI.openDialog("userAdd", "添加用户");
	}},{text:'修改',iconCls:'icon-edit',handler:function(){
		
	}},{text:'删除',iconCls:'icon-remove',handler:function(){
		
	}}];
	buildEasyUI.createDataGrid(url, columns);
	buildEasyUI.buttons = [{text:'确定',iconCls:'icon-ok',handler:function(){
		buildEasyUI.saveOrUpdate(url, "userAdd", "userForm");
	}},{text:'返回',iconCls:'icon-cancel',handler:function(){
		buildEasyUI.closeDialog("userAdd");
	}}];
	buildEasyUI.createDialog("userAdd");
	buildEasyUI.createCombobox("belongRole", contextPath + "/roleAction!findAllRoleCombobox.shtml");
}