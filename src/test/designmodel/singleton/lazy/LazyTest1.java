package test.designmodel.singleton.lazy;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/24 10:11
 */
public class LazyTest1 {
    private static volatile LazyTest1 instance;
    //私有无参构造

    private LazyTest1() {
        if (instance != null) {
            throw new RuntimeException("非法访问");
        }
    }

    public synchronized LazyTest1 getInstance() {
        if (instance == null) {
            synchronized (LazyTest1.class) {
                instance = new LazyTest1();
            }
        }
        return instance;
    }

   private static class Instance {
        private static final LazyTest1 instance1 = new LazyTest1();
    }

    public synchronized LazyTest1 getInstance1 () {
        /*if () { //由于静态内部类，只有当调用到时，才会只需要加载一次，因此不需要做null判断。
        }*/
        return Instance.instance1;
    }

}
