package Servlet.Android.Indent;

import Bean.EatIndentBean;
import Bean.LiveIndentBean;
import Bean.TakeIndentBean;
import Factory.DaoFactory;
import Tool.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndentServlet", value = "/IndentServlet")
public class IndentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indent = request.getParameter("indent");
        String id = request.getParameter("id");
//        int id2 = Integer.parseInt(id);
        switch (indent) {
            case "Eat":
//                EatIndentBean eatIndentBean=JsonUtil.JsonToObject(request.getParameter("message"),EatIndentBean.class)
                DaoFactory.EatIndent().addEatIndent(JsonUtil.JsonToObject(request.getParameter("message"), EatIndentBean.class));
                response.getWriter().print("饮食订单成功");
                break;
            case "Live":
                DaoFactory.LiveIndent().addLiveIndent(JsonUtil.JsonToObject(request.getParameter("message"), LiveIndentBean.class));
                response.getWriter().print("居住订单成功");
                break;
            case "Take":
                DaoFactory.TakeIndent().addTakeIndent(JsonUtil.JsonToObject(request.getParameter("message"), TakeIndentBean.class));
                response.getWriter().print("接送订单成功");
                break;
            case "GetEat":
                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.EatIndent().findAllEatIndent());
                break;
            case "GetLive":
                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.LiveIndent().findAllLiveIndent());
                break;
            case "GetTake":
                JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.TakeIndent().findAllTakeIndent());
                break;
            case "DeleteEat":
//                DaoFactory.EatIndent().deleteEatIndent(id2);
                break;
            case "DeleteLive":
                break;
            case "DeleteTake":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
