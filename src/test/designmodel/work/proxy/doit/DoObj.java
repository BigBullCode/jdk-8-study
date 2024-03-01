package test.designmodel.work.proxy.doit;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/27 17:37
 */
public class DoObj implements IDoObj{

    @Override
    public void doSomething(String name){
        System.out.println("do something " + name);
    }
    @Override
    public void doSomething1(String name){
        System.out.println("do something " + name);
    }
    @Override
    public void doSomething1(String name, String msg){
        System.out.println("do something " + name + ":" + msg);
    }
}
