<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--性能低--%>
<s:form name="form1" method="POST" action="UserAction">
    请输入用户名:<s:textfield name="username"></s:textfield><br/>
    <s:textfield name="password"></s:textfield><br/>
    <s:submit value="登陆"></s:submit>
</s:form>
</body>
</html>
