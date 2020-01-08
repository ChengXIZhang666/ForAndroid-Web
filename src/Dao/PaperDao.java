package Dao;

import Bean.PaperBean;

/**
 * @interface: PaperDao
 * @description: 用户论文的dao
 * @author: 张成灬玺
 * @create: 2020-01-04 13:20
 ***/
public interface PaperDao {
    /*
    添加论文
     */
    int addPaper(PaperBean paperBean);
}
