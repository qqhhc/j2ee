<%--
  Created by IntelliJ IDEA.
  User: qhc
  Date: 2019/5/4
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container" style="margin: 20px auto">
    <form action="opadd.jsp" method="post">
        学生编号：<input type="text" name="stuNo" class="form-control" style="..."><br/>
        学生姓名：<input type="text" name="stuName" class="form-control" style="..."><br/>
        学生生日：<input type="date" name="stuBirthday" class="form-control" style="..."><br/>
        学生电话：<input type="text" name="stuPhone" class="form-control" style="..."><br/>
        学生地址：<input type="text" name="stuAddress" class="form-control" style="..."><br/>
        学生身高：<input type="text" name="stuHeight" class="form-control" style="..."><br/>
        <input type="submit" value="提交" class="btn btn-success">
    </form>
</div>
</body>
</html>
