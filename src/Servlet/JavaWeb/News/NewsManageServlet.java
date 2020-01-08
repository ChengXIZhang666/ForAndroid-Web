package Servlet.JavaWeb.News;

import Tool.DateUtil;
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

@WebServlet(name = "NewsManageServlet", value = "/NewsManageServlet")
public class NewsManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String news = request.getParameter("news");
        switch (news) {
            case "search":
                String newsSearchSql = "select * from news";
                LogUtil.ShowSql(newsSearchSql);
                ResultSet rs = null;
                rs = DbUtil.query(newsSearchSql);
                StringBuffer sb = new StringBuffer();
                try {
                    while (rs != null && rs.next()) {
                        sb.append("<tr><td>");
                        sb.append(rs.getString("nId"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("nAuthor"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("nTitle"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("nContent"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("nData"));
                        sb.append("</td><td>");
                        if (rs.getInt("nCondition") == 1) {
                            sb.append("已发布");
                        } else {
                            sb.append("未发布");
                        }
//                        sb.append(rs.getString("nCondition"));
                        sb.append("</td><td>");
                        sb.append("<a href ='NewsManageServlet?news=delete&" +
                                "nId=" + rs.getInt("nId") + "'>删除</a>");
                        sb.append("&nbsp");
                        if (rs.getInt("nCondition") == 1) {
                            sb.append("<a href ='NewsManageServlet?news=update&" + "nCondition=0" +
                                    "&nId=" + rs.getInt("nId") + "'>取消发布</a>");
                        } else {
                            sb.append("<a href ='NewsManageServlet?news=update&" + "nCondition=1" +
                                    "&nId=" + rs.getInt("nId") + "'>发布</a>");
                        }
                        sb.append("</td></tr>");

                    }
                    DbUtil.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("news", sb);
                request.getRequestDispatcher("Manger/NewsManage/NewsManage.jsp").forward(request, response);
                break;
            case "add":
                String newsAddSQL = "insert into news (nAuthor,nTitle,nContent,nData)" + " values('"
//                        + request.getParameter("nId") + "','"
                        + request.getParameter("nAuthor") + "','"
                        + request.getParameter("nTitle") + "','"
                        + request.getParameter("nContent") + "','"
                        + DateUtil.getDate() + "')";
                LogUtil.ShowSql(newsAddSQL);
                if (DbUtil.update(newsAddSQL)) {
                    request.getRequestDispatcher("/NewsManageServlet?news=search").forward(request, response);
                } else {
                    System.out.println("添加新新闻失败！");
                }
                break;
            case "delete":
                String newsDeteleSql = "DELETE FROM news WHERE nId='" + request.getParameter("nId") + "'";
                LogUtil.ShowSql(newsDeteleSql);
                boolean deleteresult = DbUtil.update(newsDeteleSql);
                if (deleteresult) {
                    request.getRequestDispatcher("/NewsManageServlet?news=search").forward(request, response);
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case "update":
                String newsUpdateSql = "UPDATE news SET nCondition=" + request.getParameter("nCondition") + " where nId=" + request.getParameter("nId");
                boolean updateresult = DbUtil.update(newsUpdateSql);
                if (updateresult) {
                    request.getRequestDispatcher("/NewsManageServlet?news=search").forward(request, response);
                } else {
                    System.out.println("更新失败！");
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
