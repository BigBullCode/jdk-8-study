package test.enumtest;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/5/17 10:18
 */
public class MainTest {

    public static void main(String[] args) {
        TestEnum test = TestEnum.valueOf("test");
        System.out.println(test.getA());
    }
}
