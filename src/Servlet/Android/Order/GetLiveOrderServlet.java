package Servlet.Android.Order;

import Factory.DaoFactory;
import Tool.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetLiveOrderServlet", value = "/GetLiveOrderServlet")
public class GetLiveOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonUtil.ChangeStringToJsonToClient(response, DaoFactory.findLiveService().FindAllService());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
