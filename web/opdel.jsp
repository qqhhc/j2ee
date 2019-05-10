<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/4
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       String stuId=request.getParameter("stuId");
       Integer istuId=Integer.parseInt(stuId);
       StudentService studentService=new StudentServiceImpl();
       boolean isok=studentService.delete(istuId);
       if(isok){
         %>
   <script type="application/javascript">
       alert("删除成功");
   </script>
       <%
       }else{
         %>
        <script type="application/javascript">
            alert("删除失败");
        </script>
        <%
       }
   %>
    <script type="application/javascript">
        window.location.href="students2.jsp";
    </script>
</body>
</html>
