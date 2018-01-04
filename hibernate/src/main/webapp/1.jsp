<%@ page import="cn.happy.day05.biz.HibernateBiz" %>
<%@ page import="cn.happy.day05.entity.Emp" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Filter</h2>
<%
    HibernateBiz biz=new HibernateBiz();
    //01.获取单个员工对象
    Emp emp = (Emp)biz.get(Emp.class, 2);
    //获取员工实体中员工姓名
    System.out.println(emp.getEmpname());
%>
</body>
</html>
