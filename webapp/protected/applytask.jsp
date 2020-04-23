<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'applytask.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">
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
			 <div class="span10" style="margin-top: -25px; margin-left: -10px;">
				<h2 style="margin-left: 20px;"><span>可参与的任务任务列表：</span></h2>
			    <form action="applytask.action" method="post" class="span10">
				    <table class="table table-striped">
				    	<tr>
				    		<th></th>
				    		<th>#</th>
				    		<th>名称</th>
				    		<th>内容</th>
				    		<th>积分</th>
				    		<th></th>
				    	</tr>
				    	<c:forEach var="notstart"  items="${notstarttsak.list}" varStatus="status">
				    		<tr>
				    			<td><input type="hidden" name="taskId" value="${notstart.task_id}"></td>
				    			<td>${status.index +1}</td>
					    		<td>${notstart.task_name}</td>
					    		<td>${notstart.content}</td>
					    		<td>${notstart.task_score}</td>
					    		<td><a href="applytask.action?taskId=${notstart.task_id}" class="btn">申请</a></td>
				    		</tr>
				    	</c:forEach>
				    </table>
	   			    <div class="pagination" style="float:right;">
						  <ul>
						    <li><a href="tasklist.action?pno=${notstarttsak.prePage}">Prev</a></li>
						    <li><a href="tasklist.action?pno=1">1</a></li>
						    <li><a href="tasklist.action?pno=2">2</a></li>
						    <li><a href="tasklist.action?pno=3">3</a></li>
						    <li><a href="tasklist.action?pno=${notstarttsak.nextPage}">Next</a></li>
						  </ul>
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
