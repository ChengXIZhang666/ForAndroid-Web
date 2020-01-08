package Dao;

import Bean.EatIndentBean;

import java.util.List;

/**
 * @interface: EatIndentDao
 * @description: 饮食订单Dao
 * @author: 张成灬玺
 * @create: 2020-01-05 17:31
 ***/
public interface EatIndentDao {
    /*
    建立记录
     */
    int addEatIndent(EatIndentBean eatIndentBean);
    /*
    查找所有饮食订单
     */
    List<EatIndentBean> findAllEatIndent();
    /*
    删除某个订单
     */
    int deleteEatIndent(int eatId2);
}
