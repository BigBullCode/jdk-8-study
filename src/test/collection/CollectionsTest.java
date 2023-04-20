package test.collection;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

       /* List<Person> ints = new ArrayList<>();
        Person person = null;
        for (int i = 0; i < 4; i++) {
            person = new Person();
            person.setAge(3);
            person.setName("张三");
            ints.add(person);
        }*/
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("asdfasdf");
                return null;
            }
        });

        /*for (Person anInt : ints) {
            anInt.setAge(5);
        }
        System.out.println(ints.get(0).toString());*/
    }
}

/*class person {
    private String name;

    private String alisa;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlisa() {
        return alisa;
    }
    public void setAlisa(String alisa) {
        this.alisa = alisa;
    }
}*/
