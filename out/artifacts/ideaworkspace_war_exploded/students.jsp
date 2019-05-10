<%@ page import="com.xmetc.project.utils.DBUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="utils.DBUtil" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/3
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有学生</title>
    <link rel="stylesheet"  href="../css/bootstrap.css"/>
</head>
<body>
	<div class="container">
    <table class="table table-striped table-hover">
    <%
        DBUtil dbUtil=new DBUtil();
        String sql="select * from tab_student";
        ResultSet resultSet=dbUtil.query(sql);
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            String stuNo=resultSet.getString("stu_no");
            String stuName=resultSet.getString("stu_Name");

        %>
        <tr><td><%=id%></td><td><%=stuNo%></td><td><%=stuName%></td></tr>
        <%
        }
        resultSet.close();
    %>
    </table>
    </div>
</body>
</html>
