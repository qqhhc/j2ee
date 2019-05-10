<%@ page import="entity.Student" %>
<%@ page import="service.StudentService" %>
<%@ page import="service.impl.StudentServiceImpl" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/4
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //通过session获取数据
    Object o=(User) session.getAttribute("user");
    if (o!=null){
//        User user=(User)o;
//        out.println(user.getRealname());
    response.sendRedirect("login.jsp");
    }else{
%>
    <%
      request.setCharacterEncoding("utf-8");
      String stuNo=request.getParameter("stuNo");
      String stuName=request.getParameter("stuName");
      String stuBirthday=request.getParameter("stuBirthday");
      String stuPhone=request.getParameter("stuPhone");
      String stuAddress=request.getParameter("stuAddress");
      String stuHeight=request.getParameter("stuHeight");
      Double  istuHeight=Double.parseDouble(stuHeight);

      Student student=new Student(0,stuNo,stuName,stuBirthday,stuPhone,stuAddress,istuHeight);
      StudentService studentService=new StudentServiceImpl();
      boolean isok=studentService.save(student);
      if(isok){
          %>
      <script type="application/javascript">
          alert("保存成功");
      </script>
    <%
      }else{
          %>
        <script type="application/javascript">
            alert("保存失败");
        </script>
    <%
      }
    }
    %>
    <script type="application/javascript">
        window.location.href="students2.jsp";
    </script>
</body>
</html>
