<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CVTE图书商城</title>
    <link rel="icon" href="../imgs/favicon.ico" type="image/icon" />
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assert/css/mycss.css" />
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
                <img alt="欢迎来到CVTE图书商城" style="height: 50px; margin-top: -15px;"/>
            </a>

        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <div class="container">
                <ul class="nav navbar-nav navbar-right">
                    <li><p class="navbar-text">&nbsp;&nbsp;&nbsp;
                        <a href="/user/v1/login" class="navbar-link"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
                    </p></li>
                    <li><p class="navbar-text">&nbsp;&nbsp;&nbsp;
                        <a href="/user/v1/register" class="navbar-link"><span class="glyphicon glyphicon-log-in"></span> 现在注册</a>
                    </p></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<script type="text/javascript" src="../bootstrap3/js/jquery-1.11.2.min.js" ></script>
<script type="text/javascript" src="../bootstrap3/js/bootstrap.min.js" ></script>
</body>
</html>