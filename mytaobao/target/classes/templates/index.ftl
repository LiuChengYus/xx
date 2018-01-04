<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="/static/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/static/layui/layui.js"></script>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <script type="text/javascript" src="/static/index/index.js"></script>
    <title>test</title>
    <style>
        body{height: 100%; margin: 0;padding: 0;}
        .top{border: 1px solid #000; background: #eee;}
        .data{padding:10px;10px;}
        dl{margin:20px 5px; float:left; }
        dt{width:230px; margin:10px; height:283px; }
        dd{width:232px; margin:0 0 10px 10px; height:67px; line-height:22px;  text-align:center;}
    </style>
</head>
<body>
<div class="top">
<#if (sessionUser)??>
    欢迎您:<a href="/user/userindex">${(sessionUser.username) !""}</a>&nbsp;<a href="/user/out"> 退出</a>
<#else>
    <a href="/user/loginindex"> 登陆</a>
</#if>

</div>
<div class="container" >
    <div class="data">

    </div>
    <div id="pagediv" class="laypage_main laypageskin_default"></div>
</div>

</body>

</html>
