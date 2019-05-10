<%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script src="js/md5.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.0.js" ></script>
    <script type="text/javascript">
        function submitForm() {
            var pwd=$("#password").val();
            pwd=md5(pwd);
            console.log(pwd);
            $("#password").val(pwd);
            return true;
        }
    </script>
</head>
<body>
   <form action="opauth.jsp" method="post" onsubmit="return submitForm()">
       <input type="text" name="username" id="username"><br/>
       <input type="password" name="password" id="password"><br/>
       <input type="submit" value="登录">
   </form>
</body>
</html>
