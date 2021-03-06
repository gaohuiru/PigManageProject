<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
        猪场功能列表
    </div>
    <div class="tpl-left-nav-list">
        <ul class="tpl-left-nav-menu">
            <li class="tpl-left-nav-item">
                <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link">
                    <i class="am-icon-home"></i>
                    <span>首页</span>
                </a>
            </li>

            <li class="tpl-left-nav-item">
                <a  class="nav-link tpl-left-nav-link-list <c:if test="${fn:contains(result['service'],'User')}">active</c:if>">
                    <i class="am-icon-wpforms"></i>
                    <span>用户管理</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right<c:if test="${fn:contains(result['service'],'User')}">tpl-left-nav-more-ico-rotate</c:if> "></i>
                </a>
                <ul class="tpl-left-nav-sub-menu <c:if test="${fn:contains(result['service'],'User')}">am-block</c:if>">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/queryUserPurviews?operatorId=${sessionScope.id}&service=queryUserPurviews">
                            <i class="am-icon-angle-right"></i>
                            <span>权限管理</span>
                            <i class=" tpl-left-nav-content-ico am-fr am-margin-right"></i>
                        </a>
                    </li>
                    <li>
                        <c:if test="${purview.systemRights==0 }">
                            <a href="${pageContext.request.contextPath}/user/user-info-form.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>个人信息</span>
                                <i class=" tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                        </c:if>
                        <c:if test="${purview.systemRights==1}">
                            <a href="${pageContext.request.contextPath}/user/queryUsers?operatorId=${sessionScope.id}&service=queryUsers">
                                <i class="am-icon-angle-right"></i>
                                <span>用户信息</span>
                                <i class="tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                        </c:if>
                    </li>
                </ul>


            </li>


            <li class="tpl-left-nav-item">
                <!-- 打开状态 a 标签添加 active 即可   -->
                <a  class="nav-link tpl-left-nav-link-list <c:if test="${fn:contains(result['service'],'Pig')}">active</c:if>">
                    <i class="am-icon-wpforms"></i>
                    <span>猪只管理</span>
                    <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right <c:if test="${fn:contains(result['service'],'Pig')}">tpl-left-nav-more-ico-rotate</c:if>"></i>
                </a>
                <!-- 打开状态 添加 display:block-->
                <ul class="tpl-left-nav-sub-menu <c:if test="${fn:contains(result['service'],'Pig')}">am-block</c:if>" >
                    <li>
                        <a class="tpl-left-nav-link-list4 <c:if test="${fn:contains(result['service'],'Pigs')}">active</c:if>  <c:if test="${fn:contains(result['service'],'PigVarieties')}">active</c:if> ">
                            <i class="am-icon-angle-right tpl-left-nav-more-ico4"></i>
                            <span>猪只信息管理</span>
                            <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right <c:if test="${fn:contains(result['service'],'Pigs')}">tpl-left-nav-more-ico-rotate</c:if>
                            <c:if test="${fn:contains(result['service'],'PigVarieties')}">tpl-left-nav-more-ico-rotate</c:if>"></i>
                        </a>


                        <ul class="tpl-left-nav-sub-menu4 <c:if test="${fn:contains(result['service'],'Pig')}">am-block</c:if> <c:if test="${fn:contains(result['service'],'PigVarieties')}">am-block</c:if>">
                            <li>
                                <a href="${pageContext.request.contextPath}/pig/queryPigs?operatorId=${sessionScope.id}&service=queryPigs&pageNo=1&pageSize=10" class="tpl-left-nav-link-list"
                                   style="padding-left: 55px;">
                                    <span>猪只信息</span>
                                </a>

                                <a href="${pageContext.request.contextPath}/pig/queryPigVarieties?operatorId=${sessionScope.id}&service=queryPigVarieties&pageNo=1&pageSize=10"
                                   class="tpl-left-nav-link-list1" style="padding-left: 55px;">
                                    <span>猪只品种</span>
                                </a>

                            </li>
                        </ul>

                        <a  class="tpl-left-nav-link-list5"  type="button" data-am-modal="{target: '#error-alert'}">
                            <i class="am-icon-angle-right "></i>
                            <span>饲喂生长管理</span>
                        </a>
<%--                        <ul class="tpl-left-nav-sub-menu5">--%>
<%--                            <li>--%>
<%--                                <a href="/feedStandardList/PigService/select/feedStandard.do"--%>
<%--                                   class="tpl-left-nav-link-list" style="padding-left: 55px;">--%>
<%--                                    <span>饲喂设定</span>--%>
<%--                                </a>--%>


