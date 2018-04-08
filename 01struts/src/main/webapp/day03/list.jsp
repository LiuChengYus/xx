<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"%>
<html>
  <head>
      <title>Title</title>
  </head>
<body>
<s:debug/>
<%--<h2>成功，<s:property value="#session.username"></s:property></h2>--%>
<h2>成功，<s:property value="uname"></s:property></h2>
${uname}
</body>
</html>
