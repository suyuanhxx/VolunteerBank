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
    
    <title>Score Rank</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">

  </head>
  
  <body>
  	<div class="span12 container">
	  	<table class="table">
	  		<thead>
	  			<tr>
	  				<th>排名</th>
	  				<th>用户名</th>
	  				<th>积分</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach var="rank" items="${SRpagination.objList}" varStatus="status">
		  			<tr>
		  				<td>${status.index + SRpagination.currentPage}</td>
		  				<td>${rank.username}</td>
		  				<td>${rank.score}</td>
		  			</tr>
	  			</c:forEach>
	  		</tbody>
		</table>
		<div class="pagination">
		  <ul>
		    <li><a onclick="doPage('pre')">Prev</a></li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="">5</a></li>
		    <li ><a onclick="doPage('next')">Next</a></li>
		  </ul>
		</div>
  	</div>
  
  <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
  <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
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
