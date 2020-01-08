package Dao;

import Bean.LiveIndentBean;

import java.util.List;

/**
 * @interface: LiveIndentDao
 * @description: 居住订单Dao
 * @author: 张成灬玺
 * @create: 2020-01-05 17:32
 ***/
public interface LiveIndentDao {
    /*
    建立记录
     */
    int addLiveIndent(LiveIndentBean liveIndentBean);

    /*
    返回所有的居住订单
     */
    List<LiveIndentBean> findAllLiveIndent();
}
