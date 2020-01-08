<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/1/6
  Time: 17:51
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
    <legend><a>用户信息更新</a></legend>
<div class="site-text site-block">
    <form id="userForm" name="user" method="post" action="/UserServlet?user=update" class="layui-form">

        <label class="layui-form-label">用户账号</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uId" type="text" readonly="readonly"
                   value="<%=request.getParameter("uId") %>  "/> <br/>
        </div>

        <label class="layui-form-label">用户手机号</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uPhone" type="text" id="txtUser" disable="true"
                   value="<%=request.getParameter("uPhone") %>"/><br/>
        </div>

        <label class="layui-form-label">用户姓名</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uName" type="text" id="txrPwd"
                   value="<%=request.getParameter("uName") %>"/><br/>
        </div>
        <label class="layui-form-label">用户省份</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uProvince" value="<%=request.getParameter("uProvince") %>"/><br/>
        </div>
        <label class="layui-form-label">用户城市</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uCity" value="<%=request.getParameter("uCity") %>"/><br/>
        </div>
        <label class="layui-form-label">报名状态</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uCondition" value="<%=request.getParameter("uConditionShow") %>"
                   readonly="readonly"/><br/>
        </div>
        <label class="layui-form-label">饮食服务 </label>
        <div class="layui-input-block">
            <input class="layui-input" name="uEatService" type="text" value="<%=request.getParameter("uEatServiceShow") %>"
                   readonly="readonly"/><br/>
        </div>
        <label class="layui-form-label">居住服务</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uLiveService" value="<%=request.getParameter("uLiveServiceShow") %>"
                   readonly="readonly"/><br/>
        </div>
        <label class="layui-form-label">接送服务</label>
        <div class="layui-input-block">
            <input class="layui-input" name="uTakeService" type="text" value="<%=request.getParameter("uTakeServiceShow") %>"
                   readonly="readonly"/>
            <br/>
        </div>
        <div style="margin-left:70%;margin-bottom: 30px;">
            <input class="layui-btn" type="submit" name="submit" value="提交"/>
            <a href="/UserServlet?user=search"><input class="layui-btn layui-btn-danger" type="button"
                                                      value="取消修改"/></a>
            <input class="layui-btn layui-btn-primary" type="reset" name="reset" value="重置"/>
        </div>
    </form>
</div>
</fieldset>
</body>
<script src="../../layui/layui.js"></script>
</html>
