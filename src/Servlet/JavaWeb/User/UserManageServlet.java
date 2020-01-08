package Servlet.JavaWeb.User;

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

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        switch (user) {
            case "search":
                String uc, ue, ul, ut;
                String sqlSearch = "select * from user";
                LogUtil.ShowSql(sqlSearch);
                ResultSet rs = null;
                rs = DbUtil.query(sqlSearch);
                StringBuffer sb = new StringBuffer();
                try {
                    while (rs != null && rs.next()) {
                        sb.append("<tr><td>");
                        sb.append(rs.getString("uId"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("uPhone"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("uName"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("uProvince"));
                        sb.append("</td><td>");
                        sb.append(rs.getString("uCity"));
                        sb.append("</td><td>");
                        if (rs.getInt("uCondition") == 1) {
                            sb.append("已报名");
                            uc = "已报名";
                        } else {
                            sb.append("未报名");
                            uc = "未报名";
                        }
//                        sb.append(rs.getString("uCondition"));
                        sb.append("</td><td>");
                        if (rs.getInt("uEatService") == 1) {
                            sb.append("已预约");
                            ue = "已预约";
                        } else {
                            sb.append("未预约");
                            ue = "未预约";
                        }
//                        sb.append(rs.getString("uEatService"));
                        sb.append("</td><td>");
                        if (rs.getInt("uLiveService") == 1) {
                            sb.append("已预约");
                            ul = "已预约";
                        } else {
                            sb.append("未预约");
                            ul = "未预约";
                        }
//                        sb.append(rs.getString("uLiveService"));
                        sb.append("</td><td>");
                        if (rs.getInt("uTakeService") == 1) {
                            sb.append("已预约");
                            ut = "已预约";
                        } else {
                            sb.append("未预约");
                            ut = "未预约";
                        }
//                        sb.append(rs.getString("uTakeService"));
                        sb.append("</td><td>");
                        sb.append("<a href ='UserServlet?user=delete&" +
                                "uId=" + rs.getInt("uId") + "'>删除</a>");
                        sb.append("&nbsp");
                        sb.append("<a href ='Manger/UserManage/UserUpdate.jsp?user=update"
                                + "&uId=" + rs.getInt("uId")
                                + "&uPhone=" + rs.getString("uPhone")
                                + "&uName=" + rs.getString("uName")
                                + "&uProvince=" + rs.getString("uProvince")
                                + "&uCity=" + rs.getString("uCity")
                                + "&uConditionShow=" + uc
                                + "&uCondition" + rs.getString("uCondition")
                                + "&uEatServiceShow=" + ue
                                + "&uEatService" + rs.getString("uEatService")
                                + "&uLiveServiceShow=" + ul
                                + "&uLiveService" + rs.getString("uLiveService")
                                + "&uTakeServiceShow=" + ut
                                + "&uTakeService" + rs.getString("uTakeService")
                                + "'>修改</a>");
                        sb.append("</td></tr>");
                    }
                    DbUtil.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("search", sb);
                request.getRequestDispatcher("Manger/UserManage/UserManage.jsp").forward(request, response);
                break;

            case "update":
                int uCondition = 0, uEatService = 0, uLiveService = 0, uTakeService = 0;
                String uId = request.getParameter("uId");
                String uPhone = request.getParameter("uPhone");
                String uName = request.getParameter("uName");
                String uProvince = request.getParameter("uProvince");
                String uCity = request.getParameter("uCity");
                if (request.getParameter("uCondition").equals("已报名")) {
                    uCondition = 1;
                }
//                String uCondition = request.getParameter("uCondition");
//                int uCondition = Integer.parseInt(request.getParameter("uCondition"));
                if (request.getParameter("uEatService").equals("已预约")) {
                    uEatService = 1;
                }
//                String uEatService = request.getParameter("uEatService");
                if (request.getParameter("uLiveService").equals("已预约")) {
                    uLiveService = 1;
                }
//                String uLiveService = request.getParameter("uLiveService");
                if (request.getParameter("uTakeService").equals("已预约")) {
                    uTakeService = 1;
                }
//                String uTakeService = request.getParameter("uTakeService");
                String sql = "update user set uPhone='" + uPhone + "',uName='" + uName + "',uProvince='" + uProvince + "',uCity='" + uCity + "',uCondition='" + uCondition + "',uEatService='" + uEatService + "',uLiveService='" + uLiveService + "',uTakeService='" + uTakeService + "' where uId='" + uId + "'";
                boolean updateresult = DbUtil.update(sql);
                if (updateresult) {
                    request.getRequestDispatcher("/UserServlet?user=search").forward(request, response);
                } else {
                    System.out.println("更新失败！");
                }
                break;

            case "delete":
                String sqldelete = "DELETE FROM user WHERE uId='" + request.getParameter("uId") + "'";
                LogUtil.ShowSql(sqldelete);
                boolean deleteresult = DbUtil.update(sqldelete);
                if (deleteresult) {
                    request.getRequestDispatcher("/UserServlet?user=search").forward(request, response);
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case "add":
                String userAddSQL = "insert into user (uId,uPhone,uName,uPassword,uProvince,uCity)" + " values('"
                        + request.getParameter("uId") + "','"
                        + request.getParameter("uPhone") + "','"
                        + request.getParameter("uName") + "','"
                        + request.getParameter("uPassword") + "','"
                        + request.getParameter("uProvince") + "','"
                        + request.getParameter("uCity") + "')";
                LogUtil.ShowSql(userAddSQL);
                if (DbUtil.update(userAddSQL)) {
                    request.getRequestDispatcher("/UserServlet?user=search").forward(request, response);
                } else {
                    System.out.println("添加新用户失败！");
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
