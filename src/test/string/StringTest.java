package test.string;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/3 16:18
 */
public class StringTest {

    public static void main(String[] args) {

        String a = "aaa0";
        String ab = "aaa0";
        System.out.println(a == ab);
        String s = strToBinstr(a);
        System.out.println(s);


        System.out.println(ab.getBytes());
//
//        int i = a.getBytes() ^ ab.getBytes();
//        int ia = i ^ a.getBytes();
//        int ib = iab ^ ab.getBytes();


        String b = a.toUpperCase();
        System.out.println(b);

        a = ",bbb,";
        System.out.println(b);

        /*Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            matcher.replaceAll(null);
        }*/

        System.out.println(a.substring(1, a.length() - 1));
        System.out.println(a);

        CountDownLatch cd = new CountDownLatch(1);
        cd.countDown();
        Object t = new Object();
        WeakReference weakReference = new WeakReference<>(t);
    }

    // 将字符串转换成二进制字符串，以空格相隔
    public static String strToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]);
        }
        return result;
    }
}
