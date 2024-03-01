package test.designmodel.work.proxy.doit;
import com.sun.deploy.net.proxy.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/27 17:34
 */
public class ProxyConfig {

    public <T> T createProxy(Class<T> apiService) {
        return (T) Proxy.newProxyInstance(apiService.getClassLoader(), new Class[]{apiService}, new MyProxyHandler());
    }
    private class MyProxyHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理对象执行方法:" + method.getName());
            System.out.println("代理对象执行方法参数:" + Arrays.toString(args));
            return null;
        }
    }
}
