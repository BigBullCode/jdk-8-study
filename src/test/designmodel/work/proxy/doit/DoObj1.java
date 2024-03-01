package test.designmodel.work.proxy.doit;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/27 17:48
 */
public class DoObj1 implements IDoObj{

    @Override
    public void doSomething(String name) {
        System.out.println("代理实现类2" + name);
    }
    @Override
    public void doSomething1(String name) {
        System.out.println("代理实现类2,do2" + name);
    }
    @Override
    public void doSomething1(String name, String msg) {
        System.out.println("代理实现类2" + name + ",msg" + msg);
    }
}
