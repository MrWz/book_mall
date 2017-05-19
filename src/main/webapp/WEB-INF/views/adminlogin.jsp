<%--
  Created by IntelliJ IDEA.
  User: cvter
  Date: 2017/5/18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>CVTE管理员登陆页面</title>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="/admin/v1/index" method = post>
    <table>
        <tr>
            <td colspan = 2>CVTE管理员登陆页面</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type = text name = user size = 16/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type = password name = password size = 16/></td>
        </tr>
        <tr>
            <td><input type = submit value = submit></td>
        </tr>
    </table>
</form>
</body>
</html>
