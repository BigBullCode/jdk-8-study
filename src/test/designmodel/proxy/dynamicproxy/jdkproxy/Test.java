package test.designmodel.proxy.dynamicproxy.jdkproxy;

import test.designmodel.proxy.staticproxy.demo.Person;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 10:41
 */
public class Test {

    public static void main(String[] args) throws Throwable {

        // jdk动态代理1
        JdkProxy proxy = new JdkProxy();

        Person instance = proxy.getInstance(new Male());

        instance.findLove();

        // jdk动态代理2
        DynamicProxy dynamicProxy = new DynamicProxy();
        Person person = (Person) dynamicProxy.getInstance(new Male());
        person.findLove();
    }
}
