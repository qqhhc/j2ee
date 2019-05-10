<%@ page import="service.UserService" %>
<%@ page import="service.impl.UserServiceImpl" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户校验</title>
</head>
<body>
   <%
       String username=request.getParameter("username");
       String password=request.getParameter("password");


       UserService userService=new UserServiceImpl();
       User user=userService.findByUsername(username);
       boolean isok=false;
       if(password.equals(user.getPassword())){
           isok=true;
           //保存对象是session
           //session是浏览器和服务器的一段会话，有一个超时时间
           //超时间浏览器和服务器没有再次联系，则session会被清掉
           //session的数据保存在服务器中，sessionId会发送到客户端的cookie
           user.setPassword(null);
           session.setAttribute("user",user);
       }
       if (isok){
         %>
          <script type="text/javascript">
              alert("登陆成功");
              window.location.href="welcome.jsp";
          </script>
   <%
       }else{
        %>
         <script type="text/javascript">
             alert("登陆失败");
             window.history.back();
         </script>
   <%
       }
   %>
</body>
</html>
