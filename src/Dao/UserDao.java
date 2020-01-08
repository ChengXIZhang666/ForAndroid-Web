package Dao;

import Bean.UserApplyBean;
import Bean.UserBean;

import java.sql.SQLException;

/**
 * @interface: UserDao
 * @description: 用户dao
 * @author: 张成灬玺
 * @create: 2020-01-02 11:53
 ***/
public interface UserDao {
    /*
      用户增加
     */
    int adduser(UserBean userBean);

    /*
    用户删除
     */
    int deleteuser(UserBean userBean);

    /*
    用户修改报名状态
     */
    int updateusercondition(int change, String uId);

    /*
   用户修改服务状态
    */
    int updateuserservice(String change, String uId);

    /*
    用户查询
     */
    UserBean selectuser(String uId) throws SQLException;

    /*
    用户报名
     */
    int addUserApply(UserApplyBean userApplyBean);

    /*
    返回所有对象
     */
//    List<UserBean> findAllUser();
}
