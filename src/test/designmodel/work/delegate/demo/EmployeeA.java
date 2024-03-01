package test.designmodel.work.delegate.demo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:10
 */
public class EmployeeA implements IEmployee {

    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我开始做工作：" + command);
    }

    public static void main(String[] args) {
        String idCardNumber = "41282819900310293X"; // 替换为实际的身份证号码

        // 使用正则表达式匹配身份证号码中的中间12位数字
        Pattern pattern = Pattern.compile("\\d{3}(\\d{12})\\S{3}");
        Matcher matcher = pattern.matcher(idCardNumber);

        if (matcher.find()) {
            String middleDigits = matcher.group(1);
            System.out.println("中间12位数字为：" + middleDigits);
        } else {
            System.out.println("未找到中间12位数字");
        }
    }
}
