package test.github;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/9/28 14:32
 */
public class GitLabTest {
    public static void main(String[] args) {
        System.out.println("master分支代码");
        System.out.println("dev分支代码");

        String a = "a,b,a,";
        int i = Pattern.compile(",").matcher(a).groupCount();
        System.out.println(i);
    }



}
