package test.designmodel.proxy.dynamicproxy.cglibproxy;

import test.designmodel.proxy.dynamicproxy.jdkproxy.Male;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 11:11
 */
public class Test {

    public static void main(String[] args) {

        //cglib动态代理
        Male male = (Male) new CgligAgent().getInstance(Male.class);
        male.findLove();
    }
}
