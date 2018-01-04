<%@ page import="cn.happy.day11.service.EmployeeService" %>
<%@ page import="cn.happy.day12.another.Dept" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Filter</h2>
<%
    EmployeeService service=new EmployeeService();
    Dept data = (Dept)service.getData(Dept.class, 60);
    System.out.println(data.getDeptname());
%>
</body>
</html>
