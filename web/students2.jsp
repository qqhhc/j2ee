<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/4
  Time: 7:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container">
    <br/>
    <p>
    <a href="addStudent.jsp" class="btn btn-default">添加学生</a>
    </p>
<table class="table table-striped table-hover">
<%
       StudentService studentService=new StudentServiceImpl();
       List<Student> students=studentService.findAll();
       for (Student  student:students){
   %>
      <tr>
          <td><%=student.getId()%></td>
          <td><%=student.getStuNo()%></td>
          <td><%=student.getStuName()%></td>
          <td><%=student.getStuBirthday()%></td>
          <td><%=student.getStuPhone()%></td>
          <td><%=student.getStuAddress()%></td>
          <td><%=student.getStuHeight()%></td>
          <td><a href="editStudent.jsp?stuId=<%=student.getId()%>" class="btn btn-warning">编辑</a></td>
          <td><a href="opdel.jsp?stuId=<%=student.getId()%>" class="btn btn-danger">删除</a></td>
      </tr>
   <%
       }
   %>
   </table>
</div>
</body>
</html>
