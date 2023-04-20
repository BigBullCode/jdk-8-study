package test.designmodel.build.factory.simplefactory;
/**
 * java课程产品
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 9:45
 */
public class JavaClass implements ICourse {

    @Override
    public void record() {
        System.out.println("录制java课程");
    }
}
