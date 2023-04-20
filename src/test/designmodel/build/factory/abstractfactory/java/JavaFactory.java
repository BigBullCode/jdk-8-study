package test.designmodel.build.factory.abstractfactory.java;
import test.designmodel.build.factory.abstractfactory.ICourseFactory;
import test.designmodel.build.factory.abstractfactory.INote;
import test.designmodel.build.factory.abstractfactory.IVideo;
/**
 *
 * 由此工厂可见，抽象工厂在扩展产品簇时符合开闭原则，但是在所有产品簇都扩展产品等级时（新增产品)，需要修改抽象工厂接口，不符合开闭原则
 * 抽象工厂也增加了系统的抽象性与理解复杂度
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:36
 */
public class JavaFactory implements ICourseFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }
    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
