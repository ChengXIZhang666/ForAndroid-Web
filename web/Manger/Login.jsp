<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/12/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>体育科学大会登录界面</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.all.js"></script>
</head>
<%--<body background="../images/ForChange/4.jpg">--%>
<body>
<div class="layui-carousel" id="test1" style="position: absolute;z-index: -2;">
    <div carousel-item>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/1.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/2.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/3.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/4.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/5.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/6.jpg"/></div>
        <div><img style="width: 100%;height: 100%;" src="../images/ForChange/7.jpg"/></div>
    </div>
</div>
<!-- 条目中可以是任意内容，如：<img src=""> -->
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , height: '100%'//高度
            , interval: '3000'//切换间隔
            , autoplay: 'true'//是否自动播放
            , indicator: 'none'//是否显示指示器
            , arrow: 'none'//是否显示箭头
            , anim: 'fade' //切换动画方式
        });
    });
</script>
<!--欢迎标题-->
<div style="
box-shadow:5px 8px 7px #363636;
margin-top: 150px;margin-left:485px;margin-right:500px;
alignment:center;
border-radius: 15px;
font-size: 30px;font-family: '微软雅黑 Light';text-align: center;
background: rgba(255,255,255,0.8);">
    <p>体育科学大会后台管理系统</p>
</div>
<form action="/MangerLoginServlet" method="post">
    <!--表单块-->
    <div style="width: 600px;
    height: 300px;
    /*margin-top: 180px;*/
    margin-top: 20px;
    margin-left: 380px;
    background: rgba(255,255,255,0.4);
    border-radius: 15px;
    box-shadow: 5px 8px 10px #363636" ;>
        <!-- 表单-->
        <div style="padding-left: 120px;padding-top: 30px;padding-right: 120px;">
            <div>
                <i class="layui-icon layui-icon-username" style="font-size: 35px;color: #ffffff"></i>
                <input type="text" name="id" id="id" required lay-verify="required" placeholder="请输入管理员账户"
                       autocomplete="off" class="layui-input" style="box-shadow: 5px 5px 5px #363636">
            </div>
            <div style="margin-top: 10px">
                <i class="layui-icon layui-icon-password" style="font-size: 35px;color: #ffffff"></i>
                <input type="password" name="password" id="password" required lay-verify="required"
                       placeholder="请输入管理员密码" autocomplete="off" class="layui-input"
                       style="box-shadow: 5px 5px 5px #363636">
            </div>
            <div style="margin-top: 30px;margin-left: 296px">
                <button type="submit" class="layui-btn layui-btn-normal" style="box-shadow: 5px 5px 5px #363636">登录
                </button>
            </div>
        </div>
    </div>
</form>
</div>
</body>
</html>

