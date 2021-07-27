package test.designmodel.strategy.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:13
 */
public class GoodsStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("购买商品返现！");
    }
}
