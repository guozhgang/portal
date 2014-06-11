var buildEasyUI = {
		toolbar:'',
		fitColumns:true,
		singleSelect:true,
		pagination:true,
		rownumbers:true,
		queryParams:{},
		striped:true,
		datagridID:'',
		width:400,
		height:300,
		closed:true,
		modal:true,
		cache:false,
		buttons:'',
		lines:true,
		multiple:true,
		type:'post',
		async:true,
		dataType:'json',
		createDataGrid:function(url, columns){
			 $("#" + this.datagridID).datagrid({
				url:url,
				queryParams:this.queryParams,
				fitColumns:this.fitColumns,
				singleSelect:this.singleSelect,
				pagination:this.pagination,
				rownumbers:this.rownumbers,
				columns:[columns],
				striped:this.striped,
				toolbar:this.toolbar
			});
		},		
		createDialog:function(dlgID){
			$("#" + dlgID).dialog({
				width:this.width,
				height:this.height,
				closed:this.closed,
				modal:this.modal,
				cache:this.cache,
				iconCls:'icon-save',
				buttons:this.buttons
			});
		},
		createTree:function(treeID, url){
			$("#" + treeID).combotree({
				url:url,
				lines:this.lines,
				multiple:this.multiple
			});
		},
		createCombobox:function(comboboxID, url){
			$("#" + comboboxID).combobox({
				url:url,
				valueField:'id',
			    textField:'text'
			});
		},
		ajax:function(url, data){
			datagridID = this.datagridID;  
			$.ajax({
				url:url,
				type:this.type,
				async:this.async,
				data:data,
				dataType:this.dataType,
				success:function(data){
					if(data) {
						$.messager.alert("系统提示","删除成功！","info");
						$("#" + datagridID).datagrid("reload");
					}
				}
			});
		},
		saveOrUpdate:function(url, dialogID, formID){
			datagridID = this.datagridID;
			$("#" + formID).form('submit',{
				url:url,
				success:function(data){
					if(data){
						$.messager.alert("系统提示","操作成功!","info");
						$("#" + datagridID).datagrid("reload");
					}else{
						$.messager.alert("提示","操作失败,请联系管理员","info");
					}
					$("#" + dialogID).dialog("close");
				}
			
			});
		},
		openDialog:function(dialogID, title){
			$("#" + dialogID).dialog("open").dialog("setTitle",title);
		},
		closeDialog:function(dialogID){
			$("#"+dialogID).dialog('close');
		},
		getSelected:function(){
			return $("#" + this.datagridID).datagrid("getSelected");
		},
		promptingMessage:function(type, callback){
			if(type == "confirm") {
				$.messager.confirm("系统提示", "确定要删除此数据吗?", callback);
			} else {
				$.messager.alert("系统提示", "请先选择一条信息", "info");
			}
			
		}
};