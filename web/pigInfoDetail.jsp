<%--
  Created by IntelliJ IDEA.
  User: xxbb
  Date: 2019/10/20
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>智能养猪管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/admin.css">
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
</head>

<body data-type="generalComponents">

<%@ include file="head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">

    <%@include file="left.jsp" %>

    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            智能养猪管理系统 文字列表
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">智能养猪管理系统</a></li>
            <li class="am-active">文字列表</li>
        </ol>
    </div>
    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold"> <span class="am-icon-code"></span> 猪只详细信息 </div>

        </div>
        <div class="tpl-block ">
            <div class="am-g tpl-amazeui-form">
                <div class="am-u-sm-12 am-u-md-9">
                    <form class="am-form am-form-horizontal">
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-name" class="am-u-sm-3 am-form-label">猪耳号</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="1901100000">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-name" class="am-u-sm-3 am-form-label">品种</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="浙江金华猪">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">类型</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="育肥猪">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">性别</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="公">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">日龄</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="60">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">生长阶段</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="保育期">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">出生日期</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="2010-9-21">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">当前体重</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="100">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">接种疫苗次数</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="1">
                            </div>
                        </div>
                        <%--<div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">具体接种疫苗</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="猪瘟疫苗、冻干苗">
                            </div>
                        </div>--%>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">所在猪舍</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="10">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">所在猪栏</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="2">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">入栏体重</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="10">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">入栏日期</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email" disabled="disabled" placeholder="2015-06-07">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">出栏日期</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email1" disabled="disabled" placeholder="2020-6-13">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">状态</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="email" id="user-email2" disabled="disabled" placeholder="出栏">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">转栏记录</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <button type="button" class="am-btn am-btn-primary" style="margin-left:25%" onclick="window.location.href = 'TurnBarList.html'">点击查看</button>
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="user-email" class="am-u-sm-3 am-form-label">接种记录</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <button type="button" class="am-btn am-btn-primary" style="margin-left:25%" onclick="window.location.href = 'TurnBarList.html'">点击查看</button>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <a href="javascript:history.back(-1)"><button type="button" class="am-btn am-btn-primary" style="margin-left:25%">返回</button></a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="<%=basePath%>/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>

</html>
