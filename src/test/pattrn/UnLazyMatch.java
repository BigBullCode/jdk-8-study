package test.pattrn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/20 10:37
 */
public class UnLazyMatch {

    public static void main(String[] args) {
        /*String a = "aabbccddcc\nppaabppcaa\nasdffoo\npp";
        Matcher matcher = Pattern.compile("(aa)(\\S*\\n\\S*)*?").matcher(a);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }*/

        int a = 12;
        int b = 11;
       a = a ^ b;
        b = a ^ b;
        a = a ^ b;
//        int i = a >> 1;  // 除以2
//        int i1 = a | 1; // +1

        System.out.println(a);

        System.out.println(b);


/*        a = a + b; //超过int范围会报错
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);*/

    }
}
