package Dao.implement;

import Bean.LiveIndentBean;
import Dao.LiveIndentDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 居住订单实现
 * @author: 张成灬玺
 * @create: 2020-01-05 17:35
 ***/
public class LiveIndentImplement implements LiveIndentDao {
    @Override
    public int addLiveIndent(LiveIndentBean liveIndentBean) {
        String sql = "insert into indentlive (lsId,lsInTime,lsOutTime,lsPrice,lsType,lsDate)" + " values('"
                + liveIndentBean.getLsId() + "','"
                + liveIndentBean.getLsInTime() + "','"
                + liveIndentBean.getLsOutTime() + "','"
                + liveIndentBean.getLsPrice() + "','"
                + liveIndentBean.getLsType() + "','"
                + liveIndentBean.getLsDate() + "')";
        LogUtil.ShowSql(sql);
        updataUserLiveService(liveIndentBean);
        return DbUtil.update(sql) ? 1 : 0;
    }

    @Override
    public List<LiveIndentBean> findAllLiveIndent() {
        List<LiveIndentBean> liveIndentBeanList = new ArrayList<>();
        String sql = "select * from indentlive";
        LogUtil.ShowSql(sql);
        ResultSet resultSet = DbUtil.query(sql);
        try {
            while (resultSet.next()) {
                LiveIndentBean liveIndentBean = new LiveIndentBean();
                liveIndentBean.setLsId(resultSet.getString("lsId"));
                liveIndentBean.setLsInTime(resultSet.getString("lsInTime"));
                liveIndentBean.setLsOutTime(resultSet.getString("lsOutTime"));
                liveIndentBean.setLsPrice(resultSet.getString("lsPrice"));
                liveIndentBean.setLsType(resultSet.getString("lsType"));
                liveIndentBean.setLsDate(resultSet.getString("lsDate"));
                liveIndentBean.setLsId2(resultSet.getInt("lsId2"));
                liveIndentBeanList.add(liveIndentBean);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return liveIndentBeanList;
    }

    private void updataUserLiveService(LiveIndentBean liveIndentBean) {
        String sql = "update user set uLiveService=" + 1 + " where uId=" + liveIndentBean.getLsId();
        LogUtil.ShowSql(sql);
        DbUtil.update(sql);
    }
}
