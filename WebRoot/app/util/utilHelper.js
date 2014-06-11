var url;//提交form使用
var contextPath;
$(function(){
	var path = window.location.pathname;
	path = path.substring(path.indexOf("/") + 1);
	path = path.substr(path, path.indexOf("/"));
	contextPath = "http://" + window.location.host + "/" + path;
});
/**
 * 关闭窗体
 * @param dialogID 窗体ID
 */
function closeDialog(dialogID) {
	$("#"+dialogID).dialog('close');
}
/**
 * 增加修改
 * @param formID 
 * @param url
 * @param dialogID
 * @param datagridID
 */
function saveOrUpdate(formID, url, dialogID, datagridID){
	$("#" + formID).form('submit',{
		url:url,
		success:function(data){
			if(data){
				$.messager.alert("提示","操作成功!","info");
				$("#" + datagridID).datagrid("reload");
			}else{
				$.messager.alert("提示","操作失败,请联系管理员","info");
			}
			$("#" + dialogID).dialog("close");
		}
	
	});
}

