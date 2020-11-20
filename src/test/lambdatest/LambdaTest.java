package test.lambdatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Lambda的演化过程
 * @Author: Zhangdongdong
 * @Date: 2020/10/29 20:18
 */
public class LambdaTest {

    /*public static void main(String[] args) {

        String a = "abc";

        String b = "aaa";

        ArrayList<Integer> list = new ArrayList<>();

        list.add(123);list.add(2323);

        List<Integer> ab = filter(list, (Integer abc) -> "abc".equals(abc));

        System.out.println(ab);

        list.stream().forEach(consumer);
    }

    *//**
     * 可由不同的接口实现来进行不同的判断，可由匿名类直接在方法引用时参数化
     * @param list
     * @param p
     * @param <T>
     * @return
     *//*
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }*/


    /**
     * 1: 筛选绿苹果
     * 这种原始代码不具备任何扩展性，一旦想筛选其它颜色的苹果，则需要修改代码
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple: inventory){
            if( "green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 2： 把颜色参数化，将颜色变为参数
     * 这种方法能适用的仅仅是颜色筛选，如果想筛选重量，则依然需要修改代码，会导致大量重复的代码出现
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                  String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( apple.getColor().equals(color) ) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 将苹果的所有属性条件统一起来
     *
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( (flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight) ){  //很low的选择方式
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 5 ： 根据抽象条件进行筛选-传递代码/行为； 这种方式将filterApples方法的行为参数化了
     * 只需要将第四步中不同的筛选策略传入该方法即可-策略模式
     *
     * 不同的行为需要不同的策略对象，会显得代码臃肿
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    List<Apple> inventory = new ArrayList<>();
    /**
     * 6 ： 通过匿名类，直接内联参数化filterApples方法的行为
     *
     * 但是匿名类很笨重，占用很多空间
     */
    List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
        public boolean test(Apple apple){
            return "red".equals(apple.getColor());
        }
    });

    /*
   7 ： Lambda表达式
    但是目前的ApplePredicate只适用于Apple，需要扩展
     */
    List<Apple> result =
            filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

    /**
     * 8： MyPredicate的产品类型抽象化，不再局限于Apple，这里的List类型抽象化
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, MyPredicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
    List<Apple> apples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    List<Integer> numbers = new ArrayList<>();
    List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);


}

/**
 * 4： 通过策略模式实现重量的筛选
 */
class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}

/**
 * 4： 通过策略模式实现颜色的筛选
 */
class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}