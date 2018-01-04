<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>图书借阅系统 </title>
    <link rel="shortcut icon" href="http://www.weather.com.cn/favicon.ico" type="image/x-icon" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function login(){
        ajax();
    }
    function register() {
        window.location.href="${pageContext.request.contextPath}/register.jsp"
    }
    function ajax() {
        $.ajax({
            url:'${pageContext.request.contextPath}/user/login',
            type:'POST',
            data:$('#form1').serialize(),
            success:function (data) {
                if(data==1){
                    window.location.href="${pageContext.request.contextPath}/index.jsp"
                }else {
                    window.location.href="${pageContext.request.contextPath}/login.jsp"
                }
            }
        });
    }
</script>
<body>
 <center>
     <h3>图书借阅系统</h3>
     <form action="#" method="post" id="form1">
         <table>
             <tr>
                 <td>账号登陆:</td>
                 <td><input name="user_code"></td>
             </tr>
             <tr>
                 <td>登陆密码:</td>
                 <td> <input name="password"></td>
             </tr>
             <tr >
                 <td><input type="button" onclick="login()" value="登陆"></td>
                 <td><input type="button" onclick="register()" value="注册"></td>
             </tr>
         </table>
     </form>
 </center>

</body>
</html>