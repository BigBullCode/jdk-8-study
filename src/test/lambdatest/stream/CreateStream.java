package test.lambdatest.stream;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import test.lambdatest.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
/**
 * @Author:
 * @Date: 2020/12/24 9:51
 */
public class CreateStream {

    public static void main(String[] args) {
        Stream<String> aaa = Stream.of("aaa", "bbb");
        List<String> bbb = aaa.collect(Collectors.toList());
        System.out.println(bbb);

        int[] ints = {1,2,3,4};
        int sum = Arrays.stream(ints).sum();
        System.out.println(sum);

        List<Double> collect = Stream.generate(Math::random).limit(20)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Apple> strs = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("blue");
        strs.add(apple);
        strs.stream().collect(groupingBy(Apple :: getColor));

        List<String> list = new ArrayList();
        list.addAll(Arrays.asList(new String[]{"我", "世界", "无敌"}));
        String str = list.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }
}
