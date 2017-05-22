<%--
  Created by IntelliJ IDEA.
  User: cvter
  Date: 2017/5/18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<title>CVTE管理员登陆页面</title>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form id="loginForm">
    <table>
        <tr>
            <td colspan = 2>CVTE管理员登陆页面</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type = text name = username size = 16/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type = password name = password size = 16/></td>
        </tr>
        <tr>
            <td><input type="button" value = 提交 id="loginBtn"></td>
        </tr>
    </table>
</form>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<div id="responseText">${myJson}</div>
</body>
<script>
    $(function () {
        $("#loginBtn").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin/v1/Index",
                data: $('#loginForm').serialize(),// 你的formid
                error: function (request) {
                    alert("Connection error");
                },
                success: function (result) {
                    $("#responseText").html("<h1>" +result.data.description + "</h1>");
                }
            });
        })
    })
</script>
</html>
