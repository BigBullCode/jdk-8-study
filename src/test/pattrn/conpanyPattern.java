package test.pattrn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/28 9:46
 */
public class conpanyPattern {

    public static void main(String[] args) {
        String filenameStr = "aa/haha.exe";

        Pattern filenameP = Pattern.compile("^.+\\(?.+\\)$");

        Matcher filenameMatcher = filenameP.matcher(filenameStr);

        boolean foundFilename = filenameMatcher.matches();

        System.out.println(filenameMatcher);

        System.out.println(foundFilename);

        String onlyFilename = filenameMatcher.replaceFirst("${filenamePart}");

        System.out.println(onlyFilename);
    }
}
