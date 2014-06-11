<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
    <base href="<%=basePath%>">
	<link rel='stylesheet' type='text/css' href='ext/css/ext-all.css' />
	<script src='ext/ext-base.js'></script>
	<script src='ext/ext-all.js'></script>
	<script src='ext/ext-lang-zh_CN.js'></script>
	<script src="ext/function/index.js"></script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
