<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书抢购</title>
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
                <small>图书抢购</small>
            </h1>
        </div>
        <p>
            <span id="countTime">倒计时长：<kbd>0天0小时0分0秒</kbd></span>
            <br>
            <span id="startTime">开始时间：<kbd>2017-5-26 17:20</kbd></span>
            <span class="pull-right">
                    <button class="btn btn-success" disabled id="panicBtn">立即抢购</button>
                    <a href="/" class="btn btn-default">返回首页</a>
                </span>
        </p>

        <br>
        <br>
        <dl>
            <dt>书名</dt>
            <dd id="book_name" class="h3"></dd>
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

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/user.js"></script>
<script src="/static/book.js"></script>
<script>

    var interval;
    $(function () {

        if (getQueryString("bookid") == null) {
            location.href = "/";
            return;
        }

        getBook(getQueryString("bookid"));

        var startTime = new Date();
        interval = window.setInterval(function () {
            ShowCountDown(startTime.getFullYear(), startTime.getMonth() + 1, startTime.getDate(), startTime.getHours(), startTime.getMinutes() + 1, 'countTime');
        }, interval);
        $("#startTime").html("开始时间：<kbd>" + startTime + "</kbd>");

        $("#panicBtn").click(function () {
            $.ajax({
                type: "POST",
                headers: {
                    AUTH: localStorage.getItem("xrf_")
                },
                url: "/book/v1/panic",
                data: "bookuid=" + getQueryString("bookid") + "&nums=1",// 你的formid
                error: function (request) {
                    alert("请您先去登录");
                },
                success: function (data) {
                    if (data.code == 200) {
                        $("#panicBtn").attr("disabled", "disabled").text("抢购成功");
                        alert("抢购成功");
                    } else
                        alert(data.message);
                }
            });
        });
    });

    function ShowCountDown(year, month, day, min, sec, divname) {
        var now = new Date();
        var endDate = new Date(year, month - 1, day, min, sec);
        var leftTime = endDate.getTime() - now.getTime();
        var leftSecond = parseInt(leftTime / 1000);
        var day1 = Math.floor(leftSecond / (60 * 60 * 24));
        var hour = Math.floor((leftSecond - day1 * 24 * 60 * 60) / 3600);
        var minute = Math.floor((leftSecond - day1 * 24 * 60 * 60 - hour * 3600) / 60);
        var second = Math.floor(leftSecond - day1 * 24 * 60 * 60 - hour * 3600 - minute * 60);
        var cc = document.getElementById(divname);
        cc.innerHTML = "倒计时长：<kbd>" + day1 + "天" + hour + "小时" + minute + "分" + second + "秒</kbd>";
        if (day1 <= 0 && hour <= 0 && minute <= 0 && second <= 0) {
            window.clearInterval(interval);
            $("#panicBtn").removeAttr("disabled");
        }
    }

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    function getBook(bookuid) {
        $.ajax({
            type: "GET",
            url: "/book/v1/detail/" + bookuid,
            data: null,
            error: function (request) {
                alert("Connection error");
            },
            success: function (result) {
                var book = result.data.book;
                $("#book_uid").val(book.uid);
                $("#book_name").text(book.name);
                $("#book_author").text(book.author);
                $("#book_price").text(book.price);
                $("#book_desc").text(book.description);
                bookPrice = book.price;
            }
        });
    }
</script>

</body>
</html>