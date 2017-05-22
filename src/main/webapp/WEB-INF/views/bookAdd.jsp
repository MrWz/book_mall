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

<form id="bookAddForm">
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
        <td><input type = button value = 添加 id="bookAddBtn"></td>
    </tr>
</table>
</form>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<div id="responseText">${myJson}</div>
</body>
<script>
    $(function () {
        $("#bookAddBtn").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin/v1/book/add",
                data: $('#bookAddForm').serialize(),// 你的formid
                error: function (request) {
                    alert("bookAdd error");
                },
                success: function (result) {
                    $("#responseText").html("<h1>" +result.data.description + "</h1>");
                }
            });
        })
    })
</script>
</html>