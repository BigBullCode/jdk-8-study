package test.designmodel.work.proxy.dynamicproxy.jdkproxy.principle;

import java.lang.reflect.Method;

/**
 * 自定义代理接口
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 21:03
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
