package Servlet.JavaWeb.Service;

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

@WebServlet(name = "ServiceManageServlet", value = "/ServiceManageServlet")
public class ServiceManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eatSql = "select * from eat";
        LogUtil.ShowSql(eatSql);
        ResultSet rs = null;
        rs = DbUtil.query(eatSql);
        StringBuffer eat = new StringBuffer();
        try {
            while (rs != null && rs.next()) {
                eat.append("<tr><td>");
                eat.append(rs.getString("eId"));
                eat.append("</td><td>");
                eat.append(rs.getString("eType"));
                eat.append("</td><td>");
                eat.append(rs.getString("ePrice"));
                eat.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("eat", eat);

        String liveSql = "select * from live";
        LogUtil.ShowSql(liveSql);
        ResultSet livers = null;
        livers = DbUtil.query(liveSql);
        StringBuffer live = new StringBuffer();
        try {
            while (livers != null && livers.next()) {
                live.append("<tr><td>");
                live.append(livers.getString("lId"));
                live.append("</td><td>");
                live.append(livers.getString("lName"));
                live.append("</td><td>");
                live.append(livers.getString("lTel"));
                live.append("</td><td>");
                live.append(livers.getString("lType"));
                live.append("</td><td>");
                live.append(livers.getString("lPrice"));
                live.append("</td><td>");
                live.append(livers.getString("lLocate"));
                live.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("live", live);

        String takeSql = "select * from take";
        LogUtil.ShowSql(takeSql);
        ResultSet takes = null;
        takes = DbUtil.query(takeSql);
        StringBuffer take = new StringBuffer();
        try {
            while (takes != null && takes.next()) {
                take.append("<tr><td>");
                take.append(takes.getString("tId"));
                take.append("</td><td>");
                take.append(takes.getString("tDate"));
                take.append("</td><td>");
                take.append(takes.getString("tLocate"));
                take.append("</td><td>");
                take.append(takes.getString("tOrder"));
                take.append("</td><td>");
                take.append(takes.getString("tPrice"));
                take.append("</td><td>");
                take.append(takes.getString("tTel"));
                take.append("</td><td>");
                take.append(takes.getString("tNum"));
                take.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("take", take);
        request.getRequestDispatcher("Manger/ServiceManage/ServiceManage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
