package test.thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/11 14:56
 */
public class CreateThead {

    private static class Thread1 implements Callable {
        @Override
        public Object call() throws Exception {
            Thread.sleep(10000);
            return "hello world";
        }
    }

    public static void main(String[] args) throws Exception {
        FutureTask task = new FutureTask(new Thread1());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get().toString());

        Thread thread1 = new Thread(() -> {
            System.out.println("zzzzzz");
        });
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bbbbb");
            }
        }).start();

        new ExThread().start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("iiiiiii");
            }
        }.start();

    }

    private static class ExThread extends Thread {
        @Override
        public void run() {
            System.out.println("eeeeeee");
        }
    }

}
