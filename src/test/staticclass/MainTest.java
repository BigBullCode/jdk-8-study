package test.staticclass;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/5/17 10:10
 */
public class MainTest {

    public static void main(String[] args) {

        Person person = new Person();
        PersonUtil.getName(person);
        System.out.println(person.getName());
    }
}
