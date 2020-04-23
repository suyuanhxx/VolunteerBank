<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>ProfileManage</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author"/>
	<link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
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
							<li>
								<p>你有xx个提示</p>
							</li>
							<li>
								<a href="#">
								<span class="label label-success"><i class="icon-plus"></i></span>
								新的用户注册
								<span class="time">刚刚</span>
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
							<li><a href="../scorerank.action"><i class="icon-tasks"></i>积分排名</a></li>
							<li class="divider"></li>
							<li><a href="../loginout.action"><i class="icon-key"></i>退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>	
	<div class="page-container row-fluid">

		<div class="page-sidebar nav-collapse collapse">
			<ul>
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />				
							<input type="button" class="submit" value=" " />
						</div>
					</form>
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>
				<li class="start ">
					<a href="../index.jsp">
					<i class="icon-home"></i> 
					<span class="title">管理中心</span>
					<span class="selected"></span>
					</a>
				</li>
				<li class="has-sub ">
					<a href="javascript:;">
					<i class="icon-bookmark-empty"></i> 
					<span class="title">个人中心</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub">
						<li class="active"><a href="#tab_1_2">个人资料</a></li>
						<li ><a href="../mytasklist.action">我的任务</a></li>
						<li ><a href="../prizeshow.action">商品管理</a></li>
					</ul>
				</li>
				<li class="has-sub ">
					<a href="javascript:;">
					<i class="icon-table"></i> 
					<span class="title">任务管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub">
						<li ><a href="../protected/publishtask.jsp">发布任务</a></li>
						<li ><a href="../protected/findtask.jsp">查找任务</a></li>
						<li ><a href="../tasklist.action">参与任务</a></li>
						<li ><a href="../commentlist.action">评价任务</a></li>
					</ul>
				</li>
				<li class="">
					<a href="login.jsp">
					<i class="icon-user"></i> 
					<span class="title">Login Page</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">	
						<h3 class="page-title">
							个人管理		
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.jsp">主页</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="#">个人管理</a>
								<i class="icon-angle-right"></i>
							</li>
						</ul>
					</div>
				</div>
				<div class="row-fluid profile">
					<div class="span12">
						<!--BEGIN TABS-->
						<div class="tabbable tabbable-custom">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab_1_2" data-toggle="tab">个人信息</a></li>
								<li><a href="#tab_1_3" data-toggle="tab">修改账户</a></li>
								<li><a href="#tab_1_4" data-toggle="tab">做过的任务</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane profile-classic row-fluid" id="tab_1_2">
									<ul class="unstyled span10">
										<li><span>用户名:</span> ${user.username}</li>
										<li><span>Email:</span> <a href="#"></a></li>
										<li><span>所在权限组:</span> <span id="authoritytext"></span></li>
										<li><span>关于:</span> xxxxxxxxxxx.</li>
										<!--你们自己添加信息-->
									</ul>
								</div>
								<!--tab_1_2-->
								<div class="tab-pane row-fluid profile-account" id="tab_1_3">
									<div class="row-fluid">
										<div class="span12">
											<div class="span3">
												<ul class="ver-inline-menu tabbable margin-bottom-10">
													<li class="active">
														<a data-toggle="tab" href="#tab_1-1">
														<i class="icon-cog"></i> 
														个人信息
														</a> 
														<span class="after"></span>                           			
													</li>
													<li class=""><a data-toggle="tab" href="#tab_2-2"><i class="icon-picture"></i> 头像修改</a></li>
													<li class=""><a data-toggle="tab" href="#tab_3-3"><i class="icon-lock"></i> 密码修改</a></li>
												</ul>
											</div>
											
											<div class="span9">
												<div class="tab-content">
													<div id="tab_1-1" class="tab-pane active">
														<div style="height: auto;" id="accordion1-1" class="accordion collapse">
															<!--   <iframe width="800px" height="600px" scrolling="no" frameborder="0" src="../profilemanage.action?username=${user.username}"></iframe>		-->
															<form action="../profileupdate.action" method="post">
																	<label class="control-label">真实姓名</label>
																	<input type="text" value="${profile.truename}" class="m-wrap span8" name="truename"/>
																	<label class="control-label">性别</label>
																	<input type="text" value="${profile.sex}" class="m-wrap span8" name="sex">
																	<label class="control-label">年龄</label>
																	<input type="text" value="${profile.age}" class="m-wrap span8"  name="age">
																	<label class="control-label">专业</label>
																	<input type="text" value="${profile.major}" class="m-wrap span8"  name="major">
																	<label class="control-label">学号</label>
																	<input type="text" value="${profile.sno}" class="m-wrap span8" name="sno">
																	<label class="control-label">宿舍</label>
																	<div class="controls">
																		<input type="text" class="span8 m-wrap" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;52-319&quot;,&quot;52-318&quot;,&quot;52-317&quot;]" />
																		<p class="help-block"><span class="muted">可以自动填充哦</span></p>
																	</div>
																	<label class="control-label">关于</label>
																	<textarea class="span8 m-wrap" rows="3"></textarea>
																	<div class="submit-btn">
																		<button type="submit" class="btn green">保存</button>
																		<button class="btn">取消</button>
																	</div>
																</form>
														</div>
													</div>
													<div id="tab_2-2" class="tab-pane">
														<div style="height: auto;" id="accordion2-2" class="accordion collapse">
															<form action="#">
																<p>上传图像</p>
																<br />
																<div class="controls">
																	<div class="thumbnail" style="width: 291px; height: 170px;">
																		<img src="http://www.placehold.it/291x170/EFEFEF/AAAAAA&amp;text=no+image" alt="" />
																	</div>
																</div>
																<div class="space10"></div>
																<div class="fileupload fileupload-new" data-provides="fileupload">
																	<div class="input-append">
																		<div class="uneditable-input">
																			<i class="icon-file fileupload-exists"></i> 
																			<span class="fileupload-preview"></span>
																		</div>
																		<span class="btn btn-file">
																		<span class="fileupload-new">选择文件</span>
																	</div>
																</div>
																<div class="clearfix"></div>
											
																<div class="space10"></div>
																<div class="submit-btn">
																	<a href="#" class="btn green">保存</a>
																	<a href="#" class="btn">取消</a>
																</div>
															</form>
														</div>
													</div>
													<div id="tab_3-3" class="tab-pane">
														<div style="height: auto;" id="accordion3-3" class="accordion collapse">
															<form action="#">
																<label class="control-label">当前密码</label>
																<input type="password" class="m-wrap span8" name="cpwd" id="cpwd" onblur="modifycheck()"/>
																<span id="tips" style="display:none;">与原来的密码不匹配!</span><br>
																<label class="control-label">新密码</label>
																<input type="password" class="m-wrap span8" name="npwd" id="npwd"/>
																<label class="control-label">重新输入</label>
																<input type="password" class="m-wrap span8" name="repwd" id="repwd" onblur="passwordcheck()"/>
																<span id="retips" style="display:none;">两次输入的密码不相同</span><br>
																<div class="submit-btn">
																	<a href="modifypwd.action" class="btn green" id="submit">保存</a>
																	<a href="#" class="btn">取消</a>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
											<!--end span9-->                                   
										</div>
									</div>
								</div>
								<!--end tab-pane-->
								<div class="tab-pane" id="tab_1_4">
									<div class="row-fluid add-portfolio">
										<div class="pull-left">
											<span>做过的任务</span>
										</div>
						
									</div>
									<div class="row-fluid portfolio-block">
										<div class="span5 portfolio-text">
											<div class="portfolio-text-info">
												<h4>替人吃饭</h4>
												<p>吃得好(这里写评价？)</p>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- END PAGE CONTAINER-->	
		</div>	
	</div>

	<div class="footer">
		2014 &copy; made by team14
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
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->
	<script src="../assets/js/app.js"></script>		
	<script type="text/javascript">
		jQuery(document).ready(function() {			
			App.setPage('calendar');
			App.init();
			var au = '${user.authorityId}';
			if(au=="1"){
				document.getElementById("authoritytext").innerText="超级管理员";
			}
			if(au=="2"){
				document.getElementById("authoritytext").innerText="管理员";
			}
			if(au=="3"){
				document.getElementById("authoritytext").innerText="普通会员";
				
			}
		});
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
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>