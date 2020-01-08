package Factory;

import Dao.*;
import Dao.implement.*;

/**
 * @program: ForAndroid
 * @description: 工厂实现对象
 * @author: 张成灬玺
 * @create: 2019-12-09 22:25
 ***/
public class DaoFactory {
    /*
    创建用户dao实现实例
     */
    public static UserDao getUserDaoImpl() {
        return new UserImplement();
    }

    /*
    创建用户论文dao实现实例
     */
    public static PaperDao getPaperDaoImpl() {
        return new PaperImplement();
    }

    /*
    创建饮食服务实现实例
     */
    public static EatServiceDao findEatService() {
        return new EatServiceImplement();
    }

    /*
    创建居住服务实现实例
     */
    public static LiveServiceDao findLiveService() {
        return new LiveServiceImplement();
    }

    /*
    创建接送服务实现实例
    */
    public static TakeServiceDao findTakeService() {
        return new TakeServiceImplement();
    }

    /*
    创建饮食服务订单实现实例并更新用户该服务状态
     */
    public static EatIndentDao EatIndent() {
        return new EatIndentImplement();
    }

    /*
    创建居住服务订单实现实例并更新用户该服务状态
     */
    public static LiveIndentDao LiveIndent() {
        return new LiveIndentImplement();
    }

    /*
    创建接送服务订单实现实例并更新用户该服务状态
     */
    public static TakeIndentDao TakeIndent() {
        return new TakeIndentImplement();
    }

    /*
    获取所有的新闻
     */
    public static NewsDao FindAllNews() {
        return new NewsImplement();
    }

    ;
}
