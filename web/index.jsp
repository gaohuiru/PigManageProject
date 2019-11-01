<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019/8/21
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <script src="<%=basePath%>/assets/js/echarts.min.js"></script>
</head>

<body data-type="index">

<!--引入头部和左边界面-->
<%@ include file="head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">
  <div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
      猪场功能列表
    </div>
    <div class="tpl-left-nav-list">
      <ul class="tpl-left-nav-menu">
        <li class="tpl-left-nav-item">
          <a href="index.html" class="nav-link active">
            <i class="am-icon-home"></i>
            <span>首页</span>
          </a>
        </li>

        <li class="tpl-left-nav-item">
          <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
            <i class="am-icon-wpforms"></i>
            <span>用户管理</span>
            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
          </a>
          <ul class="tpl-left-nav-sub-menu">
            <li>
              <a href="yonghu-table-power.html">
                <i class="am-icon-angle-right"></i>
                <span>权限管理</span>
                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
              </a>
            </li>
            <li>
              <a href="UserInfo.html">
                <i class="am-icon-angle-right"></i>
                <span>用户信息</span>
                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
              </a>
            </li>
          </ul>


        </li>



        <li class="tpl-left-nav-item">
          <!-- 打开状态 a 标签添加 active 即可   -->
          <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
            <i class="am-icon-wpforms"></i>
            <span>猪只管理</span>
            <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
          </a>
          <!-- 打开状态 添加 display:block-->
          <ul class="tpl-left-nav-sub-menu">
            <li>
              <a href="javascript:;" class="tpl-left-nav-link-list4">
                <i class="am-icon-angle-right tpl-left-nav-more-ico4"></i>
                <span>猪只信息管理</span>
                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
              </a>



              <ul class="tpl-left-nav-sub-menu4">
                <li>
                  <a href="/pigInfoList/PigService/select/pigInfos.do" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <span>猪只信息</span>
                  </a>

                  <a href="zhuzhi-table-pigType.html" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <span>猪只品种</span>
                  </a>

                  <a href="zhuzhi-table-pigDefault.html" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <span>猪只默认参数</span>
                  </a>

                </li>
              </ul>

              <a href="javascript:;" class="tpl-left-nav-link-list5">
                <i class="am-icon-angle-right tpl-left-nav-more-ico5"></i>
                <span>饲喂生长管理</span>
              </a>
              <ul class="tpl-left-nav-sub-menu5">
                <li>
                  <a href="zhuzhi-table-feed.html" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <span>饲喂设定</span>
                  </a>



                  <a href="zhuzhi-table-feedAnalysis.html" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <span>猪只饲喂生长统计</span>
                  </a>

                  <a href="zhuzhi-table-badGrowth.html" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <span>生长状况不良猪只统计</span>
                  </a>
                </li>
              </ul>
              <a href="javascript:;" class="tpl-left-nav-link-list6">
                <i class="am-icon-angle-right tpl-left-nav-more-ico6"></i>
                <span>猪只安全管理</span>
                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
              </a>
              <ul class="tpl-left-nav-sub-menu6">
                <li>
                  <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>
                    <span>疫苗接种管理</span>
                  </a>
                  <ul class="tpl-left-nav-sub-menu">
                    <li>
                      <a href="CanVaccinateList.html" class="" style="padding-left: 80px;">
                        <span>需接种猪只信息表</span>
                      </a>
                      <a href="/VaccinateSetList/PigService/select/vaccinateSet.do" class="" style="padding-left: 80px;">
                        <span>疫苗接种设定表</span>
                      </a>
                      <a href="/VaccinateList/PigService/select/vaccinateList.do" class=" " style="padding-left: 80px;">
                        <span>疫苗接种记录表</span>
                      </a>
                      </a>
                    </li>
                  </ul>


                  <a href="javascript:;" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <i class="am-icon-angle-right tpl-left-nav-more-ico1"></i>
                    <span>疾病管理</span>
                  </a>
                  <ul class="tpl-left-nav-sub-menu1" style="">
                    <li>
                      <a href="SuspectIllnessList.html" class="" style="padding-left: 80px;">
                        <span>疑似生病猪只表</span>
                      </a>
                      <a href="${pageContext.request.contextPath}/IllnessSetList/PigService/select/illSetList.do" class="" style="padding-left: 80px;">
                        <span>疾病判断参数设定表</span>
                      </a>
                      <a href="/IllnessList/PigService/select/illnessList.do" class="" style="padding-left: 80px;">
                        <span>病情记录表</span>
                      </a>
                    </li>
                  </ul>

                  <a href="Eliminate.html" class="tpl-left-nav-link-list2" style="padding-left: 72px;">
                    <span>淘汰管理</span>
                  </a>

                </li>
              </ul>

              <!--<a href="javascript:;" class="tpl-left-nav-link-list7">
                  <i class="am-icon-angle-right tpl-left-nav-more-ico7"></i>
                  <span>移栏管理</span>
              </a>-->
              <!--<ul class="tpl-left-nav-sub-menu7" style="">-->

              <!--</ul>-->

              <a href="javascript:;" class="tpl-left-nav-link-list8">
                <i class="am-icon-angle-right tpl-left-nav-more-ico8"></i>
                <span>猪舍管理</span>
              </a>
              <ul class="tpl-left-nav-sub-menu8" style="">
                <li>
                  <a href="zhushe-chart.html" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <span>猪舍环境信息</span>
                  </a>


                  <a href="zhushe-house-info.html" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <span>猪舍基本信息</span>
                  </a>

                  <a href="zhushe-minhouse-info.html" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <span>猪栏信息</span>
                  </a>
                <li>
                  <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">
                    <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>
                    <span>转栏管理</span>
                  </a>
                  <ul class="tpl-left-nav-sub-menu" style="">
                    <li>
                      <a href="CanTurnBarList.html" class="" style="padding-left: 80px;">
                        <span>可转栏猪只信息表</span>
                      </a>
                      <a href="TurnBarSetList.html" class="" style="padding-left: 80px;">
                        <span>转栏参数设定表</span>
                      </a>
                      <a href="TurnBarList.html" class="" style="padding-left: 80px;">
                        <span>转栏记录表</span>
                      </a>
                    </li>
                  </ul>


                  <a href="javascript:;" class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                    <i class="am-icon-angle-right tpl-left-nav-more-ico1 "></i>
                    <span>出栏管理</span>
                  </a>
                  <ul class="tpl-left-nav-sub-menu1" style="">
                    <li>
                      <a href="CanOutBarList.html" class="" style="padding-left: 80px;">
                        <span>可出栏猪只信息表</span>
                      </a>
                      <a href="OutBarSetList.html" class="" style="padding-left: 80px;">
                        <span>出栏参数设定表</span>
                      </a>
                      <a href="OutBarList.html" class="" style="padding-left: 80px;">
                        <span>出栏记录表</span>
                      </a>
                    </li>
                  </ul>
                </li>
                </li>
              </ul>
            </li>
          </ul>
        </li>

        <li class="tpl-left-nav-item">
          <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
            <i class="am-icon-wpforms"></i>
            <span>仓库管理</span>
            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
          </a>
          <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
            <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->

            <li>
              <a href="cangku-form-storeinformation.html">
                <span>仓库信息管理</span>
              </a>

              <a href="cangku-form-loginout.html">
                <span>出入库记录</span>
              </a>


            </li>
          </ul>
        </li>


        <li class="tpl-left-nav-item">
          <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
            <i class="am-icon-wpforms"></i>
            <span>设备管理</span>
            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>
          </a>
          <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
            <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->

            <li>
              <a href="e-control.html">
                <span>设备控制表</span>
              </a>
              <a href="shebei-table-eList.html">
                <span>设备信息管理</span>
              </a>

              <a href="e-unit_exception.html">
                <span>设备异常信息</span>
              </a>

            </li>
          </ul>
        </li>


        <li class="tpl-left-nav-item">
          <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
            <i class="am-icon-file-o"></i>
            <span>日志管理</span>
            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right "></i>

          </a>
          <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">
            <a href="login-info.html">
              <span>用户登陆记录</span>
            </a>

            <a href="operate-info.html">
              <span>用户操作记录</span>
            </a>

            <a href="sys-log.html">
              <span>系统异常记录</span>
            </a>
          </ul>
        </li>


      </ul>
    </div>
  </div>
  <div class="tpl-content-wrapper">

    <div class="tpl-content-page-title">
      智能养猪管理系统 首页
    </div>
    <ol class="am-breadcrumb">
      <li>
        <a href="#" class="am-icon-home">首页</a>
      </li>
      <li>
        <a href="#">分类</a>
      </li>
      <li class="am-active">内容</li>
    </ol>
    <div class="tpl-content-scope">
      <div class="note note-info">
        <h3>光明猪场今日信息
          <span class="close" data-close="note"></span>
        </h3>
        <p> 今日消息提醒:清各位饲养员注意，今日对xxx猪舍中的猪只进行接种。</p>
        <p><span class="label label-danger">提示:</span>对xxx猪舍，xxx猪栏中猪只进行观察，是否有异常
        </p>
      </div>
    </div>

    <div class="row">
      <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
        <div class="dashboard-stat blue">
          <div class="visual">
            <i class="am-icon-comments-o"></i>
          </div>
          <div class="details">
            <div class="number"> 49 </div>
            <div class="desc"> 新消息 </div>
          </div>
          <a class="more" href="#"> 查看更多
            <i class="m-icon-swapright m-icon-white"></i>
          </a>
        </div>
      </div>
      <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
        <div class="dashboard-stat red">
          <div class="visual">
            <i class="am-icon-bar-chart-o"></i>
          </div>
          <div class="details">
            <div class="number"> 95% </div>
            <div class="desc"> 猪只健康率 </div>
          </div>
          <a class="more" href="#"> 查看更多
            <i class="m-icon-swapright m-icon-white"></i>
          </a>
        </div>
      </div>
      <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
        <div class="dashboard-stat green">
          <div class="visual">
            <i class="am-icon-apple"></i>
          </div>
          <div class="details">
            <div class="number"> 6536 </div>
            <div class="desc"> 猪只数量 </div>
          </div>
          <a class="more" href="#"> 查看更多
            <i class="m-icon-swapright m-icon-white"></i>
          </a>
        </div>
      </div>
      <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
        <div class="dashboard-stat purple">
          <div class="visual">
            <i class="am-icon-android"></i>
          </div>
          <div class="details">
            <div class="number"> 52 </div>
            <div class="desc"> 空闲猪栏数 </div>
          </div>
          <a class="more" href="#"> 查看更多
            <i class="m-icon-swapright m-icon-white"></i>
          </a>
        </div>
      </div>

    </div>

    <div class="row">
      <div class="am-u-md-6 am-u-sm-12 row-mb">
        <div class="tpl-portlet">
          <div class="tpl-portlet-title">
            <div class="tpl-caption font-green ">
              <i class="am-icon-cloud-download"></i>
              <span> 环境信息</span>
            </div>
            <div class="actions">
              <ul class="actions-btn">
                <li class="red-on">猪舍1</li>
                <li class="green">猪舍2</li>
                <li class="blue">猪舍3</li>
                <li class='pink'>猪舍4</li>
              </ul>
            </div>
          </div>

          <!--此部分数据请在 js文件夹下中的 app.js 中的 “百度图表A” 处修改数据 插件使用的是 百度echarts-->
          <div class="tpl-echarts" id="tpl-echarts-A">

          </div>
        </div>
      </div>
      <div class="am-u-md-6 am-u-sm-12 row-mb">
        <div class="tpl-portlet">
          <div class="tpl-portlet-title">
            <div class="tpl-caption font-red ">
              <i class="am-icon-bar-chart"></i>
              <span>员工资料</span>
            </div>
            <div class="actions">
              <ul class="actions-btn">
                <li class="purple-on">昨天</li>
                <li class="green">前天</li>
                <li class="dark">本周</li>
              </ul>
            </div>
          </div>
          <div class="tpl-scrollable">
            <!--<div class="number-stats">
                <div class="stat-number am-fl am-u-md-6">
                    <div class="title am-text-right"> Total </div>
                    <div class="number am-text-right am-text-warning"> 2460 </div>
                </div>
                <div class="stat-number am-fr am-u-md-6">
                    <div class="title"> Total </div>
                    <div class="number am-text-success"> 2460 </div>
                </div>

            </div>-->

            <table class="am-table tpl-table">
              <thead>
              <tr class="tpl-table-uppercase">
                <th>人员</th>
                <th>职位</th>
                <th>工龄</th>
                <th>是否上班</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <img src="assets/img/user01.png" alt="" class="user-pic">
                  <a class="user-name" href="###">陈洪彬</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              <tr>
                <td>
                  <img src="assets/img/user02.png" alt="" class="user-pic">
                  <a class="user-name" href="###">徐斌</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              <tr>
                <td>
                  <img src="assets/img/user03.png" alt="" class="user-pic">
                  <a class="user-name" href="###">熊承杰</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              <tr>
                <td>
                  <img src="assets/img/user03.png" alt="" class="user-pic">
                  <a class="user-name" href="###">刘勇</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              <tr>
                <td>
                  <img src="assets/img/user03.png" alt="" class="user-pic">
                  <a class="user-name" href="###">姚晨</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              <tr>
                <td>
                  <img src="assets/img/user03.png" alt="" class="user-pic">
                  <a class="user-name" href="###">张三</a>
                </td>
                <td>管理员</td>
                <td>3年</td>
                <td class="font-green bold">是</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="am-u-md-6 am-u-sm-12 row-mb">

        <div class="tpl-portlet">
          <div class="tpl-portlet-title">
            <div class="tpl-caption font-green ">
              <span>指派任务</span>
              <span class="caption-helper">1 件</span>
            </div>
            <div class="tpl-portlet-input">
              <div class="portlet-input input-small input-inline">
                <div class="input-icon right">
                  <i class="am-icon-search"></i>
                  <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
              </div>
            </div>
          </div>
          <div id="wrapper" class="wrapper">
            <div id="scroller" class="scroller">
              <ul class="tpl-task-list">
                <li>
                  <div class="task-checkbox">
                    <input type="hidden" value="1" name="test">
                    <input type="checkbox" class="liChild" value="2" name="test"> </div>
                  <div class="task-title">
                    <span class="task-title-sp"> 请给6688猪栏的猪只打疫苗 </span>
                    <span class="label label-sm label-success">猪只安全部</span>
                    <span class="task-bell">
                                            <i class="am-icon-bell-o"></i>
                                        </span>
                  </div>
                  <div class="task-config">
                    <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                      <a href="###" class="am-dropdown-toggle tpl-task-list-hover " data-am-dropdown-toggle>
                        <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                      </a>
                      <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                        <li>
                          <a href="javascript:;">
                            <i class="am-icon-check"></i> 保存 </a>
                        </li>
                        <li>
                          <a href="javascript:;">
                            <i class="am-icon-pencil"></i> 编辑 </a>
                        </li>
                        <li>
                          <a href="javascript:;">
                            <i class="am-icon-trash-o"></i> 删除 </a>
                        </li>
                      </ul>

                    </div>
                  </div>
                </li>

              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="am-u-md-6 am-u-sm-12 row-mb">
        <div class="tpl-portlet">
          <div class="tpl-portlet-title">
            <div class="tpl-caption font-green ">
              <span>任务进度</span>
            </div>

          </div>

          <div class="am-tabs tpl-index-tabs" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
              <li class="am-active">
                <a href="#tab1">进行中</a>
              </li>
              <li>
                <a href="#tab2">已完成</a>
              </li>
            </ul>

            <div class="am-tabs-bd">
              <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                <div id="wrapperA" class="wrapper">
                  <div id="scroller" class="scroller">
                    <ul class="tpl-task-list tpl-task-remind">
                      <li>
                        <div class="cosB">
                          2分钟前
                        </div>
                        <div class="cosA">
                                                        <span class="cosIco">
                        <i class="am-icon-bell-o"></i>
                      </span>

                          <span>正在打疫苗！</span>
                        </div>

                      </li>

                    </ul>
                  </div>
                </div>
              </div>
              <div class="am-tab-panel am-fade" id="tab2">
                <div id="wrapperB" class="wrapper">
                  <div id="scroller" class="scroller">
                    <ul class="tpl-task-list tpl-task-remind">

                      <li>
                        <div class="cosB">
                          2小时前
                        </div>
                        <div class="cosA">
                                                        <span class="cosIco label-info">
                        <i class="am-icon-bullhorn"></i>
                      </span>
                          <span>疫苗已经全部打完！</span>
                        </div>

                      </li>
                    </ul>
                  </div>
                </div>
              </div>

            </div>
          </div>

        </div>
      </div>
    </div>

  </div>
</div>
<script src="<%=basePath%>/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>

</html>
