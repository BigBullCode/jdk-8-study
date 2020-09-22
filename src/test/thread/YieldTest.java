package test.thread;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/9/9 21:23
 */
public class YieldTest {

    public static void main(String[] args) {
        new YieldTest1();
        new YieldTest1();
    }
}

class YieldTest1 implements Runnable {

    YieldTest1() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i%5 == 0) {
                System.out.println(Thread.currentThread() + "yield cpu ...");

                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }
}