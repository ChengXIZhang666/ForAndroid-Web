package Tool;

/**
 * @program: ForAndroid
 * @description: 用来与数据库连接
 * @author: 张成灬玺
 * @create: 2019-12-09 21:07
 ***/

import java.sql.*;

/**
 * 封装数据库操作
 */
public class DbUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/android?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
    //设置编码&自动重建连接（避免connection的closed异常）
    private static String username = "root";
    private static String password = "123456";//张成玺
    public static Connection conn = null;
    public static Statement stm = null;
    public static ResultSet rs = null;

    //创建连接
    public static boolean createConn() {
        boolean b = false;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null)
                LogUtil.ShowOne("数据库链接成功！");
            b = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 获取连接
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    public static boolean update(String sql) {
        boolean b = false;
        try {
            while (conn == null) {
                createConn();
            }
            stm = conn.createStatement();
            stm.executeUpdate(sql);
            b = true;
            close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    public static ResultSet query(String sql) {
        try {
            while (conn == null) {
                createConn();
            }
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    //判断有无数据
    public boolean next() {
        boolean b = false;
        try {
            if (rs != null && rs.next()) {
                b = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    //获取表字段值
    public String getValue(String field) {
        String value = null;
        try {
            if (rs != null) {
                value = rs.getString(field);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }

    public static void close() {
        closeRs();
        closeStm();
        closeConn();
    }

    //关闭连接
    public static void closeConn() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //关闭statement
    public static void closeStm() {
        try {
            if (stm != null) {
                stm.close();
                stm = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //关闭ResultSet
    public static void closeRs() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
