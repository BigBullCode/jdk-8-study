package test.algorithm.hash;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/1/13 14:24
 */
public class HashString {

    public static void main(String[] args) {
        System.out.println(Math.abs("430425198012255875".toUpperCase().hashCode())%50);
    }
}
