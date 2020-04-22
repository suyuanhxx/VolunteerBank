<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册/登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/metro.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="assets/css/style.css" rel="stylesheet" />
	<link href="assets/css/style_responsive.css" rel="stylesheet" />
	<link href="assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="assets/uniform/css/uniform.default.css" />
	<link rel="shortcut icon" href="favicon.ico" />

  </head>
  
  <body>
  	<div class="logo">
    	<img src="" alt="" /> 
  	</div>
  	<div class="content">
	  	<form action="register.action" method="post" class="form-vertical register-form" >
	      <h3 class="">注册</h3>
	      <p>信息:</p>
	      <div class="control-group">
	        <label class="control-label visible-ie8 visible-ie9">用户名</label>
	        <div class="controls">
	          <div class="input-icon left">
	            <i class="icon-user"></i>
	            <input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
	          </div>
	        </div>
	      </div>
	      <div class="control-group">
	        <label class="control-label visible-ie8 visible-ie9">密码</label>
	        <div class="controls">
	          <div class="input-icon left">
	            <i class="icon-lock"></i>
	            <input class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password" name="password"/>
	          </div>
	        </div>
	      </div>
	      <div class="control-group">
	        <label class="control-label visible-ie8 visible-ie9">密码确认</label>
	        <div class="controls">
	          <div class="input-icon left">
	            <i class="icon-ok"></i>
	            <input class="m-wrap placeholder-no-fix" type="password" placeholder="Re-type Your Password" name="rpassword"/>
	          </div>
	        </div>
	      </div>
	      <div class="control-group">
	        <label class="control-label visible-ie8 visible-ie9">邮箱</label>
	        <div class="controls">
	          <div class="input-icon left">
	            <i class="icon-envelope"></i>
	            <input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email"/>
	          </div>
	        </div>
	      </div>
	      <div class="control-group">
	        <div class="controls">
	          <label class="checkbox">
	          <input type="checkbox" name="tnc"/> 我同意 <a href="#">服务</a> 和<a href="#">隐私</a>
	          </label>  
	          <div id="register_tnc_error"></div>
	        </div>
	      </div>
	      <div class="form-actions">
	        <button id="register-back-btn" type="button" class="btn"><i class="m-icon-swapleft"></i>  后退
	        </button>
	        <button type="submit" id="register-submit-btn" class="btn green pull-right">
	        Sign Up <i class="m-icon-swapright m-icon-white"></i>
	        </button>            
	      </div>
    	</form>
  	</div>
  <div class="copyright">
    2014 &copy; 志愿者银行管理后台
  </div>

  <script src="assets/js/jquery-1.8.3.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>  
  <script src="assets/uniform/jquery.uniform.min.js"></script> 
  <script src="assets/js/jquery.blockui.js"></script>
  <script type="text/javascript" src="assets/jquery-validation/dist/jquery.validate.min.js"></script>
  <script src="assets/js/app.js"></script>

  </body>
</html>
