<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
      <title>value</title>
  </head>
<body>
<s:debug/>
<s:property value="name"></s:property>
<s:property value="mydate"></s:property>
<s:iterator value="list">
    <s:property value="address.street"></s:property>
</s:iterator>
日期
年龄
<s:set name="age" value="10" scope="request"></s:set>
<s:property value="#request.age"></s:property>
<s:date name="mydate" format="yyyy-MM-dd" ></s:date>
</body>
</html>
