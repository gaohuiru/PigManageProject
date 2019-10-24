<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: xxbb
  Date: 2019/09/12
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--下面两句，如果只有上面那句就显示不出页面，只有下面那句c if 表达式就会出错，-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <span class="am-icon-code"></span> 猪只基本信息
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6" style="width: 19%">
                        <div class="am-btn-toolbar" style="width: 100%">
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"><span
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
                    <div class="am-u-sm-12 am-u-md-3" style="width: 20%">
                        <div class="am-form-group">
                            <select>
                                <option value="option1">所有猪舍</option>
                                <option value="option2">猪舍01</option>
                                <option value="option3">猪舍02</option>
                                <option value="option3">猪舍03</option>
                                <option value="option3">猪舍04</option>
                                <option value="option3">猪舍05</option>
                                <option value="option3">猪舍06</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3" style="width: 20%">
                        <div class="am-form-group">
                            <select>
                                <option value="option1">所有猪栏</option>
                                <option value="option2">猪栏01</option>
                                <option value="option3">猪栏02</option>
                                <option value="option3">猪栏03</option>
                                <option value="option3">猪栏04</option>
                                <option value="option3">猪栏05</option>
                                <option value="option3">猪栏06</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3" style="width: 15%">
                        <div class="am-form-group">
                            <select>
                                <option value="option1">查询条件</option>
                                <option value="option2">猪只编号</option>
                                <option value="option3">品种</option>
                                <option value="option4">性别</option>
                                <option value="option5">日龄</option>
                                <option value="option6">生长阶段</option>
                                <option value="option6">生长阶段</option>
                                <option value="option7">状态</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field">
                            <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                    type="button"></button>
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
                                    <th class="table-id">猪只编号</th>
                                    <th class="table-title">品种</th>
                                    <th>性别</th>
                                    <th class="table-type">猪舍号</th>
                                    <th class="table-type">猪栏号</th>
                                    <th class="table-author am-hide-sm-only">日龄</th>
                                    <th class="table-set">当前体重</th>
                                    <th class="table-date am-hide-sm-only">生长阶段</th>
                                    <th>类型</th>
                                    <th>状态</th>
                                    <th>操作</th>


                                </tr>
                                </thead>
                                <%
                                    Map jspMap=(Map)request.getAttribute("reqMap");
                                    List pigInfo=(List)jspMap.get("PigInfo");
                                    request.setAttribute("pig",pigInfo);


                                %>
                                <tbody>

<%--                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>1901100000</td>
                                    <td><a href="#">白猪</a></td>
                                    <td>雄性</td>
                                    <td>01，01</td>
                                    <td class="am-hide-sm-only">50</td>
                                    <td>50kg</td>
                                    <td class="am-hide-sm-only">生长育肥阶段</td>
                                    <td>育肥猪</td>
                                    <td>健康</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 修改
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-copy"></span>详情
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>--%>
                                <C:forEach items="${pig}" var="pig">

                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>${pig.pigNo}</td>

                                        <td>
                                            <c:if test="${pig.pigVarietyId==0 }">虚空猪</c:if>
                                            <c:if test="${pig.pigVarietyId==1 }">白猪</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${pig.sex==0}">公</c:if>
                                            <c:if test="${pig.sex==1}">母</c:if>
                                        </td>
                                        <td>${pig.pigstyNo}</td>
                                        <td>${pig.hogcoteNo}</td>
                                        <td>${pig.age}天</td>
                                        <td>${pig.pigRecentWeight} kg</td>
                                        <td>
                                            <c:if test="${pig.growthStage==1}">哺乳阶段</c:if>
                                            <c:if test="${pig.growthStage==2}">保育阶段</c:if>
                                            <c:if test="${pig.growthStage==3}">生长育肥阶段</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${pig.pigType==0}">育种猪</c:if>
                                            <c:if test="${pig.pigType==1}">育肥猪</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${pig.pigState==1}">健康</c:if>
                                            <c:if test="${pig.pigState==2}">生病</c:if>
                                            <c:if test="${pig.pigState==-1}">淘汰</c:if>
                                            <c:if test="${pig.pigState==0}">出栏</c:if>
                                        </td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <form class="" action="/pigInfoUpdate/StoreService/select/pigInfo.do" method="post">
                                                        <!-- 这个form不可删除，用来解决第一个form表达必跳转pigInfoList界面的玄学问题-->
                                                   </form>
                                                    <div style="float:left;">
                                                    <form class="" action="/pigInfoUpdate/PigService/select/pigInfo.do" method="post">
                                                        <input type="hidden" name="pigNo" value="${pig.pigNo}" >
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                                class="am-icon-pencil-square-o"></span>修改
                                                        </button>
                                                    </form>
                                                    </div>
                                                    <div style="float:left;">
                                                    <form class="" action="/pigInfoDetail/PigService/select/pigInfo.do" method="post">
                                                        <input type="hidden" name="pigNo" value="${pig.pigNo}" >
                                                        <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
                                                            <span class="am-icon-copy"></span>详情
                                                        </button>
                                                    </form>
                                                    </div>
                                                    <div style="float:left;">
                                                    <form class="" action="/pigInfoUpdate/PigService/select/pigInfo.do" method="post">
                                                        <input type="hidden" name="pigNo" value="${pig.pigNo}" >
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                            <span class="am-icon-trash-o"></span>删除
                                                        </button>
                                                    </form>
                                                    </div>

                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </C:forEach>

                                </tbody>
                            </table>
                            <div class="am-cf">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success">导入数据</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary">导出数据</button>
                                </div>

                                <div class="am-fr">

                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
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
</body>

</html>
