package Servlet.JavaWeb.Role;

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

@WebServlet(name = "RoleManageServlet", value = "/RoleManageServlet")
public class RoleManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        switch (role) {
            case "search":
                String roleSearchSql = "select * from manager";
                LogUtil.ShowSql(roleSearchSql);
                ResultSet rs = null;
                rs = DbUtil.query(roleSearchSql);
                StringBuffer sb = new StringBuffer();
                try {
                    while (rs != null && rs.next()) {
                        sb.append("<tr><td>");
                        sb.append(rs.getString("mId"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("mName"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("mLevel"));
                        sb.append("</td><td>");
                        sb.append("<a href ='RoleManageServlet?role=update&" +
                                "mId=" + rs.getInt("mId") + "'>修改等级</a>");
                        sb.append("</td></tr>");
                    }
                    DbUtil.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("role", sb);
                request.getRequestDispatcher("Manger/RoleManage/RoleManage.jsp").forward(request, response);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
