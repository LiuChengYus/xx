<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javascript" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加新闻</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layer/theme/default/layer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apply.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
	<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/color.css">--%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<%--Layer弹层--%>

	<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>



	<script type="text/javascript">

        $(function () {

            $("#column").click(function () {
                layer.open({
                    type: 2,
                    title: '栏目选择',
                    shadeClose: true,
                    shade: 0.6,
                    area: ['380px', '90%'],
                    content: '${pageContext.request.contextPath}/page/columntree.jsp', //iframe的url
                    scrollbar: true
                });
            });
        });

        /**
         * 图片预览
         * @param e
         */
        function changImg(e) {
            for (var i = 0; i < e.target.files.length; i++) {
                var file = e.target.files.item(i);
                if (!(/^image\/.*$/i.test(file.type))) {
                    continue; //不是图片 就跳出这一次循环
                }
                //实例化FileReader API
                var freader = new FileReader();
                freader.readAsDataURL(file);
                freader.onload = function (e) {
                    $("#myImg").attr("src", e.target.result);
                };
            }
        }
       function edint(status) {
           var a = $("#file1");
           if ($.trim(a.val()) == '') {
               a.focus();
               return false;
           }else {

               $("#sts").attr("value",status);
               $('#form1').submit();
               return true;
		   }

       }
	</script>
</head>
<body>
<div id="container" style="margin-top: 10px;">
	<div class="server">
		<h3 class="apply_title">基本信息</h3>
		<form method="post" id="form1" action="${pageContext.request.contextPath}/user/updateNews" enctype="multipart/form-data">
			<table class="table" width="100%">

				<tr>
					<td class="first">所属栏目：</td>
					<td>
						<input class="easyui-textbox"  id="column"  placeHolder="点我查询" readonly="readonly" value="${news.column.columnname}"/>
						<input class="easyui-textbox"  type="text" id="columntype" name="columntype" value="${news.columntype}"/>
					</td>
					<td class="first">外部连接：</td>
					<td class="input"><input class="easyui-textbox" name="outerlink" value="${news.outerlink}" /><input type="text"  name="information_code" value="${news.information_code}" /></td>
				</tr>

				<tr>
					<td class="first">文章标题<span class="xing">*</span>：</td>
					<td class="input" colspan="3"><input class="easyui-textbox" type="text" name="title" value="${news.title}" /><input type="hidden" id="sts" name="status" value="${news.status}" /></td>
				</tr>

				<tr>
					<td class="first">标题颜色<span class="xing">*</span>：</td>
					<td class="input">
						<select class="easyui-combobox" name="titlecolor">
							<option value="color" >请选择</option>
							<option  class="apply_civil" value="red" selected="<c:if test="${news.titlecolor=='red'}">selected</c:if>">红色</option>
							<option  class="apply_abroad" value="blue" selected="<c:if test="${news.titlecolor=='blue'}">selected</c:if>">蓝色</option>
						</select>
					</td>
					<td class="first">权重/排序<span class="xing">*</span>：</td>
					<td class="input"><input class="easyui-textbox" name="weight" value="${news.weight}" /></td>

				</tr>
				<tr>
					<td class="first">文章图片<span class="xing">*</span>：</td>
					<td class="input">
						<a href="javascript:;" class="file">
							<input type="file" filename="${news.image_url}"  id="file1" name="upload" value="" accept="image/*" onchange="changImg(event)" style="width:50%;height: 30px">
						</a><img id="myImg"src="${pageContext.request.contextPath}/upload/${news.image_url}"   style="width:50px;height: 50px"/>
					</td>
					<td class="first">关键词<span class="xing">*</span>：</td>
					<td  class="input"><input class="easyui-textbox" type="text" name="primaryword" value="${news.primaryword}" /></td>
				</tr>
				<tr>
					<td colspan="4" class="head">摘要</td>
				</tr>
				<tr>
					<td  class="easyui-textbox"style="height:60px;" colspan="4">
						<textarea javacript:xx() id="summaryeditor" type="text/plain" name="summary" rows="4" cols="100" style="resize:none;width:900px;">${news.summary}</textarea>
						<script type="text/javascript">
                            UE.getEditor('summaryeditor',{
                                toolbars:[[
                                    'undo', //撤销
                                    'redo', //重做
                                    'bold', //加粗
                                    'simpleupload', //单图上传
                                    'insertimage', //多图上传
                                    'insertcode', //代码语言
                                    'fontfamily', //字体
                                    'fontsize', //字号
                                    'edittip ', //编辑提示
                                    'justifyleft', //居左对齐
                                    'justifyright', //居右对齐
                                    'justifycenter', //居中对齐
                                    'justifyjustify', //两端对齐
                                    'emotion', //表情
                                    'spechars', //特殊字符
                                ]],
                                enableAutoSave:true
                            }).getAllHtml();
						</script>
					</td>
				</tr>

				<tr>
					<td colspan="4" class="head">正文</td>
				</tr>
				<tr>
					<td class="easyui-textbox" style="height:60px;" colspan="4">
						<textarea id="editor" name="content"  style="resize:none;width:900px;">${news.content}</textarea>
						<script type="text/javascript">
                            UE.getEditor('editor',{
                                toolbars:[[
                                    'undo', //撤销
                                    'redo', //重做
                                    'bold', //加粗
                                    'simpleupload', //单图上传
                                    'insertimage', //多图上传
                                    'insertcode', //代码语言
                                    'fontfamily', //字体
                                    'fontsize', //字号
                                    'edittip ', //编辑提示
                                    'justifyleft', //居左对齐
                                    'justifyright', //居右对齐
                                    'justifycenter', //居中对齐
                                    'justifyjustify', //两端对齐
                                    'emotion', //表情
                                    'spechars', //特殊字符
								]],
								enableAutoSave:true
							}).getAllHtml();
						</script>
					</td>
				</tr>

				<tr>
					<td colspan="4" style="height:40px;">
						<a href="javascript:edint(0);" class="easyui-linkbutton">确认修改</a>
						<a href="javascript:edint(1);" class="easyui-linkbutton">发布</a>
						<a href="javascript:;" class="easyui-linkbutton">关闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>