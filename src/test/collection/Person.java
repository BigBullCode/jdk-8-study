package test.collection;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/3/17 10:41
 */
public class Person {

    Integer age;

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + '}';
    }
}
