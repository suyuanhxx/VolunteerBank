<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <base href="<%=basePath%>">
    
    <title>Publish Task</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/font-awesome/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  
  <body>
  	<!-- 头部 -->
	<div class="row-fluid span12 publishtop">
		<div class="container-fluid">
			<div style="margin-top: 2px; margin-left: 100px;"><a href="return.action"><i class="icon-home icon-white"></i> Home</a></div>
			<div class="dropdown" style="float:right; margin-top: -19px;">
  				<a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
					<i class="icon-user icon-white"></i> ${user.username} <i class="icon-hand-down icon-white"></i>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="profilemanage.action?username=${user.username}"><i class="icon-user"></i> 我的简历</a></li>
					<li><a href="mytasklist.action"><i class="icon-tasks"></i> 我的任务</a></li>
					<li class="divider"></li>
					<li><a href="loginout.action"><i class="icon-key"></i> 退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 页面部分 -->
  	<div class="container-fluid publishcontent">
  		<div class="row-fluid">
			<div class="span2">
			 </div>
			 <div class="span10">
			    <form class="form-horizontal" action="publishtask.action" method="post">
				  <div class="control-group">
				    <label class="control-label">任务名称</label>
				    <div class="controls">
				      <input type="text" id="content" name="taskName" placeholder="taskName">
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label">任务内容</label>
				    <div class="controls">
				      <textarea id="content" name="content" placeholder="taskContent" style="margin: 0px; width: 480px; height: 140px;"></textarea>
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label">任务积分</label>
				    <div class="controls">
				      <input type="text" id="content" name="taskScore" placeholder="taskScore">
				    </div>
				  </div>
				  <div class="control-group">
				    <div class="controls">
				      <button type="submit" class="btn btn-info">发布</button>
				      <a href="javascript:;" onClick="javascript :history.back(-1);" style="margin-left:100px;" class="btn btn-info">取消</a>
				    </div>
				  </div>
				</form>
		    </div>
		</div>
    </div>
    <!-- 页脚 -->
    <div class="footer">2014 &copy; made by team14
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>

    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="assets/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

  </body>
</html>
