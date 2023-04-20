package test.collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/30 13:45
 */
public class MapTest {

    public static void main(String[] args) {

        /*Map<String, String> map = new HashMap<>();
        Map<Object, Object> table = new Hashtable<>();

//        map.put(null, "1");
//        table.put(1, null);// hashtable不允许存放null键和null值

        //测试linkedHashMap的有序性
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("a", "a");
        map1.put("b","b");
        map1.put("c","c");
        map1.put("e","e");
        map1.put("f","f");
        map1.put("g","g");
        map1.put("h","h");
        map1.put("i","i");
        map1.put("d","d");
        for (String s : map1.keySet()) {
            System.out.println(s);
        }
        Set<String> strings = map1.keySet();
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }*/

       /* LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(7, 0.75f, true);
        map.put("星期一", 40);
        map.put("星期二", 43);
        map.put("星期三", 35);
        map.put("星期四", 55);
        map.put("星期五", 45);
        map.put("星期六", 35);
        map.put("星期日", 30);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<String, Integer>(7, 0.75f, false);
        map1.put("星期一", 40);
        map1.put("星期二", 43);
        map1.put("星期三", 35);
        map1.put("星期四", 55);
        map1.put("星期五", 45);
        map1.put("星期六", 35);
        map1.put("星期日", 30);
        for (Map.Entry<String, Integer> entry : map1.entrySet()){
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }*/
        /*List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        Map<String, List> map = new HashMap<>();
        map.put("姓名", list);
        System.out.println(map);

        map.get("姓名").add("王五");
        System.out.println(map);*/

        /*boolean a = true;
        boolean b = true;
        a = !b;
        System.out.println(a);*/

        /*List<String> abc = new ArrayList<>();
        abc.add("a");
        abc.add("b");
        abc.add("c");
        Optional<String> any = abc.stream().filter(a -> "a".equals(a) || "b".equals(a)).findAny();
        System.out.println(any.get());*/

        Map map = new HashMap();
        map.put("1", 123);
        map.put("1", 12312);
        System.out.println(map.get("1"));
    }
}
