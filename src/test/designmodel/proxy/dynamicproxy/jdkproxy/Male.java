package test.designmodel.proxy.dynamicproxy.jdkproxy;

import test.designmodel.proxy.staticproxy.demo.Person;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/20 16:28
 */
public class Male implements Person {


    @Override
    public void findLove() {
        System.out.println("有缘千里来相会");
    }
}
