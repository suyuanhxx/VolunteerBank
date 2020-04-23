<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'profile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/metro.css" rel="stylesheet" />
	<link href="assets/css/style.css" rel="stylesheet" />
	<link rel="shortcut icon" href="favicon.ico" />

  </head>
  
  <body class="span8" style="height:480px;">
	<form action="profileupdate.action" method="post">
		<label class="control-label">真实姓名</label>
		<input type="text" value="${profile.truename}" class="m-wrap span8" name="truename"/>
		<label class="control-label">性别</label>
		<input type="text" value="${profile.sex}" class="m-wrap span8" name="sex">
		<label class="control-label">年龄</label>
		<input type="text" value="${profile.age}" class="m-wrap span8"  name="age">
		<label class="control-label">专业</label>
		<input type="text" value="${profile.major}" class="m-wrap span8"  name="major">
		<label class="control-label">学号</label>
		<input type="text" value="${profile.sno}" class="m-wrap span8" name="sno">
		<label class="control-label">宿舍</label>
		<div class="controls">
			<input type="text" class="span8 m-wrap" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;52-319&quot;,&quot;52-318&quot;,&quot;52-317&quot;]" />
			<p class="help-block"><span class="muted">可以自动填充哦</span></p>
		</div>
		<label class="control-label">关于</label>
		<textarea class="span8 m-wrap" rows="3"></textarea>
		<div class="submit-btn">
			<button type="submit" class="btn green">保存</button>
			<button class="btn">取消</button>
		</div>
	</form>
	<script src="../assets/js/jquery-1.8.3.min.js"></script>			
	<script src="../assets/breakpoints/breakpoints.js"></script>			
	<script src="../assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>	
	<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/js/jquery.blockui.js"></script>
	<script src="../assets/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="../assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="../assets/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="../assets/jquery-slimscroll/jquery.slimscroll.min.js"></script>	
	<script type="text/javascript" src="../assets/chosen-bootstrap/chosen/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->
	<script src="../assets/js/app.js"></script>		
	<script type="text/javascript">
		jQuery(document).ready(function() {			
			App.setPage('calendar');
			App.init();
			});
	</script>
  </body>
</html>
