
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>智能养猪管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
</head>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                智能猪舍管理系统<span> 登陆</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <!-- 			<i>Log In </i> or <span> Sign Up</span> -->
        </div>
        <div class="am-u-sm-10 login-am-center">
            <form action="login" method="post" class="am-form">
                <fieldset>
                    <div class="am-form-group">
                        <input type="text" class="" id="doc-ipt-email-1" placeholder="请输入工号" name="username">
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="" id="doc-ipt-pwd-1" placeholder="输入密码吧" name="password">
                    </div>
                    <p><button type="submit" class="am-btn am-btn-default">登录</button></p>
                    <p><button type="button" class="am-btn am-btn-default" onclick="window.location.href = 'searchPassword.html'">找回密码</button></p>

                </fieldset>
            </form>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>

</html>
