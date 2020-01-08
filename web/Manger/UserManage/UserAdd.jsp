<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/1/6
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>添加新用户</a></legend>
    <div class="site-text site-block">
        <form id="userForm" name="user" method="post" action="/UserServlet?user=add" class="layui-form">

            <label class="layui-form-label">用户账号</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uId" type="text"/> <br/>
            </div>

            <label class="layui-form-label">用户手机号</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uPhone" type="text"/><br/>
            </div>

            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uPhone" type="text"/><br/>
            </div>

            <label class="layui-form-label">用户姓名</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uName" type="text"/><br/>
            </div>
            <label class="layui-form-label">用户省份</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uProvince" type="text"/><br/>
            </div>
            <label class="layui-form-label">用户城市</label>
            <div class="layui-input-block">
                <input class="layui-input" name="uCity" type="text"/><br/>
            </div>
            <div style="margin-left:70%;margin-bottom: 30px;">
                <input class="layui-btn" type="submit" name="submit" value="提交"/>
                <a href="/UserServlet?user=search"><input class="layui-btn layui-btn-danger" type="button"
                                                          value="取消添加"/></a>
                <input class="layui-btn layui-btn-primary" type="reset" name="reset" value="重置"/>
            </div>
        </form>
    </div>
</fieldset>
</body>
</html>
