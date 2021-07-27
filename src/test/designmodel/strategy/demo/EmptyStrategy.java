package test.designmodel.strategy.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:15
 */
public class EmptyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("当前无促销活动！");
    }
}
