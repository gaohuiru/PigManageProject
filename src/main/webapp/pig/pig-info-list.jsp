<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
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
<script language="JavaScript">
    function bashInsert() {
        window.open("http://localhost:8080/bash_demo.jsp", "new Windows", "height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
        alert("使用成功！！！");
    }
</script>
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
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-modal am-modal-prompt" tabindex="-1"
                                 id="pig-add">

                                <div class="am-modal-dialog">
                                    <div class="am-modal-hd">添加</div>
                                    <form action="${pageContext.request.contextPath}/pig/addPig?pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                          method="post"
                                          id="pig-add-form">
                                        <div class="am-modal-bd">
                                            猪耳号：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text" name="pigNo"
                                        ></label>

                                            <br>品种：

                                            <label
                                                    style=" display:inline-block;width: 33%;height: 60%">
                                                <input
                                                        type="text"
                                                        name="pigVarietyId"

                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                ></label>
                                            <br>类型：

                                            <label
                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                    type="text"
                                                    name="pigType"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>


                                            <br>性别：

                                            <label
                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                    type="text"
                                                    name="sex"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>
                                            日龄：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text" name="age"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>生长阶段：

                                            <label
                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                    type="text"
                                                    name="growthStage"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>出生日期：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="birthday"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br> 当前体重：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="pigRecentWeight"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>
                                            接种次数：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="vaccinumCount"
                                                placeholder=""
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>状态：
                                            <label
                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                    type="text"
                                                    name="pigState"
                                                    placeholder="1：健康；2：生病；-1：淘汰；0：出栏"
                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                            <br>所在猪舍：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="pigstyNo"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>所在猪栏：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="hogcoteNo"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>入栏日期：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="enterDate"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>入栏体重：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="pigBasicWeight"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                            <br>出栏日期：<label
                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                type="text"
                                                name="leaveDate"
                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                        </div>

                                        <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                            <span class="am-modal-btn"
                                                  onclick="document.getElementById('pig-add-form').submit();return false;">提交</span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"
                                        data-am-modal="{target: '#pig-add'}"><span class="am-icon-plus"></span> 添加
                                </button>
                            </div>
                        </div>
                    </div>


                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <label for="search-criteria">
                            </label><select id="search-criteria">

                            <option value="pig_no"
                                    <c:if test="${result['queryCondition']=='q(pig_no)p'}">selected</c:if>
                            >猪只编号
                            </option>
                            <option value="pig_variety_id"
                                    <c:if test="${result['queryCondition']=='q(pig_variety_id)p'}">selected</c:if>
                            >品种
                            </option>
                            <option value="sex"
                                    <c:if test="${result['queryCondition']=='q(sex)p'}">selected</c:if>
                            >性别
                            </option>
                            <option value="age"
                                    <c:if test="${result['queryCondition']=='q(age)p'}">selected</c:if>
                            >日龄
                            </option>
                            <option value="growth_stage"
                                    <c:if test="${result['queryCondition']=='q(growth_stage)p'}">selected</c:if>
                            >生长阶段
                            </option>
                            <option value="pig_type"
                                    <c:if test="${result['queryCondition']=='q(pig_type)p'}">selected</c:if>
                            >类型
                            </option>
                            <option value="pig_state"
                                    <c:if test="${result['queryCondition']=='q(pig_state)p'}">selected</c:if>
                            >状态
                            </option>
                            <option value="pigsty_no"
                                    <c:if test="${result['queryCondition']=='q(pigsty_no)p'}">selected</c:if>
                            >所在猪舍
                            </option>
                            <option value="hogcote_no"
                                    <c:if test="${result['queryCondition']=='q(hogcote_no)p'}">selected</c:if>
                            >所在猪栏
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
                                <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                        type="button"
                                        value="/pig/queryPigs?pageNo=${result['pageNo']}&pageSize=${result['pageSize']}"
                                        onclick="search(this)"></button>
                                <button class="am-btn  am-btn-default am-btn-default tpl-am-btn-default am-icon-refresh"
                                        type="button" value="/pig/queryPigs" onclick="refresh(this)"></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
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
                            <tbody>
                            <c:forEach items="${result['pageInfo'].list}" var="pig">

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
                                                <div style="float:left;">
                                                    <div class="am-modal am-modal-prompt" tabindex="1"
                                                         id="pig-detail-${pig.pigNo}">
                                                        <div class="am-modal-dialog">
                                                            <div class="am-modal-hd">猪只详细信息</div>
                                                            <div class="am-modal-bd">
                                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                                猪耳号：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="pigNo"
                                                                    value="${pig.pigNo}"></label>
                                                                &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                品种：
                                                                <c:if test="${pig.pigVarietyId==0 }">
                                                                    <label
                                                                            style=" display:inline-block;width: 33%;height: 60%">
                                                                        <input
                                                                                type="text" disabled="disabled"
                                                                                name="pigVarietyId"
                                                                                value="虚空猪"></label>
                                                                </c:if>
                                                                <c:if test="${pig.pigVarietyId==1 }">
                                                                    <label
                                                                            style=" display:inline-block;width: 33%;height: 60%">
                                                                        <input
                                                                                type="text" disabled="disabled"
                                                                                name="pigVarietyId"
                                                                                value="白猪"></label>
                                                                </c:if>

                                                                <br>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                类型：
                                                                <c:if test="${pig.pigType==0}">
                                                                    <label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text" disabled="disabled"
                                                                            name="pigType"
                                                                            value="育种猪
                                                                        "></label>
                                                                </c:if>
                                                                <c:if test="${pig.pigType==1}">
                                                                    <label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text" disabled="disabled"
                                                                            name="pigType"
                                                                            value="育肥猪
                                                                        "></label>
                                                                </c:if>

                                                                &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                性别：
                                                                <c:if test="${pig.sex==0}"> <label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled" name="sex"
                                                                        value="公
                                                                                 "></label></c:if>
                                                                <c:if test="${pig.sex==1}"> <label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled" name="sex"
                                                                        value="母
                                                                                 "></label></c:if>

                                                                <br>&nbsp;&nbsp;&nbsp;&nbsp;
                                                                &nbsp;&nbsp;&nbsp;日龄：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="age"
                                                                    value="${pig.age}"></label>
                                                                &nbsp;&nbsp;&nbsp; 生长阶段：
                                                                <c:if test="${pig.growthStage==1}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="growthStage"
                                                                        value="哺乳阶段"></label></c:if>
                                                                <c:if test="${pig.growthStage==2}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="growthStage"
                                                                        value="保育阶段"></label></c:if>
                                                                <c:if test="${pig.growthStage==3}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="growthStage"
                                                                        value="生长育肥阶段"></label></c:if>

                                                                <br>出生日期：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="birthday"
                                                                    value="${pig.birthday}"></label>
                                                                &nbsp;&nbsp;&nbsp; 当前体重：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled"
                                                                    name="pigRecentWeight"
                                                                    value="${pig.pigRecentWeight}"></label>
                                                                <br>
                                                                接种次数：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled"
                                                                    name="vaccinumCount"
                                                                    value="${pig.vaccinumCount}"></label>
                                                                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：
                                                                <c:if test="${pig.pigState==1}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="pigState"
                                                                        value="健康"></label></c:if>
                                                                <c:if test="${pig.pigState==2}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="pigState"
                                                                        value="生病"></label></c:if>
                                                                <c:if test="${pig.pigState==-1}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="pigState"
                                                                        value="淘汰"></label></c:if>
                                                                <c:if test="${pig.pigState==0}"><label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" disabled="disabled"
                                                                        name="pigState"
                                                                        value=">出栏"></label></c:if>
                                                                <br>所在猪舍：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="pigstyNo"
                                                                    value="${pig.pigstyNo}"></label>
                                                                &nbsp;&nbsp;&nbsp; 所在猪栏：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="hogcoteNo"
                                                                    value="${pig.hogcoteNo}"></label>
                                                                <br>入栏日期：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="enterDate"
                                                                    value="${pig.enterDate}"></label>
                                                                &nbsp;&nbsp;&nbsp; 入栏体重：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled"
                                                                    name="pigBasicWeight"
                                                                    value="${pig.pigBasicWeight}"></label>
                                                                <br>出栏日期：<label
                                                                    style=" display:inline-block;width: 33%;height: 60%"><input
                                                                    type="text" disabled="disabled" name="leaveDate"
                                                                    value="${pig.leaveDate}"></label>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <button type="button"
                                                            class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                            data-am-modal="{target: '#pig-detail-${pig.pigNo}'}">
                                                        <span class="am-icon-copy"></span>详情
                                                    </button>
                                                </div>
                                                <div style="float:left;">
                                                    <div class="am-modal am-modal-prompt" tabindex="-1"
                                                         id="pig-update-${pig.pigNo}">

                                                        <div class="am-modal-dialog">
                                                            <div class="am-modal-hd">猪只信息修改</div>
                                                            <form action="
                                                                ${pageContext.request.contextPath}/pig/modifyPig?pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}"
                                                                  method="post"
                                                                  id="pig-modify-${pig.pigNo}">
                                                                <div class="am-modal-bd">
                                                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                                                    猪耳号：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" name="pigNo" readonly
                                                                        value="${pig.pigNo}"></label>
                                                                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    品种：
                                                                    <c:if test="${pig.pigVarietyId==0 }">
                                                                        <label
                                                                                style=" display:inline-block;width: 33%;height: 60%">
                                                                            <input
                                                                                    type="text"
                                                                                    name="pigVarietyId"
                                                                                    value="虚空猪"
                                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"
                                                                            ></label>
                                                                    </c:if>
                                                                    <c:if test="${pig.pigVarietyId==1 }">
                                                                        <label
                                                                                style=" display:inline-block;width: 33%;height: 60%">
                                                                            <input
                                                                                    type="text"
                                                                                    name="pigVarietyId"
                                                                                    value="白猪"
                                                                                    onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    </c:if>

                                                                    <br>
                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    类型：
                                                                    <c:if test="${pig.pigType==0}">
                                                                        <label
                                                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                                                type="text"
                                                                                name="pigType"
                                                                                value="育种猪
                                                                        "
                                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    </c:if>
                                                                    <c:if test="${pig.pigType==1}">
                                                                        <label
                                                                                style=" display:inline-block;width: 33%;height: 60%"><input
                                                                                type="text"
                                                                                name="pigType"
                                                                                value="育肥猪
                                                                        "
                                                                                onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    </c:if>

                                                                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    性别：
                                                                    <c:if test="${pig.sex==0}"> <label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="sex"
                                                                            value="公
                                                                                 "
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.sex==1}"> <label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="sex"
                                                                            value="母
                                                                                 "
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>

                                                                    <br>&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    &nbsp;&nbsp;&nbsp;日龄：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text" name="age"
                                                                        value="${pig.age}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    &nbsp;&nbsp;&nbsp; 生长阶段：
                                                                    <c:if test="${pig.growthStage==1}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="growthStage"
                                                                            value="哺乳阶段"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.growthStage==2}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="growthStage"
                                                                            value="保育阶段"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.growthStage==3}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="growthStage"
                                                                            value="生长育肥阶段"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>

                                                                    <br>出生日期：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="birthday"
                                                                        value="${pig.birthday}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    &nbsp;&nbsp;&nbsp; 当前体重：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="pigRecentWeight"
                                                                        value="${pig.pigRecentWeight}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    <br>
                                                                    接种次数：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="vaccinumCount"
                                                                        placeholder=""
                                                                        value="${pig.vaccinumCount}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：
                                                                    <c:if test="${pig.pigState==1}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="pigState"
                                                                            placeholder="1：健康；2：生病；-1：淘汰；0：出栏"
                                                                            value="健康"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.pigState==2}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="pigState"
                                                                            value="生病"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.pigState==-1}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="pigState"
                                                                            value="淘汰"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <c:if test="${pig.pigState==0}"><label
                                                                            style=" display:inline-block;width: 33%;height: 60%"><input
                                                                            type="text"
                                                                            name="pigState"
                                                                            value=">出栏"
                                                                            onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label></c:if>
                                                                    <br>所在猪舍：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="pigstyNo"
                                                                        value="${pig.pigstyNo}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    &nbsp;&nbsp;&nbsp; 所在猪栏：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="hogcoteNo"
                                                                        value="${pig.hogcoteNo}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    <br>入栏日期：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="enterDate"
                                                                        value="${pig.enterDate}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    &nbsp;&nbsp;&nbsp; 入栏体重：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="pigBasicWeight"
                                                                        value="${pig.pigBasicWeight}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>
                                                                    <br>出栏日期：<label
                                                                        style=" display:inline-block;width: 33%;height: 60%"><input
                                                                        type="text"
                                                                        name="leaveDate"
                                                                        value="${pig.leaveDate}"
                                                                        onkeyup="this.value=this.value.replace(/[, ]/g,'')"></label>

                                                                </div>

                                                                <div class="am-modal-footer">
                                                                    <span class="am-modal-btn"
                                                                          data-am-modal-cancel>取消</span>
                                                                    <span class="am-modal-btn"
                                                                          onclick="document.getElementById('pig-modify-${pig.pigNo}').submit();return false;">提交</span>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <input type="hidden" name="pigNo" value="${pig.pigNo}">
                                                    <button type="button"
                                                            class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                            data-am-modal="{target: '#pig-update-${pig.pigNo}'}">
                                                        <span class="am-icon-pencil-square-o"></span>修改
                                                    </button>

                                                </div>
                                                <div style="float:left;">
                                                    <div class="am-modal am-modal-confirm" tabindex="3"
                                                         id="pig-remove-${pig.pigNo}">
                                                        <div class="am-modal-dialog">
                                                            <div class="am-modal-hd">删除确认</div>
                                                            <div class="am-modal-bd">
                                                                您确定要删除这条猪只信息吗？
                                                            </div>
                                                            <div class="am-modal-footer">
                                                                <span class="am-modal-btn"
                                                                      data-am-modal-cancel>取消</span>
                                                                <label for="removeRequest"></label><input hidden
                                                                                                          id="removeRequest"
                                                                                                          value="/pig/removePig?pigNo=${pig.pigNo}&pageNo=${result['pageNo']}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">
                                                                <span class="am-modal-btn"
                                                                      onclick="deleteItem()">确定</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <button type="button"
                                                            class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                            data-am-modal="{target: '#pig-remove-${pig.pigNo}'}">
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
                                                <a href="${pageContext.request.contextPath}/pig/queryPigs?pageNo=${pageNumberStart-1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">«</a>
                                            </li>
                                        </c:if>

                                        <c:forEach begin="${pageNumberStart}" end="${pageNumberEnd}"
                                                   var="pageNo">
                                            <%--当页码为当前页是页码按钮高亮--%>
                                            <li
                                                    <c:if test="${pageNo==result['pageNo']}">class="am-active"</c:if>>
                                                <a href="${pageContext.request.contextPath}/pig/queryPigs?pageNo=${pageNo}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">${pageNo}</a>
                                            </li>
                                        </c:forEach>
                                        <%--按此按钮去往下一组页码的第一个--%>
                                        <c:if test="${pageNumberEnd!=result['pageInfo'].totalPage}">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/pig/queryPigs?pageNo=${pageNumberEnd+1}&pageSize=${result['pageSize']}&queryCondition=${result['queryCondition']}&queryValue=${result['queryValue']}">»</a>
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
