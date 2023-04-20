package test.designmodel.build.factory.abstractfactory.java;
import test.designmodel.build.factory.abstractfactory.INote;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:35
 */
public class JavaNote implements INote {

    @Override
    public void edit() {
        System.out.println("java笔记");
    }
}
