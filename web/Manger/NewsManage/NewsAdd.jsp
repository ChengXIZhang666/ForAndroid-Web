<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/1/7
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<fieldset>
    <legend><a>添加新用户</a></legend>
    <div class="site-text site-block">
        <form id="userForm" name="user" method="post" action="/NewsManageServlet?news=add" class="layui-form">

<%--            <label class="layui-form-label">新闻编号</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input class="layui-input" name="nId" type="text"/> <br/>--%>
<%--            </div>--%>

            <label class="layui-form-label">新闻作者</label>
            <div class="layui-input-block">
                <input class="layui-input" name="nAuthor" type="text"/> <br/>
            </div>

            <label class="layui-form-label">新闻标题</label>
            <div class="layui-input-block">
                <input class="layui-input" name="nTitle" type="text"/><br/>
            </div>

            <label class="layui-form-label">新闻内容</label>
            <div class="layui-input-block">
                <input class="layui-input" name="nContent" type="text"/><br/>
            </div>
            <div style="margin-left:70%;margin-bottom: 30px;">
                <input class="layui-btn" type="submit" name="submit" value="提交"/>
                <a href="/NewsManageServlet?news=search"><input class="layui-btn layui-btn-danger" type="button"
                                                          value="取消添加"/></a>
                <input class="layui-btn layui-btn-primary" type="reset" name="reset" value="重置"/>
            </div>
        </form>
    </div>
</fieldset>
</body>
</html>
