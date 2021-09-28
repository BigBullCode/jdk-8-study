package test.designmodel.factory.factorymethod;
import test.designmodel.factory.simplefactory.ICourse;
import test.designmodel.factory.simplefactory.JavaClass;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:21
 */
public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaClass();
    }
}
