package test.algorithm.hash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/9/22 14:58
 */
public class HashTest {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        /*List<String> a = new ArrayList<>();
        String abc = "412828199003102921";
        String a1bc = "412828199003102922";
        String a2bc = "412828199003102923";
        String a3bc = "412828199003102924";
        String a44bc = "412828199003102925";
        String a414bc = "412828199003102926";
        String a232bc = "412828199003102927";
        String a123bc = "412828199003102928";
        a.add(abc);
        a.add(a1bc);
        a.add(a232bc);
        a.add(a2bc);
        a.add(a3bc);
        a.add(a44bc);
        a.add( a414bc);
        a.add(a123bc);
        for (String s : a) {
            int i = (~s.hashCode() + 1) % 50;
            if (map.containsKey(i)) {
                Integer sum = map.get(i);
                sum ++;
                map.put(i, sum);
            }
            else {
                map.put(i, 1);
            }
        }*/

        IdCardUtils idCardUtils = new IdCardUtils();
        for (int i = 0; i < 1000; i++) {
            String generate = idCardUtils.generate();
            int i1 = ~generate.hashCode() + 1;
            int key =  i1 % 50 + 1;
            if (map.containsKey(key)) {
                Integer sum = map.get(key);
                sum ++;
                map.put(key, sum);
            }
            else {
                map.put(key, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }
    }
}
