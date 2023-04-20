package test.designmodel.build.singleton.practice.p0730.lazy;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 13:59
 */
public class ThreadLocalP {

    private static final ThreadLocal<ThreadLocalP> INSTANCE = new ThreadLocal<ThreadLocalP>() {
        @Override
        protected ThreadLocalP initialValue() {
            return new ThreadLocalP();
        }
    };

    private ThreadLocalP() {

    }

    public static ThreadLocalP getInstance() {
        return INSTANCE.get();
    }
}
