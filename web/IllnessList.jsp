<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019/10/21
  Time: 11:21
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
    <%@ include file="left.jsp"%>

    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            猪只安全管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">猪只管理</a></li>
            <li><a href="#">猪只安全管理</a></li>
            <li><a href="#">疾病管理</a></li>
            <li class="am-active">病情记录表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span>病情记录表
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="option1">猪耳号</option>
                                <option value="option2">性别</option>
                                <option value="option3">猪种</option>
                                <option value="option3">类型</option>
                                <option value="option3">状态</option>
                                <option value="option3">生长阶段</option>
                                <option value="option3">日龄</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field">
                            <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
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
                                    <th class="table-id">猪耳号</th>
                                    <th class="table-title">药种类</th>
                                    <th class="table-type">服药时间</th>
                                    <th class="table-author am-hide-sm-only">总用量</th>
                                    <th class="table-author am-hide-sm-only">生病日期</th>
                                    <th class="table-author am-hide-sm-only">病种</th>
                                    <th class="table-author am-hide-sm-only">所在猪舍</th>
                                    <th class="table-author am-hide-sm-only">所在猪栏</th>
                                    <th class="table-author am-hide-sm-only">生病原因</th>
                                    <th class="table-author am-hide-sm-only">是否恢复</th>
                                    <th class="table-set">操作</th>
                                </tr>
                                </thead>
                                <%
                                    List<Object> IllnessRecord = (List<Object>) ((Map)request.getAttribute("data")).get("IllnessRecord");
                                    request.setAttribute("IllnessRecord",IllnessRecord);
                                %>
                                <c:forEach items="${IllnessRecord}" var="record">
                                <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td class="am-hide-sm-only">${record.pigNo}</td>
                                    <td class="am-hide-sm-only">${record.drugSpecies}</td>
                                    <td class="am-hide-sm-only">${record.time}</td>
                                    <td class="am-hide-sm-only">${record.totalAmount}</td>
                                    <td class="am-hide-sm-only">${record.illDate}</td>
                                    <td class="am-hide-sm-only">${record.illType}</td>
                                    <td class="am-hide-sm-only">${record.description}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                                </c:forEach >
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

</body>

</html>
