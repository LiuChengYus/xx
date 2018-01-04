<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<!--[if IE]>
			<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
		<![endif]-->
	</head>
	<script type="text/javascript">
		function loginfront(){
			$.post('${pageContext.request.contextPath}/front/loginFront',$('#form1').serialize(),function(data){
			   if(data!=null){
			       window.location.href="/front/index.jsp";
			   }
			 })
		}

	</script>
	<body>
	<form action="${pageContext.request.contextPath}/front/loginFront" method="post" id="form1">
		<div class="container-fluid">
			<div class="row login-logo-div">
				<div class="col-dm-12">
					<img src="images/index/logo_06.png"/>
					<a href="index.html"><button type="button" class="btn btn-default">返回首页</button></a>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row login-center-div">
				<div class="col-md-12 padding-right">
					<img src="images/index/bg1_02.png"/>
					<div class="col-md-4 col-sm-8 border1 col-md-offset-4 loginDiv">
						<div class="col-md-11 width100">
							<hr class="margin-top-55" />
							<span id="userLoginTxt" class="font-family">用户登录</span>
							<div class="input-group usernameDiv">
							    <span class="backgroundColor input-group-addon border1" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
							    <input type="text" name="username" id="username" class="form-control font-family" placeholder="请输入账号" aria-describedby="basic-addon1">
							</div>
							<div class="input-group userpwdDiv">
							    <span class="backgroundColor input-group-addon border1" id="basic-addon1"><span class="glyphicon glyphicon-lock"></span></span>
							    <input type="password" name="userpwd" id="userpwd" class="form-control font-family" placeholder="请输入密码" aria-describedby="basic-addon1">
							</div>
							<div class="col-md-6 padding-left text-left margin-top-20"><a href="forgot-pass.jsp" class="font12">忘记密码?</a></div>
							<div class="col-md-6 padding-right text-right margin-top-20"><a href="" class="font12">注册</a></div>
							<div class="col-md-12 padding-left padding-right">
								<button type="button" class="btn btn-default margin-top-20" id="loginBtn" onclick="loginfront()">立即登录</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
		<div class="container linkDiv">
			<div class="row">
				<div class="col-md-12">
					<ul class="margin-top-20 font12">
						<li><a href="">关于我们</a><span id="line">|</span></li>
						<li><a href="">业务体系</a><span id="line">|</span></li>
						<li><a href="">企业动态</a><span id="line">|</span></li>
						<li><a href="">联系我们</a><span id="line">|</span></li>
						<li><a href="">法律声明</a><span id="line">|</span></li>
						<li><a href="">服务协议</a><span id="line">|</span></li>
						<li><a href="">Investor Relations</a><span id="line">|</span></li>
						<li><a href="">用户体验中心</a><span id="line">|</span></li>
						<li><a href="">关于会员</a><span id="line">|</span></li>
						<li><a href="">我要提意见</a></li>
					</ul>
				</div>
			</div>
			<div class="row margin-top-20">
				<div class="col-md-6 text-left font12">
					CopyRight © 2000-2015 BitAuto,All Rights Reserved.  版权所有  北京国数源科技有限公司
				</div>
				<div class="col-md-6 text-right font12">
					咨询热线：4000-168-168 (每天9:00—17:30，法定节日休息）
				</div>
			</div>
		</div>
	
	</body>
	<script src="js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</html>
