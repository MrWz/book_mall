<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书详情</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

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
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <div class="">
        <input type="hidden" id="book_uid">
        <p>
            <span class="pull-right">
                <!--onclick="$('#loginBtn').click();"-->
                    <button class="btn btn-primary" data-toggle="modal" data-target="#buyModal">立即购买</button>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#shopCarModal">加入购物车</button>
                </span>
        </p>
        <h3 id="book_name"></h3>
        <br>
        <dl>
            <dt>价格</dt>
            <dd id="book_price"></dd>
            <br>
            <dt>作者</dt>
            <dd id="book_author"></dd>
            <br>
            <dt>
                图书简介
            </dt>
            <dd id="book_desc"></dd>
        </dl>
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
                        <label>用户名</label>
                        <input class="form-control" name="username" type="text" required placeholder="6-15位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label>密码</label>
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
                        <label for="">用户名</label>
                        <input class="form-control" name="username" type="text" required placeholder="6-15位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" name="password" type="password" required placeholder="至少6位字母或数字">
                        <span class="help-block text-warning"></span>
                    </div>
                    <div class="form-group">
                        <label for="">再次输入密码</label>
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

<div id="buyModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">购买支付</h3>
            </div>

            <div class="modal-body">
                <form class="form-group">

                    <input type="hidden" name="bookuid" id="bookuid_buy">

                    <div class="form-group">
                        <label for="">购买数量</label>
                        <input class="form-control" name="nums" value="1" type="number" id="book_buy_num">
                        <span id="" class="help-block text-warning"></span>
                    </div>
                    <div class="modal-body">
                        <h4 id="bookPrice_buy">您需支付￥108</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-group">
                            <div class="text-right">
                                <button class="btn btn-info" id="buyBtn">立即支付</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div id="shopCarModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">加入购物车</h3>
            </div>

            <div class="modal-body">
                <form class="form-group">

                    <input type="hidden" name="bookuid" id="bookuid_add">

                    <div class="form-group">
                        <label for="">添加数量</label>
                        <input class="form-control" name="nums" type="number" value="1" required
                               placeholder="6-15位字母或数字">
                    </div>
                    <div class="modal-body">
                        <form class="form-group">
                            <div class="text-right">
                                <button class="btn btn-info" id="addBtn">添加</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/min/user.js"></script>
<script src="/static/min/book.js"></script>
<script src="/static/min/detail.js"></script>

</body>
</html>