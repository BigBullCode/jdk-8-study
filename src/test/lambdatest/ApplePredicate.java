package test.lambdatest;

/**
 * 方法行为参数化之统一过滤接口
 * @Author: Zhangdongdong
 * @Date: 2020/10/29 20:21
 */
public interface ApplePredicate<T> {

    /**
     * 产品类型抽象化
     * @param t
     * @return
     */
//    boolean test(T t);
    //选择行为建模-苹果产品簇
    boolean test(Apple t);
}
