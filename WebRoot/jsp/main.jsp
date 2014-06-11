<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新闻管理系统</title>
	<link rel="stylesheet" type="text/css" href="../jquery/easyui-1.3.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery/easyui-1.3.6/themes/icon.css">
	<script type="text/javascript" src="../jquery/easyui-1.3.6/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../jquery/easyui-1.3.6/jquery.easyui.min.js"></script>
	
	
	<link rel="stylesheet" type="text/css" href="../app/css/style.css">
	<script type="text/javascript" src="../app/util/utilHelper.js"></script>
	<script type="text/javascript" src="../frame/datagrid.js"></script>
	<script type="text/javascript" src = "../js/rolemgr.js"></script>
	<script type="text/javascript" src = "../js/usermgr.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
	<script type="text/javascript" src="../app/content-mgr/column/columnMgr.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:100%;"></div>
    <div data-options="region:'west',title:'新闻管理系统菜单'" style="width:250px;">
    		<div id="menu"></div>
    </div>
	<div id="menuTab" class="easyui-tabs" data-options="region:'center'" style="padding:5px;background:#eee;">
		
	</div>
	
	<div id='roleAdd'>
		<form id='roleForm' method='post'>
			<div class='role'>
				<input type='hidden' name = 'menuIds'/>
				<label>角色名称：</label>
				<input name='tbRole.roleName' type='text' class="easyui-validatebox" data-options = "required:true"/><br/><br/>
				<label>角色权限：</label>
				<input id='rolePermission' name = 'rolePermission'/>
			</div>
		</form>
	</div>
	<div id='userAdd'>
		<form id='userForm' method='post'>
			<div class='role'>
				<label>登录名称：</label>
				<input name='user.loginname' type='text' class="easyui-validatebox" data-options = "required:true"/><br/><br/>
				<label>用户名称：</label>
				<input name='user.username' type='text' class="easyui-validatebox" data-options = "required:true"/><br/><br/>
				<label>登陆密码：</label>
				<input name='user.loginpassword' type='text' class="easyui-validatebox" data-options = "required:true"/><br/><br/>
				<label>所属角色：</label>
				<input id="belongRole" name='belongRole' /><br/><br/>
			</div>
		</form>
	</div>
</body>
</html>