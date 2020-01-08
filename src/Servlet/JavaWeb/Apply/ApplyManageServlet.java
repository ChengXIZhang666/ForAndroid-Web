package Servlet.JavaWeb.Apply;

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

@WebServlet(name = "ApplyManageServlet",value = "/ApplyManageServlet")
public class ApplyManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applySql = "select * from apply";
        LogUtil.ShowSql(applySql);
        ResultSet rs = null;
        rs = DbUtil.query(applySql);
        StringBuffer sb = new StringBuffer();
        try {
            while (rs != null && rs.next()) {
                sb.append("<tr><td>");
                sb.append(rs.getString("aName"));
                sb.append("</td><td>");
                sb.append(rs.getString("aOrder"));
                sb.append("</td><td>");
                sb.append(rs.getString("aDate"));
                sb.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("apply", sb);
        request.getRequestDispatcher("Manger/ApplyManage/ApplyManage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
