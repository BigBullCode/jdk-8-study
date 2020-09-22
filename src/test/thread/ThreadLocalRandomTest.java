package test.thread;

import java.util.Random;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/9/10 10:32
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        //创建一个默认种子的随机数生成器
        Random random = new Random();
        //输出10个在0~5不包含5的随机数
        for (int i = 0; i < 10; i++) {
            //在执行nextInt方法时，多线程并发执行下会因为CAS操作导致性能降低
            System.out.println(random.nextInt(5));
        }
    }
}
