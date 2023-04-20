package test.designmodel.work.strategy.demo;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/15 10:27
 */
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGE_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGE_MAP.put(PromotionKey.GROUP, new GroupStrategy());
        PROMOTION_STRATEGE_MAP.put(PromotionKey.JAVA, new JavaStrategy());
        PROMOTION_STRATEGE_MAP.put(PromotionKey.GOODS, new GoodsStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    /**
     * 单例私有构造
     */
    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String activityKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGE_MAP.get(activityKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    private interface PromotionKey {
        String GROUP = "group";
        String JAVA = "java";
        String GOODS = "goods";
    }
}
