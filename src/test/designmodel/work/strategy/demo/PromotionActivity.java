package test.designmodel.work.strategy.demo;
/**
 *
 * 促销活动类
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:16
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excute() {
        promotionStrategy.doPromotion();
    }
}
