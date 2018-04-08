<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<s:head theme="xhtml"/>
<sd:head parseContent="true"/>
<%--性能低--%>
<s:form action="register" method="post">
    <s:textfield name="name" label="用户名称"></s:textfield>
    <s:textfield name="age" label="用户年龄"></s:textfield>
    <sd:datetimepicker name="birthday" label="出生日期"></sd:datetimepicker>
    <sd:textarea cols="20" rows="10" name="intro" label="用户介绍"></sd:textarea>
    <s:submit value="注册"></s:submit>
</s:form>
</body>
</html>
