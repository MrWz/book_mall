<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>购物车</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        table td {
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="">
        <div class="page-header">
            <h1>
                <small>我的购物车</small>
            </h1>
        </div>
        <p>
            <span><script>document.write(new Date());</script></span>
            <span class="pull-right">
                <button class="btn btn-warning">清空购物车</button>
                    <a href="/" class="btn btn-default">返回首页</a>
                </span>
        </p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>
                    #
                </th>
                <th>
                    书名
                </th>
                <th>
                    作者
                </th>
                <th>
                    单价
                </th>
                <th>
                    购买数量
                </th>
                <th>
                    操作
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    1
                </td>
                <td>
                    Java编程思想
                </td>
                <td>
                    谁谁谁
                </td>
                <td>
                    108
                </td>
                <td>
                    3
                </td>
                <td>
                    <button class="btn btn-info btn-sm increase_btn">+</button>
                    <button class="btn btn-info btn-sm decrease_btn">-</button>
                    <button class="btn btn-success btn-sm buynow_btn" data-toggle="modal" data-target="#buyModal">立即购买
                    </button>
                    <button class="btn btn-danger btn-sm del_btn">删除</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="text-right" id="page_nav_area">
    </div>
</div>

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
                <h4 id="bookPrice">您需支付￥108</h4>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <div class="text-right">
                        <button class="btn btn-info">立即支付</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    var totalRecord;
    var currentPage;

    $(function () {

        if (sessionStorage.getItem("username") == null) {
            alert("您未登录");
            location.href = "/";
            return;
        }
        //去首页
        to_page(1);

    });

    function to_page(pn) {
        $.ajax({
            type: "POST",
            url: "/book/v1/list",
            data: "pn=" + pn,
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {

                if (result.code == 200) {
                    //1、解析并显示书籍
                    build_book_table(result);

                    //2、显示分页条信息
                    build_page_nav(result);
                } else {
                    alert(result.message);
                }
            }
        });
    }

    function build_book_table(result) {
        $("tbody").empty();
        var books = result.data.page.list;
        $.each(books, function (index, item) {
            var bookCk = $("<td></td>").append(item.id);//$("<input type='checkbox'>")
            var bookName = $("<td></td>").append(item.name);
            var bookAuthor = $("<td></td>").append(item.author);
            var bookPrice = $("<td></td>").append("￥" + item.price);
            var bookStock = $("<td></td>").append(item.stock);
            var editBtn = $("<button>编辑</button>").addClass("btn btn-info btn-sm edit_btn");
            editBtn.attr("edit-id", item.uid);
            var panicBtn = $("<button>发布抢购</button>").addClass("btn btn-primary btn-sm panic_btn");
            panicBtn.attr("panic-id", item.uid);

            var delBtn = $("<button>下架</button>").addClass("btn btn-danger btn-sm delete_btn");
            delBtn.attr("delete-id", item.uid).attr("bookname", item.name);
            var bookTd = $("<td></td>").append(panicBtn).append(" ").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(bookCk)
                .append(bookName)
                .append(bookAuthor)
                .append(bookPrice)
                .append(bookStock)
                .append(bookTd)
                .appendTo("tbody");
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

    $("#book_add_btn").click(function () {
        $("#bookModal form")[0].reset();
        $("#bookModal").modal("show");
    });
    $("#book_save_btn").click(function () {
        $.ajax({
            type: "POST",
            url: "/admin/v1/book/add",
            data: $("#bookModal form").serialize(),
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                alert(result.message);
                $("#bookModal").modal("hide");
                to_page(totalRecord);
            }
        });
        return false;
    });
</script>

</body>
</html>