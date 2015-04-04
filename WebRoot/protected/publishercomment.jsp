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
    
    <title>My JSP 'publishtask.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/jquery-ui-1.10.0.custom.css">
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
			 <div class="span10" style="margin-top: -40px;margin-left: 100px">
			 	<h4 style="margin-left: 26px;">待评价任务：</h4>
			 	<table class="table table-hover span12">
			 		<thead>
			 			<tr>
			 				<th>#</th>
			 				<th>任务发布者</th>
		 					<th>任务ID</th>
		 					<th>任务名称</th>
		 					<th>任务接受者</th>
		 					<th>任务内容</th>
		 					<th>任务积分</th>
		 					<th>开始时间</th>
		 					<th>任务进度</th>
			 			</tr>
			 		</thead>
			 		<tbody>
			 		<c:forEach var="ptask" items="${comment.list}" varStatus="status">
			 			<tr>
			 				<td>${status.index+1}</td>
			 				<td>${ptask.publisher_name}</td>
			 				<td id="taskId_${ptask.task_id}">${ptask.task_id}</td>
			 				<td>${ptask.task_name}</td>
			 				<td>${ptask.accepter_name}</td>
			 				<td>${ptask.content}</td>
			 				<td>${ptask.task_score}</td>
			 				<td>${ptask.start_time}</td>
			 				<td>${ptask.end_time}</td>
			 				<td>
			 					<input type="hidden" id="comment_${ptask.task_id}" value="${ptask.task_comment}">
			 					<input type="hidden" id="progress_${ptask.task_id}" value="${ptask.progress}">
			 					<div style="margin-left:-90px;margin-top: -6px; height: 100px;">
				 					<input type="text"  id="amount_${ptask.task_id}" disabled="disabled" name="amount" style="width: 30px;" value="${ptask.progress}"><span>%</span>
									<div id="slider_${ptask.task_id}" style="width:100px;"></div>
								</div>
			 				</td>
			 				<td><a id="modal-77218" name="comment_${ptask.task_id}" href="#modal-container-77218" role="button" class="btn btn-info comment" data-toggle="modal" style="width: 60px;">评价</a></td>
			 			</tr>
			 		</c:forEach>
			 		</tbody>
			 	</table>
			 	 <div class="pagination" style="float:right; margin-right: 200px;">
					  <ul>
					    <li><a href="commentlist.action?pno=${myPage.prePage}">Prev</a></li>
					    <li><a href="commentlist.action?pno=1">1</a></li>
					    <li><a href="commentlist.action?pno=2">2</a></li>
					    <li><a href="commentlist.action?pno=3">3</a></li>
					    <li><a href="commentlist.action?pno=${myPage.nextPage}">Next</a></li>
					  </ul>
				</div>
		    </div>
		</div>
    </div>
    <!-- 遮罩窗体 -->
	<div id="modal-container-77218" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<form action="comment.action" method="post" name="commentform">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">任务ID:</h3><h3 id="taskId"></h3>
			</div>
			<div class="modal-body">
				<input type="hidden" id="taskId_hidden" name="tid">
				<div id="display">
					<span>以前的评价</span>
					<textarea style="margin: 0px 0px 10px; width: 530px; height: 75px;" disabled="disabled" id="commented"></textarea>
				</div>
				<textarea style="margin: 0px 0px 10px; width: 530px; height: 106px;" name="comment"></textarea>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
				<button class="submit btn btn-primary" id="commentb">保存设置</button>
			</div>
		</form>
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
  </body>
</html>
