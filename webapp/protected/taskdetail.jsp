<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'taskdetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/demo.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/jquery-ui-1.10.0.custom.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
  </head>
  
  <body>
  		<!-- 头部 -->
	<div class="row-fluid span12 detailtop">
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
  	<div class="container-fluid detailcontent">
  		<div class="row-fluid">
			<div class="span2">
			 </div>
			 <div class="span10">
			 	<ul class="unstyled">
				  <li><p class="text-info taskdetail">任务ID：${task.taskId}</p></li>
				  <li><p class="text-info taskdetail">任务名称：${task.taskName}</p></li>
				  <li><p class="text-info taskdetail">任务内容：${task.content}</p></li>
				  <li><p class="text-info taskdetail">任务积分：${task.taskScore}</p></li>
				  <li><p class="text-info taskdetail">任务进度：</p></li>
				</ul>
				<!--  <div class="progress active progress-striped span4" style="margin-left: -1px;">
					<div id="progressbar" class="bar"></div>
				</div>-->
				<br>
				<div id="submitjob" style="float:left;">
					<form action="" method="post" name="submitjob">
						<input type="hidden" name="taskid" value="${task.taskId}">
						<input type="hidden" name="taskscore" value="${task.taskScore}">
						<input type="text"  id="amount" disabled="disabled" name="amount" style="width: 30px; margin-top: 5px;"><span>%</span>
						<div id="slider" style="width:200px;"></div>
						<span class="text_info">我已完成该任务</span>
						<input type="button" value="提交" onclick="go()">
					</form>
				</div>
				<br>
		    </div>
		    <div class="span6" style="margin-top:10px;"><p id="tc" class="text-info taskdetail">任务评价：${task.taskComment}</p></div>
		</div>
    </div>

    <!-- 页脚 -->
    <div class="footer">2014 &copy; made by team14
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>

    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/bootstrap/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    
  	<script type="text/javascript">
  		$(document).ready(function(){
  		var progress = '${atask.progress}';
		 $("#slider").slider({
		    orientation: "horizontal ",
		    range: "min",
		    min: 0,
		    max: 100,
		    value: progress,
		    slide: function (event, ui) {
		        $("#amount").val(ui.value);
		    }
		});
		$("#amount").val($("#slider").slider("value"));
		});
		
		window.onload=function(){
			var progress = '${atask.progress}';
	  		if(progress<100){
	  			document.getElementById("tc").style.display="none";
	  		}
	  		else
	  		{
	  			document.getElementById("submitjob").style.display="none";
	  			document.getElementById("tc").style.display="";
	  		}
	  	};
	  	function go(){
	  		var taskid= '${task.taskId}';
		    var taskscore ='${task.taskScore}';
	  		var progress = '${atask.progress}';
	  		var sprogress = document.getElementById("amount").value;
	  		if(sprogress<=progress){
	  			alert("进度条不能小于或等于以前任务完成进度！");
	  		}
	  		else{
	  			document.forms["submitjob"].action="submitjob.action?taskid="+taskid+"&taskscore="+taskscore+"&progress="+sprogress;
	  			document.forms["submitjob"].submit();
	  		}
	  	}
  	</script>
    </body>
</html>
