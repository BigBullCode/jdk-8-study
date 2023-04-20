package test.designmodel.work.strategy.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:12
 */
public class JavaStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程打五折！");
    }
}
