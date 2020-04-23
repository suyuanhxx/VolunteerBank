<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  <base href="<%=basePath%>">
    <title>Volunteer Bank</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="suhui">
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" type="text/css" href="css/fonts.css">
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="dist/onepage-scroll/jquery.onepage-scroll.css">
    <link rel="stylesheet" href="dist/fancybox/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
	<link rel="stylesheet" href="dist/fancybox/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
	<link rel="stylesheet" href="dist/fancybox/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
  </head>
  <body>
  	<div class="header">
  		<div class="pull-left">
  			<span>
				<a href="//www.github.com" target="_blank"><span class="fa-stack fa-lg">
					<i class="fa fa-circle fa-stack-2x background"></i>
					<i class="fa fa-github-alt fa-stack-1x fa-inverse foreground"></i>
				</span></a>
				<a href="" target="_blank"><span class="fa-stack fa-lg">
					<i class="fa fa-circle fa-stack-2x background"></i>
					<i class="fa fa-comments fa-stack-1x fa-inverse foreground"></i>
				</span></a>
			</span>
  		</div>
  		<div class="pull-right">
  			
	  		<a href="./login.jsp" ><strong>登陆</strong></a>
	  		<a href="./register.jsp" ><strong>注册</strong></a>
	  		<a class="hide-mobile" href="" target="_blank"><strong>社区</strong></a>
	  	</div>
  	</div>

