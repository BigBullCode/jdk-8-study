package test.pattrn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 13:27
 */
public class RegexMatches {

    public static void main(String[] args) {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";

//        String str = "123456789";
//        String str = "123456789";

        String str = "41282819900310293X";

//        String pattern = "(.*)(\\d+)(.*)";

        String pattern = "^\\d{9}$"; //n位的数字 123456789
        String pattern1 = "^[0-9]*$"; //纯数字字符串
        String pattern2 = "^\\d{3,}$"; //至少n位的数字
        String pattern3 = "^\\d{0,9}$"; //m-n位的数字

        String pattern4 = "^(\\d{17})([0-9]|X)$"; //身份证
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern4);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);

        if (m.find()) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
            System.out.println(m.group());
        } else {
            System.out.println("NO MATCH");
        }
    }
}
