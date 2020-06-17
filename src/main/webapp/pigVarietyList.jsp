<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.bluedot.pig.pojo.PigVariety" %><%--
  Created by IntelliJ IDEA.
  User: xxbb
  Date: 2019/09/12
  Time: 14:24
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
                    <ul class="tpl-left-nav-sub-menu display:block" style="display: block;">
                        <li>
                            <a href="javascript:;" class="tpl-left-nav-link-list4 active">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico4"></i>
                                <span>猪只信息管理</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <ul class="tpl-left-nav-sub-menu4" style="display:block">
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

                            <a href="javascript:;" class="tpl-left-nav-link-list5">
                                <i class="am-icon-angle-right tpl-left-nav-more-ico5"></i>
                                <span>饲喂生长管理</span>
                            </a>
                            <ul class="tpl-left-nav-sub-menu5">
                                <li>
                                    <a href="/feedStandardList/PigService/select/feedStandard.do" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                                        <span>饲喂设定</span>
                                    </a>



                                    <a href="/pigFeedList/PigService/select/pigFeed.do" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                                        <span>猪只饲喂生长统计</span>
                                    </a>

                                    <a href="zhuzhi-table-badGrowth.html" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
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
            猪只管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">猪只管理</a></li>
            <li><a href="#">猪只管理信息</a></li>
            <li class="am-active">猪只信息</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 猪只品种
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success" value="pigVariety"
                                        onclick="insertForPig(this)"><span
                                        class="am-icon-plus"></span> 添加
                                </button>
                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                        class="am-icon-save"></span> 保存
                                </button>
                                <!--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 特殊标记</button>-->
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span
                                        class="am-icon-trash-o"></span> 删除
                                </button>
                            </div>
                        </div>
                    </div>


                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <select id="search-criteria">
                                <option value="pigVarietyId">品种编号</option>
                                <option value="pigVariety">品种名称</option>

                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field" id="search-content">
                            <span class="am-input-group-btn">
                                <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                        type="button" value="pigVariety" onclick="search(this)"></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                    <th class="table-id">品种编号</th>
                                    <th class="table-title">品种名称</th>
                                    <th>操作</th>


                                </tr>
                                </thead>
                                <!--     读取数据          -->
                                <%
                                    Map<String, List<Object>> jspMap = (Map) request.getAttribute("reqMap");
                                    List varietys = (List) jspMap.get("PigVariety");
                                    request.setAttribute("variety", varietys);
                                %>

                                <%--    分页        --%>
                                <%
                                    //只需要修改这两个参数
                                    int pageButtonNum = 5;//显示页数下标按钮的个数
                                    int pageSize = 100;//页面显示数据的条数，实际显示数量为pageSize+1，表示的应该是数据下标的位移量，由于下标是从0开始
                                    //

                                    int dataBegin = 0;//页面第一条数据的位置
                                    int dataEnd = 0;//页面最后一条数据的位置
                                    int pageTotal = 0;//总页数
                                    int pageButtonBegin = 1;//显示页数按钮的第一个按钮的数字
                                    int pageButtonAddNum = 0;//用于追加显示页面下标，每次点击按钮<<或>>都会使得相应的使页面按钮变化，如从6~10按<<变成1~5，按>>变成11~15


                                    //通过请求往map中传一下三个值以实现页面分页参数的更改
                                    if (jspMap.containsKey("dataBegin")) {
                                        dataBegin = Integer.valueOf(jspMap.get("dataBegin").get(0).toString());
                                        System.out.println("dataBegin: " + dataBegin);
                                    }
                                    if (jspMap.containsKey("pageButtonAddNum")) {
                                        pageButtonAddNum = Integer.valueOf(jspMap.get("pageButtonAddNum").get(0).toString());
                                        System.out.println("pageButtonAddNum: " + pageButtonAddNum);
                                    }
                                    if (jspMap.containsKey("pageButtonBegin")) {
                                        pageButtonBegin = Integer.valueOf(jspMap.get("pageButtonBegin").get(0).toString());
                                        System.out.println("pageButtonBegin: " + pageButtonBegin);
                                    }

                                    dataEnd = dataBegin + pageSize;//一页中最后一条数据的下标
                                    System.out.println("dataEnd: " + dataEnd);

                                    request.setAttribute("dataBegin", dataBegin);
                                    request.setAttribute("dataEnd", dataEnd);
                                    //计算显示数据所需要的页数
                                    //需要自行修改list数组名
                                    if (varietys.size() % (pageSize + 1) == 0) {
                                        pageTotal = varietys.size() / (pageSize + 1);
                                    } else {
                                        pageTotal = varietys.size() / (pageSize + 1) + 1;
                                    }
                                    System.out.println("pageTotal: " + pageTotal);
                                    //接下来的代码段在末尾
                                %>
                                <%--    分页        --%>
                                <tbody>
                                <c:forEach items="${variety}" var="v" begin="${dataBegin}" end="${dataEnd}">

                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>${v.pigVarietyId}</td>
                                        <td>${v.pigVariety}</td>


                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <form class=""
                                                          action="/pigVarietyUpdate/PigService/select/pigVariety.do"
                                                          method="post">
                                                        <!-- 这个form不可删除，用来解决第一个form表达必跳转pigInfoList界面的玄学问题-->
                                                    </form>
                                                    <div style="float:left;">
                                                        <form class=""
                                                              action="/pigVarietyUpdate/PigService/select/pigVariety.do"
                                                              method="post">
                                                            <input type="hidden" name="pigVarietyId"
                                                                   value="${v.pigVarietyId}">
                                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                                    class="am-icon-pencil-square-o"></span>修改
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div style="float:left;">
                                                            <%--<form class="" action="/pigInfoList/PigService/delete/pigInfo.do" method="post">
                                                                <input type="hidden" name="pigNo" value="${pig.pigNo}" >
                                                               <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " onclick="deletePigInfoList()">
                                                                    <span class="am-icon-trash-o"></span>删除
                                                                </button>
                                                            </form>--%>
                                                        <button type="button" value="${v.pigVarietyId}"
                                                                onclick="deletePigVarietyList(this)"
                                                                class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                            <span class="am-icon-trash-o"></span>删除
                                                        </button>
                                                    </div>

                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                            <div class="am-cf">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success">导入数据</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary">导出数据</button>
                                </div>
                                <%--        以下代码只需要修改form表单中的action值 三处                --%>
                                <div class="am-fr">

                                    <%
                                        if (pageTotal < pageButtonNum) {
                                            for (int i = 1; i <= pageTotal; i++) {
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <%
                                                dataBegin = (pageSize + 1) * (i - 1);
                                            %>
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0"><%=i%>
                                            </button>

                                        </form>
                                    </li>
                                    <%
                                        }
                                    } else {
                                        pageButtonBegin += pageButtonAddNum;
                                        System.out.println("else pageButtonBegin:" + pageButtonBegin);
                                        System.out.println("else pageButtonAddNum:" + pageButtonAddNum);
                                        if (!((pageButtonBegin) == 1)) {
                                            dataBegin = (pageSize + 1) * (pageButtonBegin - 2);
                                            System.out.println("send before dataBegin:" + dataBegin);
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form>
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <input type="hidden" name="pageButtonAddNum" value="<%=-(pageButtonNum)%>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0">
                                                <<
                                            </button>
                                        </form>
                                    </li>
                                    <%
                                        }
                                        for (int i = pageButtonBegin; i < pageButtonBegin + pageButtonNum; i++) {
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <%
                                                dataBegin = (pageSize + 1) * (i - 1);
                                            %>
                                            <input type="hidden" name="dataBegin" value="<%= dataBegin %>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0"><%=i%>
                                            </button>

                                        </form>
                                    </li>
                                    <%
                                            if (i == pageTotal) {
                                                break;
                                            }
                                        }
                                        if ((pageButtonBegin + pageButtonNum) < pageTotal) {
                                            dataBegin = (pageSize + 1) * (pageButtonBegin + pageButtonNum - 1);
                                            System.out.println("send next dataBegin:" + dataBegin);
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <input type="hidden" name="pageButtonAddNum" value="<%=pageButtonNum%>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0">
                                                >>
                                            </button>
                                        </form>
                                    </li>
                                    <%
                                            }
                                        }
                                    %>
                                    <%--<li class="am-disabled"><a href="#">«</a></li>
                                    <li class="am-active"><a href="#">1</a></li>--%>

                                </div>
                            </div>
                            <hr>
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
<script src="<%=basePath%>/assets/js/common.js"></script>
</body>

</html>