<div class="logo hide-mobile">
  		<img class="default" src="img/logo.png" />
  		<img class="alt invisible" src="img/logo.png" />
  	</div>



  	<nav id="bt-menu" class="bt-menu">

	    <ul>
	    	<li class="separate"><strong>VolunteerBank</strong></li>
	        <li class="link"><a href="#" class="signin">登陆</a></li>
	        <li class="link"><a href="#" class="register">注册</a></li>
	        <li class="link"><a href="#">论坛</a></li>
	    </ul>
	    <div class="bt-overlay"></div>
	</nav>

  

  	<div class="main">

  	<section class="page page-1">
  		<div class="pin-to-top black">
	    	<h1 class="text-bottom"><span class="white">志愿者</span><br />
			<span class="black"><span class="hide-mobile">服务</span> 银行</span></h1>
	    </div>
	    <div class="pin-to-bottom">
	    	<img src="img/pic2.jpg" />
	    	<div class="animation">
		    	<span class="slide slide-in slide-1 subtext">全世界最好的 <strong>志愿者服务平台</strong> </span><br /><br />
		    	<span class="slide slide-in slide-2 subtext"><strong>结识</strong> 更多和你一样的志愿者</span><br /><br />
		    </div>
	    </div>
  	</section>

  	<section class="page page-2">
  		<div class="pin-to-top"><img src="img/pic3.jpg" /></div>
  		<div class="pin-to-bottom black">
	    	<h1 class="text-top"><span class="black slide slide-down">爱心</span><br />
			<span class="white slide slide-down">传播美好</span></h1>


	    </div>
  	</section>

  	<section class="page page-3">
  		<div class="pin-to-top black">
	    	<h1 class="text-bottom"><span class="white">在这里</span><br />
			<span class="black slide slide-down">实现爱的传播</span></h1>
	    </div>
	    <div class="pin-to-bottom">
	    	<span class="thumbnails" data-toggle="lightbox">
				<a href="img/1.jpg" class="fancybox thumbnail img-thumbnail" rel="features-gallery">
					<img src="img/1.jpg" alt="">
				</a>
				<a href="img/1.jpg" class="fancybox thumbnail img-thumbnail" rel="features-gallery">
					<img src="img/1.jpg" alt="">
				</a>
				<br class="small-only" />
				<a href="img/1.jpg" class="fancybox thumbnail img-thumbnail" rel="features-gallery">
					<img src="img/1.jpg" alt="">
				</a>
				<a href="img/1.jpg" class="fancybox thumbnail img-thumbnail not-important" rel="features-gallery">
					<img src="img/1.jpg" alt="">
				</a>
				<a href="img/1.jpg" class="fancybox thumbnail img-thumbnail" rel="features-gallery">
					<img src="img/1.jpg" alt="">
				</a>
			</span>

	    </div>
  	</section>

  	<section class="page page-4">
  		<div class="pin-to-top">
  			<span class="subtext"><strong>走过路过不要错过</strong><br />
			 一起玩，不孤单</span><br />
  		</div>
  		<div class="pin-to-bottom black">
  			<h1 class="text-top"><span class="black">还在等什么?</span><br />
		

			<div class="carousel">
				<div class="thumb">
					<span>打扫敬老院</span>
					<img src="img/1.jpg" alt="">
				</div>
				<div class="thumb">
					<span>52#献血</span>
					<img src="img/1.jpg" alt="">
				</div>
				<div class="thumb">
					<span>修电脑</span>
					<img src="img/1.jpg" alt="">
				</div>
			    <div class="thumb">
					<span>教写作业</span>
					<img src="img/1.jpg" alt="">
				</div>
			</div>
			
  		</div>
  	</section>

  	

	</div><!-- end .main -->

	<div id="overlay">
	</div>

	<div class="modal loginModal">
		<div class="container">
			<h2 class="modal-message">创建一个志愿者帐号</h2>

			<form id="loginForm" action="./register" method="post">
				<input class="email" type='text' placeholder="username/email" name="username" id="email"><br />
				<input class="password" type="password" placeholder="password" name="pwd" id="password"><br />
				<label class="readtos">
					<br /><input type="checkbox" name="readtos" id="readtos" /> 同意网站 <a href="./tos">协议</a><br />
				</label>
			</form>
			<button class="submit">注册</button><br />
			<a href="#" class="cancelModal">取消</a>
			<a href="#" class="passwordReset">忘记密码?</a>
		</div>
	</div>

	<div class="modal passwordResetModal">
		<div class="container">
			<h2 class="modal-message">邮箱</h2>
			<form id="resetForm" action="./reset" method="post">
				<input class="email" type='text' placeholder="username/email" name="username" id="email"><br />
			</form>
			<button class="submit">发送</button><br />
			<a href="#" class="cancelModal">取消</a>
		</div>
	</div>

	<div class="modal resetModal">
		<div class="container">
			<h2 class="modal-message">Reset Password</h2>
			<form id="resetForm" action="" method="post">
				<input class="password" type="password" placeholder="New Password" name="password" id="password"><br />
				<input class="password" type="password" placeholder="Password Again" name="passwordAgain" id="passwordAgain"><br />
				<input type="hidden" id="csrf" name="_csrf" value="r3RSFtoNQvSybVDhEJJAlq+IEl/nIXZjBtJJg=" />
				<input type="hidden" id="code" name="code" value="" />
			</form>
			<button class="submit">Reset Password</button><br />
			<a href="#" class="cancelModal">cancel</a>
		</div>
	</div>

	<div id="alert_window"></div>

	<script type="text/javascript" src="dist/jquery.js"></script>
	<script type="text/javascript" src="dist/onepage-scroll/jquery.onepage-scroll.min.js"></script>
	<script type="text/javascript" src="dist/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="dist/fancybox/jquery.fancybox.pack.js?v=2.1.5"></script>
	<script type="text/javascript" src="dist/fancybox/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
	<script type="text/javascript" src="dist/fancybox/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
	<script type="text/javascript" src="dist/fancybox/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>
	<script src="lib/homepage.js"></script>
	<script src="lib/main.js"></script>
	<script>
		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

		ga('create', 'UA-45914244-2', 'nodebb.org');
		ga('send', 'pageview');
	</script>
	<script type="text/javascript">
		var fb_param = {};
		fb_param.pixel_id = '6013069992218';
		fb_param.value = '0.00';
		fb_param.currency = 'USD';
		(function(){
			var fpw = document.createElement('script');
			fpw.async = true;
			fpw.src = '//connect.facebook.net/en_US/fp.js';
			var ref = document.getElementsByTagName('script')[0];
			ref.parentNode.insertBefore(fpw, ref);
		})();
	</script>
  </body>
</html>