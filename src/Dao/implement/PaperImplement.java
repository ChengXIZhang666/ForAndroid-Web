package Dao.implement;

import Bean.PaperBean;
import Dao.PaperDao;
import Tool.DbUtil;
import Tool.LogUtil;

/**
 * @program: ForAndroid
 * @description: 用户论文的实现
 * @author: 张成灬玺
 * @create: 2020-01-04 13:22
 ***/
public class PaperImplement implements PaperDao {
    @Override
    public int addPaper(PaperBean paperBean) {
        String sql = "insert into paper (" +
                "pId," +
                "pAuthor," +
                "pStoreName," +
                "pShowName," +
                "pPath," + " values('"
                + paperBean.getpId() + "','"
                + paperBean.getpAhthor() + "','"
                + paperBean.getpStoreName() + "','"
                + paperBean.getpShowName() + "','"
                + paperBean.getpPath() + "')";
        LogUtil.ShowSql(sql);
        return DbUtil.update(sql) ? 1 : 0;
    }
}
