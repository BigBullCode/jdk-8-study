package test.designmodel.factory.abstractfactory.java;
import test.designmodel.factory.abstractfactory.IVideo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:34
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("java视频");
    }
}
