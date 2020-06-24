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
    <link rel="icon" type="image/png" href="/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="智能养猪管理系统"/>
    <link rel="stylesheet" href="/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/assets/css/admin.css">
    <link rel="stylesheet" href="/assets/css/app.css">
</head>

<body data-type="generalComponents">

<%@ include file="/head.jsp" %>

<div class="tpl-page-container tpl-page-header-fixed">

    <%@ include file="/left.jsp" %>
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
                    <span class="am-icon-code"></span> 猪只品种
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success" value="pigVariety"
                                        onclick="insertForPig(this)"><span
                                        class="am-icon-plus"></span> 添加
                                </button>
                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                        class="am-icon-save"></span> 保存
                                </button>
                                <!--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 特殊标记</button>-->
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span
                                        class="am-icon-trash-o"></span> 删除
                                </button>
                            </div>
                        </div>
                    </div>


                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <select id="search-criteria">
                                <option value="pigVarietyId">品种编号</option>
                                <option value="pigVariety">品种名称</option>

                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field" id="search-content">
                            <span class="am-input-group-btn">
                                <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                        type="button" value="pigVariety" onclick="search(this)"></button>
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
                                    <th class="table-id">品种编号</th>
                                    <th class="table-title">品种名称</th>
                                    <th>操作</th>


                                </tr>
                                </thead>
                                <!--     读取数据          -->
                                <%
                                    Map<String, List<Object>> jspMap = (Map) request.getAttribute("reqMap");
                                    List varietys = (List) jspMap.get("PigVariety");
                                    request.setAttribute("variety", varietys);
                                %>

                                <%--    分页        --%>
                                <%
                                    //只需要修改这两个参数
                                    int pageButtonNum = 5;//显示页数下标按钮的个数
                                    int pageSize = 100;//页面显示数据的条数，实际显示数量为pageSize+1，表示的应该是数据下标的位移量，由于下标是从0开始
                                    //

                                    int dataBegin = 0;//页面第一条数据的位置
                                    int dataEnd = 0;//页面最后一条数据的位置
                                    int pageTotal = 0;//总页数
                                    int pageButtonBegin = 1;//显示页数按钮的第一个按钮的数字
                                    int pageButtonAddNum = 0;//用于追加显示页面下标，每次点击按钮<<或>>都会使得相应的使页面按钮变化，如从6~10按<<变成1~5，按>>变成11~15


                                    //通过请求往map中传一下三个值以实现页面分页参数的更改
                                    if (jspMap.containsKey("dataBegin")) {
                                        dataBegin = Integer.valueOf(jspMap.get("dataBegin").get(0).toString());
                                        System.out.println("dataBegin: " + dataBegin);
                                    }
                                    if (jspMap.containsKey("pageButtonAddNum")) {
                                        pageButtonAddNum = Integer.valueOf(jspMap.get("pageButtonAddNum").get(0).toString());
                                        System.out.println("pageButtonAddNum: " + pageButtonAddNum);
                                    }
                                    if (jspMap.containsKey("pageButtonBegin")) {
                                        pageButtonBegin = Integer.valueOf(jspMap.get("pageButtonBegin").get(0).toString());
                                        System.out.println("pageButtonBegin: " + pageButtonBegin);
                                    }

                                    dataEnd = dataBegin + pageSize;//一页中最后一条数据的下标
                                    System.out.println("dataEnd: " + dataEnd);

                                    request.setAttribute("dataBegin", dataBegin);
                                    request.setAttribute("dataEnd", dataEnd);
                                    //计算显示数据所需要的页数
                                    //需要自行修改list数组名
                                    if (varietys.size() % (pageSize + 1) == 0) {
                                        pageTotal = varietys.size() / (pageSize + 1);
                                    } else {
                                        pageTotal = varietys.size() / (pageSize + 1) + 1;
                                    }
                                    System.out.println("pageTotal: " + pageTotal);
                                    //接下来的代码段在末尾
                                %>
                                <%--    分页        --%>
                                <tbody>
                                <c:forEach items="${variety}" var="v" begin="${dataBegin}" end="${dataEnd}">

                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td>${v.pigVarietyId}</td>
                                        <td>${v.pigVariety}</td>


                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <form class=""
                                                          action="/pigVarietyUpdate/PigService/select/pigVariety.do"
                                                          method="post">
                                                        <!-- 这个form不可删除，用来解决第一个form表达必跳转pigInfoList界面的玄学问题-->
                                                    </form>
                                                    <div style="float:left;">
                                                        <form class=""
                                                              action="/pigVarietyUpdate/PigService/select/pigVariety.do"
                                                              method="post">
                                                            <input type="hidden" name="pigVarietyId"
                                                                   value="${v.pigVarietyId}">
                                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                                    class="am-icon-pencil-square-o"></span>修改
                                                            </button>
                                                        </form>
                                                    </div>
                                                    <div style="float:left;">
                                                            <%--<form class="" action="/pigInfoList/PigService/delete/pigInfo.do" method="post">
                                                                <input type="hidden" name="pigNo" value="${pig.pigNo}" >
                                                               <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " onclick="deletePigInfoList()">
                                                                    <span class="am-icon-trash-o"></span>删除
                                                                </button>
                                                            </form>--%>
                                                        <button type="button" value="${v.pigVarietyId}"
                                                                onclick="deletePigVarietyList(this)"
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
                                <div class="am-fr">

                                    <%
                                        if (pageTotal < pageButtonNum) {
                                            for (int i = 1; i <= pageTotal; i++) {
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <%
                                                dataBegin = (pageSize + 1) * (i - 1);
                                            %>
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0"><%=i%>
                                            </button>

                                        </form>
                                    </li>
                                    <%
                                        }
                                    } else {
                                        pageButtonBegin += pageButtonAddNum;
                                        System.out.println("else pageButtonBegin:" + pageButtonBegin);
                                        System.out.println("else pageButtonAddNum:" + pageButtonAddNum);
                                        if (!((pageButtonBegin) == 1)) {
                                            dataBegin = (pageSize + 1) * (pageButtonBegin - 2);
                                            System.out.println("send before dataBegin:" + dataBegin);
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form>
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <input type="hidden" name="pageButtonAddNum" value="<%=-(pageButtonNum)%>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0">
                                                <<
                                            </button>
                                        </form>
                                    </li>
                                    <%
                                        }
                                        for (int i = pageButtonBegin; i < pageButtonBegin + pageButtonNum; i++) {
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <%
                                                dataBegin = (pageSize + 1) * (i - 1);
                                            %>
                                            <input type="hidden" name="dataBegin" value="<%= dataBegin %>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0"><%=i%>
                                            </button>

                                        </form>
                                    </li>
                                    <%
                                            if (i == pageTotal) {
                                                break;
                                            }
                                        }
                                        if ((pageButtonBegin + pageButtonNum) < pageTotal) {
                                            dataBegin = (pageSize + 1) * (pageButtonBegin + pageButtonNum - 1);
                                            System.out.println("send next dataBegin:" + dataBegin);
                                    %>
                                    <li class="am-active" style="float: left">
                                        <form action="/pigVarietyList/PigService/select/pigVariety.do" method="post">
                                            <input type="hidden" value="<%= dataBegin %>" name="dataBegin">
                                            <input type="hidden" name="pageButtonAddNum" value="<%=pageButtonNum%>">
                                            <input type="hidden" name="pageButtonBegin" value="<%=pageButtonBegin%>">
                                            <button type="submit"
                                                    style="color:white;background-color:#0f9ae0;border-color: #0f9ae0">
                                                >>
                                            </button>
                                        </form>
                                    </li>
                                    <%
                                            }
                                        }
                                    %>
                                    <%--<li class="am-disabled"><a href="#">«</a></li>
                                    <li class="am-active"><a href="#">1</a></li>--%>

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


<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/amazeui.min.js"></script>
<script src="/assets/js/app.js"></script>
<script src="/assets/js/common.js"></script>
</body>

</html>