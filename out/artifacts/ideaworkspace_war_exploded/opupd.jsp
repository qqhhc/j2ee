<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生</title>
</head>
<body>
   <%
       request.setCharacterEncoding("utf-8");
       String id=request.getParameter("id");
       String stuNo=request.getParameter("stuNo");
       String stuName=request.getParameter("stuName");
       String stuBirthday=request.getParameter("stuBirthday");
       String stuPhone=request.getParameter("stuPhone");
       String stuAddress=request.getParameter("stuAddress");
       String stuHeight=request.getParameter("stuHeight");
   try {
       Integer isutId=Integer.parseInt(id);
       Double  istuHeight=Double.parseDouble(stuHeight);

       Student student=new Student(isutId,stuNo,stuName,stuBirthday,stuPhone,stuAddress,istuHeight);
       StudentService studentService=new StudentServiceImpl();
       boolean isok=studentService.update(student);
       if (isok){
         %>
        <script type="text/javascript">
            alert("更新成功");
            window.location.href="students2.jsp";
        </script>
    <%
       }else{
           %>
        <script type="text/javascript">
            alert("更新失败");
            window.history.go(-1);
        </script>
   <%
       }
    }catch(Exception e){
           e.printStackTrace();
   %>
<script type="text/javascript">
    alert("更新失败，请重试");
    window.history.go(-1);
</script>
<%
    }
%>
</body>
</html>
