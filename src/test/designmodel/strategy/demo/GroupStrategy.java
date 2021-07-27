package test.designmodel.strategy.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:14
 */
public class GroupStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("拼团价格更优！");
    }
}
