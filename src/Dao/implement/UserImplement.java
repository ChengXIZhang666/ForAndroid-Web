package Dao.implement;

import Bean.UserApplyBean;
import Bean.UserBean;
import Dao.UserDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: ForAndroid
 * @description: 用户接口的实现
 * @author: 张成灬玺
 * @create: 2020-01-02 12:02
 ***/
public class UserImplement implements UserDao {
    /*
    添加用户
     */
    @Override
    public int adduser(UserBean userBean) {
        String sql = "insert into user (uId,uPhone,uName,uPassword,uProvince,uCity,uCondition,uEatService,uLiveService,uTakeService)" + " values('"
                + userBean.getuId() + "','"
                + userBean.getuPhone() + "','"
                + userBean.getuName() + "','"
                + userBean.getuPassword() + "','"
                + userBean.getuProvince() + "','"
                + userBean.getuCity() + "','"
                + userBean.getuCondition() + "','"
                + userBean.getuEatService() + "','"
                + userBean.getuLiveService() + "','"
                + userBean.getuTakeService() + "')";
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }

    /*
    删除用户
     */
    @Override
    public int deleteuser(UserBean userBean) {
        String sql = "delete from user where uId=" + userBean.getuId();
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }

    /*
    更新报名状态
     */
    @Override
    public int updateusercondition(int change, String uId) {
        String sql = "update user set uCondition = " + change + " where uId = " + uId;
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }

    /*
    更新服务
     */
    @Override
    public int updateuserservice(String change, String uId) {
        String sql = "update user set uCondition=" + change + "where uId=" + uId;
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }

    /*
    根据，uId查找一个用户
     */
    @Override
    public UserBean selectuser(String uId) throws SQLException {
        String sql = "select * from user where uId=" + uId;
        LogUtil.ShowSql(sql);
        ResultSet rst = DbUtil.query(sql);
        UserBean userBean = new UserBean();
        if (rst.next()) {
            userBean.setuId(rst.getString("uId"));
            userBean.setuPhone(rst.getString("uPhone"));
            userBean.setuName(rst.getString("uName"));
            userBean.setuProvince(rst.getString("uProvince"));
            userBean.setuCity(rst.getString("uCity"));
            userBean.setuCondition(rst.getInt("uCondition"));
            userBean.setuEatService(rst.getInt("uEatService"));
            userBean.setuLiveService(rst.getInt("uLiveService"));
            userBean.setuTakeService(rst.getInt("uTakeService"));
        }
        return userBean;
    }

    /*
    添加用户报名
     */
    @Override
    public int addUserApply(UserApplyBean userApplyBean) {
        String sql = "insert into apply (aId,aName,aOrder,aDate,uId)" + " values('"
                + userApplyBean.getaId() + "','"
                + userApplyBean.getaName() + "','"
                + userApplyBean.getaOrder() + "','"
                + userApplyBean.getaDate() + "','"
                + userApplyBean.getuId() + "')";
        LogUtil.ShowSql(sql);
        updateusercondition(1, userApplyBean.getuId());
        return DbUtil.update(sql) ? 1 : 0;
    }
}
