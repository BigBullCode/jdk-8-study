package test.designmodel.work.proxy.doit;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/27 17:35
 */
public class ProxyMain {

    public static void main(String[] args) {
        ProxyConfig proxyConfig = new ProxyConfig();
        IDoObj proxy = proxyConfig.createProxy(IDoObj.class);
        System.out.println(proxy.getClass());
        proxy.doSomething("lalala");

        proxy.doSomething1("demaxiya");
        proxy.doSomething1("这件事", "很难做呀");
        IDoObj proxy1 = proxyConfig.createProxy(IDoObj.class);
        System.out.println(proxy1.getClass());
    }
}
