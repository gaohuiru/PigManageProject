<!doctype html>
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
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"><span
                                        class="am-icon-plus"></span> 添加用户
                                </button>
                                <%--                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span--%>
                                <%--                                        class="am-icon-save"></span> 删除用户--%>
                                <%--                                </button>--%>
                                <!-- <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 特殊标记</button>
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 标记生病</button> -->
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <!-- <select data-am-selected="{btnSize: 'sm'}">
          <option value="option1">所有部门</option>
          <option value="option2">饲养部门</option>
          <option value="option3">仓库部门</option>
          <option value="option3">设备部门</option>-->
                            <!-- <option value="option3">猪舍编号4</option>
          <option value="option3">猪舍编号5</option>
          <option value="option3">猪舍编号6</option> -->
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
                                    <th class="table-id">员工编号</th>
                                    <th class="table-title">姓名</th>
                                    <th>性别</th>
                                    <th class="table-type">工龄</th>
                                    <th class="table-author am-hide-sm-only">职位</th>
                                    <th class="table-date am-hide-sm-only">账号状态</th>
                                    <th class="table-date am-hide-sm-only">操作</th>


                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>2017301</td>
                                    <td><a href="#">刘勇</a></td>
                                    <td>男</td>
                                    <td>2年</td>
                                    <td>设备管理员</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span
                                                        class="am-icon-copy"></span> 详细
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-refresh"></span>重置密码
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <!-- <td>10kg
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 启动</button>
                                                <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 重新启动</button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 异常报修</button>
                                            </div>
                                        </div>-->

                                    <!-- <td>10kg</td> -->
                                </tr>
                                <tr>

                                    <td><input type="checkbox"></td>
                                    <td>2016201</td>
                                    <td><a href="#">姚晨</a></td>
                                    <td>男</td>
                                    <td>3年</td>
                                    <td>仓库管理员</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 详细
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-copy"></span>重置密码
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>


                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>2015101</td>
                                    <td><a href="#">徐斌</a></td>
                                    <td>男</td>
                                    <td>4年</td>
                                    <td>饲养管理员</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 详细
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-copy"></span>重置密码
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>2016102</td>
                                    <td><a href="#">熊承杰</a></td>
                                    <td>男</td>
                                    <td>3年</td>
                                    <td>饲养管理员</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 详细
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-copy"></span>重置密码
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>2017103</td>
                                    <td><a href="#">陈洪彬</a></td>
                                    <td>男</td>
                                    <td>1年</td>
                                    <td>饲养管理员</td>
                                    <td>正常</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 详细
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-hide-sm-only"
                                                        onclick="window.location.href = 'zhuzhi-table-pigDetail.html'">
                                                    <span class="am-icon-copy"></span>重置密码
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="am-cf">
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


<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<script src="../assets/js/app.js"></script>
</body>

</html>