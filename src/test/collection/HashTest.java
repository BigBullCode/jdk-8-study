package test.collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/28 15:33
 */
public class HashTest {

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        Integer c = 2; //2%16 = 2
        Integer d = 18; //18%16 = 2
        int i = a.hashCode();
        int i1 = b.hashCode();
        System.out.println(i);
        System.out.println(i1);
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        Integer e = 12312321;
        Integer f = 12312321;
        System.out.println(e.hashCode());
        System.out.println(f.hashCode());

        HashMap map = new HashMap();
        map.put(2, "a");
        map.put(18, "b");
        Set<Map.Entry> set = map.entrySet();
        System.out.println(map.size());
    }
}
