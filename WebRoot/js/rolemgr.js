function roleManager(){
	/*$("#detail").layout('add',{
		region:'center',
		id:'role'
	});
	//初始化角色管理
	$("#role")[0].innerHTML = "<div id=\"rolemgr\" fit='true'></div>" ;*/
	
	var columns = [{field:'ck',checkbox:true},{field:'roleName',title:'角色名称',width:300,align:'center'},{field:'roleId',title:'角色ID',width:300,align:'center'}];
	buildEasyUI.toolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			url = contextPath + "/roleAction!saveRole.shtml";
			buildEasyUI.openDialog("roleAdd", "增加角色");
		}
	},{
		text:'修改',
		iconCls:'icon-edit',
		handler:function(){
			var row = buildEasyUI.getSelected();   //获得选中的记录
			if(row != null) {
				$("#roleAdd").dialog("open").dialog("setTitle","修改角色");
				//回显
				$("input[name='tbRole.roleName']").val(row.roleName);
				url = contextPath + "/roleAction!saveRole.shtml?tbRole.roleId="+row.roleId;
			} else {
				buildEasyUI.promptingMessage();
			}
		}
	},{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			var row = buildEasyUI.getSelected();   //获得选中的记录
			if(row != null) {
				buildEasyUI.promptingMessage("confirm", function(ok){
					if(ok) {
						buildEasyUI.ajax(contextPath + "/roleAction!deleteRole.shtml", {'tbRole.roleId' : row.roleId});
					}
				});
			}else{
				buildEasyUI.promptingMessage();
			}
		}
	}];
	buildEasyUI.datagridID = "rolemgr";
	buildEasyUI.createDataGrid(contextPath +"/roleAction!findAllRole.shtml", columns);
	buildEasyUI.buttons = [{
		text:'确定',
		iconCls:'icon-ok',
		handler:function(){
			$("input[name='menuIds']").val($("#rolePermission").combotree("getValues").toString());
			buildEasyUI.saveOrUpdate(url, "roleAdd", "roleForm");
		}
	},{
		text:'返回',
		iconCls:'icon-cancel',
		handler:function(){
			buildEasyUI.closeDialog("roleAdd");
		}
	}];
	buildEasyUI.createDialog("roleAdd");
	buildEasyUI.createTree("rolePermission", contextPath + "/menuAction!getMenu.shtml");
	$($("#rolemgr").datagrid("getPager")).pagination({
		pageList: [5,10,15,20],
		pageSize:10,
		layout:['list','sep','first','prev','links','next','last','sep','refresh'],
		displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
	
}

