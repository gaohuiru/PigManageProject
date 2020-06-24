<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>智能养猪管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统"/>
    <link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../assets/css/admin.css">
    <link rel="stylesheet" href="../assets/css/app.css">
</head>
<body data-type="generalComponents">

<%@ include file="../head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">

    <%@ include file="../left.jsp" %>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            猪只管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">猪只管理</a></li>
            <li><a href="#">猪只管理信息</a></li>
            <li class="am-active">猪只品种信息</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 猪只品种信息
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-modal am-modal-prompt" tabindex="-1"
                                 id="pigVariety-add">

                                <div class="am-modal-dialog">
                                    <div class="am-modal-hd">添加</div>
                                    <form action="${pageContext.request.contextPath}/pig/addPigVariety?service=addPigVariety&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                          method="post"
                                          id="pigVariety-add-form">
                                        <div class="am-modal-bd">
                                            <br>品种：<label style=" display:inline-block;width: 33%;height: 60%"><input type="text" name="pigVariety" onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                        </div>

                                        <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                            <span class="am-modal-btn"
                                                  onclick="document.getElementById('pigVariety-add-form').submit();return false;">提交</span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"
                                        data-am-modal="{target: '#pigVariety-add'}"><span class="am-icon-plus"></span> 添加
                                </button>
                            </div>
                        </div>
                    </div>


                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <label for="search-criteria">
                            </label><select id="search-criteria">

                            <option value="pig_variety_id"
                                    <c:if test="${result['queryCondition']=='q(pig_variety_id)p'}">selected</c:if>
                            >品种编号
                            </option>
                            <option value="pig_variety"
                                    <c:if test="${result['queryCondition']=='q(pig_variety)p'}">selected</c:if>
                            >品种名称
                            </option>

                        </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <label for="search-content"></label><input type="text" class="am-form-field"
                                                                       id="search-content"
                                                                       value="${result['queryValue']}">
                            <span class="am-input-group-btn">
                                <%-- 在搜索时一定要重置页码，不然页码可能越界--%>
                                <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                        type="button"
                                        value="/pig/queryPigVarieties?service=queryPigVarieties&pageNo=1&pageSize=${result['pageSize']}"
                                        onclick="search(this)"></button>
                                <button class="am-btn  am-btn-default am-btn-default tpl-am-btn-default am-icon-refresh"
                                        type="button" value="/pig/queryPigVarieties?service=queryPigVarieties" onclick="refresh(this)"></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-check"><label>
                                    <input type="checkbox" class="tpl-table-fz-check">
                                </label></th>
                                <th class="table-id">品种编号</th>
                                <th class="table-title">品种名称</th>
                                <th>操作</th>


                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${result['pageInfo'].list}" var="pigVariety">

                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>${pigVariety.pigVarietyId}</td>
                                    <td>${pigVariety.pigVariety}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <div style="float:left;">
                                                    <div class="am-modal am-modal-prompt" tabindex="-1"
                                                         id="pigVariety-update-${pigVariety.pigVarietyId}">

                                                        <div class="am-modal-dialog">
                                                            <div class="am-modal-hd">猪只品种信息修改</div>
                                                            <form action="
                                                                ${pageContext.request.contextPath}/pig/modifyPigVariety?service=modifyPigVariety&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                                  method="post"
                                                                  id="pigVariety-modify-${pigVariety.pigVarietyId}">
                                                                <div class="am-modal-bd">

                                                                    品种编号：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" name="pigVarietyId" readonly
                                                                        value="${pigVariety.pigVarietyId}"></label>
                                                                    <br>
                                                                    品种：
                                                                    <label style=" display:inline-block;width: 33%;height: 60%"><input
                                                                                    type="text"
                                                                                    name="pigVariety"
                                                                                    value="${pigVariety.pigVariety}"
                                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                                </div>

                                                                <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                                                    <span class="am-modal-btn"
                                                                          onclick="document.getElementById('pigVariety-modify-${pigVariety.pigVarietyId}').submit();return false;">提交</span>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <button type="button"
                                                            class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                            data-am-modal="{target: '#pigVariety-update-${pigVariety.pigVarietyId}'}">
                                                        <span class="am-icon-pencil-square-o"></span>修改
                                                    </button>

                                                </div>
                                                <div style="float:left;">
                                                    <div class="am-modal am-modal-prompt" tabindex="-1"
                                                         id="pigVariety-remove-${pigVariety.pigVarietyId}">
                                                        <div class="am-modal-dialog">
                                                            <div class="am-modal-hd">删除确认</div>
                                                            <form action="${pageContext.request.contextPath}/pig/removePigVariety?service=removePigVariety&pigVarietyId=${pigVariety.pigVarietyId}&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                                    method="post"
                                                                    id="pigVariety-delete-${pigVariety.pigVarietyId}">
                                                            <div class="am-modal-bd">
                                                                您确定要删除这条猪只品种信息吗？
                                                            </div>
                                                            <div class="am-modal-footer">
                                                                <span class="am-modal-btn"
                                                                      data-am-modal-cancel>取消</span>
                                                                <span class="am-modal-btn"
                                                                      onclick="document.getElementById('pigVariety-delete-${pigVariety.pigVarietyId}').submit();return false;">确定</span>
                                                            </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <button type="button"
                                                            class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                            data-am-modal="{target: '#pigVariety-remove-${pigVariety.pigVarietyId}'}">
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
                            <div class="am-cf">
                                <div class="am-fr">
                                    <%-- 页码的分页参数，用于将页码分成n个一组，如此处每次只显示5个页码--%>
                                    <c:set var="pageNumberPagingFactor" value="5"/>
                                    <%--使用${result['pageInfo'].pageNo}会报错？？？
                                    直接从参数集中拿${result['pageNo']}不报错，
                                    而且${result['pageInfo']}中其他参数都不报错？？？离谱--%>
                                    <%--当前页面开始和结束的页码，如第一页开始页码为1，结束页码为5 --%>
                                    <%--计算当前页面的第一个页码--%>
                                    <%--除法计算得到的是浮点型数，需要取整，去除小数--%>
                                    <%--页码算法（除法的结果要去除小数取整）
                                        pageNumberStart=（pageNo-1）/pageNumberPagingFactor+1;
                                        pageNumberEnd=（pageNo-1）/pageNumberPagingFactor+1;
                                    --%>
                                    <fmt:parseNumber integerOnly="true" var="prePageNumberStart"
                                                     value="${((result['pageNo']-1)/pageNumberPagingFactor)}"/>
                                    <fmt:parseNumber integerOnly="true" var="pageNumberStart"
                                                     value="${prePageNumberStart*pageNumberPagingFactor+1}"/>
                                    <%--计算预期的最后一个页码--%>
                                    <%--除法计算得到的是浮点型数，需要取整，去除小数--%>
                                    <fmt:parseNumber integerOnly="true" var="tempPageNumberEnd"
                                                     value="${((result['pageNo']-1)/pageNumberPagingFactor)}"/>
                                    <%--处理计算结果的小数--%>
                                    <fmt:parseNumber integerOnly="true" var="prePageNumberEnd"
                                                     value="${tempPageNumberEnd*pageNumberPagingFactor+pageNumberPagingFactor}"/>
                                    <%--最后一个页码和页面总数比较，避免越界--%>
                                    <c:set var="pageNumberEnd"
                                           value="${prePageNumberEnd>result['pageInfo'].totalPage?result['pageInfo'].totalPage:prePageNumberEnd}"/>
                                    <ul class="am-pagination tpl-pagination">
                                        <%--按此按钮回到上一组页码的最后一个--%>
                                        <c:if test="${pageNumberStart!=1}">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/pig/queryPigVarieties?service=queryPigVarieties&pageNo=${pageNumberStart-1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">«</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="${pageNumberStart}" end="${pageNumberEnd}"
                                                   var="pageNo">
                                            <%--当页码为当前页，则页码按钮高亮--%>
                                            <li
                                                    <c:if test="${pageNo==result['pageNo']}">class="am-active"</c:if>>
                                                <a href="${pageContext.request.contextPath}/pig/queryPigVarieties?service=queryPigVarieties&pageNo=${pageNo}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">${pageNo}</a>
                                            </li>
                                        </c:forEach>
                                        <%--按此按钮去往下一组页码的第一个--%>
                                        <c:if test="${pageNumberEnd!=result['pageInfo'].totalPage}">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/pig/queryPigVarieties?service=queryPigVarieties&pageNo=${pageNumberEnd+1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">»</a>
                                            </li>
                                        </c:if>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <hr>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>


    </div>

</div>
<%@ include file="../footer.jsp" %>

<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<script src="../assets/js/app.js"></script>
<script src="../assets/js/common.js"></script>
</body>

</html>
