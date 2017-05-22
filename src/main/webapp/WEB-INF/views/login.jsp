<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CVTE图书商城_欢迎登录</title>
    <link rel="icon" href="../imgs/favicon.ico" type="image/icon"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assert/css/mycss.css"/>
</head>
<body>
<nav class="navbar navbar-default  navbar-static-top" role="navigation" id="nav-top-id">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                <img alt="CVTE图书商城_欢迎登录" style="height: 50px; margin-top: -15px;"/>
            </a>

        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <div class="container">
                <ul class="nav navbar-nav navbar-right">
                    <li><p class="navbar-text">没有账号？&nbsp;&nbsp;&nbsp;
                        <a href="/user/v1/register" class="navbar-link"><span class="glyphicon glyphicon-log-in"></span>
                            现在注册</a>
                    </p></li>
                    <li><p class="navbar-text"><a href="/book/v1/list" class="navbar-link">返回首页</a></p></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <form id="loginForm" class="form-horizontal">
        <div class="form-group">
            <label for="loginAccount" class="col-xs-12 col-md-2 col-md-offset-3 control-label">
                <span class="text-muted">用户名：</span>
            </label>
            <div class="col-xs-12 col-md-3">
                <input type="text" name="username" id="loginAccount" class="form-control" value="" required="required"/>
            </div>
            <div class="col-xs-12 col-md-6 col-md-offset-5">
                <p class="help-block" style="margin-bottom: 0;font-size: 12px;color: #f00;">${accountMsg }</p>
            </div>
        </div>

        <div class="form-group">
            <label for="LoginPassword" class="col-xs-12 col-md-2 col-md-offset-3 control-label">
                <span class="text-muted">密 码：</span>
            </label>
            <div class="col-xs-12 col-md-3">
                <input type="password" name="password" id="LoginPassword" class="form-control" required="required"
                       maxlength="32"/>
            </div>
            <div class="col-xs-12 col-md-6 col-md-offset-5">
                <p class="help-block" style="margin-bottom: 0;font-size: 12px;color: #f00;"></p>
            </div>
        </div>


        <div class="form-group">
            <div class="col-xs-3 col-md-1 col-md-offset-5">
                <input type="button" class="btn btn-primary mybtn" value="登录" id="loginBtn"/>
            </div>
            <div class="col-xs-3 col-md-1">
                <input type="reset" class="btn btn-primary mybtn" value="重置"/>
            </div>
        </div>

        <div class="col-xs-12 col-md-6 col-md-offset-5">
            <p class="help-block" id="" style="margin-bottom: 0;font-size: 12px;color: #f00;">${loginMsg }</p>
        </div>
    </form>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js"></script>
<div id="responseText">${myJson}</div>
</body>

<script>
    $(function () {
        $("#loginBtn").click(function () {
            $.ajax({
                type: "POST",
                url: "/user/v1/login",
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