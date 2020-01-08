package Servlet.JavaWeb.Indent;

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

@WebServlet(name = "IndentManageServlet", value = "/IndentManageServlet")
public class IndentManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eatSql = "select * from indenteat";
        LogUtil.ShowSql(eatSql);
        ResultSet rs = null;
        rs = DbUtil.query(eatSql);
        StringBuffer eat = new StringBuffer();
        try {
            while (rs != null && rs.next()) {
                eat.append("<tr><td>");
                eat.append(rs.getString("esId"));
                eat.append("</td><td>");
                eat.append(rs.getString("esType"));
                eat.append("</td><td>");
                eat.append(rs.getString("esPrice"));
                eat.append("</td><td>");
                eat.append(rs.getString("esDate"));
                eat.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("eat", eat);

        String liveSql = "select * from indentlive";
        LogUtil.ShowSql(liveSql);
        ResultSet livers = null;
        livers = DbUtil.query(liveSql);
        StringBuffer live = new StringBuffer();
        try {
            while (livers != null && livers.next()) {
                live.append("<tr><td>");
                live.append(livers.getString("lsId"));
                live.append("</td><td>");
                live.append(livers.getString("lsInTime"));
                live.append("</td><td>");
                live.append(livers.getString("lsOutTime"));
                live.append("</td><td>");
                live.append(livers.getString("lsPrice"));
                live.append("</td><td>");
                live.append(livers.getString("lsType"));
                live.append("</td><td>");
                live.append(livers.getString("lsDate"));
                live.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("live", live);

        String takeSql = "select * from indenttake";
        LogUtil.ShowSql(takeSql);
        ResultSet takes = null;
        takes = DbUtil.query(takeSql);
        StringBuffer take = new StringBuffer();
        try {
            while (takes != null && takes.next()) {
                take.append("<tr><td>");
                take.append(takes.getString("tsId"));
                take.append("</td><td>");
                take.append(takes.getString("tsLocate"));
                take.append("</td><td>");
                take.append(takes.getString("tsPersonNumber"));
                take.append("</td><td>");
                take.append(takes.getString("tsOrder"));
                take.append("</td><td>");
                take.append(takes.getString("tsDate"));
                take.append("</td><td>");
                take.append(takes.getString("tsPrice"));
                take.append("</td><td>");
                take.append(takes.getString("tsCarNumber"));
                take.append("</td></tr>");
            }
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("take", take);
        request.getRequestDispatcher("Manger/IndentManage/IndentManage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
