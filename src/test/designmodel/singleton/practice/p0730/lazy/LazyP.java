package test.designmodel.singleton.practice.p0730.lazy;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 13:36
 */
public class LazyP {
    private static LazyP INSTANCE;

    private LazyP() { //私有构造会被反射攻击,增加反射调用判断
        if (INSTANCE != null) {
            throw new RuntimeException();
        }
    }

    public static LazyP getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyP();
        }
        return INSTANCE;
    }

    public static synchronized LazyP getInstance1() {
        if (INSTANCE == null) {
            INSTANCE = new LazyP();
        }
        return INSTANCE;
    }

    /**
     * DCL，会出现指令重排序问题，需要给实例加valitle关键词
     *
     * @return
     */
    private static volatile LazyP INSTANCE1;
    public static synchronized LazyP getInstance2() {
        if (INSTANCE1 == null) {
            synchronized (LazyP.class) {
                if (INSTANCE1 == null) {
                    INSTANCE1 = new LazyP();
                }
            }
        }
        return INSTANCE1;
    }

    /**
     * 静态内部类，只在第一次需要的时候执行一次
     */
    private static class Holder {
        private static final LazyP LAZYP = new LazyP();
    }

    public static LazyP getInstance4() {
        INSTANCE1 = Holder.LAZYP;
        return INSTANCE1;
    }

    private LazyP readResovle() {
        return INSTANCE1;
    }

}
