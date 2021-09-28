package test.designmodel.factory.simplefactory;
import org.apache.commons.lang3.StringUtils;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 9:50
 */
public class CourseFactory {

    /**
     * 一个简单的工厂，用于生产各种产品创建
     *
     * 缺点：随着各种课程出现，这个方法需要不断增加if else 不符合开闭原则
     * @param name
     * @return
     */
    public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaClass();
        }
        else {
            return null;
        }
    }

    /**
     * 通过反射创建，无需修改工厂的创建方法，但是这种方法无法在编译阶段控制参数的准确性，需要优化
     * @param clazzName
     * @return
     */
    public ICourse create1(String clazzName) {
        try {
            if (StringUtils.isNotBlank(clazzName)) {
                return (ICourse) Class.forName(clazzName).newInstance();
            }
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 这样就实现了增加课程，只需要提取对应的产品类名就可以了，工厂的创建方法无需变动.使用场景，Calender
     *
     * 缺点，由于创建类都在这个方法内，职责较重，不易于扩展过于负责的产品结构，即产品簇+ 产品等级结构类的产品
     * @param clazz
     * @return
     */
    public ICourse create1(Class<? extends ICourse> clazz) {
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
