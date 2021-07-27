package test.collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/28 11:17
 */
public class ListTest {

    public static void main(String[] args) {
        /*List list1 = new ArrayList<Integer>();
        List list2 = new ArrayList<Integer>();
        List list3 = new ArrayList<Integer>();
        Collections.addAll(list1, 1,2,3,4);
        Collections.addAll(list2, 1,2,3,4);
        Collections.addAll(list3, 1,2,3,4);
        ListUtil.doing(list1, list2, list3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        List<String> strs = new ArrayList<>();
        strs.add("中国");
        strs.add("无敌");
        strs.add("平安");
        strs.add("平安1");
        strs.add("平安2");
        String str = "这是一首对祖国赞美的歌，唱的是喜乐";
        boolean b = strs.stream().anyMatch(a -> str.indexOf(a) != -1);
        System.out.println(b);

        List<String> list = strs.subList(0, 3);
        System.out.println(list);
        String[] abc = {"adsf", "asdfsa"};
        list.addAll(0, Arrays.asList(abc));
        System.out.println(list);*/

        Person person = new Person();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张飞", "关羽", "刘备");
       /* person.setList(list);
        System.out.println(person.toString());
        List<String> list1 = person.getList();
        list1.removeIf(str -> str.equals("关羽"));
        System.out.println(person.toString());*/
        List<String> list1 = list.subList(0, 5);
        System.out.println(list1);

    }

}
