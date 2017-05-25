<%@ page import="cvter.intern.model.User" %>
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
                    <a href="#">
                        <span class="glyphicon glyphicon-shopping-cart "></span> 购物车
                        <span class="badge">4</span>
                    </a>
                </li>
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <li class="unLogin">
                    <a href="#">
                        欢迎您 ${user.name}
                    </a>
                </li>
                <%
                } else {
                %>
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
                <%
                    }
                %>
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
            <div class="row" id="bookList"></div>

            <div class="text-right" id="page_nav_area"></div>

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
<script>
    $(function () {

        var totalRecord;
        var currentPage;

        $(function () {
            //去首页
            to_page(1);
        });

        function to_page(pn) {
            $.ajax({
                type: "POST",
                url: "/book/v1/list",
                data: "pn=" + pn + "&pageSize=" + 9,
                error: function (request) {
                    alert("Connection error");
                },
                success: function (result) {
                    //1、解析并显示书籍
                    build_book_table(result);

                    //2、显示分页条信息
                    build_page_nav(result);

                }
            });
        }

        function build_book_table(result) {
            $("#bookList").empty();
            var books = result.data.page.list;
            $.each(books, function (index, item) {
                var bookName = $("<h3></h3>").append(item.name);
                var bookDesc = $("<p></p>").append(item.description);
                var bookAuthor = $("<p></p>").append($("<span></span>").append(item.author));
                var detail = $("<a></a>").attr("href", "/book/detail?bookid=" + item.uid).append("查看详情");
                var bookPrice = $("<span></span>").addClass("pull-right").css({
                    "margin-right": "10px",
                    "color": "darkred"
                }).append("￥" + item.price);

                var rootDiv = $("<div></div>").addClass("col-md-4");
                var captionDiv = $("<div></div>").addClass("caption");
                var thumbnailDiv = $("<div></div>").addClass("thumbnail").append();
                thumbnailDiv.append(bookName)
                    .append(bookName)
                    .append(bookDesc)
                    .append(bookAuthor)
                    .append($("<p></p>").append(detail).append(bookPrice));
                captionDiv.append(thumbnailDiv);
                rootDiv.append(captionDiv).appendTo("#bookList");
            })
        }

        function build_page_nav(result) {
            $("#page_nav_area").empty();
            var ul = $("<ul></ul>").addClass("pagination");
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
            var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
            if (result.data.page.hasPreviousPage == false) {
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            } else {
                firstPageLi.click(function () {
                    to_page(1);
                });
                prePageLi.click(function () {
                    to_page(result.data.page.pageNum - 1);
                });
            }

            var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
            if (result.data.page.hasNextPage == false) {
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            } else {
                nextPageLi.click(function () {
                    to_page(result.data.page.pageNum + 1);
                });
                lastPageLi.click(function () {
                    to_page(result.data.page.pages);
                });
            }

            ul.append(firstPageLi).append(prePageLi);
            $.each(result.data.page.navigatepageNums, function (index, item) {
                var numLi = $("<li></li>").append($("<a></a>").append(item));
                if (result.data.page.pageNum == item) {
                    currentPage = item;
                    numLi.addClass("active");
                }
                numLi.click(function () {
                    to_page(item);
                });
                ul.append(numLi);
            });
            ul.append(nextPageLi).append(lastPageLi).appendTo($("#page_nav_area"));
        }

        $('#userLoginBtn').click(function () {
            $.ajax({
                type: "POST",
                url: "/user/v1/login",
                data: $('#loginModal form').serialize(),// 你的formid
                error: function (request) {
                    alert("Connection error");
                },
                success: function (data) {
                    var code = data.code;
                    switch (code) {
                        case (200):
                            alert("欢迎回来");
                            $('#loginModal').modal('hide');
                            window.location.reload(true);
                            break;
                        case (500):
                            alert(data.message);
                            break;
                    }

                }
            });
            return false;
        });

        $('#userRegisterBtn').click(function () {
            $.ajax({
                type: "POST",
                url: "/user/v1/register",
                data: $('#registerModal form').serialize(),// 你的formid
                error: function (request) {
                    alert("Connection error");
                },
                success: function (data) {
                    var code = data.code;
                    switch (code) {
                        case (200):
                            alert("注册成功");
                            $('#loginModal').modal('hide');
                            window.location.reload(true);
                            break;
                        case (500):
                            alert(data.message);
                            break;
                    }
                }
            });
            return false;
        });

        $('.Logout').click(function () {
            $.ajax({
                type: "POST",
                url: "/user/v1/logoff",
                data: null,// 你的formid
                error: function (request) {
                    alert("请先登录");
                },
                success: function (data) {
                    var code = data.code;
                    switch (code) {
                        case (200):
                            alert("OK");
                            window.location.reload(true);
                            break;
                        case (500):
                            alert(data.message);
                            break;
                    }
                }
            });
            return false;
        });

        $("#searchBtn").click(function () {
            location.href = "/book/search?" + encodeURI($("#searchForm").serialize());

            return false;
        });

    });
</script>

</body>
</html>