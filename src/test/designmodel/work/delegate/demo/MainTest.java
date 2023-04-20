package test.designmodel.work.delegate.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:21
 */
public class MainTest {

    public static void main(String[] args) {
        new Boss().command("登录", new Leader());
        new Leader().doing("登录");
    }
}
