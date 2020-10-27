package test.designmodel.proxy.dynamicproxy.jdcproxy;

import test.designmodel.proxy.staticproxy.demo.Person;

import java.lang.reflect.Method;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 10:41
 */
public class Test {

    public static void main(String[] args) throws Throwable {
        JdkProxy proxy = new JdkProxy();

        Person instance = proxy.getInstance(new Male());

        instance.findLove();

        DynamicProxy dynamicProxy = new DynamicProxy();
        Person person = (Person) dynamicProxy.getInstance(new Male());
        person.findLove();
    }
}
