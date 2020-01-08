package Servlet.Android.Order;

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
import java.sql.SQLException;

@WebServlet(name = "SelectServiceServlet", value = "/SelectServiceServlet")
public class SelectServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uId = request.getParameter("uId");
        switch (request.getParameter("message")) {
            case "Eat":
//                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findEatService().FindAllEatService());
                try {
                    JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findEatService().FindEatService());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Live":
//                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findLiveService().FindAllService());
                try {
                    JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findLiveService().FindLiveService());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Take":
//                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findTakeService().FindAllTakeService());
                try {
                    JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findTakeService().FindTakeService());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "EatOrder":
                String sqlEat = "update user set uEatService=" + 1 + " where uId=" + uId;
//        ResultSet rst = DbUtil.query(sql);
                //            if (rst.next()) {
                if (DbUtil.update(sqlEat)) {
                    LogUtil.ShowText(getServletName(), "饮食服务更改成功！");
                    response.getWriter().print("成功");
                } else {
                    response.getWriter().print("失败");
                }
                break;
            case "LiveOrder":
                String sqlLive = "update user set uLiveService=" + 1 + " where uId=" + uId;
//        ResultSet rst = DbUtil.query(sql);
                //            if (rst.next()) {
                if (DbUtil.update(sqlLive)) {
                    LogUtil.ShowText(getServletName(), "居住服务更改成功！");
                    response.getWriter().print("成功");
                } else {
                    response.getWriter().print("失败");
                }
                break;
            case "TakeOrder":
                String sqlTake = "update user set uTakeService=" + 1 + " where uId=" + uId;
//        ResultSet rst = DbUtil.query(sql);
                //            if (rst.next()) {
                if (DbUtil.update(sqlTake)) {
                    LogUtil.ShowText(getServletName(), "接送服务更改成功！");
                    response.getWriter().print("成功");
                } else {
                    response.getWriter().print("失败");
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
