<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<%--性能低--%>
<s:form name="form1" method="POST" action="UserAction">
    请输入用户名:<s:textfield name="dept.deptno"></s:textfield><br/>
    <s:textfield name="dept.deptname"></s:textfield><br/>
    <s:submit value="添加"></s:submit>
</s:form>
</body>
</html>
