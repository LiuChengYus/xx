<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="/***/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="/***/favicon.ico" type="image/x-icon" />
	<link rel="bookmark" href="/***/favicon.ico" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>国数源项目</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
	<link rel="stylesheet" href="/css/normalize.css">
	<link rel="stylesheet" href="/css/convert.css" media="screen" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function submitData(){
		$("#fm").form("submit",{
			url:"${pageContext.request.contextPath}/user/login",
			success:function(result){
				if(result=='y'){
					window.location.href="${pageContext.request.contextPath}/user/doMain";
				}else{
					$.messager.alert("系统提示");
					return;
				}
			}
		});
	}

	function resetValue(){
		$("#userName").val("");
		$("#password").val("");
		$("#groupId").combobox("setValue","");
	}

</script>
</head>
<body>
<div style="position: absolute;width: 100%;height: 100%;z-index: -1;left: 0;top: 0">
	<img src="${pageContext.request.contextPath}/static/images/login_bg.jpg" width="100%" height="100%" style="left: 0;top: 0;">
</div>
<div class="easyui-window" title="国数源项目" data-options="modal:true,closable:false,collapsible:false,minimizable:false,maximizable:false" style="width: 400px;height: 280px;padding: 10px">
	<form id="fm" action="" method="post">
		<table cellpadding="6px" align="center">
			<tr align="center">
				<th colspan="2" style="padding-bottom: 10px"><big>用户登录</big></th>
			</tr>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="userName" name="username" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" id="password" name="userpwd" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<%--<tr>
				<td>角色：</td>
				<td>
					<input  id="groupId" name="groupId" class="easyui-combobox" data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/group/findGroup.action'" value="请选择"/>
				</td>
			</tr>--%>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="javascript:submitData()" class="easyui-linkbutton" iconCls="icon-submit">登录</a>&nbsp;
					<a href="javascript:resetValue()" class="easyui-linkbutton" iconCls="icon-reset">重置</a>
				</td>
			</tr>
		</table>
	</form>
</div>


</div>
<canvas class="canvas"></canvas>
<div class="help">?</div>
<div class="ui">
	<input class="ui-input" type="text" />
	<span class="ui-return">↵</span>
</div>
<div class="overlay">
	<div class="tabs">
		<div class="tabs-labels"><span class="tabs-label">Commands</span><span class="tabs-label">Info</span><span class="tabs-label">Share</span></div>
		<div class="tabs-panels">
			<ul class="tabs-panel commands">
				<li class="commands-item"><span class="commands-item-title">Text</span><span class="commands-item-info" data-demo="Hello :)">Type anything</span><span class="commands-item-action">Demo</span></li>
				<li class="commands-item"><span class="commands-item-title">Countdown</span><span class="commands-item-info" data-demo="#countdown 10">#countdown<span class="commands-item-mode">number</span></span><span class="commands-item-action">Demo</span></li>
				<li class="commands-item"><span class="commands-item-title">Time</span><span class="commands-item-info" data-demo="#time">#time</span><span class="commands-item-action">Demo</span></li>
				<li class="commands-item"><span class="commands-item-title">Rectangle</span><span class="commands-item-info" data-demo="#rectangle 30x15">#rectangle<span class="commands-item-mode">width x height</span></span><span class="commands-item-action">Demo</span></li>
				<li class="commands-item"><span class="commands-item-title">Circle</span><span class="commands-item-info" data-demo="#circle 25">#circle<span class="commands-item-mode">diameter</span></span><span class="commands-item-action">Demo</span></li>
				<li class="commands-item commands-item--gap"><span class="commands-item-title">Animate</span><span class="commands-item-info" data-demo="The time is|#time|#countdown 3|#icon thumbs-up"><span class="commands-item-mode">command1</span>&nbsp;|<span class="commands-item-mode">command2</span></span><span class="commands-item-action">Demo</span></li>
			</ul>
		</div>
	</div>
</div>

<script src="js/index.js"></script>
</body>
</html>