<%@ page import="cn.happy.day05.biz.HibernateBiz" %>
<%@ page import="cn.happy.day05.entity.Emp" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>添加部门</h2>
    <form method="post" action="/addDept">
        部门名称<input name="deptname">
        <input type="submit" value="添加">
    </form>
</body>
</html>
