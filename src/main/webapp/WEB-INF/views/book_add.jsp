<%--
  Created by IntelliJ IDEA.
  User: cvter
  Date: 2017/5/18
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<title>图书上架</title>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="/admin/v1/book_add" method="post">
    <table>
    <tr>
        <td colspan = 2>请添加上架图书详情</td>
    </tr>
    <tr>
        <td>书名：</td>
        <td><input type = text name="bookname" size = 32/></td>
    </tr>
    <tr>
        <td>作者：</td>
        <td><input type = text name = "author" size = 32/></td>
    </tr>
    <tr>
        <td>价格：</td>
        <td><input type = int name = "price" size = 32/></td>
    </tr>
    <tr>
        <td>库存：</td>
        <td><input type = int name = "stock" size = 32/></td>
    </tr>
    <tr>
        <td>描述：</td>
        <td><input type = text name = "description" size = 32/></td>
    </tr>
    <tr>
        <td><input type = submit value = 添加></td>
    </tr>
</table>
</form>
<center>${myJson}</center>
</body>
</html>