<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>忘记密码</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/forgot-pass.css" />
		<!--[if IE]>
			<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
		<![endif]-->

	</head>
	<script type="text/javascript">
        var countdown=5;
        function settime(obj) {
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.value="免费获取验证码";
                countdown = 5;
                return;
            } else {
                obj.setAttribute("disabled", true);
                obj.value="重新发送(" + countdown + ")";
                countdown--;
            }
            setTimeout(function() {
                    settime(obj) }
                ,1000)
        }



		function getCode(obj){
		  var id=  $('[name=getcode]').val();
		  if(id==1){
		      alert("请选择")
		  }
		  if(id==2){
              var r=confirm("您选择的是手机短信找回密码");
              var name=$('#name').val();
              settime(obj);
              if(r==true){
                  if(name!=""){
                      $.ajax({
                          url:'${pageContext.request.contextPath}/front/sendManagerCode',
                          type:'POST',
                          data:{"phone":name},
                          success:function(data){
                              alert(data)
                          }
                      });
                  }
              }
		  }
            if(id==3){
                var r=confirm("您选择的是QQ邮箱找回密码");
                var name=$('#name').val();
                settime(obj);
                if(r==true){
                    if(name!=""){
                        $.ajax({
                            url:'${pageContext.request.contextPath}/front/SenCode',
                            type:'POST',
                            data:{"address":name},
                            success:function(data){
                                alert(data)
                            }
                        });
                    }
                }
            }
		}

		function postrequest(){
            var id=  $('[name=getcode]').val();
            if(id==1){
               alert("请选择")
			}else if(id==2){
                var r=confirm("短信找回发送");
                if(r==true){
                    $.ajax({
                        url:'${pageContext.request.contextPath}/front/findManageCode',
                        type:'POST',
                        data:{"username":$("[name=username]").val(),"userpwd":$('[name=userpwd]').val(),"code":$('#codes').val()},
                        success:function(data){
                            alert(data)
                        }
                    });
                }
            }else if (id==3){
                var r=confirm("邮箱找回发送");
                if(r==true){
                    $.ajax({
                        url:'${pageContext.request.contextPath}/front/findCode',
                        type:'POST',
                        data:{"username":$("[name=username]").val(),"userpwd":$('[name=userpwd]').val(),"code":$('#codes').val()},
                        success:function(data){
                            alert(data)
                        }
                    });
                }
            }else {
                alert("请选择")
            }
		}

	</script>
	<body>
		<!--顶部-->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 top">
					<div class="container">
						<div class="row">
							<div class="col-md-6">
								<span id="welcome">您好，欢迎您进入中国木材大数据平台</span>
								<span id="loginOrRes"><a href="login.html">登陆</a> / <a href="register.html">注册</a></span>
							</div>
							<div class="col-md-6 padding-right">
								<ul id="topUL">
									<li><a href="">设为首页</a><span id="line">|</span></li>
									<li><a href="">收藏此页</a><span id="line">|</span></li>
									<li><a href="">联系我们</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<!--logo-->
		<div class="container logoDiv">
			<div class="row">
				<div class="col-sm-4 col-md-4 padding-left">
					<img src="images/index/logo_06.png" id="logo"/>
				</div>
				<div class="col-sm-7 col-md-7 col-md-offset-1 padding-right">
					<div class="col-md-7 search">
						<div class="input-group">
						    <span class="input-group-addon"><img src="images/index/search_12.png"/></span>
						    <input type="text" class="form-control" id="searchText" aria-describedby="inputGroupSuccess1Status">
						    <button class="btn btn-default list-inline border-radius" id="searchBtn" type="button">搜索</button>
						</div>
					</div>
					<div class="col-md-5 padding-right">
						<p class="text-right telText bold font-family">全国服务电话:</p>
						<p class="text-right tel bold font-family">400-1234-1234</p>
					</div>
				</div>
			</div>
		</div>
	
		<!--导航-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 padding-left padding-right">
					<nav class="navbar navbar-inverse navbar-static-top">
						<div class="container">
							<div id="navbar" class="collapse navbar-collapse">
					            <ul class="nav navbar-nav font-family">
					            	<li class="active"><a href="index.html">首页</a></li>
						            <li><a href="newsInfo.html">新闻资讯</a></li>
						            <li><a href="marketTrend.html">行情趋势</a></li>
						            <li><a href="marketLive.html">市场实况</a></li>
						            <li><a href="supplyInfo.html">交易中心</a></li>
						            <li><a href="customReport.html">定制报告</a></li>
						            <li><a href="investInfo.html">投资咨询</a></li>
						            <li><a href="businessSystem.html">商务系统</a></li>
						            <li><a href="englishReport.html">English Report</a></li>
					            </ul>
					        </div>
						</div>
					</nav>
				</div>
			</div>
		</div>
		
		<!--注册须知-->
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 border1 margin-top-15 regNoticeDiv">
					<div class="col-md-12 text-center">
						<h2 class="redAn bold font-family">找回密码</h2>
					</div>
					<div class="col-md-12 margin-top-20">
						<form id="form1" action="#">
							<p><span>选择找回方式：</span>
								<select name="getcode">
									<option value="1">选择找回方式</option>
									<option value="2">手机短信</option>
									<option value="3">邮箱</option>
								</select>
							</p>
							<p><span>用户名：</span>
								<input name="username" type="text"/>
							</p>
							<p><span>账号：</span>
								<input id="name" type="text"/>
							</p>
							<p class="code"><span>验证码：</span>
								<input id="codes" type="text" />
								<%--<button type="button" onclick="getCode()">点击获取验证码</button>--%>
								<%--<input  type="button" onclick="getCode()" id="send" value="发送验证码">--%>
								<input type="button" id="btn" value="免费获取验证码" onclick="getCode(this)" />
							</p>
							<p><span>输入密码：</span>
								<input name="userpwd" type="password" />
							</p>
							<%--<p><span>再次输入密码：</span>
								<input type="password"/>
								<input type="" value=""/>
							</p>--%>
							<div class="col-md-10 text-center margin-top-30">
								<a class="btn btn-default goRegisterBth font-family" onclick="postrequest()">确定</a>
							</div>
						</form>
					</div>
					
					
				</div>
			</div>
		</div>
		
		
		<!--友情链接-->
		<div class="container">
			<div class="row">
				<div class="col-md-12 padding-left padding-right">
					<div class="content-friend-link">
						<span id="linkTxt">
							友情链接：
						</span>
						<ul>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
							<a href=""><li>木材大数据平台</li></a>
						</ul>
					</div>
				</div>
			</div>
		</div>
	
		<!--底部-->
		<div class="container-fluid">
			<div class="row footer">
				<div class="col-md-12 ">
					<ul>
						<li><a href="">关于我们</a><span id="shu">|</span></li>
						<li><a href="">业务体系</a><span id="shu">|</span></li>
						<li><a href="">企业动态</a><span id="shu">|</span></li>
						<li><a href="">联系我们</a><span id="shu">|</span></li>
						<li><a href="">法律声明</a><span id="shu">|</span></li>
						<li><a href="">服务协议</a><span id="shu">|</span></li>
						<li><a href="">Investor Relations</a><span id="shu">|</span></li>
						<li><a href="">用户体验中心</a><span id="shu">|</span></li>
						<li><a href="">关于会员</a><span id="shu">|</span></li>
						<li><a href="">我要提意见</a></li>
					</ul>
				</div>
				<div class="row address">
					CopyRight © 2000-2015 BitAuto,All Rights Reserved.  版权所有  北京国数源科技有限公司
				</div>
				<div class="row telphone">
					咨询热线：4000-168-168 (每天9:00—17:30，法定节日休息）
				</div>
				<img src="images/index/rcode_03.png" id="rcode"/>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js" ></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</html>

