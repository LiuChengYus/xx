<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<h2>注解版</h2>
<form method="post" action="/add">
    部门名称:<input name="dept.deptname">
    <input type="submit" value="添加">
</form>
</body>
</html>
