package test.designmodel.proxy.cglibproxy;

import sun.management.resources.agent;
import test.designmodel.proxy.dynamicproxy.jdcproxy.Male;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 11:11
 */
public class Test {

    public static void main(String[] args) {
        Male male = (Male) new CgligAgent().getInstance(Male.class);
        male.findLove();
    }
}
