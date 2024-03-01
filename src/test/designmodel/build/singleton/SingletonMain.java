package test.designmodel.build.singleton;
import test.designmodel.build.singleton.hungry.HungrySinleton;
import test.designmodel.build.singleton.lazy.LazySimpleSingleton;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/29 15:58
 */
public class SingletonMain {

    public static void main(String[] args) {
//        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始1");
                System.out.println(LazySimpleSingleton.getInstance());
                System.out.println("完成1");
            }
        }, "线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始2");
                System.out.println(LazySimpleSingleton.getInstance());
                System.out.println("完成2");
            }
        }, "线程2").start();
    }
}
