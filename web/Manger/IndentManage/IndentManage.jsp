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
    <legend><a>饮食订单</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>订单编号</th>
            <th>饮食类型</th>
            <th>服务价格</th>
            <th>下单日期</th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("eat") == null ? "" : request.getAttribute("eat") %>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <legend><a>居住订单</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>订单编号</th>
            <th>入住时间</th>
            <th>退房时间</th>
            <th>服务价格</th>
            <th>房间类型</th>
            <th>下单时间</th>
            </thead>
        </tr>
        <tbody>
        <%=request.getAttribute("live") == null ? "" : request.getAttribute("live") %>
        </tbody>
    </table>
</fieldset>

<fieldset>
    <legend><a>接送订单</a></legend>
    <table class="layui-table">
        <tr>
            <thead>
            <th>订单编号</th>
            <th>接站地址</th>
            <th>联系电话</th>
            <th>流水班次</th>
            <th>下单日期</th>
            <th>服务价格</th>
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
