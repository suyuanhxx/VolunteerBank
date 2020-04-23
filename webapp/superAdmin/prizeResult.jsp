<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'prizeResult.jsp' starting page</title>
    <!-- 说明：本页面是prizeManage的复制，唯一不同在于foreach中的items -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/general.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
	<script src="js/popup.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.js"></script>
  </head>
  
  <body>
  	<!-- 头部 -->
	<div class="row-fluid span12 publishtop">
		<div class="container-fluid">
			<div style="margin-top: 2px;"><a href="return.action"><i class="icon-home icon-white"></i> Home</a></div>
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
  	<div class="container-fluid">
  		<div class="row-fluid">
			<div class="span12">
			  	<div style="float: right">
			  		<form  class="form-search" action="selectprize.action" method="post">
			  			<input class="input-medium search-query" type="text" name="keyword"/>
			  			<input class="btn" type="submit" value="搜索"/>
			  		</form>
			  	</div><br>
   				<table class="table table-bordered table-hover">
			    	<thead>
						<tr>
				    		<th width="15%">商品编号</th>
				    		<th width="15%">商品名称</th>
				    		<th width="45%">商品图像</th>
				    		<th width="15%">商品积分</th>
				    		<th width="10%" colspan="2">操作</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach var="prize" items="${prizeSelectedList}">
				    		<tr class="info">
					    		<td id="id_${prize.prizeId}">${prize.prizeId}</td>
					    		<td id="name_${prize.prizeId}">${prize.prizeName}</td>
					    		<td></td>
					    		<td id="score_${prize.prizeId}">${prize.prizeScore}</td>
					    		<td>
					                <div>
					                	<input name="update_${prize.prizeId}"
					                		class="btn btn-small btn-primary update_" type="button" value="修改" style="float:left"/>
					                	<form action="deleteprize.action?prizeId=${prize.prizeId}" method="post" style="float:left">
					                	<input class="btn btn-small btn-danger" type="submit" value="删除" onclick='return confirm("确定要删除吗?")'/>
					                	</form>
					                </div>
					            </td>
				            </tr>
				        </c:forEach>
				        <tr class="warning">
				    		<td id="id_"></td>
				    		<td id="name_"></td>
				    		<td></td>
				    		<td id="score_"></td>
				    		<td>
				                <div>
				                	<input name="update_"
				                		class="btn btn-small btn-info update_" type="button" value="添加" style="float:left"/>&nbsp;
				                </div>
				            </td>        
				        </tr>
				    </tbody>
				</table>
			</div>
		</div>
	</div>	
    
    <div id="popupContact">
		<div class="modal-header">
			<a id="popupContactClose">x</a>
			<h3 id="myModalLabel">
				请输入商品信息
			</h3>
		</div>
		<form id="contactArea" action="updateprize.action" method="post">
			<div class="modal-body">
				<input type="hidden" id="prizeId_edit" name="prizeId"/>
				商品名称：<br>
				<input type="text" id="prizeName_edit" name="prizeName"/>
				<br/><br/>
				商品图像：<br>
				<input type="file" id="prizeImg_edit" name="prizeImg"/>
				<br/><br/>
				商品积分：<br>
				<input type="text" id="prizeScore_edit" name="prizeScore"/>
				<br/><br/>
				<input class="btn btn-primary" type="submit" value="确认" style="float:right"/>
			</div>
		</form>
	</div>
	<div id="backgroundPopup"></div>
</html>