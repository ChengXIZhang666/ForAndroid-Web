package Servlet.JavaWeb.Paper;

import Tool.DbUtil;
import Tool.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "PaperManageServlet", value = "/PaperManageServlet")
public class PaperManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paper = request.getParameter("paper");
        switch (paper) {
            case "search":
                String newsSearchSql = "select * from paper";
                LogUtil.ShowSql(newsSearchSql);
                ResultSet rs = null;
                rs = DbUtil.query(newsSearchSql);
                StringBuffer sb = new StringBuffer();
                try {
                    while (rs != null && rs.next()) {
                        sb.append("<tr><td>");
                        sb.append(rs.getString("pId"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("pAuthor"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("pShowName"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("pDate"));
                        sb.append("</td><td>");
                        sb.append("<a href ='PaperManageServlet?paper=delete&" +
                                "pId=" + rs.getInt("pId") + "'>删除</a>");
                        sb.append("</td></tr>");
                    }
                    DbUtil.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("paper", sb);
                request.getRequestDispatcher("Manger/PaperManage/PaperManage.jsp").forward(request, response);
                break;
            case "delete":
                String paperDeleteSql = "DELETE FROM paper WHERE pId='" + request.getParameter("pId") + "'";
                LogUtil.ShowSql(paperDeleteSql);
                boolean deleteresult = DbUtil.update(paperDeleteSql);
                if (deleteresult) {
                    request.getRequestDispatcher("/PaperManageServlet?paper=search").forward(request, response);
                } else {
                    System.out.println("删除失败！");
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
