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
                    <button class="btn btn-primary" data-toggle="modal" data-target="#bookModal">新增</button>
                    <button class="btn btn-danger">下架</button>
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
                    价格
                </th>
                <th>
                    库存
                </th>
                <th>
                    操作
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input type="checkbox">
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
                    <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#bookModal">修改</button>
                    <button class="btn btn-danger btn-sm">下架</button>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox">
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
                    <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#bookModal">修改</button>
                    <button class="btn btn-danger btn-sm">下架</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <span>当前第<kbd>1</kbd>页，共<kbd>20</kbd>页，<kbd>100</kbd>条数据</span>
    <div class="text-right">
        <ul class="pagination">
            <li><a href="#">首页</a></li>
            <li><a href="#">&laquo;</a></li>
            <li class="active"><a>1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
            <li><a href="#">尾页</a></li>
        </ul>
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
                        <input class="form-control" name="bookname" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">作者</label>
                        <input class="form-control" name="author" required type="text" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">价格</label>
                        <input class="form-control" name="price" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">数量</label>
                        <input class="form-control" name="stock" required type="number" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="">图书简介</label>
                        <textarea name="description" class="form-control" required placeholder=""></textarea>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary">提交</button>
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

</script>

</body>
</html>