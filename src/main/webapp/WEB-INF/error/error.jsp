<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019/8/21
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
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
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统"/>
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../assets/css/admin.css">
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script src="../../assets/js/echarts.min.js"></script>
</head>

<body data-type="index">

<!--引入头部导航栏-->
<%@ include file="../../head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">

    <%@ include file="../../left.jsp" %>
    <div class="tpl-content-wrapper">

        <div class="tpl-content-page-title">
            智能养猪管理系统 错误
        </div>
        <ol class="am-breadcrumb">
            <li>
                <a href="#" class="am-icon-home">错误页面</a>
            </li>
        </ol>
        <div class="tpl-portlet-components">
            ${result['error']}
        </div>
        

    </div>
</div>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>
