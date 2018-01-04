<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书借阅系统 </title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('tr:even').css('background','pink');
        ajax();
    });
    function ajax() {
        $('#type').html('');
        $('#type').append(' <option value="0">请选择</option>')
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
</script>
<body>
 <center>
    <h3>图书借阅系统</h3>
     <form action="#" method="post">
         图书分类:
         <select name="type" id="type">
             <option value="0">请选择</option>
         </select>
         &nbsp;&nbsp;&nbsp;图书名称<input>
         是否借阅:
         <select>
             <option value="0">请选择</option>
             <option value="1">以借阅</option>
             <option value="2">未借阅</option>
         </select>
         &nbsp;&nbsp;&nbsp;
         <input type="submit" value="查询">
         <table>
             <tr>
                 <td>图书编号</td>
                 <td>图书分类</td>
                 <td>图书名称</td>
                 <td>作者</td>
                 <td>出版社</td>
                 <td>操作</td>
             </tr>

         </table>
     </form>
 </center>

</body>
</html>