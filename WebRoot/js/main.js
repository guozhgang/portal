$(function(){
	$("#menu").tree({
		url:contextPath + '/menuAction!getMenu.shtml',
		lines:true,
		onClick:function(node){ 
			if(node.text == "角色管理"){
				if($("#menuTab").tabs('exists','角色管理')){
					$("#menuTab").tabs('select',"角色管理");
				}else{
					$("#menuTab").tabs('add',{
						title:'角色管理',
						closable:true,
						content:'<div id="rolemgr" fit="true"></div>'
					});
					roleManager();
				}
			} else if(node.text == "用户管理") {
				if($("#menuTab").tabs('exists','用户管理')) {
					$("#menuTab").tabs('select','用户管理');
				}else{
					$("#menuTab").tabs('add',{
						title:'用户管理',
						closable:true,
						content:'<div id="usermgr" fit="true"></div>'
					});
					userManager();
				}
			}
		}
	});
	
});