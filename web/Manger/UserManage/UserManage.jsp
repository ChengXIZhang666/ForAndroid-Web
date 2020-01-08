<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>用户管理</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>用户账号</th>
            <th>手机号码</th>
            <th>用户姓名</th>
            <th>用户省份</th>
            <th>用户城市</th>
            <th>用户大会报名状态</th>
            <th>饮食服务预订情况</th>
            <th>居住服务预订情况</th>
            <th>接送服务预订情况</th>
            <th>操作 <a class="layui-icon layui-icon-add-1" style="font-size: 20px; color: #FFB800;"
                      href="Manger/UserManage/UserAdd.jsp"></a></th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("search") == null ? "" : request.getAttribute("search") %>
        </tbody>
    </table>
</fieldset>
</body>
</html>