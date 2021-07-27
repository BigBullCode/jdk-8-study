package test.pattrn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/5/7 17:09
 */
public class TeShuWord {

    public static void main(String[] args) {
        String context = "打扫房间阿拉水电费爱上华为(北京)公司的看法就爱上了阿斯蒂芬慷慨激昂";
        String key = "华为(北京)公司";
        int left = key.indexOf("(");
        int right = key.indexOf(")");
        /*if (left != -1 && right != -1) {
            String leftStr = key.substring(0, left);
            String mid = key.substring(left, right);
            String rightStr = key.substring(right);
            key = leftStr + "\\\\" + mid + "\\\\" + rightStr;
        }*/
        String s = key.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)");
        Pattern compile = Pattern.compile(s);
        Matcher matcher = compile.matcher(context);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
