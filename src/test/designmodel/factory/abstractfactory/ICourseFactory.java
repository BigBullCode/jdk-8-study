package test.designmodel.factory.abstractfactory;
/**
 * 抽象工厂案例中，用于解决产品簇及产品等级之间的关系
 *
 * 在本案例中，java，python等不在是简单工厂demo和工厂方法demo中的产品等级结构，而变成了产品簇。
 * 产品簇与产品等级结构可理解为不同的商家（java课程，python课程），每个商家都生产相同的几个产品（video，note）
 *
 * 这个总工厂，用于生产产品方法的总接口
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 10:27
 */
public interface ICourseFactory {

    INote createNote();
    IVideo createVideo();

}
