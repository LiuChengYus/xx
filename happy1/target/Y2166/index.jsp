<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加新闻</title>


    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script type="text/javascript">

    </script>
</head>
<body>
<script>
    var ctx = '${ctx}';</script>
<!--百度编辑器--->
<script type="text/javascript" charset="utf-8" src="${ctx}/assets/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/assets/ueditor/ueditor.all.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${ctx}/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script>
    var ue = UE.getEditor('editor');
</script>
<div>
    <script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
</div>
</body>
</html>