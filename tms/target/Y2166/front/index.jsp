<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>国数源-中国木材大数据平台</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/slider-banner.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/reset.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
        <!-- 引入 ECharts 文件 -->
        <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dark.js"></script>
        <!--[if IE]>
			<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
		<![endif]-->
	</head>
	<script type="text/javascript">
		/* $.post("/front/getAllColumn",function(data){
			 $.each(data,function(key,val){
			     alert(val.columnname)
			 })
		 });*/

		$(function(){
            $('.value_nav span').click(function () {
                $(this).addClass('hover');
                $(this).siblings().removeClass('hover');
                $('.yi').attr('value',$(this).attr('value'));
            });
            $('.yi').change(function () {
                var index=$(this).attr("value");
                $(".value_nav span").eq(index-1).addClass("hover").siblings().removeClass("hover");

                var zid=$("#cpid").find('option:selected').attr("portcode");//这是获取自定义属性的值
				var er=$('.er').val();
                //清除样式
                $(".value_list ul").empty();
                $('.er').empty();
                $.ajax({
                    url:'${pageContext.request.contextPath}/home/week',
                    type:'POST',
                    data:{'port':zid},
                    success:function(data){
                        $.each(data,function(i,dom){
                            /* var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2></li>';*/
                            var timestamp4 = new Date(dom.pubtime);//直接用 new Date(时间戳) 格式转化获得当前时间
                            var time=timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);
                            var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2><font>'+time+'</font> </div> <div class="value_xx2"> <h2>价格</h2> <h3 style=""> <font>'+dom.price+'</font>元</h3> <h4 class="z_j1">'+dom.reduceprice+'元</h4> <h5 style="">0.00%</h5> </div> </li>';
                            $(".value_list ul").append(begin);
                            $('.er').append('<option checked="checked" value='+dom.portlumptype.type_code+'>'+dom.portlumptype.woodname+'</option>')
                            var zid=$("#cpid").find('option:selected').attr("portcode");//这是获取自定义属性的值
                            var er=$('.er').val();
                            $.post("${pageContext.request.contextPath}/front/echaresWeek",{port:zid,type_Code:er},function(data){
                                echares(data);
                            })
                        })
                    }
                });
            });

            $.ajax({
                url:'${pageContext.request.contextPath}/home/week',
				type:'POST',
				success:function(data){
                    $.each(data,function(i,dom){
                       /* var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2></li>';*/
                        var timestamp4 = new Date(dom.pubtime);//直接用 new Date(时间戳) 格式转化获得当前时间
                        var time=timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);
                        var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2><font>'+time+'</font> </div> <div class="value_xx2"> <h2>价格</h2> <h3 style=""> <font>'+dom.price+'</font>元</h3> <h4 class="z_j1">'+dom.reduceprice+'元</h4> <h5 style="">0.00%</h5> </div> </li>';
                        $(".value_list ul").append(begin);
                        $('.er').append('<option checked="checked" value='+dom.portlumptype.type_code+'>'+dom.portlumptype.woodname+'</option>')
                        var zid=$("#cpid").find('option:selected').attr("portcode");//这是获取自定义属性的值
                        var er=$('.er').val();
						$.post("${pageContext.request.contextPath}/front/echaresWeek",{port:zid,type_Code:er},function(data){

                            echares(data);
						})
					})
                }
			});

            $('.er').change(function () {
                var zid=$("#cpid").find('option:selected').attr("portcode");//这是获取自定义属性的值
                var er=$('.er').val();
                $.post("${pageContext.request.contextPath}/front/echaresWeek",{port:zid,type_Code:er},function(data){

                    echares(data);
                })
            });

		})

        function tagPage(name){
		    //清除样式
            $(".value_list ul").empty();
            $('.er').empty();
		   var port=$(name).attr('xx');
            $.ajax({
                url:'${pageContext.request.contextPath}/home/week',
                type:'POST',
                data:{'port':port},
                success:function(data){
                    $.each(data,function(i,dom){
                        /* var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2></li>';*/
                        var timestamp4 = new Date(dom.pubtime);//直接用 new Date(时间戳) 格式转化获得当前时间
                        var time=timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);
                        var begin='<li style="padding-bottom: 5px;"><div class="value_xx1"><h2>'+dom.portlumptype.woodname+'</h2><font>'+time+'</font> </div> <div class="value_xx2"> <h2>价格</h2> <h3 style=""> <font>'+dom.price+'</font>元</h3> <h4 class="z_j1">'+dom.reduceprice+'元</h4> <h5 style="">0.00%</h5> </div> </li>';
                        $(".value_list ul").append(begin);
                        /*$('.er').append('<option checked="checked" value="860">'+dom.portlumptype.woodname+'</option>')*/
                        $('.er').append('<option checked="checked" value='+dom.portlumptype.type_code+'>'+dom.portlumptype.woodname+'</option>')
                        var zid=$("#cpid").find('option:selected').attr("portcode");//这是获取自定义属性的值
                        var er=$('.er').val();
                        $.post("${pageContext.request.contextPath}/front/echaresWeek",{port:zid,type_Code:er},function(data){

                            echares(data);
                        })
                    })
                }
            });
        }


        //报表统计
        function echares(data){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 指定图表的配置项和数据
            option = {
                title: {
                    /*text: '折线图堆叠'*/
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:['市场价格']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: data.datatime
                },
                yAxis: {
                    type: 'value'
                },
                series: [

                    {
                        name:'市场价格',
                        type:'line',
                        stack: '总量',
                        data:data.prices
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }






	</script>
	<body>
	<c:if test="${portInfo==null}">
		<%
		   request.getRequestDispatcher("/home/portinfo").forward(request,response);
		%>
	</c:if>
		<!--顶部-->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 top">
					<div class="container">
						<div class="row">
							<div class="col-md-6">
								<span id="welcome">您好,<span style="color: #5eb95e">${userinfo.username}</span>欢迎您进入中国木材大数据平台</span>
								<c:if test="${userinfo.username==null}">
									<span id="loginOrRes"><a href="login.html">登陆</a> / <a href="registerNotice.html">注册</a></span>
								</c:if>
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
					            <ul class="nav navbar-nav font-family" id="list">
									<c:forEach items="${columnList}" var="item">
										<li><a class="active" href="index.html">${item.columnname}</a></li>
									</c:forEach>
					            </ul>
					        </div>
						</div>
					</nav>
				</div>
			</div>
		</div>

		<!--新闻资讯-->
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-md-8 padding-left">
					<div class="content-news">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									新闻资讯
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>
						<div class="content-news-con">
							<div class="content-news-con-up">
								<div class="col-sm-2 col-md-2">
									<img src="${pageContext.request.contextPath}/upload/${newList[0].image_url}"/>
								</div>
								<div class="col-sm-10 col-md-10 newsCon">
									<h4 class="font-family"><a href="${pageContext.request.contextPath}/front/newsDetails?id=${newList[0].information_code}">${newList[0].summary}</a></h4>
									<p id="content-news-con-p">
										${newList[0].content}
									</p>
									<p id="checkAll"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
								</div>
							</div>
							<div class="content-news-con-down">
								<div class="col-sm-12 col-md-12">
									<ul>
										<c:forEach items="${newList}" var="item" varStatus="status">
											  <c:if test="${status.index>0}">
												  <li><img src="images/index/dott_03.png"/><a href="${pageContext.request.contextPath}/front/newsDetails?id=${item.information_code}">${item.title}</a><span id="date"><fmt:formatDate value="${item.publish_time}" pattern="yyyy-MM-dd"></fmt:formatDate></span></li>
											  </c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-4 padding-right padding-left">
					<div class="banner-news">
						<div class="yx-rotaion">
							<ul class="rotaion_list">
								<li><a href=""><img src="images/other/_2.jpg" alt="木材涨价将促成新一轮优胜劣汰" style="width: 385px; height: 290px;"></a></li>
								<li><a href=""><img src="images/other/_3.jpg" alt="人造板产业焕发新活力之道" style="width: 385px; height: 290px;"></a></li>
								<li><a href=""><img src="images/other/_4.jpg" alt="预计2018年木材行业涨价潮仍将持续" style="width: 385px; height: 290px;"></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="index_bt">
			<h2>市场价格</h2>
			<a href="/index/index/jiage/id/0.html" class="index_more">更多+</a>
		</div>

		<div class="value clearfix">
			<div class="left">
				<div class="value_nav">
					<c:forEach items="${portInfo}" var="item" varStatus="status">
						<c:if test="${status.index==0}">
							<span value="1" xx="${item.info_code}" onclick="tagPage(this)" class="jiage1 hover">${item.port}</span>
						</c:if>
						<c:if test="${status.index>0}">
							<span onclick="tagPage(this)" xx="${item.info_code}" value="${status.index+1}">${item.port}</span>
						</c:if>
					</c:forEach>
				</div>
				<div class="value_box">

					<div class="value_list">
						<ul class="clearfix cao">



							<%--<li style="padding-bottom: 5px;">
								<div class="value_xx1">
									<h2>澳松原木（4m , 16-20)</h2>
									<font>2017-11-20</font>
								</div>
								<div class="value_xx2">
									<h2>价格</h2>
									<h3 style="">
										<font>830</font>元</h3>
									<h4 class="z_j1">0元</h4>
									<h5 style="">0.00%</h5>
								</div>
							</li>--%>




						</ul>
					</div>
				</div>
			</div>
			<div class="right">
				<div class="value_right1 clearfix">
					<div style="position: relative;height: auto;overflow: hidden;">
						<select class="yi" id="cpid">
							<c:forEach items="${portInfo}" var="item" varStatus="status">
								<c:if test="${status.index==0}">
									<option selected="selected" portcode="${item.info_code}" value="1">${item.port}</option>
								</c:if>
								<c:if test="${status.index>0}">
									<option value="${status.index+1}" portcode="${item.info_code}">${item.port}</option>
								</c:if>
							</c:forEach>
						</select>

						<select class="er">
                            <%--<option checked="checked" value="865">澳松原木（4m , 16-20)</option>
                            <option checked="checked" value="861">铁杉原木（不带皮28以下）</option>
                            <option checked="checked" value="862">花旗松原木（不带皮28以下）</option>
                            <option checked="checked" value="863">白松原木（3.8m , 16-20）</option>
                            <option checked="checked" value="864">落叶松原木（4m , 16-20）</option>--%>
                        </select>
					</div>

					<div class="value_right2">
						<%--<div id="shichang" style="width: 450px; height: 330px; -webkit-tap-highlight-color: transparent; user-select: none; position: relative; background: transparent;" _echarts_instance_="ec_1511771490904"><div style="position: relative; overflow: hidden; width: 450px; height: 330px; padding: 0px; margin: 0px; border-width: 0px;"><canvas width="450" height="330" data-zr-dom-id="zr_0" style="position: absolute; left: 0px; top: 0px; width: 450px; height: 330px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); padding: 0px; margin: 0px; border-width: 0px;"></canvas></div><div></div></div>--%>
                            <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                            <div id="main" style="width: 400px;height:300px;"></div>
					</div>
				</div>
			</div>
		</div>
		<!--市场实况-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 padding-left padding-right">
					<div class="content-state">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									市场实况
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>

						<div class="content-state-con">
							<div class="slideTxtBox">
								<div class="hd">
									<ul><li>实时价格</li><li>实时库存</li><li>市场解读</li></ul>
								</div>
								<div class="bd">
									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--广告图-->
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 adDiv padding-left padding-right">
					<ul>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
					</ul>
				</div>
			</div>
		</div>

		<!--定制报告、投资讯息、供应信息、需求信息-->
		<div class="container">
			<div class="row">
				<div class="col-sm-11 col-md-6 padding-left padding-right">
					<div class="content-dingzhi">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									定制报告
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>
						<div class="content-news-con-down">
							<div class="col-sm-12 col-md-12">
								<ul id="dingzhi-ul">
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-11 col-md-6 padding-right">
					<div class="content-dingzhi">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									投资咨询
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>
						<div class="content-news-con-down">
							<div class="col-sm-12 col-md-12">
								<ul id="dingzhi-ul">
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">煤炭行业最新消息：煤炭市场仍将持续低位运行</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">成品油调价最新消息：年内第二次下调</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">中国环境统计年鉴2013</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-11 col-md-6 padding-left padding-right">
					<div class="content-dingzhi">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									投资咨询
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>
						<div class="content-news-con-down">
							<div class="col-sm-12 col-md-12">
								<ul id="dingzhi-ul">
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">煤炭行业最新消息：煤炭市场仍将持续低位运行</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">成品油调价最新消息：年内第二次下调</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">中国环境统计年鉴2013</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-11 col-md-6 padding-right">
					<div class="content-dingzhi">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									投资咨询
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>
						<div class="content-news-con-down">
							<div class="col-sm-12 col-md-12">
								<ul id="dingzhi-ul">
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">我国将发展低能耗绿色建筑 推动节能建材</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">煤炭行业最新消息：煤炭市场仍将持续低位运行</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">成品油调价最新消息：年内第二次下调</a></li>
									<li><img src="images/index/dott_03.png"/><a href="">中国环境统计年鉴2013</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--综合排名-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 padding-left padding-right">
					<div class="content-state">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									综合排名
								</span>
							</div>
							<div class="col-sm-2 col-md-2 col-md-offset-6 col-sm-offset-6">
								<a href=""><span id="more">
									更多>>
								</span></a>
							</div>
						</div>

						<div class="content-state-con">
							<div class="slideTxtBox">
								<div class="hd">
									<ul><li>进口国别</li><li>进口企业</li><li>出口企业</li></ul>
								</div>
								<div class="bd">
									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="content-state-con-up">
												<div class="col-sm-2 col-md-2">
													<img src="images/other/pic_07.png"/>
												</div>
												<div class="col-sm-10 col-md-10 newsCon padding-right">
													<h4 class="font-family">2016-2021年中国自动控制设备产业市场行暨产业发展趋势研究报告。</h4>
													<p id="content-state-con-p">
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
														美国劳伦斯伯克利国家实验室的能源分析师埃文·米尔斯博士日前完成了迄今首个关于向太阳能LED照明转变将如何影响就业和工作机会的全球性分析。他着重研究了全球约2.74亿个缺乏电力供应的家庭中最贫困的1.12亿个。这些主要分布在非洲和亚洲的家庭没有接入电网，也无法负担太阳能发电设备，因此适合使用太阳能LED照明。
													</p>
													<p id="checkAll-state"><a href="">[&nbsp;查看全文&nbsp;]</a></p>
												</div>
											</div>

											<div class="content-state-con-down">
												<div class="col-sm-6 col-md-6">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
												<div class="col-sm-6 col-md-6 padding-right">
													<ul>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
														<li><img src="images/index/dott_03.png"/><a href="">2016-2021年中国自动控制设备产业市场运行暨产业发展趋势研究报</a><span id="date">[07-30]</span></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--广告图-->
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 adDiv padding-left padding-right">
					<ul>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
						<li><img src="images/other/111.jpg"/></li>
					</ul>
				</div>
			</div>
		</div>

		<!--我们的优势-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 padding-left padding-right">
					<div class="content-ourgoods">
						<div class="content-news-title">
							<div class="col-sm-4 col-md-4 padding-left">
								<img src="images/index/nav1_07.png" id="titleBg"/>
								<span id="title" class="font-family">
									我们的优势
								</span>
							</div>
						</div>
						<div class="content-ourgoods-con">
							<ul>
								<li>
									<img src="images/index/shuzi_08.png"/>
									<h3><span id="big" class="font-family bold">请您买的放心</span><br><span id="small">采购支付流程安全快捷</span></h3>
								</li>
								<li>
									<img src="images/index/shuzi_10.png"/>
									<h3><span id="big" class="font-family bold">售前售后服务</span><br><span id="small">最完善的售前售后服务</span></h3>
								</li>
								<li>
									<img src="images/index/shuzi_12.png"/>
									<h3><span id="big" class="font-family bold">赠送增值服务</span><br><span id="small">买报告赠送数据中心会员</span></h3>
								</li>
								<li>
									<img src="images/index/shuzi_03.png"/>
									<h3><span id="big" class="font-family bold">节省时间费用</span><br><span id="small">买多份能获得更高折扣</span></h3>
								</li>
								<li>
									<img src="images/index/shuzi_05.png"/>
									<h3><span id="big" class="font-family bold">报告更新及时</span><br><span id="small">汇集行业最新研究成果</span></h3>
								</li>
							</ul>
						</div>
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

		<!--浮层-->
		<div class="ticket">
			<ul>
				<li><img src="images/index/ticket_03.png"/>定制报告</li>
				<li><img src="images/index/ticket_06.png"/>投资咨询</li>
				<li><img src="images/index/ticket_08.png"/>商务系统</li>
				<li><img src="images/index/ticket_10.png"/>客服中心</li>
			</ul>
		</div>
	</body>
	<!--<script src="js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>-->
	<%--<script src="/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>--%>

	<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.yx_rotaion.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){



			/*选项卡*/
			var ary = location.href.split("&");
			jQuery(".slideTxtBox").slide( { effect:ary[1],autoPlay:ary[2],trigger:ary[3],easing:ary[4],delayTime:ary[5],pnLoop:ary[6] });

			/*轮播图*/
			$(".yx-rotaion").yx_rotaion({auto:true});
		})
	</script>
</html>
