<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
      <title>value</title>
  </head>
<body>
 <s:form method="post" action="register">
     <s:textfield name="student.name"></s:textfield>
     <s:textfield name="student.age"></s:textfield>
     <s:textfield name="student.birthday"></s:textfield>
     <s:submit value="注册"></s:submit>
 </s:form>
</body>
</html>
