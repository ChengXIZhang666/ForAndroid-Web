<%@ page import="Tool.LogUtil" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/12/5
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理界面</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.js"></script>
</head>
<% boolean condition = (boolean) session.getAttribute("condition");
    LogUtil.ShowText("main.jsp", condition);
%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">体育科学大会后台管理系统</div>
        <%--        <div style="margin-left: 40%;margin-top: 30px;"><p id="hitokoto" style="font-family: '微软雅黑 Light';color: #ffffff">:D 获取中...</p></div>--%>
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../images/userimages/8.jpg" class="layui-nav-img">
                    <%=session.getAttribute("username")%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="Manger/Login.jsp">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="/UserServlet?user=search" target="main_body">用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="/RoleManageServlet?role=search" target="main_body">角色管理</a>
                    <%--                    <dl class="layui-nav-child">--%>
                    <%--                        <dd><a href="javascript:;">列表一</a></dd>--%>
                    <%--                        <dd><a href="javascript:;">列表二</a></dd>--%>
                    <%--                        <dd><a href="">超链接</a></dd>--%>
                    <%--                    </dl>--%>
                </li>
                <li class="layui-nav-item"><a href="/NewsManageServlet?news=search" target="main_body">新闻管理</a></li>
                <li class="layui-nav-item"><a href="/ApplyManageServlet" target="main_body">报名管理</a></li>
                <li class="layui-nav-item"><a href="/PaperManageServlet?paper=search" target="main_body">论文管理</a></li>
                <li class="layui-nav-item"><a href="/ServiceManageServlet" target="main_body">服务管理</a></li>
                <li class="layui-nav-item"><a href="/IndentManageServlet" target="main_body">订单管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body"
    <%--         style="padding-top: 15px;padding-right: 15px;padding-left: 15px;"--%>
    >
        <!-- 内容主体区域 -->
        <iframe src="Manger/first.jsp" style="width: 100%; height: 100%;"
                frameborder="0px"
        <%--                scrolling="no"--%>
                id="main_body" name="main_body"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <p id="hitokoto" style="font-family: '微软雅黑 Light';">:D 获取中...</p>
    </div>
</div>
<script>
    fetch('https://v1.hitokoto.cn')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            var hitokoto = document.getElementById('hitokoto');
            hitokoto.innerText = data.hitokoto;
        })
        .catch(function (err) {
            console.error(err);
        })
</script>
<script src="../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>