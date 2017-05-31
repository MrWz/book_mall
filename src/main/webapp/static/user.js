$('#userLoginBtn').click(function () {
    $.ajax({
        type: "POST",
        url: "/user/v1/login",
        data: $('#loginModal form').serialize(),// 你的formid
        error: function (request) {
            alert("Connection error");
        },
        success: function (data, status, xhr) {
            var code = data.code;
            switch (code) {
                case (200):

//                            alert("欢迎回来");
                    localStorage.setItem("xrf_", xhr.getResponseHeader("AUTH"));
                    localStorage.setItem("username", xhr.getResponseHeader("username"));
                    $('#loginModal').modal('hide');
                    setStatus();
                    break;
                default:
                    alert(data.message);
                    break;
            }

        }
    });
    return false;
});

$('#userRegisterBtn').click(function () {
    $.ajax({
        type: "PUT",
        url: "/user/v1/login",
        data: $('#registerModal form').serialize(),// 你的formid
        error: function (request) {
            alert("Connection error");
        },
        success: function (data, status, xhr) {
            var code = data.code;
            switch (code) {
                case (200):
                    alert("注册成功");
                    localStorage.setItem("xrf_", xhr.getResponseHeader("AUTH"));
                    localStorage.setItem("username", xhr.getResponseHeader("username"));
                    $('#registerModal').modal('hide');
                    setStatus();
                    break;
                default:
                    alert(data.message);
                    break;
            }
        }
    });
    return false;
});

$('.Logout').click(function () {
    $.ajax({
        type: "DELETE",
        headers: {
            AUTH: localStorage.getItem("xrf_")
        },
        url: "/user/v1/login",
        data: null,// 你的formid
        error: function (request) {
            alert("请先登录");
        },
        success: function (data) {
            var code = data.code;
            switch (code) {
                case (200):
                    // alert("OK");
                    localStorage.removeItem("username");
                    localStorage.removeItem("AUTH");
                    setStatus();
                    break;
                case (500):
                    alert(data.message);
                    break;
            }
        }
    });
    return false;
});

function setStatus() {
    if (localStorage.getItem("username") == null) {
        $(".unLogin").show();
        $(".Logout").hide();
        $("#username").hide();
    } else {
        $(".unLogin").hide();
        $(".Logout").show();
        $("#username").show();
        $("#username a").text("欢迎您，" + localStorage.getItem("username"));
    }
}

$("#bookCarbtn").click(function () {
    if (localStorage.getItem("username") == null) {
        alert("请先登录");
        return false;
    } else {
        location.href = "/book/shopcar";
    }
});