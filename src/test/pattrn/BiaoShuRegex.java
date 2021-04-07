package test.pattrn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/7 17:06
 */
public class BiaoShuRegex {

    public static void main(String[] args) {



        String pat1 = "(中国|中国建设|中国银行|中国工商|中国农业|招商|中信|交通|上海浦东|民生|光大|广东发展|兴业|华夏|恒丰)";
        String pat2 = "([\\\\u4E00-\\\\u9FA5]{0,20})";
        String pat3 = "[\\\\(|（]{0,1}";
        String pat4 = "[\\\\)）]{0,1}";
        String pat5 = "(支行|分行|银行|公司)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pat4);

        String str = "中国银行股份有限公司电子银行安全评估及个人金融业务咨询服务项目招标公告";

        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);

        if (m.find( )) {
            System.out.println(m.group());
        } else {
            System.out.println("NO MATCH");
        }
    }
}
