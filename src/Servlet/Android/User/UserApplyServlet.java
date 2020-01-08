package Servlet.Android.User;

import Bean.UserApplyBean;
import Factory.DaoFactory;
import Tool.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserApplyServlet", value = "/UserApplyServlet")
public class UserApplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory.getUserDaoImpl().addUserApply(JsonUtil.JsonToObject(request.getParameter("apply"), UserApplyBean.class));
        response.getWriter().print("报名成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
