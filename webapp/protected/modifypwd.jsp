<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifypwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <form action="modifypwd.action" method="post">
    	当前密码：<input type="password" name="cpwd" id="cpwd" onblur="modifycheck()"/>
    	<span id="tips" style="display:none;">与原来的密码不匹配!</span><br>
    	输入密码：<input type="password" name="npwd" id="npwd"><br>
    	确认密码：<input type="password" name="repwd" id="repwd" onblur="passwordcheck()">
    	<span id="retips" style="display:none;">两次输入的密码不相同</span><br>
    	<input type="submit" id="submit" value="修改">
    </form>
  </body>
  <script type="text/javascript">
  	function modifycheck(){
		var pwd = '${profile.pwd}';
		var cpwd = document.getElementById("cpwd").value;
		if(pwd!=cpwd){
			document.getElementById("tips").style.display="";
			document.getElementById("submit").disabled = "disabled";
		}
		else{
			document.getElementById("tips").style.display="none";
			document.getElementById("submit").disabled = "";
		}
	}
	function passwordcheck(){
		var npwd = document.getElementById("npwd").value;
		var repwd = document.getElementById("repwd").value;
		if(npwd == repwd){
			document.getElementById("retips").style.display="none";
			document.getElementById("submit").disabled = "";
		}
		else{
			document.getElementById("retips").style.display="";
			document.getElementById("submit").disabled = "disabled";
		}
	
	}
  </script>
</html>
