<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书借阅系统xxxxx </title>
    <link rel="shortcut icon" href="http://www.weather.com.cn/favicon.ico" type="image/x-icon" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function a() {
      /*  var name= $('[name=user_code]').val();
        $.ajax({
            url:'{pageContext.request.contextPath}/selUserByname',
            type:'POST',
            data:{"uname":name},
            success:function (data) {
                alert(data)

            }
        })*/
    }
    function b() {
        var pwd1= $('[name=pwd]').val();
        var pwd2=$('[name=password]').val();
        if(pwd1!=pwd2 || !pwd1.eq(pwd2)){
            alert("两次密码不相同")
        }
    }
</script>
<body>
<center>
    <form action="${pageContext.request.contextPath}user/addUser" method="post">
        <h3>会员注册</h3>
        登陆账号:<input type="text" name="user_code" onblur="a()"><br>
        密码:<input type="password" name="pwd"><br>
        确认密码:<input type="password" name="password" onblur="b()"><br>
        性别<select name="gender">
        <option value="1">男</option>
        <option value="0">女</option>
    </select><br>
        电子邮箱:<input type="text" name="email"><br>
        <input type="submit" value="注册">
        <input type="button" value="返回" onclick="history.go(-1)">
    </form>
</center>

</body>
</html>