package test.collection;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/8/28 14:29
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(0.1);
        doubleList.add(0.22);
        doubleList.add(2.1);
        doubleList.add(2.0);

        System.out.println(Collections.max(doubleList));

        List<String> strList = new ArrayList<>();
        strList.add("2020-08-30");
        strList.add("2020-08-31");
        strList.add("2020-08-29");
        strList.add("2020-09-01");
        strList.add("2020-08-26");
        strList.add("2020-08-28");
        strList.add("2020-08-27");
        System.out.println("未排序" + strList);

        Collections.sort(strList, Collections.reverseOrder());

        System.out.println("sort 排序：" + strList);

        Person person = new Person();
        person.setAge(3);
        List<Person> ints = new ArrayList<>();
        ints.add(person);
        for (Person anInt : ints) {
            anInt.setAge(5);
        }
        System.out.println(ints.get(0).toString());
    }
}
