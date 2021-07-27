package test.designmodel.strategy.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:17
 */
public class MainTestDemo {

    public static void main(String[] args) {
        /*PromotionActivity groupActivity = new PromotionActivity(new GroupStrategy());
        PromotionActivity emptyActivity = new PromotionActivity(new EmptyStrategy());

        groupActivity.excute();
        emptyActivity.excute();*/

        //上面虽然展示了策略模式，但并不是真实应用场景，真实应用场景如下
        PromotionActivity activity = null;
        String activityKey = "group";
        if ("group".equals(activityKey)) {
            activity =  new PromotionActivity(new GroupStrategy());
        }
        else if ("empty".equals(activityKey)) {
            activity = new PromotionActivity(new EmptyStrategy());
        }
        activity.excute();

        //上面虽然满足策略模式的简单应用场景，但是随着业务复杂度增加，这样会显得异常臃肿，下面利用单例和工厂模式搭配策略模式
        /*
        建促销策略工厂类,可以只在工厂内扩展
         */
        PromotionActivity activity1 = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(activityKey));
        activity1.excute();
    }
}
