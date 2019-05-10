<%@ page import="entity.User" %>
<%@ page import="service.UserService" %>
<%@ page import="service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
      <%
          request.setCharacterEncoding("utf-8");
          String username=request.getParameter("username");
          String password=request.getParameter("password");
          String realname=request.getParameter("realname");
          String phone=request.getParameter("phone");

          User user=new User(0,username,password,realname,phone);

          UserService userService=new UserServiceImpl();
          boolean isok=userService.register(user);
          if (isok){
             %>
           <script type="text/javascript">
               alert("用户注册成功");
               window.location.href="register.jsp";
           </script>
      <%
          }else{
              %>
          <script type="text/javascript">
           alert("用户注册失败");
           window.history.back();
          </script>
      <%
          }
      %>
</body>
</html>
