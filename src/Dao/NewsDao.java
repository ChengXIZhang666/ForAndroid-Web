package Dao;

import Bean.NewsBean;

import java.util.List;

/**
 * @interface: NewsDao
 * @description: 新闻Dao
 * @author: 张成灬玺
 * @create: 2020-01-05 20:55
 ***/
public interface NewsDao {
    /*
    获取所有的新闻
     */
    List<NewsBean> findAllNews();
}
