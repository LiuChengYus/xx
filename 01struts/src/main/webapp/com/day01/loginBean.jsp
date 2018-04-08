<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"%>
<html>
  <head>
      <title>Title</title>
  </head>
<body>
<s:debug/>
<s:form name="form1" namespace="/" method="post" action="login">
    请输入用户名： <s:textfield name="name"></s:textfield> <br/>
    <s:password name="pwd"></s:password><br/>
    <s:submit value="登陆"></s:submit>
</s:form>

</body>
</html>
