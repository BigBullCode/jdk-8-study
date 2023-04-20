package test.designmodel.build.factory.simplefactory;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 9:46
 */
public class SimpleFactoryMain {

    public static void main(String[] args) {
        /*ICourse javaClass = new JavaClass();
        javaClass.record();*/

        CourseFactory courseFactory = new CourseFactory();
        courseFactory.create("java");
    }
}
