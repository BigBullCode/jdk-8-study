package test.algorithm.cp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/12/21 9:42
 */
public class Test1 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);

        list1.retainAll(list2);
        System.out.println(list1);
    }
}
