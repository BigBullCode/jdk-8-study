package test.staticclass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/5/17 10:07
 */
public class PersonUtil {

    private static List<String> list = new ArrayList<>();
    private static String name = null;

    static {
        list.addAll(Arrays.asList(new String[]{"张三", "李四"}));
    }

    public static void getName (Person person) {
        list.add("王五");
        name = list.get(0) + list.size();
        person.setName(name);
    }
}
