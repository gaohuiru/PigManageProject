<%--
  Created by IntelliJ IDEA.
  User: 姚晨
  Date: 2019/8/27
  Time: 16:45
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

    <%@include file="left.jsp"%>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            仓库管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">首页</a></li>
            <li><a href="#">仓库管理</a></li>
            <li><a href="#">仓库信息管理</a></li>
            <li class="am-active">商品信息详细</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 商品入库信息记录
                </div>


            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" method="post" action="/storeManage/StoreService/insert/StoreAdd.do" >

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-name" class="am-u-sm-3 am-form-label">物品名称</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="goodsName" name="goodsName">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">物品类型</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <select>
                                        <option value ="volvo">陈憨憨</option>
                                        <c:forEach items="${list}" var="item">
                                            <option value="${item}">${item}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">类型型号</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <select>
                                        <option value ="volvo">憨憨陈</option>
                                        <c:forEach items="${list1}" var="item">
                                            <option value="${item}">${item}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">购买对象</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="sellerPeople" name="sellerPeople">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">购买地点</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="sellerSite" name="sellerSite">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">入库数量</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="importNum" name="importNum">

                                </div>
                            </div>



                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">生产公司</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="goodsCompany" name="goodsCompany">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">商品金额</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="goodsMoney" name="goodsMoney">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">生产日期</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="birthGoods" name="birthGoods">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">过期日期</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="outtimeDay">

                                </div>
                            </div>

                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">物品下限</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="goodsLower" name="goodsLower">

                                </div>
                            </div>


                            <div class="am-form-group" style="width: 50%;float: left">
                                <label for="user-email" class="am-u-sm-3 am-form-label">保质下限</label>
                                <div class="am-u-sm-9" style="width: 50%;margin-right:15%">
                                    <input type="text" id="expirationLimit" name="expirationLimit">

                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-intro" class="am-u-sm-3 am-form-label">物品简介</label>
                                <div class="am-u-sm-9">
                                    <textarea class="" rows="5" id="goodsDescription" name="goodsDescription" style="width: 80%"></textarea>

                                </div>
                            </div>



                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary" style="margin-left:25%">提交</button>
                                    <button type="button" class="am-btn am-btn-primary" style="margin-left:25%">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>