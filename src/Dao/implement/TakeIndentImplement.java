package Dao.implement;

import Bean.TakeIndentBean;
import Bean.TakeIndentBean;
import Dao.TakeIndentDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 接送订单实现
 * @author: 张成灬玺
 * @create: 2020-01-05 17:35
 ***/
public class TakeIndentImplement implements TakeIndentDao {
    @Override
    public int addTakeIndent(TakeIndentBean takeIndentBean) {
        String sql = "insert into indenttake (tsId,tsLocate,tsPersonNumber,tsOrder,tsDate,tsPrice,tsCarNumber)" + " values('"
                + takeIndentBean.getTsId() + "','"
                + takeIndentBean.getTsLocate() + "','"
                + takeIndentBean.getTsPersonNumber() + "','"
                + takeIndentBean.getTsOrder() + "','"
                + takeIndentBean.getTsDate() + "','"
                + takeIndentBean.getTsPrice() + "','"
                + takeIndentBean.getTsCarNumber() + "')";
        LogUtil.ShowSql(sql);
        updataUserTakeService(takeIndentBean);
        return DbUtil.update(sql) ? 1 : 0;
    }

    @Override
    public List<TakeIndentBean> findAllTakeIndent() {
        List<TakeIndentBean> takeIndentBeanList = new ArrayList<>();
        String sql = "select * from indenttake";
        LogUtil.ShowSql(sql);
        ResultSet resultSet = DbUtil.query(sql);
        try {
            while (resultSet.next()) {
                TakeIndentBean takeIndentBean = new TakeIndentBean();
                takeIndentBean.setTsId(resultSet.getString("tsId"));
                takeIndentBean.setTsLocate(resultSet.getString("tsLocate"));
                takeIndentBean.setTsPersonNumber(resultSet.getString("tsPersonNumber"));
                takeIndentBean.setTsOrder(resultSet.getString("tsOrder"));
                takeIndentBean.setTsDate(resultSet.getString("tsDate"));
                takeIndentBean.setTsPrice(resultSet.getString("tsPrice"));
                takeIndentBean.setTsCarNumber(resultSet.getString("tsCarNumber"));
                takeIndentBean.setTsId2(resultSet.getInt("tsId2"));
                takeIndentBeanList.add(takeIndentBean);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return takeIndentBeanList;
    }

    private void updataUserTakeService(TakeIndentBean takeIndentBean) {
        String sql = "update user set uTakeService=" + 1 + " where uId=" + takeIndentBean.getTsId();
        LogUtil.ShowSql(sql);
        DbUtil.update(sql);
    }

}
