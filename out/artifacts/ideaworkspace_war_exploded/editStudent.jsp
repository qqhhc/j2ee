<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<%
    String   stuId=request.getParameter("stuId");
    if (stuId!=null&&!"".equals(stuId)){
        try {
            int  iStuId = Integer.parseInt(stuId);
            StudentService studentService = new StudentServiceImpl();
            Student student = studentService.findById(iStuId);
%>
<form action="opupd.jsp" method="post" >
    <input type="hidden" name="id" value="<%=student.getId()%>">
    学生编号：<input type="text" name="stuNo" class="form-control" style="width: 300px" value="<%=student.getStuNo()%>"/><br/>
    学生姓名：<input type="text" name="stuName" class="form-control" style="width: 300px"  value="<%=student.getStuName()%>"/><br/>
    学生生日：<input type="date" name="stuBirthday" class="form-control" style="width: 300px" value="<%=student.getStuBirthday()%>"/><br/>
    学生电话：<input type="text" name="stuPhone" class="form-control" style="width: 300px" value="<%=student.getStuPhone()%>"/><br/>
    学生住址：<input type="text" name="stuAddress" class="form-control" style="width: 300px" value="<%=student.getStuAddress()%>"/><br/>
    学生身高：<input type="text" name="stuHeight" class="form-control" style="width: 300px" value="<%=student.getStuHeight()%>"/><br/>
    <input type="submit" value="修改" class="btn btn-success" />
</form>
<%
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }
%>
</body>
</html>
