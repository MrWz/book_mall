<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书管理</title>
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
                图书商城后台管理
                <small>图书管理</small>
            </h1>
        </div>
        <p>
            <span><script>document.write(new Date());</script></span>
            <span class="pull-right">
                    <button class="btn btn-success" id="book_add_btn">新增图书</button>
                    <button class="btn btn-default" id="log_off_btn">退出管理</button>
                </span>
        </p>
        <table class="table table-hover">
            <thead>
            <tr>
                <%--<th><input type="checkbox"/></th>--%>
                <th>#</th>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <span id="page_info_area"></span>
    <div class="text-right" id="page_nav_area">
    </div>
</div>

<div id="bookModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">添加图书</h3>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <div class="form-group">
                        <label for="">书名</label>
                        <input class="form-control" id="" name="name" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">作者</label>
                        <input class="form-control" id="" name="author" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">价格</label>
                        <input class="form-control" id="" name="price" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">数量</label>
                        <input class="form-control" id="" name="stock" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">图书简介</label>
                        <textarea name="description" id="" class="form-control" required
                                  placeholder=""></textarea>
                    </div>
                    <div class="form-group">
                        <label for="">图书类别</label>
                        <select name="bookType" id="bookType" class="form-control" required>
                        </select>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" id="book_save_btn">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div id="bookUpdateModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">更新图书信息</h3>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <input type="hidden" name="uid" id="bookuid_input">
                    <div class="form-group">
                        <label for="">书名</label>
                        <input class="form-control" id="bookname_input" name="name" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">作者</label>
                        <input class="form-control" id="author_input" name="author" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">价格</label>
                        <input class="form-control" id="price_input" name="price" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">数量</label>
                        <input class="form-control" id="stock_input" name="stock" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">图书简介</label>
                        <textarea name="description" id="description_input" class="form-control" required
                                  placeholder=""></textarea>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" id="book_update_btn">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="panicModal" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">发布图书抢购</h3>
            </div>
            <div class="modal-body">
                <form class="form-group">
                    <input type="hidden" name="uid" id="panicuid_input">
                    <div class="form-group">
                        <label for="">抢购价格</label>
                        <input class="form-control" id="panicPrice_input" name="curPrice" required type="number"
                               placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">数量</label>
                        <input class="form-control" id="panicNums_input" name="nums" required type="number"
                               placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">开始时间</label>
                        <input type="datetime-local" name="startTime" id="panic_startTime_input" class="form-control"
                               required/>
                    </div>
                    <div class="form-group">
                        <label for="">开始时间</label>
                        <input type="datetime-local" name="endTime" id="panic_endTime_input" class="form-control"
                               required/>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" id="book_panic_btn">发布</button>
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
        if (sessionStorage.getItem("admin") == null) {
            location.href = "/admin/login";
            return;
        }
        //去首页
        to_page(1);

        $("#log_off_btn").click(function () {
            $.ajax({
                type: "DELETE",
                headers: {
                    AUTH: sessionStorage.getItem("axrf_")
                },
                url: "/admin/v1/login",
                data: null,
                error: function (request) {
                    alert("Connection error");
                },
                success: function (result) {

                    if (result.code == 200) {
                        alert(result.message);
                        sessionStorage.removeItem("admin");
                        sessionStorage.removeItem("axrf_");
                        location.href = "/admin/login";
                    } else {
                        alert(result.message);
                    }

                }
            });
        });
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

                //1、解析并显示书籍
                build_book_table(result);

                //2、显示分页信息
                build_page_info(result);

                //3、显示分页条信息
                build_page_nav(result);

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
            panicBtn.attr("panic-price", item.price);

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

    function build_page_info(result) {
        $("#page_info_area").empty();
        //当前<kbd>1</kbd>页，共<kbd>20</kbd>页，总共<kbd>100</kbd>条数据
        $("#page_info_area").append("当前<kbd>" +
            result.data.page.pageNum + "</kbd>页，共<kbd>" +
            result.data.page.pages + "</kbd>页，总共<kbd>" +
            result.data.page.total + "</kbd>条数据");

        totalRecord = result.data.page.total;
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

        getBookTags();

        $("#bookModal").modal("show");
    });
    function getBookTags() {
        $.ajax({
                type: "GET",
                headers: {
                    AUTH: sessionStorage.getItem("axrf_")
                },
                url: "/book/v1/booktag",
                data: null,
                error: function (request) {
                },
                success: function (result) {
                    if (result.code == 200) {
                        var booktags = result.data.booktags;
                        $("#bookType").empty();
                        $.each(booktags, function (index, item) {
                            $("#bookType").append("<option value='" + item.description + "'>" + item.description + "</option>");
                        })
                    } else {
                        alert("获取图书分类信息失败")
                    }
                }
            }
        )
        ;
    }
    $("#book_save_btn").click(function () {
        $.ajax({
            type: "POST",
            headers: {
                AUTH: sessionStorage.getItem("axrf_")
            },
            url: "/admin/v1/book/add",
            data: $("#bookModal form").serialize(),
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                alert(result.message);
                if (result.code == 200) {
                    $("#bookModal").modal("hide");
                    to_page(totalRecord);
                }
            }
        });
        return false;
    });

    $(document).on("click", ".edit_btn", function () {
//        alert($(this).attr("edit-id"));
        getBook($(this).attr("edit-id"));
        $("#bookUpdateModal").modal("show");

    });

    function getBook(bookuid) {
        $.ajax({
            type: "GET",
            headers: {
                AUTH: sessionStorage.getItem("axrf_")
            },
            url: "/book/v1/detail/" + bookuid,
            data: null,
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                var book = result.data.book;
                $("#bookuid_input").val(book.uid);
                $("#bookname_input").val(book.name);
                $("#author_input").val(book.author);
                $("#price_input").val(book.price);
                $("#stock_input").val(book.stock);
                $("#description_input").val(book.description);
            }
        });
    }
    $("#book_update_btn").click(function () {
        $.ajax({
            type: "PUT",
            headers: {
                AUTH: sessionStorage.getItem("axrf_")
            },
            url: "/admin/v1/book/adjust",
            data: $("#bookUpdateModal form").serialize(),
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                alert(result.message);
                $("#bookUpdateModal").modal("hide");
                to_page(currentPage);
            }
        });
        return false;
    });

    $(document).on("click", ".delete_btn", function () {
//        alert($(this).attr("delete-id"));
        if (confirm("确定删除 " + $(this).attr("bookname") + " 吗？")) {
            del_book($(this).attr("delete-id"))
        }

        return false;
    });
    function del_book(uids) {
        $.ajax({
            type: "DELETE",
            headers: {
                AUTH: sessionStorage.getItem("axrf_")
            },
            url: "/admin/v1/book/del/" + uids,
            data: null,
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                alert(result.message);
                to_page(currentPage);
            }
        });
    }

    $(document).on("click", ".panic_btn", function () {
        $("#panicModal").modal('show');
        $('#panicuid_input').val($(this).attr("panic-id"));
        $('#panicPrice_input').val($(this).attr("panic-price"));
        $('#panicNums_input').val(1);

        return;
    });

    $("#book_panic_btn").click(function () {
        $.ajax({
            type: "POST",
            headers: {
                AUTH: sessionStorage.getItem("axrf_")
            },
            url: "/admin/v1/book/panic",
            data: $("#panicModal form").serialize(),
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                if (result.code == 200) {
                    $("#panicModal").modal('hide');
                    alert(result.message);
                } else {
                    alert(result.message);
                }
            }
        });
        return false;
    });

</script>
</body>
</html>