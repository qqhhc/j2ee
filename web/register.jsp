<%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/5
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
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
    <form action="reg.do" method="post" onclick="return submitForm()">
        用户名：<input type="text" name="username" id="username"><br/>
        密码：<input type="password" name="password" id="password"><br/>
        确认密码:<input type="password" name="cpassword"><br/>
        真实姓名：<input type="text" name="realname"><br/>
        电话号码：<input type="text" name="phone"><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
