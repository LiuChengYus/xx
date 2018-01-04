<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学管理系统-主页面</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
   $(function(){
       optree();
       seacher();
   });

   //查询框
   function seacher(name,title){
      $('#ss').searchbox({
           searcher:function(value,e){
               var name=$("#tt").tree('getSelected').id;
              /* alert(name+","+value);*/
               loadNews(name,value);
           },
           prompt:'在此输入内容',
       });
   }
    //打开树状图
    function optree() {
        $("#tt").tree({
            url: '${pageContext.request.contextPath}/user/findAllColumn',
            animate: true,
            cascadeCheck: false,
            lines: true,
            loadFilter: function (data) {
                change(data);
                $.each(data, function (i, v) {

                    v.iconCls = "icon-folder";
                });
                return data;
            },
            onLoadSuccess : function(node, data) {
                $('#tt').tree("collapseAll");
            },
			onClick:function(node){
                //判断是否是子节点
                if($('#tt').tree('isLeaf',node.target)){
                    var name=$("#tt").tree('getSelected').id;
                    var title = $('#ss').val();
                    loadNews(name,title);
                }
            }
        })
    }

   //修改
   function edit(id){
       location.href="${pageContext.request.contextPath}/user/showNews?id="+id;
   }


    //新闻列表
    function loadNews(name,title){
        var status;
        status=$("input[type='radio']:checked").val();
        if(status==undefined){
            status=-1;
		}
        $('#column').datagrid({
            height:400,
            pagination: true,
            loadMsg: '数据加载中...',
            nowrap: true,
            striped: true,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/user/getOneNewsTwo?columntype='+name+"&title="+title+"&status="+status,
            sortName: 'code',
            sortOrder: 'desc',
            align:'center',
            idField:'code',
            frozenColumns:[[  //冻结列
                /*{field:'ck',checkbox:false},//控制复选框是否显示*/
            ]],
            columns:[[ //Column是一个数组对象，它的每个元素也是一个数组。元素数组的元素是一个配置对象，它定义了每个列的字段。
                {field:'title',title:'标题',width:120},
                {title:'栏目',field:'columnname',width:80,sortable:true,formatter:function(value,row,index){
                    return row.column.columnname;
                }},
                {title:'创建者',field:'username',width:80,sortable:true,formatter:function(value,row,index){
                    return row.userInfo.username;
                }},
                {title:'状态',field:'status',width:80,sortable:true,formatter:function(value,row,index){
                    if(value==0){
                        return "草稿";
                    }else if(value==1){
                        return "发布";
                    }else if(value==2){
                        return "审核";
                    }else if(value==3){
                        return "删除";
                    }else if(value==4){
                        return "驳回";
                    }
                }},
                {field:'opt',title:'操作',width:400,align:'center',formatter:function(value,rec,index){
                    var e = '<a href="#" mce_href="#" onclick="edit(\''+ rec.information_code + '\')">修改</a> ';
                    return e;
                }},
            ]],
            pagination:true,
            rownumbers:true,
            pageSize: 2,
            pageList: [2, 3, 5, 10],
            singleSelect:false,
        });
	}


   function change(data) {
       if (!data.length) {
           data.text = data.columnname;
           data.id=data.syscode;
           if (data.children) {
               change(data.children);
           }
       } else {
           $.each(data, function (i, v) {
               change(v);
           });
       }
   }


</script>
<body class="easyui-layout">
<div class="easyui-layout" style="width:1127px;height:600px;">
	<div region="west" split="true" title="内容发布" style="width:270px;">
		<ul id="tt"></ul>
	</div>

	<div id="content" region="center" title="国内咨询" style="padding:5px;">
		<input id="ss" class="easyui-searchbox" style="width:180px"/>
		<input type="radio"value="0" name="stat">草稿
		<input type="radio"value="1" name="stat">发布
		<input type="radio"value="2" name="stat">审核
		<input type="radio"value="3" name="stat">删除
		<input type="radio"value="4" name="stat">驳回
		<%--<a href="/page/addNews.jsp" class="easyui-linkbutton"data-options="plain:true" iconCls="icon-search">查询</a>--%>
	    <a href="/page/addNews.jsp" class="easyui-linkbutton"data-options="plain:true" iconCls="icon-add">新增</a>
		<!--搜索框-->
		<table id="column"></table>
	</div>
	</div>
</div>
</body>
</html>