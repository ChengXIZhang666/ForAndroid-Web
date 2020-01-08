<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/1/7
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body>

<fieldset>
    <legend><a>饮食服务</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>服务编号</th>
            <th>饮食类型</th>
            <th>服务价格</th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("eat") == null ? "" : request.getAttribute("eat") %>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <legend><a>居住服务</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>服务编号</th>
            <th>酒店名称</th>
            <th>酒店电话</th>
            <th>服务类型</th>
            <th>服务价格</th>
            <th>酒店地址</th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("live") == null ? "" : request.getAttribute("live") %>
        </tbody>
    </table>
</fieldset>

<fieldset>
    <legend><a>接送服务</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>服务编号</th>
            <th>接站日期</th>
            <th>接站地址</th>
            <th>流水班次</th>
            <th>服务价格</th>
            <th>联系电话</th>
            <th>车辆牌号</th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("take") == null ? "" : request.getAttribute("take") %>
        </tbody>
    </table>
</fieldset>

</body>
</html>