<%--                                <a href="/pigFeedList/PigService/select/pigFeed.do" class="tpl-left-nav-link-list1"--%>
<%--                                   style="padding-left: 55px;">--%>
<%--                                    <span>猪只饲喂生长统计</span>--%>
<%--                                </a>--%>

<%--                                <a href="zhuzhi-table-badGrowth.html" class="tpl-left-nav-link-list1"--%>
<%--                                   style="padding-left: 55px;">--%>
<%--                                    <span>生长状况不良猪只统计</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
                        <a class="tpl-left-nav-link-list6" type="button" data-am-modal="{target: '#error-alert'}">
                            <i class="am-icon-angle-right "></i>
                            <span>猪只安全管理</span>
                            <i class="tpl-left-nav-content-ico am-fr am-margin-right"></i>
                        </a>
<%--                        <ul class="tpl-left-nav-sub-menu6">--%>
<%--                            <li>--%>
<%--                                <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">--%>
<%--                                    <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>--%>
<%--                                    <span>疫苗接种管理</span>--%>
<%--                                </a>--%>
<%--                                <ul class="tpl-left-nav-sub-menu">--%>
<%--                                    <li>--%>
<%--                                        <a href="CanVaccinateList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>需接种猪只信息表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="/VaccinateSetList/PigService/select/vaccinateSet.do" class=""--%>
<%--                                           style="padding-left: 80px;">--%>
<%--                                            <span>疫苗接种设定表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="/VaccinateList/PigService/select/vaccinateList.do" class=" "--%>
<%--                                           style="padding-left: 80px;">--%>
<%--                                            <span>疫苗接种记录表</span>--%>
<%--                                        </a>--%>
<%--                                        </a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>


<%--                                <a href="javascript:;" class="tpl-left-nav-link-list1" style="padding-left: 55px;">--%>
<%--                                    <i class="am-icon-angle-right tpl-left-nav-more-ico1"></i>--%>
<%--                                    <span>疾病管理</span>--%>
<%--                                </a>--%>
<%--                                <ul class="tpl-left-nav-sub-menu1" style="">--%>
<%--                                    <li>--%>
<%--                                        <a href="SuspectIllnessList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>疑似生病猪只表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="${pageContext.request.contextPath}/IllnessSetList/PigService/select/illSetList.do"--%>
<%--                                           class="" style="padding-left: 80px;">--%>
<%--                                            <span>疾病判断参数设定表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="/IllnessList/PigService/select/illnessList.do" class=""--%>
<%--                                           style="padding-left: 80px;">--%>
<%--                                            <span>病情记录表</span>--%>
<%--                                        </a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>

<%--                                <a href="Eliminate.html" class="tpl-left-nav-link-list2"--%>
<%--                                   style="padding-left: 72px;">--%>
<%--                                    <span>淘汰管理</span>--%>
<%--                                </a>--%>

<%--                            </li>--%>
<%--                        </ul>--%>

                        <!--<a href="javascript:;" class="tpl-left-nav-link-list7">
                            <i class="am-icon-angle-right tpl-left-nav-more-ico7"></i>
                            <span>移栏管理</span>
                        </a>-->
                        <!--<ul class="tpl-left-nav-sub-menu7" style="">-->

                        <!--</ul>-->

                        <a href="javascript:;" class="tpl-left-nav-link-list8">
                            <i class="am-icon-angle-right tpl-left-nav-more-ico8"></i>
                            <span>猪舍管理</span>
                            <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right <c:if test="${fn:contains(result['service'],'Pigs')}">tpl-left-nav-more-ico-rotate</c:if>
                            <c:if test="${fn:contains(result['service'],'Pigsty')}">tpl-left-nav-more-ico-rotate</c:if>"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu8" style="">
                            <li>
                                <a href="zhushe-chart.html" class="tpl-left-nav-link-list"
                                   style="padding-left: 55px;">
                                    <span>猪舍环境信息</span>
                                </a>


                                <a href="zhushe-house-info.html" class="tpl-left-nav-link-list"
                                   style="padding-left: 55px;">
                                    <span>猪舍基本信息</span>
                                </a>

                                <a href="zhushe-minhouse-info.html" class="tpl-left-nav-link-list"
                                   style="padding-left: 55px;">
                                    <span>猪栏信息</span>
                                </a>
                            <li>
<%--                                <a href="javascript:;" class="tpl-left-nav-link-list" style="padding-left: 55px;">--%>
<%--                                    <i class="am-icon-angle-right tpl-left-nav-more-ico"></i>--%>
<%--                                    <span>转栏管理</span>--%>
<%--                                </a>--%>
<%--                                <ul class="tpl-left-nav-sub-menu" style="">--%>
<%--                                    <li>--%>
<%--                                        <a href="CanTurnBarList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>可转栏猪只信息表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="TurnBarSetList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>转栏参数设定表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="TurnBarList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>转栏记录表</span>--%>
<%--                                        </a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>


