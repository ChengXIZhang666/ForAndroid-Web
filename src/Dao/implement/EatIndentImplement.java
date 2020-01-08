package Dao.implement;

import Bean.EatIndentBean;
import Dao.EatIndentDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 饮食订单实现
 * @author: 张成灬玺
 * @create: 2020-01-05 17:34
 ***/
public class EatIndentImplement implements EatIndentDao {
    @Override
    public int addEatIndent(EatIndentBean eatIndentBean) {
        String sql = "insert into indenteat (esId,esType,esPrice,esDate)" + " values('"
                + eatIndentBean.getEsId() + "','"
                + eatIndentBean.getEsType() + "','"
                + eatIndentBean.getEsPrice() + "','"
                + eatIndentBean.getEsDate() + "')";
        LogUtil.ShowSql(sql);
        updataUserEatService(eatIndentBean);
        return DbUtil.update(sql) ? 1 : 0;
    }

    private void updataUserEatService(EatIndentBean eatIndentBean) {
        String sql = "update user set uEatService=" + 1 + " where uId=" + eatIndentBean.getEsId();
        LogUtil.ShowSql(sql);
        DbUtil.update(sql);
    }

    @Override
    public List<EatIndentBean> findAllEatIndent() {
        List<EatIndentBean> eatIndentBeanList = new ArrayList<>();
        String sql = "select * from indenteat";
        LogUtil.ShowSql(sql);
        ResultSet resultSet = DbUtil.query(sql);
        try {
            while (resultSet.next()) {
                EatIndentBean eatIndentBean = new EatIndentBean();
                eatIndentBean.setEsId(resultSet.getString("esId"));
                eatIndentBean.setEsType(resultSet.getString("esType"));
                eatIndentBean.setEsPrice(resultSet.getString("esPrice"));
                eatIndentBean.setEsDate(resultSet.getString("esDate"));
                eatIndentBean.setEsId2(resultSet.getInt("esId2"));
                eatIndentBeanList.add(eatIndentBean);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return eatIndentBeanList;
    }

    @Override
    public int deleteEatIndent(int eatId2) {
        String sql = "delete from indenteat where esId2=" + eatId2;
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }
}
