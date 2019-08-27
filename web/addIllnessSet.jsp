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
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/css/admin.css">
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
</head>

<body data-type="generalComponents">

<%@ include file="head.jsp" %>


<div class="tpl-page-container tpl-page-header-fixed">

    <%@include file="left.jsp"%>

    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            猪只安全管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">猪只管理</a></li>
            <li><a href="#">猪只安全管理</a></li>
            <li><a href="#">疾病管理</a></li>
            <li class="am-active">疾病判断参数设定表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span>疾病判断参数设定表
                </div>


            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="/addIllnessSet/PigService/insert/illSet.do" method="post">
                            <div class="am-form-group">
                                <label  class="am-u-sm-3 am-form-label">品种</label>
                                <div class="am-u-sm-9">
                                    <select name="pigVarietyId">
                                    <option name="1" value="1">白猪</option>
                                    <option name="2" value="2">黑猪</option>
                                    <option name="3" value="3">花猪</option>
                                </select>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">生长阶段</label>
                                <div class="am-u-sm-9">
                                    <select name="growthStage">
                                        <option name="1" value="1">哺乳阶段</option>
                                        <option name="2" value="2">保育阶段</option>
                                        <option name="3" value="3">生长育肥阶段</option>
                                    </select>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="pig-temperature" class="am-u-sm-3 am-form-label">猪只体温</label>
                                <div class="am-u-sm-9">
                                    <input type="tel" id="pig-temperature" name="temperature" placeholder="输入猪只最低和最高体温，例36，40 ">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="pig-foodIntake" class="am-u-sm-3 am-form-label">猪只进食量</label>
                                <div class="am-u-sm-9">
                                    <input type="tel" id="pig-foodIntake" name="foodIntake" placeholder="输入猪只最低进食量 ">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">确定添加</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>
    </div>
</div>

<script src="<%=basePath%>/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>

</html>
