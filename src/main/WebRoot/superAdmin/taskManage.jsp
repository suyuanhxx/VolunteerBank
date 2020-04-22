<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <!-- <base href="<%=path%>">  -->
    
    <title>TaskManage</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="../assets/css/metro.css" rel="stylesheet" />
	<link href="../assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="../assets/bootstrap-fileupload/bootstrap-fileupload.css" rel="stylesheet" />
	<link href="../assets/css/style.css" rel="stylesheet" />
	<link href="../assets/css/style_responsive.css" rel="stylesheet" />
	<link href="../assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="../assets/chosen-bootstrap/chosen/chosen.css" />
	<link rel="stylesheet" type="text/css" href="../assets/uniform/css/uniform.default.css" />
	<link rel="shortcut icon" href="favicon.ico" />

  </head>
  
  <body class="fixed-top">
  	<div class="header navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
					<img src="assets/img/menu-toggler.png" alt="" />
				</a>          				
				<ul class="nav pull-right">
					<li class="dropdown" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-warning-sign"></i>
							<span class="badge">6</span>
						</a>
						<ul class="dropdown-menu extended notification">
							<li><p>你有xx个提示</p></li>
							<li><a href="#"><span class="label label-success"><i class="icon-plus"></i></span>
								新的用户注册<span class="time">刚刚</span>
								</a>
							</li>
						</ul>
					</li>
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span class="username">${user.username}</span>
							<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="profilemanage.action?username=${user.username}"><i class="icon-user"></i> 我的简历</a></li>
							<li><a href="../mytasklist.action"><i class="icon-tasks"></i>我的任务</a></li>
							<li class="divider"></li>
							<li><a href="../loginout.action"><i class="icon-key"></i>退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="page-container row-fluid">
		<!-- 左边 -->
		<div class="page-sidebar nav-collapse collapse">
			<ul>
				<li><div class="sidebar-toggler hidden-phone"></div></li>
				<li>
					<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />				
							<input type="button" class="submit" value=" " />
						</div>
					</form>
				</li>
				<li class="start ">
					<a href="profileManage.jsp">
					<i class="icon-home"></i> 
					<span class="title">管理中心</span>
					<span class="selected"></span>
					</a>
				</li>
				<li class="has-sub ">
					<a href="javascript:;">
					<i class="icon-table"></i> 
					<span class="title">任务管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub">
						<li class="active"><a href="../protected/publishtask.jsp">发布任务</a></li>
						<li><a href="../pendingtask.action">审核任务</a></li>
						<li ><a href="#">查找任务</a></li>
						<li ><a href="../tasklist.action">参与任务</a></li>
						<li ><a href="../commentlist.action">评价任务</a></li>
					</ul>
				</li>
				<li class="">
					<a href="../login.jsp">
					<i class="icon-user"></i> 
					<span class="title">Login Page</span>
					</a>
				</li>
			</ul>
		</div>
		<!-- 中间 -->
		<div class="page-content">
			<div class="container-fluid span12">
				<div style="float:left; margin-left: 30px;"><h3><a href="../pendingtask.action">审核任务</a></h3></div>
			  	<div style="float: right">
			  		<form  class="form-search" action="selectprize.action" method="post">
			  			<input type="text" class="input-medium search-query" placeholder="Text input" name="keyword"/>
			  			<button type="submit" class="btn btn-success" >搜索</button>
			  		</form>
			  	</div>
			  	<div class="span12" style="padding-top: 10px;">
				    <h3>我发布的任务:（<a href="../protected/publishtask.jsp">我要发布任务</a>）</h3>
				    <table class="table table-hover span10">
				    	<tr>
				    		<th>#</th>
				    		<th>任务名</th>
				    		<th>任务内容</th>
				    	</tr>
					    <c:forEach var="tasklist2" items="${mypublishertask}" varStatus="status">
					    	<tr>
					    		<td>${ status.index + 1}</td>  
					    		<td>${tasklist2.taskName}</td>
					    		<td>${tasklist2.content}</td>
					    	</tr>
					    </c:forEach>
				    </table>
				    <div class="pagination" style="float:right; margin-right: 150px;">
					  <ul>
					    <li><a href="#">Prev</a></li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">Next</a></li>
					  </ul>
					</div>
				</div>
				<!-- 接受的任务 -->
			    <div class="span12">
				    <h3>我接收的任务:（<a href="../tasklist.action">我要做任务</a>）</h3>
				    	<table class="table table-hover span4">
				    		<tr>
				    			<th>#</th>
				    			<th>任务名称</th>
				    		</tr>
						    <c:forEach var="tasklist1" items="${myacceptertask}" varStatus="status">
						    	<tr>
						    		<td>${ status.index + 1}</td>  
						    		<td><a href="../findtask.action?id=${tasklist1.taskId}" class="btn btn-link">${tasklist1.taskName}</a>
						    			<!--<form action="../findtask.action" method="post" name="detailform">
							    			<input type="hidden" name="id" value="${tasklist1.taskId}">
							    			<input type="button" class="btn btn-link" id="detailB" value="${tasklist1.taskName}">
						    			</form>-->
						    		</td>
						    	</tr>
						    </c:forEach>
					    </table>
					     <div class="span6" style="display: none;" id="detaildiv">
							<ul class="unstyled">
							  <li><p class="text-info taskdetail">任务ID：${task.taskId}</p></li>
							  <li><p class="text-info taskdetail">任务名称：${task.taskName}</p></li>
							  <li><p class="text-info taskdetail">任务内容：${task.content}</p></li>
							  <li><p class="text-info taskdetail">任务积分：${task.taskScore}</p></li>
							  <li><p class="text-info taskdetail">任务进度：</p></li>
							</ul><br>
							<div id="submitjob" style="float:left;">
								<form action="" method="post" name="submitjob">
									<input type="hidden" name="taskid" value="${task.taskId}">
									<input type="hidden" name="taskscore" value="${task.taskScore}">
									<input type="text"  id="amount" disabled="disabled" name="amount" style="width: 30px; margin-top: 5px;"><span>%</span>
									<div id="slider" style="width:200px;"></div>
									<span class="text_info">我已完成该任务</span>
									<input type="button" value="提交" onclick="go()">
								</form>
							</div><br>
		    			<div class="span6" style="margin-top:10px;"><p id="tc" class="text-info taskdetail">
		    					任务评价：${task.taskComment}</p>
		    			</div>
					</div>
			   </div>
			    <div class="pagination" style="float:left; margin-left: 230px;">
				  <ul>
				    <li><a href="#">Prev</a></li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">Next</a></li>
				  </ul>
				</div>
			 </div>
		</div>
	</div>
	<div class="footer">2014 &copy; made by team14
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>
	
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
	<script src="../assets/js/app.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {	
			App.setPage('calendar');
			App.init();
			});
		$("#detailB").click(function(){
			document.forms["detailform"].submit();
			document.getElementById("detaildiv").style.display = "";
		});
	</script>
  </body>
</html>
