<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统" />
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../assets/css/admin.css">
    <link rel="stylesheet" href="../../assets/css/app.css">
</head>

<body data-type="generalComponents">

<%@ include file="../../head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">
    <%@ include file="../../left.jsp"%>

    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            智能养猪管理系统 表单
        </div>
        <ol class="am-breadcrumb">
            <li>
                <a href="#" class="am-icon-home">首页</a>
            </li>
            <li>
                <a href="#">表单</a>
            </li>
            <li class="am-active">智能养猪管理系统 表单</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 个人详细信息
                </div>


            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">

                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">
                                      员工编号：</label>
                                <!--<div class="am-u-sm-9">-->
                                <!-- <input type="text" id="user-name" placeholder="姓名 / Name">
                                    <small>输入你的名字，让我们记住你。</small> -->
                                <label  class="am-u-sm-3 am-form-label info">2017103</label>
                                <!--</div>-->
                            </div>

                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">真实姓名：</label>
                                <!--<div class="am-u-sm-9">-->
                                <!-- <input type="email" id="user-email" placeholder="输入你的电子邮件 / Email">
                                    <small>邮箱你懂得...</small> -->
                                <label  class="am-u-sm-3 am-form-label info">蓝点工作室</label>
                                <!--</div>-->
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">性别：</label>
                                <!-- <input type="tel" id="user-phone" placeholder="输入你的电话号码 / Telephone"> -->
                                <label class="am-u-sm-3 am-form-label info">男</label>
                            </div>

                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">年龄：</label>
                                <!-- <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入你的QQ号码"> -->
                                <label  class="am-u-sm-3 am-form-label info">21</label>
                            </div>
                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">入职时间：</label>

                                <label  class="am-u-sm-3 am-form-label info">2017-7</label>
                            </div>
                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">工龄：</label>

                                <label  class="am-u-sm-3 am-form-label info">2年</label>
                            </div>
                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">手机号：</label>
                                <!-- <input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter"> -->
                                <label  class="am-u-sm-3 am-form-label info">15179937160</label>
                            </div>

                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">邮箱：</label>
                                <!--  <textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
                                    <small>250字以内写出你的一生...</small> -->
                                <label  class="am-u-sm-3 am-form-label info">2671623283@qq.com</label>
                            </div>
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">职位；</label>

                                <label  class="am-u-sm-3 am-form-label info">仓库管理员</label>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">详细地址：</label>

                                <label  class="am-u-sm-3 am-form-label info">江西农业大学</label>
                            </div>
                            <!-- <div class="am-form-group">
                                <label for="user-intro" class="am-u-sm-3 am-form-label">密码：</label>

                                <label for="user-name" class="am-u-sm-3 am-form-label info">1234abcd</label>
                            </div> -->
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="button" class="am-btn am-btn-primary">修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>