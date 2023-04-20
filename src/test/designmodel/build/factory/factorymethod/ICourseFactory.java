package test.designmodel.build.factory.factorymethod;
import test.designmodel.build.factory.simplefactory.ICourse;
/**
 * 总工厂
 * 为适应产品等级结构复杂（即工厂需要生产很多种产品）的产品，将生产具体的产品的功能交给具体的车间
 * 使用场景：logback 存在ILogFactory和下面的log4jFactory和NoPloggerFactory等
 *
 * 缺点，如果产品个数过多，增加了代码复杂度。同事也比较抽象，增加了理解难度。
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:03
 */
public interface ICourseFactory {

    ICourse create();
}
