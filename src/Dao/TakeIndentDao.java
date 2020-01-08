package Dao;

import Bean.TakeIndentBean;

import java.util.List;

/**
 * @interface: TakeIndentDao
 * @description: 接送订单Dao
 * @author: 张成灬玺
 * @create: 2020-01-05 17:33
 ***/
public interface TakeIndentDao {
    /*
    建立记录
     */
    int addTakeIndent(TakeIndentBean takeIndentBean);

    /*
    返回所有的居住的订单
     */
    List<TakeIndentBean> findAllTakeIndent();
}
