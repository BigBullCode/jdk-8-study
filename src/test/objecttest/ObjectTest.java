package test.objecttest;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/7 15:03
 */
public class ObjectTest {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setName("张三");
        System.out.println(demo.getName());
        Demo demo1 = new Demo();
        demo1 = demo;
        System.out.println("demo:"+demo);
        System.out.println("demo1:"+demo1);
        System.out.println("demo1:"+demo1.getName());
        demo.setName("李四");
        System.out.println("demo1:"+demo1.getName());
        Demo demo2 = new Demo();
        demo2.setName("王五");
        demo = demo2;
        System.out.println("demo:"+demo.getName());
        System.out.println("demo1:"+demo1.getName());

    }
}
