package Dao;

import Bean.TakeBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @interface: TakeServiceDao
 * @description: 接送服务Dao
 * @author: 张成灬玺
 * @create: 2020-01-04 15:03
 ***/
public interface TakeServiceDao {
    /*
    查找接送服务信息
     */
    TakeBean FindTakeService() throws SQLException;

    /*
    查找所有的接送服务的信息
     */
    List<TakeBean> FindAllTakeService();
}
