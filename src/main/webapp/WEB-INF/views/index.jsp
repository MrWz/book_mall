<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书商城</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .footer {
            border-top: 1px solid #e5e5e5;
            color: #777;
            padding: 19px 0;
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">图书商城</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-shopping-cart "></span> 购物车
                        <span class="badge">4</span>
                    </a>
                </li>
                <li>
                    <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="login">
                        <span class="glyphicon glyphicon-log-in"></span> 登录
                    </a>
                </li>
                <li>
                    <a href="#" data-toggle="modal" data-target="#registerModal" data-whatever="register">
                        <span class="glyphicon glyphicon-edit"></span> 注册
                    </a>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
    <div class="row clearfix">

        <div class="col-md-3 column">
            <div class="list-group">
                <a class="list-group-item active">抢购活动</a>
                <div class="list-group-item">
                    <h3>Java编程思想</h3>
                    <p>14:30准时开始</p>
                </div>
                <div class="list-group-item">
                    <h3>Java编程思想</h3>
                    <p>14:30准时开始</p>
                </div>
            </div>
        </div>

        <div class="col-md-6 column">
            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <!--<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/people/default.jpg"/>-->
                        <div class="caption">
                            <h3>
                                Java编程思想
                            </h3>
                            <p>
                                《Java编程思想》是2007年由机械工业出版社出版的图书，该书作者是埃克尔，译者是陈昊鹏。
                            </p>
                            <p>
                                <span>作者：<a href="#">陈昊鹏</a></span>
                            </p>
                            <p>
                                <a href="/bookDetails">查看详情</a>
                                <span class="pull-right" style="margin-right: 10px; color: darkred">￥108</span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <!--<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/people/default.jpg"/>-->
                        <div class="caption">
                            <h3>
                                Java编程思想
                            </h3>
                            <p>
                                《Java编程思想》是2007年由机械工业出版社出版的图书，该书作者是埃克尔，译者是陈昊鹏。
                            </p>
                            <p>
                                <span>作者：<a href="#">陈昊鹏</a></span>
                            </p>
                            <p>
                                <a href="#">查看详情</a>
                                <span class="pull-right" style="margin-right: 10px; color: darkred">￥108</span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <!--<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/people/default.jpg"/>-->
                        <div class="caption">
                            <h3>
                                Java编程思想
                            </h3>
                            <p>
                                《Java编程思想》是2007年由机械工业出版社出版的图书，该书作者是埃克尔，译者是陈昊鹏。
                            </p>
                            <p>
                                <span>作者：<a href="#">陈昊鹏</a></span>
                            </p>
                            <p>
                                <a href="#">查看详情</a>
                                <span class="pull-right" style="margin-right: 10px; color: darkred">￥108</span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <!--<img alt="300x200" src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/people/default.jpg"/>-->
                        <div class="caption">
                            <h3>
                                Java编程思想
                            </h3>
                            <p>
                                《Java编程思想》是2007年由机械工业出版社出版的图书，该书作者是埃克尔，译者是陈昊鹏。
                            </p>
                            <p>
                                <span>作者：<a href="#">陈昊鹏</a></span>
                            </p>
                            <p>
                                <a href="#">查看详情</a>
                                <span class="pull-right" style="margin-right: 10px; color: darkred">￥108</span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="text-center">
                <ul class="pagination">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                    <li><a href="#">尾页</a></li>
                </ul>
            </div>

        </div>

        <div class="col-md-3 column">
            <div class="list-group">
                <a class="list-group-item active">图书推荐</a>
                <div class="list-group-item">
                    <span class="badge">14</span>
                    <a href="#">Java编程思想</a>
                </div>
                <div class="list-group-item">
                    <a href="#">Java程序员面试宝典</a>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="footer ">
    <div class="container">
        <div class="row footer-top text-center">
            <div class="col-xs-4 col-md-2 col-md-offset-2">
                <h4>关于</h4>
                <ul class="list-unstyled">
                    <li>
                        <a href="">关于我们</a>
                    </li>
                    <li style="margin-top: 10px;">
                        <a href="/admin/v1/login">后台管理</a>
                    </li>
                </ul>
            </div>
            <div class="col-xs-4 col-md-2 col-md-offset-1">
                <h4>联系方式</h4>
                <ul class="list-unstyled">
                    <li>
                        <a target="_blank" href="#">新浪微博</a>
                    </li>
                    <li style="margin-top: 10px;">
                        <a href="">电子邮件</a>
                    </li>
                </ul>
            </div>

            <div class="col-xs-4 col-md-2  col-md-offset-1">
                <h4>联系方式</h4>
                <ul class="list-unstyled">
                    <li>
                        <a target="_blank" href="#">新浪微博</a>
                    </li>
                    <li style="margin-top: 10px;">
                        <a href="">电子邮件</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

<div id="loginModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">用户登录</h3>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" name="username" type="text" required placeholder="6-15位字母或数字">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" name="password" type="password" required placeholder="至少6位字母或数字">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <!--<div class="form-group">
                        <label for="">验证码</label>
                        <div class="input-group">
                            <input class="form-control" name="yzm" type="text" placeholder="">
                            <span class="input-group-btn">
                                <button><img
                                        src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3958660674,2563683780&fm=117&gp=0.jpg"
                                        alt="验证码"
                                        height="26">
                                </button>
                            </span>
                        </div>
                        <span id="" class="help-block text-warning"></span>
                    </div>-->
                    <div class="text-right">
                        <button class="btn btn-primary" id="userLoginBtn">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#registerModal">还没有账号？点我注册</a>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="registerModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">用户注册</h3>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" name="username" type="text" required placeholder="6-15位字母或数字">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" name="password" type="password" required placeholder="至少6位字母或数字">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">再次输入密码</label>
                        <input class="form-control" name="rePassword" type="password" required placeholder="至少6位字母或数字">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">验证码</label>
                        <div class="input-group">
                            <input class="form-control" name="yzm" type="text" required placeholder="">
                            <span class="input-group-btn">
                                <button><img
                                        src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3958660674,2563683780&fm=117&gp=0.jpg"
                                        alt="验证码"
                                        height="26">
                                </button>
                            </span>
                        </div>
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" id="userRegisterBtn">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                    <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#loginModal">已有账号？点我登录</a>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('#userLoginBtn').click(function () {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/user/v1/login",
                data: $('#loginModal form').serialize(),// 你的formid
                error: function (request) {
                    alert("Connection error");
                },
                success: function (data) {
//                $("#commonLayout_appcreshi").parent().html(data);
                    alert(data.code + "---" + data.message + "---" +data.data.description);

                }
            });
            return false;
        });
    });
</script>

<script>
    $(function () {
        $('#userRegisterBtn').click(function () {
            $.ajax({
                type: "POST",
                url: "/user/v1/register",
                data: $('#registerModal form').serialize(),// 你的formid
                error: function (request) {
                    alert("Connection error");
                },
                success: function (data) {
//                $("#commonLayout_appcreshi").parent().html(data);
                    alert(data.code + "---" + data.message + "---" +data.data.description);
                }
            });
            return false;
        });
    });
</script>

</body>
</html>