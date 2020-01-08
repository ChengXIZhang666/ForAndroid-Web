<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/12/8
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>角色管理</a></legend>
<table class="layui-table">
    <tr>
        <thead>
        <th>管理员账号</th>
        <th>管理员姓名</th>
        <th>管理员等级</th>
        <th>操作 <a class="layui-icon layui-icon-add-1" style="font-size: 20px; color: #FFB800;"
                  href="Manger/RoleManage/RoleAdd.jsp"></a></th>
        </thead>
    </tr>
    <tbody>
    <%=request.getAttribute("role") == null ? "" : request.getAttribute("role") %>
    </tbody>
</table>
</fieldset>
</body>
</html>
