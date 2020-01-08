package Servlet.Android.Paper;

import Bean.PaperBean;
import Factory.DaoFactory;
import Tool.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaperServlet", value = "/PaperServlet")
public class PaperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaperBean paperBean = null;
        String paperMessage = request.getParameter("paperMessage");
        paperBean = JsonUtil.JsonToObject(paperMessage, PaperBean.class);
        if (paperBean != null) {
            int a = DaoFactory.getPaperDaoImpl().addPaper(paperBean);
            if (a > 0) {
                response.getWriter().print("论文提交成功");
            }
            response.getWriter().print("论文提交失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
