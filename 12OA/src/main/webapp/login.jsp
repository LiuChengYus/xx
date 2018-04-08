<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/layui/lay/modules/layer.js"></script>
	<title>北大青鸟办公自动化管理系统</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		font: 12px 宋体;
		background: #4BB8EF url(images/bg.gif) repeat-x;
	}
	
	img {
		border: 0;
	}
	
	.login-top {
		width: 100%;
		height: 186px;
		margin: 147px auto 0;
		background: url(images/login_01.gif) no-repeat center 0;
	}
	
	.login-area {
		width: 100%;
		height: 140px;
		margin: 0 auto;
		background: url(images/login_02.gif) no-repeat center 0;
	}
	
	.login-area form {
		width: 290px;
		margin: 0 auto;
	}
	
	.login-area label {
		clear: left;
		float: left;
		margin-top: 13px;
		width: 60px;
		font: 600 14px 宋体;
	}
	
	.login-area  input {
		width: 122px;
		height: 16px;
		margin-top: 11px;
		border: 1px #767F94 solid;
		font: 12px/ 16px 宋体;
	}
	
	input.login-sub {
		width: 104px;
		height: 34px;
		border: 0;
		background: url(images/login_sub.gif) no-repeat 0px 1px; *
		margin-top: 5px;
	}
	
	
</style>
</head>
<body>

	<div class="login-top"></div>
	<div class="login-area">
	
	    <!-- 登录表单绘制 -->
		<form id="form1" method="post">
			<label>工&nbsp;&nbsp;号：</label>
			<input  type="text" name="sn"/>
			<label>密&nbsp;&nbsp;码：</label>
			<input  type="password" name="password"/>
			<%--<input type="button" value="登陆" onclick="login()"/>--%>
			<div id="mpane" style="margin-top:50px;"></div>
		</form>

	</div>
	
</body>
<script>
  /*  var xx=function login(){
        $.post('/user/login',$('#form1').serialize(),function(data){
            if (data!=null){
                window.location.href="/success.jsp"
            }
        })
    }*/

   $('#mpane').slideVerify({
   type : 2,		//类型
   vOffset : 5,	//误差量，根据需求自行调整
   vSpace : 5,	//间隔
   imgName : ['1.jpg', '2.jpg','3.jpg'],
   imgSize : {
   width: '180px',
   height: '80px',
   },
   blockSize : {
   width: '20px',
   height: '20px',
   },
   barSize : {
   width : '180px',
   height : '30px',
   },
   ready : function() {
   },
   success : function() {

   xx();

   alert('验证成功！');
   },
   error : function() {
   alert('验证失败！');
   }

   });
</script>
</html>