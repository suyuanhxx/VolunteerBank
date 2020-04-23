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
    
    <title>FindTask</title>
    
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
				<div class="span10" style="margin-left: 220px;">
					<span style="font-size: 18px; margin-top: -20px;">任务名称：</span>
					<div class="input-append">
						<form action="../fuzzytask.action" method="post" name="fuzzy">
							<input type="hidden" value="findtask2" name="uri">
						  	<input class="span12" id="appendedInputButtons" name="keyword" type="text" style="height:34px;">
						  	<button class="btn" onclick="find()">Search</button>
					  	</form>
					</div>
				</div>
				<div class="span12">
					<table class="table">
						<tr>
							<th>任务ID</th>
							<th>任务名称</th>
						</tr>
						<c:forEach var="ftask" items="${futask.objList}">
							<tr>
								<td>${ftask.taskId}</td>
								<td>${ftask.taskName}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="pagination pagination-right">
					  <ul>
					    <li><a onclick="doPage('pre')">Prev</a></li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li ><a onclick="doPage('next')">Next</a></li>
					  </ul>
					</div>
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
			</script>
		<script type="text/javascript">
		$(document).ready(function(){
			var f = '${f}';
			if(f){
				document.getElementById("ftask").style.display="";
			}
		});
	</script>
	<script type="text/javascript">
		function find(){
			$.ajax({
				url:'<%=basePath%>fuzzytask.action.action',
				type:'POST',
				data:$(document.forms["fuzzy"]).serialize(),
				success:function(dataMap){
						alert("sadsadsad");
						var jqueryObj = $(dataMap);
				},
				error:function(){
				}
			});
		}
	</script>
	 <script type="text/javascript">
	/*** 翻页*/
	function doPage(page){  
	    var form=document.forms[0];
	    if('${SRpagination.currentPage}'===page){
	        return;
	    }else if("next"===page){
	        if('${SRpagination.currentPage}'=='${SRpagination.totalPage}')return;
	        form.action='<s:url />?SRpagination.currentPage='+(new Number('${SRpagination.currentPage}')+1);
	    }else if("pre"===page){
	        if('${SRpagination.currentPage}'==1)return;
	        form.action='<s:url />?SRpagination.currentPage='+(new Number('${SRpagination.currentPage}')-1);  
	    }else {
	        form.action='<s:url />?SRpagination.currentPage='+page;
	    }
	    form.submit();
	}
  </script>
  </body>
</html>
