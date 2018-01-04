<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>CheckBox Tree - jQuery EasyUI Demo</title>

</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<body>

<ul id="tt" class="easyui-tree" data-options="url:'/static/jquery-easyui-1.3.3/demo/tree/tree_data2.json',animate:true,checkbox:true"></ul>

</body>
</html>