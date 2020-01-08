package Dao.implement;

import Bean.NewsBean;
import Dao.NewsDao;
import Tool.DbUtil;
import Tool.LogUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: ForAndroid
 * @description: 新闻dao实现
 * @author: 张成灬玺
 * @create: 2020-01-05 20:57
 ***/
public class NewsImplement implements NewsDao {
    @Override
    public List<NewsBean> findAllNews() {
        List<NewsBean> newsBeans = new LinkedList<>();
        String sql = "select * from news";
        LogUtil.ShowSql(sql);
        ResultSet resultSet = DbUtil.query(sql);
        try {
            while (resultSet.next()) {
                NewsBean newsBean = new NewsBean();
                newsBean.setnId(resultSet.getInt("nId"));
                newsBean.setnAuthor(resultSet.getString("nAuthor"));
                newsBean.setnTitle(resultSet.getString("nTitle"));
                newsBean.setnContent(resultSet.getString("nContent"));
                newsBean.setnData(resultSet.getString("nData"));
                newsBean.setnCondition(resultSet.getString("nCondition"));
                if (resultSet.getInt("nCondition") == 1) {
                    newsBeans.add(newsBean);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsBeans;
    }
}
