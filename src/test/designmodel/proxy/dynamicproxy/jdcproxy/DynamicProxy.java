package test.designmodel.proxy.dynamicproxy.jdcproxy;

import test.designmodel.proxy.staticproxy.demo.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 20:40
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("代理结束");
    }

    private void before() {
        System.out.println("代理开始");
    }

}
