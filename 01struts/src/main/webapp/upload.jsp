<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<%--性能低--%>
<s:form action="login" method="POST">
    <s:textfield name="user.name" label="用户名称"></s:textfield>
    <s:textfield name="user.age" label="用户年龄"></s:textfield>
    <s:textfield name="user.birthday" label="用户生日"></s:textfield>
    <s:submit value="注册"></s:submit>
</s:form>
</body>
</html>
