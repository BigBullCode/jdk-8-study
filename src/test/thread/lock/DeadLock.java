package test.thread.lock;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/11 15:21
 */
public class DeadLock {

    private static String a = "a";
    private static String b = "b";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread() + " get a");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get b");
                synchronized (b) {
                    System.out.println(Thread.currentThread() + "get b");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread() + " get b");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get a");
                synchronized (a) {
                    System.out.println(Thread.currentThread() + "get a");
                }
            }
        }).start();
    }
}
