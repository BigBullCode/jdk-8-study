package test.thread;

/** 线程本地变量
 * @Author: Zhangdongdong
 * @Date: 2020/9/9 21:37
 */
public class ThreadLocalTest {

    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    public static ThreadLocal<String> inLocal = new InheritableThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
//        localVariable.remove();
    }

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("父线程线程本地变量" + inLocal.get());
                localVariable.set("线程1本地参数");
                print("线程1");
               System.out.println("线程1移除后" + localVariable.get());
            }
        });

        /*Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(inLocal.get());
                localVariable.set("线程2本地参数");
                print("线程2");
                System.out.println("线程2移除后" + localVariable.get());
            }
        });*/

        threadOne.start();
//        threadTwo.start();
        inLocal.set("主线程本地变量");
        System.out.println("主线程本地变量:" + inLocal.get());
//        print("主线程本地参数" + localVariable.get());
    }

}
