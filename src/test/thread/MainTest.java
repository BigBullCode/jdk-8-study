package test.thread;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/5/16 14:57
 */
public class MainTest {

    public static void main(String[] args) {
        boolean a = false;

        boolean b = !a;
        System.out.println(b);
        if (b) {
            System.out.println("aaa");
        }
    }
}
