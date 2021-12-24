package test.collection;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/3/17 10:41
 */
public class Person {

    Integer age;

    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private List<String> list;

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", list=" + list + '}';
    }
}
