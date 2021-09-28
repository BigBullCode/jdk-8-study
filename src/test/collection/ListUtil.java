package test.collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/28 11:22
 */
public class ListUtil {

    public static void doing(List list1, List list2, List list3) {
        list1.remove(1);
        list2.remove(2);
        list3.remove(3);
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");

        Thread thread = new Thread(() -> {
            list.add("李四");
        });
        Thread thread1 = new Thread(() -> {
            list.add("王五");
        });
        thread1.start();
        thread.start();
        thread.join();
        thread1.join();

        System.out.println(list);

        List<String> linkedList = new LinkedList<>();
    }
}
