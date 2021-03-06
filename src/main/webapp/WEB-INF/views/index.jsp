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
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">图书商城</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" id="bookCarbtn">
                        <span class="glyphicon glyphicon-shopping-cart "></span> 购物车
                        <span class="badge" id="shopcarSize">0</span>
                    </a>
                </li>
                <li class="" id="username">
                    <a href="#"></a>
                </li>
                <li class="unLogin">
                    <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="login">
                        <span class="glyphicon glyphicon-log-in"></span> 登录
                    </a>
                </li>
                <li class="unLogin">
                    <a href="#" data-toggle="modal" data-target="#registerModal" data-whatever="register">
                        <span class="glyphicon glyphicon-edit"></span> 注册
                    </a>
                </li>

                <li class="Logout">
                    <a href="#">
                        <span class="glyphicon glyphicon-log-out"></span> 退出
                    </a>
                </li>
            </ul>
            <form class="navbar-form navbar-right" id="searchForm">
                <div class="form-group input-group">
                    <input type="text" name="params" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button class="btn btn-default" id="searchBtn">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row clearfix">

        <div class="col-md-3 column">
            <div class="list-group" id="panic_list">
                <a class="list-group-item active">抢购活动</a>
                <!-- 此处放置抢购图书列表 -->
            </div>
        </div>

        <div class="col-md-6 column">

            <div class="row" id="bookList"></div>

            <div class="text-right" id="page_nav_area"></div>

        </div>

        <div class="col-md-3 column">
            <div class="list-group" id="hotBooks">
                <a class="list-group-item active">图书推荐</a>
                <!-- 此处放置推荐图书列表 -->
                <%--<div class="list-group-item">--%>
                <%--<span class="badge">14</span>--%>
                <%--<a href="/book/detail?bookid=04303d63f90344609977f92844ebdd09">Java编程思想</a>--%>
                <%--</div>--%>
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
                        <a href="/admin/login">后台管理</a>
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
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" name="password" type="password" required placeholder="至少6位字母或数字">
                        <span class="help-block text-warning"></span>
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
                        <label>用户名</label>
                        <input class="form-control" name="username" type="text" required placeholder="6-15位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input class="form-control" name="password" type="password" required placeholder="至少6位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label>再次输入密码</label>
                        <input class="form-control" name="rePassword" type="password" required placeholder="至少6位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label for="">验证码</label>--%>
                    <%--<div class="input-group">--%>
                    <%--<input class="form-control" name="yzm" type="text" required placeholder="">--%>
                    <%--<span class="input-group-btn">--%>
                    <%--<button><img--%>
                    <%--src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3958660674,2563683780&fm=117&gp=0.jpg"--%>
                    <%--alt="验证码"--%>
                    <%--height="26">--%>
                    <%--</button>--%>
                    <%--</span>--%>
                    <%--</div>--%>
                    <%--<span id="" class="help-block text-warning"></span>--%>
                    <%--</div>--%>
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
<script src="/static/min/user.js"></script>
<script src="/static/min/book.js"></script>
<script src="/static/min/index.js"></script>

</body>
</html>