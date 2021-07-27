package test.booleanTest;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/6/11 16:32
 */
public class BooleanTest {

    public static void main(String[] args) {
        boolean a = false;

        a = changeBoolean(a);
        System.out.println(a);
    }
    private static boolean changeBoolean(boolean a) {
        a = true;
        return a;
    }
}
