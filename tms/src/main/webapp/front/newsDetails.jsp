<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>新闻详情</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<!--[if IE]>
			<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
		<![endif]-->
	</head>
	<style type="text/css">
		#img{
			margin-left: 400px
		}
	</style>
	<script type="text/javascript">
        function pagecount(id){

			window.location.href="${pageContext.request.contextPath}/front/newsDetails?id="+id;
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
					            	<li><a href="index.html">首页</a></li>
						            <li class="active"><a href="newsInfo.html">新闻资讯</a></li>
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
		
		<!--面包屑-->
		<div class="container">
			<div class="row">
				<div class="col-md-12 padding-left">
					<span id="addressSpan">您所在的位置是：<a href="index.html">首页</a>&nbsp;>&nbsp;<a href="newsInfo.html">新闻资讯</a>&nbsp;>&nbsp;<a href="">新闻详情</a></span>
				</div>
			</div>
		</div>
		
		<!--内容-->
		<div class="container">
			<div class="row border1 margin-top-25">
				<div class="col-md-12 padding-left padding-right">
					<h3 class="text-center margin-top-55 font-family newstitle">董家口港建设木材交易产业园 打造成山东最具影响力的木业中心！</h3>
					<h5 class="text-center margin-top-25 font-family grey newsPublishInfo">发布时间：2016-06-20<span id="laiyuan">来源：木材大数据</span><span id="fangwenliang">访问量：2058</span></h5>
				</div>
				<div class="col-md-12">
					<p class="newsContent font-family"><span style="text-align: center">${news1.summary}</span></p>
					<img src="${pageContext.request.contextPath}/upload/${news1.image_url}" alt="新闻详情" id="img"  width="30%" height="30%"/>
					<p class="newsContent font-family">
						${news1.content}
					</p>
				<%--	<p class="newsContent font-family">
						      该项目设计年处理能力为300万方木材，实际处理能力达350万方。项目运营后，世界上所有进口原木、集装箱原木均可进入大丰港，经过检验检疫处理和加工后，运往全国各地。凭借运距和运价的双重优势，大大提高了物流效率，节约了物流成本，从而在构建大丰港木材集散基地的同时，最终实现打造华东地区最大木材加工贸易集散基地和国家级木材产业园区的目标。 
					</p>--%>
					<div class="col-md-6 prev font-family margin-top-55">
						上一篇：<a  class="blue" onclick="pagecount('${news2.information_code}')">${news2.title}</a>
					</div>
					<div class="col-md-6 text-right next font-family">
						下一篇：<a  class="blue" onclick="pagecount('${news3.information_code}')">${news3.title}</a>
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
					CopyRight © 2000-2019 BitAuto,All Rights Reserved.  版权所有  北京小红基地
				</div>
				<div class="row telphone">
					咨询热线：4000-168-168 (每天9:00—17:30，法定节日休息）
				</div>
				<img src="images/index/rcode_03.png" id="rcode"/>
			</div>
		</div>
	</body>
	<script src="js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</html>
