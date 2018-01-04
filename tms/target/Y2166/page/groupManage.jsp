<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="set" uri="/" %>
<%--<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>角色管理</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        function save() {

            var rows = $("#test").datagrid("getSelected")
               var nodes = $("#tt").tree("getChecked");//重点方法
                var res_id = '';//获取选中的tree叶子的id值
                for (var i = 0; i < nodes.length; i++) {
                    if (res_id != '') res_id += ',';
                    res_id += nodes[i].id;
                }

                  $.ajax({
                    url: "/user/updateRolePrivilege",
                    data: {"rid": rows.rid, "id": res_id},
                    success: function (data) {
                        if (data == "OK") {
                            alert("修改成功!");
                            /!*document.getElementById('frameExecute').contentWindow.location.reload(true);*!/
                        }
                        else {
                            alert(data);
                        }
                    }
                });


        }






                /*    var nodes = $('#tt').tree('getChecked', 'indeterminate');
                  var nodes1 = $('#tt').tree('getChecked');
                    var s = '';
                     for (var i = 0; i < nodes.length; i++) {
                        alert(nodes)
                    }*/



        /* /!*var xx=[];*!/
         var xx= $("#tt").tree('getSelected').text;
         alert(xx.);
         for(var i=0;i<2;i++){
         alert(1);
         }*/


        //打开树状图
        function optree() {
            $("#tt").tree({
                url: '${pageContext.request.contextPath}/user/getDatePrivilege',
                animate: true,
                cascadeCheck: false,
                lines: true,
                checkbox: true,
                loadFilter: function (data) {
                    change(data);
                    $.each(data, function (i, v) {
                        v.iconCls = "icon-folder";
                    });
                    return data;
                },
                onLoadSuccess: function () {
                    var row = $("#test").datagrid("getSelected")
                    /*alert(row.rid)*/
                    //绑定权限
                    $.ajax({
                        url: '${pageContext.request.contextPath}/user/getAllDatePrivilege',
                        cache: false,
                        data: {"rid": row.rid},
                        dataType: 'JSON',
                        success: function (data) {
                            $.each(data, function (i, dom) {
                                $.each(dom.children, function (i, v) {

                                    $.each(v.children,function(i,x){
                                        var node = $('#tt').tree('find', x.id);
                                        /*alert(v.id)*/
                                        $('#tt').tree('check', node.target);
                                    })


                                    var node = $('#tt').tree('find', v.id);
                                    /*alert(v.id)*/
                                    $('#tt').tree('check', node.target);

                                })
                                var node = $('#tt').tree('find', dom.id);
                                /*alert(v.id)*/
                                $('#tt').tree('check', node.target);
                            })
                            /*var array = data.split(',');
                             for(var i=0;i<array.length;i++)
                             {
                             var node = $('#tt').tree('find',array[i]);
                             $('#tt').tree('check',node.target);
                             }*/
                        }
                    })
                }
            })
            /*$("#bb").show();*/
            $('#bb').dialog('open')
        }

        function change(data) {
            if (!data.length) {
                data.text = data.name;
                if (data.children) {
                    change(data.children);
                }
            } else {
                $.each(data, function (i, v) {
                    change(v);
                });
            }
        }


        //角色列表
        $(function () {
            $('#bb').dialog('close')
            $('#test').datagrid({
                fitCloumns: true,
                fit: true,
                pagination: true,
                nowrap: true,
                striped: true,
                url: '${pageContext.request.contextPath}/user/getOneRole',
                sortName: 'code',
                sortOrder: 'desc',
                align: 'center',
                idField: 'code',
                frozenColumns: [[  //冻结列
                    {field: 'ck', checkbox: true},//控制复选框是否显示
                ]],
                columns: [[ //Column是一个数组对象，它的每个元素也是一个数组。元素数组的元素是一个配置对象，它定义了每个列的字段。
                    {field: 'rid', title: '角色编码', width: 100}, //title 标题文本
                    {
                        field: 'rolename', title: '角色名称', width: 100//field：列的字段名
                    },
                    {
                        field: 'opt',
                        title: '操作',
                        width: 100,
                        align: 'center',
                        formatter: function (value, rec, index) {
                            var e = '<a href="#" mce_href="#" onclick="optree(\'' + rec.id + '\')">分配权限</a> ';
                            return e;
                        }
                    },
                ]],
                pagination: true,
                rownumbers: true,
                pageSize: 2,
                pageList: [2, 3, 5, 10],
                singleSelect: true,
                toolbar: [{ //工具栏
                    text: '添加',
                    iconCls: 'icon-add',
                    disabled: false,
                    handler: function () {
                        open1();
                    }
                }, '-', {
                    id: 'btnDelete',
                    text: '删除',
                    iconCls: 'icon-remove',
                    disabled: false,
                    handler: function () {
                        deluser();
                    }
                }, '-', {
                    text: '修改',
                    iconCls: 'icon-edit',
                    disabled: false,
                    handler: function () {
                        alert('修改');
                    }
                }, '-', {
                    text: '查找',
                    iconCls: 'icon-search',
                    disabled: false,
                    handler: function () {
                        alert('查找');
                    }
                }, '-']
            });
        });

        function deleteGroup() {
            var selectRows = $("#dg").datagrid("getSelections");
            if (selectRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的数据！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectRows.length; i++) {
                strIds.push(selectRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectRows.length + "</font>条数据吗?", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/group/deleteGroup.action", {ids: ids}, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "数据已经成功删除！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "数据删除失败，请联系管理员！");
                        }
                    }, "json");
                }
            });
        }


        function openGroupAddDiglog() {
            $("#dlg").dialog("open").dialog("setTitle", "添加角色信息");
            $("#flag").val(1);
            $("#id").attr("readonly", false);
        }

        function openGroupModifyDiglog() {
            var selectRows = $("#dg").datagrid("getSelections");
            if (selectRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要编辑的数据！");
                return;
            }
            var row = selectRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "编辑角色信息");
            $("#fm").form("load", row);
            $("#flag").val(2);
            $("#id").attr("readonly", true);
        }


        function checkData() {
            if ($("#id").val() == '') {
                $.messager.alert("系统系统", "请输入角色名！");
                $("#id").focus();
                return;
            }
            var flag = $("#flag").val();
            if (flag == 1) {
                $.post("${pageContext.request.contextPath}/group/existGroupName.do", {groupName: $("#id").val()}, function (result) {
                    if (result.exist) {
                        $.messager.alert("系统系统", "该角色名已存在，请更换下！");
                        $("#id").focus();
                    } else {
                        saveGroup();
                    }
                }, "json");
            } else {
                saveGroup();
            }
        }

        function saveGroup() {
            $("#fm").form("submit", {
                url: '${pageContext.request.contextPath}/group/groupSave.action',
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统系统", "保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    } else {
                        $.messager.alert("系统系统", "保存失败！");
                        return;
                    }
                }
            });
        }

        function resetValue() {
            $("#id").val("");
            $("#name").val("");
        }

        function closeGroupDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }

    </script>
