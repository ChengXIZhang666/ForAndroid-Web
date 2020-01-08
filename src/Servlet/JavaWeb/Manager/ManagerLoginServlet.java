package Servlet.JavaWeb.Manager;

import Tool.DbUtil;
import Tool.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "MangerLoginServlet", value = "/MangerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession loginsession = request.getSession();
        loginsession.setAttribute("condition", false);
        // 得到管理员登录的名字
        String mId = request.getParameter("id");
        // 得到管理员登录的密码
        String mPassword = request.getParameter("password");
        String sql = " select * from manager where mId=" + mId + " and mPassword=" + mPassword;
        try {
            ResultSet rst = DbUtil.query(sql);
            if (rst.next()) {
                String username = rst.getString("mName");
                // 请求转发至主页面
                loginsession.setAttribute("condition", true);
                loginsession.setAttribute("username", username);
                LogUtil.ShowText(getServletName(), "登录成功！");
                request.getRequestDispatcher("Manger/main.jsp").forward(request, response);
            } else {
                LogUtil.ShowText(getServletName(), "用户名或密码错误！");
                // 如果没有,那么重定向到登录界面
                response.sendRedirect("Manger/Login.jsp");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
