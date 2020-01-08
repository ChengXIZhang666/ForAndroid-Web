package Servlet.Android.User;

import Bean.UserBean;
import Factory.DaoFactory;
import Tool.JsonUtil;
import Tool.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", value = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = null;
        user = JsonUtil.JsonToObject(request.getParameter("RegisteMessage"), UserBean.class);
        if (user != null) {
            int a = DaoFactory.getUserDaoImpl().adduser(user);
            if (a == 1) {
                LogUtil.ShowText(getServletName(), "注册成功！");
                response.getWriter().print("注册成功");
            } else {
                LogUtil.ShowText(getServletName(), "注册失败！");
                response.getWriter().print("注册失败");
            }
        } else {
            LogUtil.ShowText(getServletName(), "注册失败！");
            response.getWriter().print("注册失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
