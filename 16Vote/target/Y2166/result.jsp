<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <title>本次考试难度</title>
</head>
<script type="text/javascript">

</script>

<body>
<center>


        <h2>本次考试难度如何>></h2>
        <h2>${selectOne.viewTimes}次查看${selectOne.id} ,共有${selectOne.totalVotes}人投票</h2>
        <form action="/vote/add" method="post">
            <c:forEach var="xx" items="${opt}">
                <input type="hidden" name="ids" value="${selectOne.id}"/>
                <input type="radio"  name="id" value="${xx.id}"/>${xx.optContent},${xx.vote}票,${xx.vote/(xx.vote+selectOne.totalVotes)}%
            </c:forEach>
           <input type="submit"  value="投票" />
        </form>

</center>



</body>
</html>