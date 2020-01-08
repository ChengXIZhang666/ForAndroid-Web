package Servlet.Android.User;

import Bean.UserBean;
import Factory.DaoFactory;
import Tool.DbUtil;
import Tool.JsonUtil;
import Tool.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernumber = request.getParameter("usernumber");
        String userpassord = request.getParameter("userpassword");
        String sql = "select * from user where uId=" + usernumber + " and uPassword=" + userpassord;
        try {
            ResultSet rst = DbUtil.query(sql);
            if (rst.next()) {
                LogUtil.ShowText(getServletName(), "登录成功！");
//                UserBean userBean = new UserBean();
//                userBean.setuId(rst.getString("uId"));
//                userBean.setuPhone(rst.getString("uPhone"));
//                userBean.setuName(rst.getString("uName"));
//                userBean.setuProvince(rst.getString("uProvince"));
//                userBean.setuCity(rst.getString("uCity"));
//                userBean.setuCondition(rst.getString("uCondition"));
//                userBean.setuService(rst.getString("uService"));
                UserBean userBean = DaoFactory.getUserDaoImpl().selectuser(usernumber);
                JsonUtil.ChangeStringToJsonToClient(response, userBean);
//                response.getWriter().print("登录成功");
            } else {
                LogUtil.ShowText(getServletName(), "用户名或密码错误！");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
