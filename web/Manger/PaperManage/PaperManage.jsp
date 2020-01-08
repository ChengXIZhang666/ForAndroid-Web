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
    <title>报名管理</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>论文管理</a></legend>
<table class="layui-table">
    <tr>
        <thead>
        <th>论文编号</th>
        <th>论文作者</th>
        <th>论文名称</th>
        <th>提交日期</th>
        <th>操作</th>
        </thead>
    </tr>
    <tbody>
    <%=request.getAttribute("paper") == null ? "" : request.getAttribute("paper") %>
    </tbody>
</table>
</fieldset>
</body>
</html>
