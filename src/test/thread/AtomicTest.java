package test.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 多线程下使用原子变量进行0数字统计，高并发下会造成大量线程为竞争更新同一个原子变量而自选尝试CAS，浪费CPU资源
 * @Author: Zhangdongdong
 * @Date: 2020/9/10 14:15
 */
public class AtomicTest {

    //创建Long型原子计数器
    private static AtomicLong atomicLong = new AtomicLong();

    //创建数据源
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,4,5,6,0,45,0,1};
    private static Integer[] arrayTwo = new Integer[]{7,8,9,78,0,1,11,111};

    public static void main(String[] args) throws InterruptedException {
        //使用线程one来统计数组one中0的个体数
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayOne[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayTwo[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(atomicLong.get());
    }
}
