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
            <li class="am-active">员工基本信息</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 员工基本信息
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-modal am-modal-prompt" tabindex="-1"
                                 id="user-add-modal">

                                <div class="am-modal-dialog">
                                    <div class="am-modal-hd">添加</div>
                                    <form action="${pageContext.request.contextPath}/user/addUser?service=addUser&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                          method="post"
                                          id="user-add-form">
                                        <div class="am-modal-bd">
                                            员工编号：<label
                                                ><input
                                                type="text" name="employeeId"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                        ></label>

                                            <br>姓名：

                                            <label
                                                    >
                                                <input
                                                        type="text"
                                                        name="realName"
                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                ></label>
                                            <br>性别：

                                            <label
                                                    ><input
                                                    type="text"
                                                    name="sex"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>


                                            <br>年龄：

                                            <label
                                                    ><input
                                                    type="text"
                                                    name="age"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>
                                            身份证号：<label
                                                ><input
                                                type="text" name="identityNumber"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>电话号码：

                                            <label
                                                    ><input
                                                    type="text"
                                                    name="telephone"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>email：<label
                                                ><input
                                                type="text"
                                                name="email"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br> 职位：<label
                                                ><input
                                                type="text"
                                                name="position"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>
                                            地址：<label
                                                ><input
                                                type="text"
                                                name="address"
                                                placeholder=""
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>入职时间：
                                            <label
                                                    ><input
                                                    type="text"
                                                    name="entryTime"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>工作年限：<label
                                                ><input
                                                type="text"
                                                name="workingYears"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>账号状态：<label
                                                ><input
                                                type="text"
                                                name="status"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                        </div>

                                        <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                            <span class="am-modal-btn"
                                                  onclick="document.getElementById('user-add-form').submit();return false;">提交</span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"
                                        data-am-modal="{target: '#user-add-modal'}"><span
                                        class="am-icon-plus"

                                ></span> 添加用户
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <label for="search-criteria">
                            </label><select id="search-criteria">

                            <option value="employee_id"
                                    <c:if test="${result['queryCondition']=='q(employee_id)p'}">selected</c:if>
                            >员工编号
                            </option>
                            <option value="real_name"
                                    <c:if test="${result['queryCondition']=='q(real_name)p'}">selected</c:if>
                            >姓名
                            </option>
                            <option value="sex"
                                    <c:if test="${result['queryCondition']=='q(sex)p'}">selected</c:if>
                            >性别
                            </option>
                            <option value="age"
                                    <c:if test="${result['queryCondition']=='q(age)p'}">selected</c:if>
                            >年龄
                            </option>
                            <option value="position"
                                    <c:if test="${result['queryCondition']=='q(position)p'}">selected</c:if>
                            >职位
                            </option>
                            <option value="status"
                                    <c:if test="${result['queryCondition']=='q(status)p'}">selected</c:if>
                            >账号状态
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
                                        value="/user/queryUsers?service=queryUsers&pageNo=1&pageSize=${result['pageSize']}"
                                        onclick="search(this)"></button>
                                <button class="am-btn  am-btn-default am-btn-default tpl-am-btn-default am-icon-refresh"
                                        type="button" value="/user/queryUsers?service=queryUsers"
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
                                <th class="table-type">性别</th>
                                <th>年龄</th>
                                <th class="table-author am-hide-sm-only">职位</th>
                                <th>工作年限</th>
                                <th class="table-date am-hide-sm-only">账号状态</th>
                                <th class="table-date am-hide-sm-only">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${result['pageInfo'].list}" var="emp">
                                <tr>

                                    <td><label>
                                        <input type="checkbox">
                                    </label></td>
                                    <td>${emp.employeeId}</td>
                                    <td>${emp.realName}</td>
                                    <td>${emp.sex}</td>
                                    <td>${emp.age}</td>
                                    <td>${emp.position}</td>
                                    <td>${emp.workingYears}</td>
                                    <td>${emp.status}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <div class="am-modal am-modal-prompt" tabindex="-1"
                                                     id="user-detail-modal-${emp.employeeId}">
                                                    <div class="am-modal-dialog">
                                                        <div class="am-modal-hd">详细信息</div>
                                                        <div class="am-modal-bd">
                                                            员工编号：<label
                                                                ><input
                                                                type="text" name="employeeId" readonly
                                                                value="${emp.employeeId}"
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                        ></label>
                                                            <br>姓名：
                                                            <label
                                                                    >
                                                                <input
                                                                        type="text"
                                                                        name="realName"
                                                                        readonly
                                                                        value="${emp.realName}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                                ></label>
                                                            <br>性别：
                                                            <label
                                                                    ><input
                                                                    type="text"
                                                                    name="sex"
                                                                    value="${emp.sex}" readonly
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>


                                                            <br>年龄：
                                                            <label
                                                                    ><input
                                                                    type="text"
                                                                    name="age"
                                                                    value="${emp.age}" readonly
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                            <br>
                                                            身份证号：<label
                                                                ><input
                                                                type="text" name="identityNumber"
                                                                value="${emp.identityNumber}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br>电话号码：
                                                            <label
                                                                    ><input
                                                                    type="text"
                                                                    name="telephone"
                                                                    value="${emp.telephone}" readonly
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br>email：<label
                                                                ><input
                                                                type="text"
                                                                name="email"
                                                                value="${emp.email}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br> 职位：<label
                                                                ><input
                                                                type="text"
                                                                name="position"
                                                                value="${emp.position}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br>
                                                            地址：<label
                                                                ><input
                                                                type="text"
                                                                name="address"
                                                                value="${emp.address}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br>入职时间：
                                                            <label
                                                                    ><input
                                                                    type="text"
                                                                    name="entryTime"
                                                                    value="${emp.entryTime}" readonly
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                            <br>工作年限：<label
                                                                ><input
                                                                type="text"
                                                                name="workingYears"
                                                                value="${emp.workingYears}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            <br>账号状态：<label
                                                                ><input
                                                                type="text"
                                                                name="status"
                                                                value="${emp.status}" readonly
                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        data-am-modal="{target: '#user-detail-modal-${emp.employeeId}'}"><span
                                                        class="am-icon-copy"
                                                ></span> 详细
                                                </button>
                                                <div class="am-modal am-modal-prompt" tabindex="-1"
                                                     id="user-modify-modal-${emp.employeeId}">
                                                    <div class="am-modal-dialog">
                                                        <div class="am-modal-hd">修改员工信息</div>
                                                        <form action="${pageContext.request.contextPath}/user/modifyUser?service=modifyUser&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                              method="post"
                                                              id="user-modify-form-${emp.employeeId}">
                                                            <div class="am-modal-bd">
                                                                员工编号：<label
                                                                    ><input
                                                                    type="text" name="employeeId" readonly
                                                                    value="${emp.employeeId}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                            ></label>
                                                                <br>姓名：
                                                                <label
                                                                        >
                                                                    <input
                                                                            type="text"
                                                                            name="realName"
                                                                            readonly
                                                                            value="${emp.realName}"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                                    ></label>
                                                                <br>性别：

                                                                <label
                                                                        ><input
                                                                        type="text"
                                                                        name="sex"
                                                                        value="${emp.sex}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>


                                                                <br>年龄：

                                                                <label
                                                                        ><input
                                                                        type="text"
                                                                        name="age"
                                                                        value="${emp.age}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                                <br>
                                                                身份证号：<label
                                                                    ><input
                                                                    type="text" name="identityNumber"
                                                                    value="${emp.identityNumber}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br>电话号码：

                                                                <label><input
                                                                        type="text"
                                                                        name="telephone"
                                                                        value="${emp.telephone}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                                <br>email：<label
                                                                    ><input
                                                                    type="text"
                                                                    name="email"
                                                                    value="${emp.email}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br> 职位：<label><input
                                                                    type="text"
                                                                    name="position"
                                                                    value="${emp.position}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br>
                                                                地址：<label><input
                                                                    type="text"
                                                                    name="address"
                                                                    value="${emp.address}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br>入职时间：
                                                                <label><input
                                                                        type="text"
                                                                        name="entryTime"
                                                                        value="${emp.entryTime}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                                <br>工作年限：<label><input
                                                                    type="text"
                                                                    name="workingYears"
                                                                    value="${emp.workingYears}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                <br>账号状态：<label><input
                                                                    type="text"
                                                                    name="status"
                                                                    value="${emp.status}"
                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                            </div>

                                                            <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                                                <span class="am-modal-btn"
                                                                      onclick="document.getElementById('user-modify-form-${emp.employeeId}').submit();return false;">提交</span>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                        data-am-modal="{target: '#user-modify-modal-${emp.employeeId}'}">
                                                    <span class="am-icon-pencil-square-o"></span>修改
                                                </button>
                                                <div class="am-modal am-modal-confirm" tabindex="3"
                                                     id="user-remove-modal-${emp.employeeId}">
                                                    <div class="am-modal-dialog">
                                                        <div class="am-modal-hd">删除确认</div>
                                                        <form action="${pageContext.request.contextPath}/user/removeUser?service=removeUser&employeeId=${emp.employeeId}&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                              method="post"
                                                              id="user-remove-form-${emp.employeeId}">
                                                            <div class="am-modal-bd">
                                                                您确定要删除此条用户信息吗？
                                                            </div>
                                                            <div class="am-modal-footer">
                                                                <span class="am-modal-btn"
                                                                      data-am-modal-cancel>取消</span>
                                                                <span class="am-modal-btn"
                                                                      onclick="document.getElementById('user-remove-form-${emp.employeeId}').submit();return false;">确定</span>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                        data-am-modal="{target: '#user-remove-modal-${emp.employeeId}'}">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                                <div class="am-modal am-modal-prompt" tabindex="-1"
                                                     id="user-reset-modal-${emp.employeeId}">

                                                    <div class="am-modal-dialog">
                                                        <div class="am-modal-hd">修改密码</div>
                                                        <form action="${pageContext.request.contextPath}/user/modifyUser?service=modifyUser&employeeId=${emp.employeeId}&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                              method="post"
                                                              id="user-reset-form-${emp.employeeId}">
                                                            <div class="am-modal-bd">
                                                                新密码：
                                                                <label><input type="text" name="password" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
                                                                </label>
                                                            </div>
                                                            <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                                                <span class="am-modal-btn"
                                                                      onclick="document.getElementById('user-reset-form-${emp.employeeId}').submit();return false;">提交</span>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                        data-am-modal="{target: '#user-reset-modal-${emp.employeeId}'}">
                                                    <span class="am-icon-refresh"></span>重置密码
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
                                            <a href="${pageContext.request.contextPath}/user/queryUsers?service=queryUsers&pageNo=${pageNumberStart-1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">«</a>
                                        </li>
                                    </c:if>

                                    <c:forEach begin="${pageNumberStart}" end="${pageNumberEnd}"
                                               var="pageNo">
                                        <%--当页码为当前页，则页码按钮高亮--%>
                                        <li
                                                <c:if test="${pageNo==result['pageNo']}">class="am-active"</c:if>>
                                            <a href="${pageContext.request.contextPath}/user/queryUsers?service=queryUsers&pageNo=${pageNo}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">${pageNo}</a>
                                        </li>
                                    </c:forEach>
                                    <%--按此按钮去往下一组页码的第一个--%>
                                    <c:if test="${pageNumberEnd!=result['pageInfo'].totalPage}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/user/queryUsers?service=queryUsers&pageNo=${pageNumberEnd+1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">»</a>
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