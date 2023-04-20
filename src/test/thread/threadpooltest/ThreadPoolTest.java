package test.thread.threadpooltest;
import test.staticclass.Person;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/3/30 9:28
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        int size = 1000000000;
        CountDownLatch latch = new CountDownLatch(size);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, Integer.MAX_VALUE,
                1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < size; i++) {
            int a = i;
            pool.execute(() -> {
                try {
                    Person person = null;
                    for (int j = 0; j < 100; j++) {
                        person = new Person();
                        person.setName(j + "");
                    }
//                    Thread.sleep(1000);
                    System.out.println("当前剩余线程池队列数量:" + (latch.getCount() - 1) + "; 进度：" + (size - latch.getCount() + 1)/(size/100.00) + "%");
                    latch.countDown();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
            double lastSize = Double.parseDouble(size + "");
//            System.out.println("当前剩余线程池队列数量:" + size + "; 进度：" + lastSize/10000 + "%");
        }

    }


}
