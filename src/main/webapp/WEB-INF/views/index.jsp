<%--
  Created by IntelliJ IDEA.
  User: cvter
  Date: 2017/5/18
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>欢迎来到CVTE商城</title>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form name = add  action="	/admin/v1/book_add" method = post>
    <table>
        <tr>
            <td colspan = 2>管理员登陆页面</td>
        </tr>
        <tr>
            <td><input type = submit value = 图书上架></td>
        </tr>
        <tr>
            <td><input type = submit value = 图书下架></td>
        </tr>
        <tr>
            <td><input type = submit value = 调整库存></td>
        </tr>
        <tr>
            <td><input type = submit value = 调整价格></td>
        </tr>
    </table>
</form>
</body>
</html>
