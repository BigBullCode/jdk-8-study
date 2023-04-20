package test.testabstract;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/6/9 17:30
 */
public class PersonTest {

    public static void main(String[] args) {
        /*Person person = new Person();
        person.setName("张三");
        person.setAge(18);

        Person person1 = person;
        getPerson1(person1);
        System.out.println(person1);*/
        String s = null;
        String replace = s.replace("%sex", "123");
        System.out.println(replace);
    }
    private static void getPerson1(Person person1) {
        Person person = new Person();
        person.setName("李四");
        person.setAge(17);
        person1 = person;
    }

}
