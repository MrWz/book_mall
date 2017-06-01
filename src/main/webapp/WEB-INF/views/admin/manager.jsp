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
        <div class="btn-group">
            <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                销售统计 <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="/admin/book/sale">当日销售统计</a></li>
                <li><a href="/admin/book/saleAll">总销售统计</a></li>
            </ul>
        </div>
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
<script src="/static/min/admin.js"></script>

</body>
</html>