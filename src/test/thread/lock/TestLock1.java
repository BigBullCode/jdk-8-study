package test.thread.lock;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/11 11:03
 */
public class TestLock1 {

    public synchronized void helloA() {
        System.out.println("hello");
    }

    public synchronized void helloB() {
        System.out.println("hello B");
        helloA();
    }
}
