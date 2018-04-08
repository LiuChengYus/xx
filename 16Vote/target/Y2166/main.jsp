<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <title>系统登陆</title>
</head>
<script type="text/javascript">
    $(function(){
        $("tr:even").css("background","pink");
        $.ajax({
            url:"/vote/subjectlist",
            type : "POST",
            success:function (date) {
                $.each(date,function (i,item) {
                    $('#sublist').append('<tr> <td>'+item.id+'</td> <td><a href="/vote/options?sid='+item.id+'">'+item.title+'</a></td><td>'+item.totalVotes+'</td><td></td></tr>')
                })
            }
        });
    });
</script>

<body>
<center>

    <table id="sublist" border="1" style="border-collapse: collapse">
        <tr colspan="4"><h2>全部主题>></h2></tr>
        <tr>
            <td>序号</td>
            <td>主题</td>
            <td>投票/查看</td>
            <td>创建时间</td>
        </tr>
    </table>
</center>



</body>
</html>