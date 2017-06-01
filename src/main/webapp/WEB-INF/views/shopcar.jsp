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
                <button class="btn btn-warning" id="clearShopcar" disabled>清空购物车</button>
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
                    数量
                </th>
                <th>
                    操作
                </th>
            </tr>
            </thead>
            <tbody>
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
                <form class="form-group">

                    <input type="hidden" name="bookuid" id="bookuid_hidden">
                    <input type="hidden" name="nums" id="book_nums">

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

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/min/shopcar.js"></script>

</body>
</html>