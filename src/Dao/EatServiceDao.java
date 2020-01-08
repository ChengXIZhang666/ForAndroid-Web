package Dao;

import Bean.EatBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @interface: EatServiceDao
 * @description: 饮食dao
 * @author: 张成灬玺
 * @create: 2020-01-04 15:02
 ***/
public interface EatServiceDao {
    /*
    查找饮食服务信息
     */
    EatBean FindEatService() throws SQLException;

    /*
    查找所有的饮食服务信息
     */
    List<EatBean> FindAllEatService();
}
