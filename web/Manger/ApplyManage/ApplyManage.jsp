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
    <legend><a>用户报名管理</a></legend>
<table class="layui-table">
    <tr>
        <thead>
        <th>报名姓名</th>
        <th>报名场次</th>
        <th>报名日期</th>
        </thead>
    </tr>
    <tbody>
    <%=request.getAttribute("apply") == null ? "" : request.getAttribute("apply") %>
    </tbody>
</table>
</fieldset>
</body>
</html>
