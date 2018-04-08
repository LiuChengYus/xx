<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%--打印错误信息--%>
<s:fielderror/>
<s:form action="upload.action" enctype="multipart/form-data" method="POST">
  <s:file name="upload" ></s:file>
    <s:file name="upload" ></s:file>
    <s:file name="upload" ></s:file>
    <s:submit value="点我提交"></s:submit>
</s:form>
<img alt="图片" src="upload/<s:property value='uploadFileName'/>">
<s:iterator value="uploadFileName">
    <img src="upload/<s:property/>" >
</s:iterator>
</body>
</html>
