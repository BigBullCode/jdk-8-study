package test.designmodel.proxy.dynamicproxy.jdcproxy;

import test.designmodel.proxy.staticproxy.demo.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 10:35
 */
public class JdkProxy implements InvocationHandler {

    private Person target;

    public Person getInstance(Person target) {
        this.target = target;

        Class<? extends Person> clazz = target.getClass();

        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("我是代理人");
    }

    private void after() {
        System.out.println("结果ok");
    }
}
