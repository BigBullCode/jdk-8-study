package test.thread;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 测试Unsafe的多线程工具类
 * 并发编程之美 page64
 * @Author: Zhangdongdong
 * @Date: 2020/8/19 21:29
 */
public class TestUnSafe {

    //获取unsafe的实例
    static Unsafe unsafe;

    //记录变量state在类TestUnSage中的偏移值
    static long stateOffset;
    //变量
    private volatile long state = 0;

    private volatile long state1 = 0;
    private volatile long state2 = 0;
    private volatile long state3 = 0;

    static {

        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            //获取state变量在类TestUnSafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        //创建实例，并且设置state的值为1
        boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0,1);

        System.out.println(sucess);

    }

}
