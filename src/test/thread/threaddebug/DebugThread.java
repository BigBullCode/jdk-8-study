package test.thread.threaddebug;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/30 13:54
 */
public class DebugThread implements Runnable {

    private static AtomicInteger ai = new AtomicInteger(); //线程安全的原子计数器
    private static Map<Integer, Integer> map = new HashMap<>();


    @Override
    public void run() {
        /*Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }*/

        //测试HashMap在多线程情况下的不安全情况
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }

    }
}
