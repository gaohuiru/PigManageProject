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
</head>

<body data-type="generalComponents">


<%@ include file="../../head.jsp" %>


<div class="tpl-page-container tpl-page-header-fixed">


    <%@ include file="../../left.jsp" %>


    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            用户管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">用户管理 </a></li>
            <li class="am-active">权限信息</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 员工权限信息
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <label for="search-criteria">
                            </label><select id="search-criteria">

                            <option value="employee_id"
                                    <c:if test="${result['queryCondition']=='q(p.employee_id)p'}">selected</c:if>
                            >员工编号
                            </option>
                            <option value="real_name"
                                    <c:if test="${result['queryCondition']=='q(e.real_name)p'}">selected</c:if>
                            >姓名
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
                                        value="/user/queryUserPurviews?service=queryUserPurviews&pageNo=1&pageSize=${result['pageSize']}"
                                        onclick="search(this)"></button>
                                <button class="am-btn  am-btn-default am-btn-default tpl-am-btn-default am-icon-refresh"
                                        type="button" value="/user/queryUserPurviews?service=queryUserPurviews"
                                        onclick="refresh(this)"></button>
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
                                <th class="table-id">员工编号</th>
                                <th class="table-title">姓名</th>
                                <th>用户管理权限</th>
                                <th class="table-author am-hide-sm-only">猪只管理权限</th>
                                <th>仓库管理权限</th>
                                <th class="table-date am-hide-sm-only">设备管理权限</th>
                                <th class="table-date am-hide-sm-only">系统管理权限</th>
                                <th class="table-date am-hide-sm-only">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${result['pageInfo'].list}" var="purview">
                                <tr>

                                    <td><label>
                                        <input type="checkbox">
                                    </label></td>
                                    <td>${purview.employeeId}</td>
                                    <td>${purview.realName}</td>
                                    <td ><label>
                                        <input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${purview.userRights==1 }">checked="checked"</c:if> >
                                    </label></td>
                                    <td><label>
                                        <input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${purview.pigRights==1 }">checked="checked"</c:if> >
                                    </label></td>
                                    <td><label>
                                        <input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${purview.storeRights==1 }">checked="checked"</c:if> >
                                    </label></td>
                                    <td><label>
                                        <input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${purview.equipmentRights==1 }">checked="checked"</c:if> >
                                    </label></td>
                                    <td><label>
                                        <input name="checkbox" type="checkbox" class="noborder" value="checkbox" disabled <c:if test="${purview.systemRights==1 }">checked="checked"</c:if> >
                                    </label></td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <div class="am-modal am-modal-prompt" tabindex="-1"
                                                     id="user-purview-modify-modal-${purview.employeeId}">
                                                    <div class="am-modal-dialog">
                                                        <div class="am-modal-hd">修改员工权限</div>
                                                        <form action="${pageContext.request.contextPath}/user/modifyUserPurview?service=modifyUserPurview&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                              method="post"
                                                              id="user-purview-modify-form-${purview.employeeId}">
                                                            <div class="am-modal-bd">
                                                                员工编号：<label
                                                            ><input
                                                                    type="text" name="employeeId" readonly
                                                                    value="${purview.employeeId}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                            ></label>
                                                                <br>姓名：
                                                                <label><input
                                                                            type="text"
                                                                            name="realName"
                                                                            readonly
                                                                            value="${purview.realName}"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br>拥有权限：
                                                                <br>
                                                                <label for="userRights"></label>
                                                                <input name="userRights" id="userRights"
                                                                       type="checkbox"
                                                                       value="1" <c:if test="${purview.userRights==1 }">checked="checked"</c:if>>
                                                                用户管理
                                                                <br>
                                                                <label for="pigRights"></label>
                                                                <input name="pigRights" id="pigRights"
                                                                       type="checkbox"
                                                                       value="1" <c:if test="${purview.pigRights==1 }">checked="checked"</c:if>>
                                                                猪只管理
                                                                <br>
                                                                <label for="storeRights"></label>
                                                                <input name="storeRights" id="storeRights"
                                                                       type="checkbox"
                                                                       value="1" <c:if test="${purview.storeRights==1 }">checked="checked"</c:if>>
                                                                仓库管理
                                                                <br>
                                                                <label for="equipmentRights"></label>
                                                                <input name="equipmentRights" id="equipmentRights"
                                                                       type="checkbox"
                                                                       value="1" <c:if test="${purview.equipmentRights==1 }">checked="checked"</c:if>>
                                                                设备管理
                                                                <br>
                                                                <label for="systemRights"></label>
                                                                <input name="systemRights" id="systemRights"
                                                                       type="checkbox"
                                                                       value="1" <c:if test="${purview.systemRights==1 }">checked="checked"</c:if>>
                                                                系统管理
                                                                <br>
                                                            </div>

                                                            <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                                                <span class="am-modal-btn"
                                                                      onclick="document.getElementById('user-purview-modify-form-${purview.employeeId}').submit();return false;">提交</span>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                        data-am-modal="{target: '#user-purview-modify-modal-${purview.employeeId}'}">
                                                    <span class="am-icon-pencil-square-o"></span>修改
                                                </button>
                                            </div>
                                        </div>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
                                            <a href="${pageContext.request.contextPath}/user/queryUserPurviews?service=queryUserPurviews&pageNo=${pageNumberStart-1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">«</a>
                                        </li>
                                    </c:if>

                                    <c:forEach begin="${pageNumberStart}" end="${pageNumberEnd}"
                                               var="pageNo">
                                        <%--当页码为当前页，则页码按钮高亮--%>
                                        <li
                                                <c:if test="${pageNo==result['pageNo']}">class="am-active"</c:if>>
                                            <a href="${pageContext.request.contextPath}/user/queryUserPurviews?service=queryUserPurviews&pageNo=${pageNo}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">${pageNo}</a>
                                        </li>
                                    </c:forEach>
                                    <%--按此按钮去往下一组页码的第一个--%>
                                    <c:if test="${pageNumberEnd!=result['pageInfo'].totalPage}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/user/queryUserPurviews?service=queryUserPurviews&pageNo=${pageNumberEnd+1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">»</a>
                                        </li>
                                    </c:if>

                                </ul>
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
<%@include file="../../footer.jsp" %>

<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>