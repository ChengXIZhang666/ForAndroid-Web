<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/12/8
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>新闻管理</a></legend>
<table class="layui-table">
    <tr>
        <colgroup>
            <col width="10%">
            <col width="10%">
            <col width="20%">
            <col width="20%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
        </colgroup>
        <thead>
        <th>新闻编号</th>
        <th>新闻作者</th>
        <th>新闻标题</th>
        <th>新闻内容</th>
        <th>新闻日期</th>
        <th>发布状态</th>
        <th>操作 <a class="layui-icon layui-icon-add-1" style="font-size: 20px; color: #FFB800;"
                  href="Manger/NewsManage/NewsAdd.jsp"></a></th>
        </thead>
    </tr>
    <tbody>
    <%=request.getAttribute("news") == null ? "" : request.getAttribute("news") %>
    </tbody>
</table>
</fieldset>
</body>
</html>
