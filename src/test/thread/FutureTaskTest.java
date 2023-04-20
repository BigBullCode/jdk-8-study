package test.thread;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/3/29 17:12
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException {
        //第一种方式
        //        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        futureTask.run();
//        Thread thread = new Thread(futureTask);
//        String name = thread.getName();
//        System.out.println("开启callable线程的线程名称：" + name);
//        thread.start();
        futureTask.run();
        //        executor.submit(futureTask);
        //        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/
        boolean a = true;
        while (a) {
            if (futureTask.isDone()) {
                a = false;
                System.out.println("callable线程全部执行完成！！！！");
            }
            else {
                System.out.println("callable线程未执行完成，等待1s");
                Thread.sleep(1000);
            }
        }

     /*   try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + futureTask.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        System.out.println("所有任务执行完毕");
//        futureTask.cancel(futureTask.isDone());
        futureTask = null;
        return;
    }
}
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //FutureTask与线程池组合使用
        /*ThreadPoolExecutor pool = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), new ThreadFactory() {
            private final AtomicInteger integer = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "ThreadPool thread: " + integer.getAndIncrement());
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        pool.allowCoreThreadTimeOut(true);
        int sum = 0;
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            sum = sum + i;
            int sum1 = sum;
            pool.execute(() -> {
                System.out.println("sum = " + sum1);
                countDownLatch.countDown();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();*/
//        pool.shutdown();

        System.out.println("callble线程名称：" + Thread.currentThread().getName());
//        System.out.println("aaa");
////        Thread.sleep(10000);
//        System.out.println("bbb");
        return 0;
    }
}
