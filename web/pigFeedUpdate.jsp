<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/10
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.bd.pigmanage.Po.PigFeed" %>
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

    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            猪场功能列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="index.html" class="nav-link">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>用户管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="yonghu-table-power.html">
                                <i class="am-icon-angle-right"></i>
                                <span>权限管理</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                        </li>
                        <li>
                            <a href="UserInfo.html">
                                <i class="am-icon-angle-right"></i>
                                <span>用户信息</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                        </li>
                    </ul>


                </li>


                <li class="tpl-left-nav-item">
                    <!-- 打开状态 a 标签添加 active 即可   -->
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-wpforms"></i>
                        <span>猪只管理</span>
                        <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <!-- 打开状态 添加 display:block-->
                    <ul class="tpl-left-nav-sub-menu "  style="display: block">
                        <li>
                            <a href="javascript:" class="tpl-left-nav-link-list4 active">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico4"></i>
                                <span>猪只信息管理</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <ul class="tpl-left-nav-sub-menu4">
                                <li>
                                    <a href="/pigInfoList/PigService/select/pigInfo.do" class="tpl-left-nav-link-list"
                                       style="padding-left: 55px;">
                                        <span>猪只信息</span>
                                    </a>

                                    <a href="/pigVarietyList/PigService/select/pigVariety.do"
                                       class="tpl-left-nav-link-list1"
                                       style="padding-left: 55px;">
                                        <span>猪只品种</span>
                                    </a>

                                </li>
                            </ul>

                            <a href="javascript:" class="tpl-left-nav-link-list5" style="display: block;">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico5"></i>
                                <span>饲喂生长管理</span>
                            </a>
                            <ul class="tpl-left-nav-sub-menu5" style="display: block;">
                                <li>
                                    <a href="/feedStandardList/PigService/select/feedStandard.do" class="tpl-left-nav-link-list"
                                       style="padding-left: 55px;">
                                        <span>饲喂设定</span>
                                    </a>


                                    <a href="/pigFeedList/PigService/select/pigFeed.do" class="tpl-left-nav-link-list1"
                                       style="padding-left: 55px;">
                                        <span>猪只饲喂生长统计</span>
                                    </a>

                                    <a href="zhuzhi-table-badGrowth.html" class="tpl-left-nav-link-list1"
                                       style="padding-left: 55px;">
                                        <span>生长状况不良猪只统计</span>
                                    </a>
                                </li>
                            </ul>
                            <a href="javascript:;" class="tpl-left-nav-link-list6">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico6"></i>
                                <span>猪只安全管理</span>
                            </a>
                            <ul class="tpl-left-nav-sub-menu6" style="">
                                <li>
                                    <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                                        <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>
                                        <span>疫苗接种管理</span>
                                    </a>
                                    <ul class="tpl-left-nav-sub-menu" style="">
                                        <li>
                                            <a href="CanVaccinateList.html" class="" style="padding-left: 80px;">
                                                <span>需接种猪只信息表</span>
                                            </a>
                                            <a href="VaccinateSetList.html" class="" style="padding-left: 80px;">
                                                <span>疫苗接种设定表</span>
                                            </a>
                                            <a href="/VaccinateList/PigService/select/vaccinateList.do" class=""
                                               style="padding-left: 80px;">
                                                <span>疫苗接种记录表</span>
                                            </a>
                                        </li>
                                    </ul>


                                    <a href="javascript:;" class="tpl-left-nav-link-list1 active"
                                       style="padding-left: 55px;">
                                        <i class="am-icon-angle-right tpl-left-nav-more-ico1 "></i>
                                        <span>疾病管理</span>
                                    </a>
                                    <ul class="tpl-left-nav-sub-menu1" style="">
                                        <li>
                                            <a href="#" class="" style="padding-left: 80px;">
                                                <span>疑似生病猪只表</span>
                                            </a>
                                            <a href="/IllnessSetList/PigService/select/illSetList.do" class=" active"
                                               style="padding-left: 80px;">
                                                <span>疾病判断参数设定表</span>
                                            </a>
                                            <a href="/IllnessList/PigService/select/illnessList.do" class=""
                                               style="padding-left: 80px;">
                                                <span>病情记录表</span>
                                            </a>
                                        </li>
                                    </ul>

                                    <a href="Eliminate.html" class="tpl-left-nav-link-list2"
                                       style="padding-left: 72px;">
                                        <span>淘汰管理</span>
                                    </a>

                                </li>
                            </ul>

                            <!--<a href="javascript:;" class="tpl-left-nav-link-list7">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico7"></i>
                                <span>移栏管理</span>
                            </a>-->
                            <!--<ul class="tpl-left-nav-sub-menu7" style="">-->

                            <!--</ul>-->

                            <a href="javascript:;" class="tpl-left-nav-link-list8">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico8"></i>
                                <span>猪舍管理</span>
                            </a>
                            <ul class="tpl-left-nav-sub-menu8" style="">
                                <li>
                                    <a href="zhushe-chart.html" class="tpl-left-nav-link-list"
                                       style="padding-left: 55px;">
                                        <span>猪舍环境信息</span>
                                    </a>


                                    <a href="zhushe-house-info.html" class="tpl-left-nav-link-list"
                                       style="padding-left: 55px;">
                                        <span>猪舍基本信息</span>
                                    </a>

                                    <a href="zhushe-minhouse-info.html" class="tpl-left-nav-link-list"
                                       style="padding-left: 55px;">
                                        <span>猪栏信息</span>
                                    </a>
                                <li>
                                    <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                                        <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>
                                        <span>转栏管理</span>
                                    </a>
                                    <ul class="tpl-left-nav-sub-menu" style="">
                                        <li>
                                            <a href="CanTurnBarList.html" class="" style="padding-left: 80px;">
                                                <span>可转栏猪只信息表</span>
                                            </a>
                                            <a href="TurnBarSetList.html" class="" style="padding-left: 80px;">
                                                <span>转栏参数设定表</span>
                                            </a>
                                            <a href="TurnBarList.html" class="" style="padding-left: 80px;">
                                                <span>转栏记录表</span>
                                            </a>
                                        </li>
                                    </ul>


                                    <a href="javascript:;" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                                        <i class="am-icon-angle-right tpl-left-nav-more-ico1 "></i>
                                        <span>出栏管理</span>
                                    </a>
                                    <ul class="tpl-left-nav-sub-menu1" style="">
                                        <li>
                                            <a href="CanOutBarList.html" class="" style="padding-left: 80px;">
                                                <span>可出栏猪只信息表</span>
                                            </a>
                                            <a href="OutBarSetList.html" class="" style="padding-left: 80px;">
                                                <span>出栏参数设定表</span>
                                            </a>
                                            <a href="OutBarList.html" class="" style="padding-left: 80px;">
                                                <span>出栏记录表</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>仓库管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
                        <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->

                        <li>
                            <a href="cangku-form-storeinformation.html">
                                <span>仓库信息管理</span>
                            </a>

                            <a href="cangku-form-loginout.html">
                                <span>出入库记录</span>
                            </a>


                        </li>
                    </ul>
                </li>


                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>设备管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
                        <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->

                        <li>
                            <a href="e-control.html">
                                <span>设备控制表</span>
                            </a>
                            <a href="shebei-table-eList.html">
                                <span>设备信息管理</span>
                            </a>

                            <a href="e-unit_exception.html">
                                <span>设备异常信息</span>
                            </a>

                        </li>
                    </ul>
                </li>


                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-file-o"></i>
                        <span>日志管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>

                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
                        <a href="login-info.html">
                            <span>用户登陆记录</span>
                        </a>

                        <a href="operate-info.html">
                            <span>用户操作记录</span>
                        </a>

                        <a href="sys-log.html">
                            <span>系统异常记录</span>
                        </a>
                    </ul>
                </li>


            </ul>
        </div>
    </div>

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
            <div class="caption font-green bold"><span class="am-icon-code"></span> 猪只详细信息</div>

        </div>
        <%
            Map jspMap = (Map) request.getAttribute("reqMap");
            List pigFeeds = (List) jspMap.get("PigFeed");
            PigFeed pigFeed= ( PigFeed) pigFeeds.get(0);
            request.setAttribute("pf", pigFeed);
        %>
        <div class="tpl-block ">
            <div class="am-g tpl-amazeui-form">
                <div class="am-u-sm-12 am-u-md-9">
                    <form class="am-form am-form-horizontal" action="/pigFeedList/PigService/update/pigFeed.do"
                          id="pigFeedList" onsubmit="selectPigFeedList()"
                          method="post">
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="id" class="am-u-sm-3 am-form-label">记录编号</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="id" placeholder="0" name="id"
                                       value="${pf.id}" readonly>
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="pigNo" class="am-u-sm-3 am-form-label">猪只编号</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="pigNo" placeholder=""
                                       name="pigNo" value="${pf.pigNo}">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="feedTake" class="am-u-sm-3 am-form-label">进食量</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="feedTake" placeholder=""
                                       name="feedTake" value="${pf.feedTake}">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="avgWeight" class="am-u-sm-3 am-form-label">日增重量</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="avgWeight" placeholder=""
                                       name="avgWeight" value="${pf.avgWeight}">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="pigRecentWeight" class="am-u-sm-3 am-form-label">当前体重</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="pigRecentWeight" placeholder=""
                                       name="pigRecentWeight" value="${pf.pigRecentWeight}">
                            </div>
                        </div>
                        <div class="am-form-group" style="width: 50%;float: left">
                            <label for="pigVariety" class="am-u-sm-3 am-form-label">记录时间</label>
                            <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                <input type="text" id="pigVariety" placeholder=""
                                       name="pigNo" value="${pf.recordTime}" readonly>
                            </div>
                        </div>


                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3" style="float: left">

                                <input type="hidden" name="where" value="id"/>
                                <button type="submit" class="am-btn am-btn-primary" style="margin-left:10%">确认修改
                                </button>

                                <button type="button" class="am-btn am-btn-primary" style="margin-left:10%" onclick="history.back()">返回
                                </button>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="<%=basePath%>/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>/assets/js/jquery-1.9.1.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
<script src="<%=basePath%>/assets/js/common.js"></script>
</body>

</html>
