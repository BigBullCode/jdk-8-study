package test.thread;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/3/29 17:19
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
//
//        CompletableFuture.runAsync(() -> {}).thenRun(() -> {});
//        CompletableFuture.runAsync(() -> {}).thenAccept(resultA -> {});
//        CompletableFuture.runAsync(() -> {}).thenApply(resultA -> "resultB");
//
//        CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {});
//        CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> {});
//        CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + " resultB");

        test2();
    }


    public static void test2() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 创建异步执行任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
                if(true){
                    System.out.println("test");
                }else{
                    System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                    return 1.2;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 00D;
        });
        stopWatch.split();
        System.out.println("main thread start,time->"+stopWatch.getTime() + "ms");
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        stopWatch.stop();
        System.out.println("main thread exit,time->"+stopWatch.getTime() + "ms");
    }

    public static void test4() throws Exception {
        // 创建异步执行任务，无返回值
        CompletableFuture cf = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(6000);
                if(false){
                    throw new RuntimeException("test");
                }else{
                    System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }
}
class Task1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            Thread.sleep(1000);
        }
        System.out.println("子线程计算结束");
        return sum;
    }


}
