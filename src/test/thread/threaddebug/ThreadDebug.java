package test.thread.threaddebug;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/30 13:53
 */
public class ThreadDebug {

    public static void main(String[] args) {
        DebugThread myRunnable = new DebugThread();
        Thread thread1 = new Thread(myRunnable, "线程1");
        Thread thread2 = new Thread(myRunnable, "线程2");
        Thread thread3 = new Thread(myRunnable, "线程3");
        Thread thread4 = new Thread(myRunnable, "线程4");
        Thread thread5 = new Thread(myRunnable, "线程5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
