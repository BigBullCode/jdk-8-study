package test.collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/30 16:07
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> set= new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        /*Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("b")) {
                it.remove();
            }
        }

        System.out.println(set);*/

        /*set.forEach(str -> { //异常，无法使用set.remove()
            if (str.equals("b")) {
                set.remove(str);
            }
        });*/

        System.out.println(set);
    }
}
