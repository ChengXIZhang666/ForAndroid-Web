package Dao.implement;

import Bean.TakeBean;
import Dao.TakeServiceDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 接送服务实现
 * @author: 张成灬玺
 * @create: 2020-01-04 15:05
 ***/
public class TakeServiceImplement implements TakeServiceDao {
    ResultSet resultSet = null;
    private int id = 1;

    @Override
    public TakeBean FindTakeService() throws SQLException {
        String sql = "select * from take where tId=" + id;
        resultSet = DbUtil.query(sql);
        TakeBean takeBean = new TakeBean();
        LogUtil.ShowSql(sql);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    takeBean.settId(resultSet.getInt("tId"));
//                    takeBean.settId(id);
                    takeBean.settDate(resultSet.getString("tDate"));
                    takeBean.settLocate(resultSet.getString("tLocate"));
                    takeBean.settOrder(resultSet.getString("tOrder"));
                    takeBean.settPrice(resultSet.getString("tPrice"));
                    takeBean.settTel(resultSet.getString("tTel"));
                    takeBean.settNum(resultSet.getString("tNum"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return takeBean;
    }

    @Override
    public List<TakeBean> FindAllTakeService() {
        String sql = "select * from take";
        resultSet = DbUtil.query(sql);
        LogUtil.ShowSql(sql);
        List<TakeBean> takeBeans = new LinkedList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    TakeBean takeBean = new TakeBean();
                    takeBean.settId(resultSet.getInt("tId"));
                    takeBean.settDate(resultSet.getString("tDate"));
                    takeBean.settLocate(resultSet.getString("tLocate"));
                    takeBean.settOrder(resultSet.getString("tOrder"));
                    takeBean.settPrice(resultSet.getString("tPrice"));
                    takeBean.settTel(resultSet.getString("tTel"));
                    takeBean.settNum(resultSet.getString("tNum"));
                    takeBeans.add(takeBean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return takeBeans;
    }
}
