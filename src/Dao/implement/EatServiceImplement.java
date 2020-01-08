package Dao.implement;

import Bean.EatBean;
import Dao.EatServiceDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 饮食的实现
 * @author: 张成灬玺
 * @create: 2020-01-04 15:04
 ***/
public class EatServiceImplement implements EatServiceDao {
    ResultSet resultSet = null;

    @Override
    public EatBean FindEatService() throws SQLException {
        String sql = "select * from eat where eId=" + 1;
        resultSet = DbUtil.query(sql);
        EatBean eatBean = new EatBean();
        LogUtil.ShowSql(sql);
        if (resultSet != null) {
            while (resultSet.next()) {
                eatBean.seteId(resultSet.getInt("eId"));
//                    assert eatBean != null;
//                    eatBean.seteId(id);
                eatBean.seteType(resultSet.getString("eType"));
                eatBean.setePrice(resultSet.getString("ePrice"));
            }

        }
        DbUtil.close();
        return eatBean;
    }

    @Override
    public List<EatBean> FindAllEatService() {
        String sql = "select * from eat";
        resultSet = DbUtil.query(sql);
        LogUtil.ShowSql(sql);
        List<EatBean> eatBeans = new LinkedList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    EatBean eatBean = new EatBean();
                    eatBean.seteId(resultSet.getInt("eId"));
                    eatBean.seteType(resultSet.getString("eType"));
                    eatBean.setePrice(resultSet.getString("ePrice"));
                    eatBeans.add(eatBean);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eatBeans;
    }
}