<%--                                <a href="javascript:;" class="tpl-left-nav-link-list1" style="padding-left: 55px;">--%>
<%--                                    <i class="am-icon-angle-right tpl-left-nav-more-ico1 "></i>--%>
<%--                                    <span>出栏管理</span>--%>
<%--                                </a>--%>
<%--                                <ul class="tpl-left-nav-sub-menu1" style="">--%>
<%--                                    <li>--%>
<%--                                        <a href="CanOutBarList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>可出栏猪只信息表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="OutBarSetList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>出栏参数设定表</span>--%>
<%--                                        </a>--%>
<%--                                        <a href="OutBarList.html" class="" style="padding-left: 80px;">--%>
<%--                                            <span>出栏记录表</span>--%>
<%--                                        </a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
                            </li>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>

            <li class="tpl-left-nav-item">
                <a  class="nav-link tpl-left-nav-link-list" type="button" data-am-modal="{target: '#error-alert'}">
                    <i class="am-icon-wpforms"></i>
                    <span>仓库管理</span>
                    <i class="am-icon-angle-right am-fr am-margin-right "></i>
                </a>
<%--                <ul class="tpl-left-nav-sub-menu" style="padding-left: 17px;">--%>
<%--                    <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->--%>

<%--                    <li>--%>
<%--                        <a href="cangku-form-storeinformation.html">--%>
<%--                            <span>仓库信息管理</span>--%>
<%--                        </a>--%>

<%--                        <a href="cangku-form-loginout.html">--%>
<%--                            <span>出入库记录</span>--%>
<%--                        </a>--%>


<%--                    </li>--%>
<%--                </ul>--%>
            </li>

            <div class="am-modal am-modal-alert" tabindex="-1" id="error-alert">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">页面维护中</div>
                    <div class="am-modal-bd">
                        抱歉！该模块页面正在进行维护！
                    </div>
                    <div class="am-modal-footer">
                        <span class="am-modal-btn">确定</span>
                    </div>
                </div>
            </div>
            <li class="tpl-left-nav-item">
                <a  class="nav-link tpl-left-nav-link-list " type="button" data-am-modal="{target: '#error-alert'}">
                    <i class="am-icon-wpforms"></i>
                    <span>设备管理</span>
                    <i class="am-icon-angle-right  am-fr am-margin-right  "></i>
                </a>
<%--                <ul class="tpl-left-nav-sub-menu " style="padding-left: 17px;">--%>
<%--                    <!--{% comment %} style="display: block;"  打开 {% endcomment %}  -->--%>

<%--                    <li>--%>
<%--                        <a href="e-control.html">--%>
<%--                            <span>设备控制表</span>--%>
<%--                        </a>--%>
<%--                        <a href="shebei-table-eList.html">--%>
<%--                            <span>设备信息管理</span>--%>
<%--                        </a>--%>

<%--                        <a href="e-unit_exception.html">--%>
<%--                            <span>设备异常信息</span>--%>
<%--                        </a>--%>

<%--                    </li>--%>
<%--                </ul>--%>
            </li>


            <li class="tpl-left-nav-item">
                <!-- 打开状态 a 标签添加 active 即可 选中状态  -->
                <a  class="nav-link tpl-left-nav-link-list <c:if test="${fn:contains(result['service'],'Log')}">active</c:if>">
                    <i class="am-icon-file-o"></i>
                    <span>日志管理</span>
                    <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right <c:if test="${fn:contains(result['service'],'Log')}">tpl-left-nav-more-ico-rotate</c:if>"></i>

                </a>
                <!-- 打开状态 添加 display:block-->
                <ul class="tpl-left-nav-sub-menu <c:if test="${fn:contains(result['service'],'Log')}">am-block</c:if>" style="padding-left: 17px;" >
                    <a href="${pageContext.request.contextPath}/log/queryLoginLogs?operatorId=${sessionScope.id}&service=queryLoginLogs&pageNo=1&pageSize=10">
                        <span>用户登陆日志</span>
                    </a>

                    <a href="${pageContext.request.contextPath}/log/queryOperationLogs?operatorId=${sessionScope.id}&service=queryOperationLogs&pageNo=1&pageSize=10">
                        <span>用户操作日志</span>
                    </a>

                    <a href="${pageContext.request.contextPath}/log/queryErrorLogs?operatorId=${sessionScope.id}&service=queryErrorLogs&pageNo=1&pageSize=10">
                        <span>系统异常日志</span>
                    </a>
                </ul>
            </li>



        </ul>
    </div>
</div>
