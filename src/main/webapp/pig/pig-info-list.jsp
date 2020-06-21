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
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success"
                                        onclick="insertForPig(this)" value="pigInfo"><span
                                        class="am-icon-plus"></span> 添加
                                </button>
                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                        class="am-icon-save"></span> 保存
                                </button>
                                <!--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 特殊标记</button>-->
                                <button type="button" class="am-btn am-btn-default am-btn-danger"
                                        onclick="bashInsert()"><span
                                        class="am-icon-trash-o"></span> 删除
                                </button>
                            </div>
                        </div>
                    </div>


                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <select id="search-criteria">
                                <option value="pigNo">猪只编号</option>
                                <option value="pigVarietyId">品种</option>
                                <option value="sex">性别</option>
                                <option value="age">日龄</option>
                                <option value="growthStage">生长阶段</option>
                                <option value="pigType">类型</option>
                                <option value="pigState">状态</option>
                                <option value="pigstyNo">所在猪舍</option>
                                <option value="hogcoteNo">所在猪栏</option>

                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field" id="search-content">
                            <span class="am-input-group-btn">
                                <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                        type="button" value="pigInfos" onclick="search(this)"></button>
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
                                <tbody>
                                <c:forEach items="${pig}" var="pig">

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
                                                    <form class=""
                                                          action="/pigInfoUpdate/StoreService/select/pigInfo.do"
                                                          method="post">
                                                        <!-- 这个form不可删除，用来解决第一个form表达必跳转pigInfoList界面的玄学问题,可能是受最外面的一个form表单影响-->
                                                    </form>
                                                    <div style="float:left;">
                                                        <form class=""
                                                              action="/pigInfoUpdate/PigService/select/pigInfo.do"
                                                              method="post">
                                                            <input type="hidden" name="pigNo" value="${pig.pigNo}">
                                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                                    class="am-icon-pencil-square-o"></span>修改
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div style="float:left;">
                                                        <form class=""
                                                              action="/pigInfoDetail/PigService/select/pigInfos.do"
                                                              method="post">
                                                            <input type="hidden" name="pigNo" value="${pig.pigNo}">
                                                            <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
                                                                <span class="am-icon-copy"></span>详情
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div style="float:left;">
                                                        <button type="button" value="${pig.pigNo}"
                                                                onclick="deletePigInfoList(this)"
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
<script src="../assets/js/common.js"></script>
</body>

</html>
