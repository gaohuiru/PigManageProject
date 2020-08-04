<%--
  Created by IntelliJ IDEA.
  User: xxbb
  Date: 2020/7/26
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <script src="../../assets/js/echarts.min.js"></script>
</head>

<body data-type="chart">


<%@ include file="../../head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">

    <%@ include file="../../left.jsp" %>

    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            猪舍管理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">猪只管理</a></li>
            <li><a href="#">猪舍管理</a></li>
            <li class="am-active">猪舍环境信息图</li>
        </ol>
        <div class="tpl-portlet-components">

            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 猪舍实时数据
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."></div>
                    </div>
                </div>

            </div>


            <div class="tpl-block">
                <div class="am-g">

                    <label>
                        <select >
                            <option value="option1">所属猪舍</option>
                            <option value="option2">猪舍编号1</option>
                            <option value="option3">猪舍编号2</option>
                            <option value="option3">猪舍编号3</option>
                            <option value="option3">猪舍编号4</option>
                            <option value="option3">猪舍编号5</option>
                            <option value="option3">猪舍编号6</option>
                        </select>
                    </label>
                    <label>
                        <select>
                            <option value="option1">猪舍环境</option>
                            <option value="option2">温度</option>
                            <option value="option3">湿度</option>
                            <option value="option3">光照度</option>
                            <option value="option3">二氧化碳浓度</option>
                            <option value="option3">硫化氢浓度</option>
                        </select>
                    </label>

                    <div class="am-btn-group am-btn-group-xs am-fr">
                        <button type="button" class="am-right am-btn am-btn-default am-btn-warning"><span
                                class="am-icon-archive"></span> 设备调整
                        </button>
                    </div>
                </div>
                <!-- 实时图 -->
                <div class="tpl-echarts tpl-chart-mb" id="tpl-echarts-B">
                </div>




                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 猪舍环境信息图
                    </div>


                </div>


                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <!-- <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button> -->
                                    <button type="button" class="am-btn am-btn-default am-btn-success"><span
                                            class="am-icon-save"></span> 导出数据
                                    </button>
                                    <!-- <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button> -->
                                    <!-- <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button> -->
                                </div>
                            </div>
                        </div>

                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <label>
                                    <select >
                                        <option value="option1">所属猪舍</option>
                                        <option value="option2">猪舍编号1</option>
                                        <option value="option3">猪舍编号2</option>
                                        <option value="option3">猪舍编号3</option>
                                        <option value="option3">猪舍编号4</option>
                                        <option value="option3">猪舍编号5</option>
                                        <option value="option3">猪舍编号6</option>
                                    </select>
                                </label>
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

                    起始
                    <label>
                        <select>
                            <option value="a">选择月份</option>
                            <option value="a">一月</option>
                            <option value="b">二月</option>
                            <option value="c">三月</option>
                            <option value="d">四月</option>
                            <option value="d">五月</option>
                            <option value="d">六月</option>
                            <option value="d">七月</option>
                            <option value="d">八月</option>
                            <option value="d">九月</option>
                            <option value="d">十月</option>
                            <option value="d">十一月</option>
                            <option value="d">十二月</option>
                        </select>
                    </label>
                    <label>
                        <select >
                            <option value="a">选择日期</option>
                            <option value="a">0</option>
                            <option value="b">1</option>
                            <option value="c">2</option>
                            <option value="d">3</option>
                            <option value="d">4</option>

                            <option value="d">5</option>
                            <option value="d">6</option>
                            <option value="d">7</option>
                            <option value="d">8</option>
                            <option value="d">9</option>
                            <option value="d">10</option>
                            <option value="d">11</option>
                            <option value="d">12</option>
                            <option value="d">13</option>
                            <option value="d">14</option>
                            <option value="d">15</option>
                            <option value="d">16</option>
                            <option value="d">17</option>
                            <option value="d">18</option>
                            <option value="d">19</option>
                            <option value="d">20</option>
                            <option value="d">21</option>
                            <option value="d">22</option>
                            <option value="d">23</option>
                            <option value="d">24</option>
                            <option value="d">25</option>
                            <option value="d">26</option>
                            <option value="d">27</option>
                            <option value="d">28</option>
                            <option value="d">29</option>
                            <option value="d">30</option>

                        </select>
                    </label>
                    <label>
                        <select>
                            <option value="a">选择小时</option>
                            <option value="a">0</option>
                            <option value="b">1</option>
                            <option value="c">2</option>
                            <option value="d">3</option>
                            <option value="d">4</option>
                            <option value="d">5</option>
                            <option value="d">6</option>
                            <option value="d">7</option>
                            <option value="d">8</option>
                            <option value="d">9</option>
                            <option value="d">10</option>
                            <option value="d">11</option>
                            <option value="d">12</option>
                            <option value="d">13</option>
                            <option value="d">14</option>
                            <option value="d">15</option>
                            <option value="d">16</option>
                            <option value="d">17</option>
                            <option value="d">18</option>
                            <option value="d">19</option>
                            <option value="d">20</option>
                            <option value="d">21</option>
                            <option value="d">22</option>
                            <option value="d">23</option>
                            <option value="d">24</option>


                        </select>
                    </label>

                    终止
                    <!-- <div class=".am-sm-text-right"> -->
                    <label>
                        <select>
                            <option value="a">选择月份</option>
                            <option value="a">一月</option>
                            <option value="b">二月</option>
                            <option value="c">三月</option>
                            <option value="d">四月</option>
                            <option value="d">五月</option>
                            <option value="d">六月</option>
                            <option value="d">七月</option>
                            <option value="d">八月</option>
                            <option value="d">九月</option>
                            <option value="d">十月</option>
                            <option value="d">十一月</option>
                            <option value="d">十二月</option>
                        </select>
                    </label>
                    <label>
                        <select >
                            <option value="a">选择日期</option>
                            <option value="b">1</option>
                            <option value="c">2</option>
                            <option value="d">3</option>
                            <option value="d">4</option>
                            <option value="d">5</option>
                            <option value="d">6</option>
                            <option value="d">7</option>
                            <option value="d">8</option>
                            <option value="d">9</option>
                            <option value="d">10</option>
                            <option value="d">11</option>
                            <option value="d">12</option>
                            <option value="d">13</option>
                            <option value="d">14</option>
                            <option value="d">15</option>
                            <option value="d">16</option>
                            <option value="d">17</option>
                            <option value="d">18</option>
                            <option value="d">19</option>
                            <option value="d">20</option>
                            <option value="d">21</option>
                            <option value="d">22</option>
                            <option value="d">23</option>
                            <option value="d">24</option>
                            <option value="d">25</option>
                            <option value="d">26</option>
                            <option value="d">27</option>
                            <option value="d">28</option>
                            <option value="d">29</option>
                            <option value="d">30</option>

                        </select>
                    </label>
                    <label>
                        <select >
                            <option value="a">选择小时</option>
                            <option value="b">1</option>
                            <option value="c">2</option>
                            <option value="d">3</option>
                            <option value="d">4</option>
                            <option value="d">5</option>
                            <option value="d">6</option>
                            <option value="d">7</option>
                            <option value="d">8</option>
                            <option value="d">9</option>
                            <option value="d">10</option>
                            <option value="d">11</option>
                            <option value="d">12</option>
                            <option value="d">13</option>
                            <option value="d">14</option>
                            <option value="d">15</option>
                            <option value="d">16</option>
                            <option value="d">17</option>
                            <option value="d">18</option>
                            <option value="d">19</option>
                            <option value="d">20</option>
                            <option value="d">21</option>
                            <option value="d">22</option>
                            <option value="d">23</option>
                            <option value="d">24</option>
                        </select>
                    </label>
                    <!--此部分数据请在 js文件夹下中的 app.js 中的 “百度图表A” 处修改数据 插件使用的是 百度echarts-->
                    <div class="tpl-echarts tpl-chart-mb" id="tpl-echarts-A">

                    </div>
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 猪舍物资消耗
                        </div>
                    </div>
                    <div class="tpl-echarts tpl-chart-mb" id="tpl-echarts-C">

                    </div>
                </div>

            </div>


        </div>

    </div>

    <%@include file="../../footer.jsp" %>
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../assets/js/amazeui.min.js"></script>
    <script src="../../assets/js/app.js"></script>


</body>
</html>
