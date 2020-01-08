package Dao;

import Bean.LiveBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @interface: LiveServiceDao
 * @description: 居住服务Dao
 * @author: 张成灬玺
 * @create: 2020-01-04 15:03
 ***/
public interface LiveServiceDao {
    /*
    查找居住服务信息
     */
    LiveBean FindLiveService() throws SQLException;

    /*
    查找所有的居住服务信息
     */
    List<LiveBean> FindAllService();
}
