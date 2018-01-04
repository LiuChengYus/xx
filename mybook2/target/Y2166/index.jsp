<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书借阅系统 </title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('#first').css('background','grey');
        $('tr:even').css('background','gray');
        ajax();
    });
    function ajax() {
        $('#type').html('');
        $('#type').append(' <option value="-1">请选择</option>')
        $.ajax({
            url:'${pageContext.request.contextPath}/user/type',
            type:'POST',
            success:function (data) {
                $.each(data,function(i,v){
                    $('#type').append('<option value='+v.id+'>'+v.type_name+'</option>')
                })
            }
        });
    }
    //上一页
    function updata(){
        //分类
       var type= $('#type').val();
       //名称
        var name=$('#name').val();
        //阅读
        var look=$('#look').val();
        //当前页
       var index= ${bookData.pageIndex};
        //总页数
        var all=$("#all").attr("href");
       window.location.href="${pageContext.request.contextPath}/user/getOneDatebook/?pageIndex="+(index-1)+"&type="+type+"&bookname="+name+"&look="+look+"&all="+all;
    }
    //下一页
    function downdata(){
        //分类
        var type= $('#type').val();
        //名称
        var name=$('#name').val();
        //阅读
        var look=$('#look').val();
        //当前页
        var index= ${bookData.pageIndex}
        //总页数
        var all=$("#all").attr("href")
            window.location.href="${pageContext.request.contextPath}/user/getOneDatebook/?pageIndex="+(index+1)+"&type="+type+"&bookname="+name+"&look="+look+"&all="+all;
    }
</script>
<body>
 <center>
    <h3>图书借阅系统</h3>
     <form action="${pageContext.request.contextPath}/user/getOneDatebook" method="post">
         图书分类:
         <select name="type" id="type">
             <option value="-1">请选择</option>
         </select>
         &nbsp;&nbsp;&nbsp;图书名称<input type="text" id="name" name="bookname" value="${bookname}">
         是否借阅:
         <select name="look" id="look">
             <option value="-1">请选择</option>
             <option value="0">未借阅</option>
             <option value="1">以借阅</option>
         </select>
         &nbsp;&nbsp;&nbsp;
         <input type="submit" value="查询"><p/>
         <span>当前用户:${user.user_code}</span>
         <table border="1" style="border-collapse:collapse;">
             <tr id="first">
                 <td>图书编号</td>
                 <td>图书分类</td>
                 <td>图书名称</td>
                 <td>作者</td>
                 <td>出版社</td>
                 <td>操作</td>
             </tr>
             <c:if test="${bookData.list.size()<=0}">
                 <tr><td colspan="6" style="text-align: center">对不起,没有符合条件的结果!</td></tr>
             </c:if>
             <c:forEach items="${bookData.list}" var="item">
                 <tr>
                     <td>${item.book_id}</td>
                     <td>${item.type.type_name}</td>
                     <td>${item.book_name}</td>
                     <td>${item.author.author_name}</td>
                     <td>${item.publish_press}</td>
                     <c:if test="${item.is_borrow==0}">
                         <td>申请借阅</td>
                     </c:if>
                     <c:if test="${item.is_borrow==1}">
                         <td>以借阅</td>
                     </c:if>
                 </tr>
             </c:forEach>
         </table>

             <table style="color:white ">
                 <tr>
                     <td> <a href="javascript:updata()" style="color: white">上一页</a></td>
                     <c:forEach var="s"  begin="1" end="${bookData.totalPages}">
                     <td> <div style="border: 1px solid;width: 20px;height: 20px; ">${s}</div></td>
                     </c:forEach>
                     <td> <a href="javascript:downdata()" style="color: white">下一页</a></td>
                     <td>共:<a id="all" href="${bookData.totalPages}" style="color: white">${bookData.totalPages}</a>页
                     <input name="all" type="hidden" value="${bookData.totalPages}">
                     </td>
                 </tr>
             </table>
     </form>
 </center>

</body>
</html>