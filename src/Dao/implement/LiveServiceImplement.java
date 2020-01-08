package Dao.implement;

import Bean.LiveBean;
import Dao.LiveServiceDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 居住服务实现
 * @author: 张成灬玺
 * @create: 2020-01-04 15:05
 ***/
public class LiveServiceImplement implements LiveServiceDao {
    ResultSet resultSet = null;
    private int id = 1;

    @Override
    public LiveBean FindLiveService() throws SQLException {
        String sql = "select * from live where lId=" + id;
        resultSet = DbUtil.query(sql);
        LiveBean liveBean = new LiveBean();
        LogUtil.ShowSql(sql);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    liveBean.setlId(resultSet.getInt("lId"));
//                assert liveBean != null;
//                liveBean.setlId(id);
                    liveBean.setlName(resultSet.getString("lName"));
                    liveBean.setlTel(resultSet.getString("lTel"));
                    liveBean.setlType(resultSet.getString("lType"));
                    liveBean.setlPrice(resultSet.getString("lPrice"));
                    liveBean.setlLocate(resultSet.getString("lLocate"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DbUtil.close();
        return liveBean;
    }

    @Override
    public List<LiveBean> FindAllService() {
        String sql = "select * from live";
        resultSet = DbUtil.query(sql);
        LogUtil.ShowSql(sql);
        List<LiveBean> liveBeans = new LinkedList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    LiveBean liveBean = new LiveBean();
                    liveBean.setlId(resultSet.getInt("lId"));
                    liveBean.setlName(resultSet.getString("lName"));
                    liveBean.setlTel(resultSet.getString("lTel"));
                    liveBean.setlType(resultSet.getString("lType"));
                    liveBean.setlPrice(resultSet.getString("lPrice"));
                    liveBean.setlLocate(resultSet.getString("lLocate"));
                    liveBeans.add(liveBean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return liveBeans;
    }
}
