package test.string;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/5/28 14:00
 */
public class CharTest {

    public static void main(String[] args) {
        String a = "nbc";
        char c = a.charAt(0);
        System.out.println(c);
        String[] cs = {"m", "n"};
        System.out.println(Arrays.asList(cs).contains(String.valueOf(c)));
    }
}