</head>
<set:authorize URL="/role/addRole">
    <a href="#">角色添加</a>
</set:authorize>

<%--sec:authorize url="/role/addRole/">
    <a href="#">为所欲为啊</a>
</sec:authorize>--%>

<body style="margin: 1px">
<%--<table id="dg" title="角色管理" class="easyui-datagrid"
  fitColumns="true" pagination="true" rownumbers="true"
  url="${pageContext.request.contextPath}/group/groupPage.action" fit="true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="cb" checkbox="true" align="center"></th>
 		<th field="id" width="80" align="center">角色名</th>
 		<th field="name" width="80" align="center">角色名称</th>
 	</tr>
 </thead>
</table>--%>
<table id="test"></table>
<%--<div id="tb">--%>
<%-- <div>
	<a href="javascript:openGroupAddDiglog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
	<a href="javascript:openGroupModifyDiglog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	<a href="javascript:deleteGroup()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
 </div>--%>
</div>


<%--
<ul id="tt" class="easyui-tree" data-options="url:'/user/getDatePrivilege',animate:true,checkbox:true"></ul>--%>

<%--easyui-panel--%>
<div id="bb" class="easyui-dialog" style="width:400px;height:500px;" data-options="title:'分配权限'" modal="true"
     toolbar="#dlg-toolbar" buttons="#dlg-buttons">
    <%--<ul id="tt" class="easyui-tree" data-options="url:'/user/getDatePrivilege',animate:true,checkbox:true"></ul>--%>
    <%-- <ul id="tt" ></ul>--%>
    <ul id="tt"></ul>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="save()">保存权限</a>
</div>


<div id="dlg" class="easyui-dialog" style="width: 600px;height: 150px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellpadding="8px">
            <tr>
                <td>角色名：</td>
                <td>
                    <input type="text" id="id" name="id" class="easyui-validatebox" required="true"/>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>角色名称：</td>
                <td>
                    <input type="text" id="name" name="name" class="easyui-validatebox" required="true"/>
                    <input type="hidden" id="flag" name="flag"/>
                </td>
            </tr>
        </table>
    </form>

</div>


<div id="dlg-buttons">
    <a href="javascript:checkData()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeGroupDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>