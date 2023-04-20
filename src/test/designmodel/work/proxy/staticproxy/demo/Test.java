package test.designmodel.work.proxy.staticproxy.demo;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/20 19:46
 */
public class Test {

    public static void main(String[] args) {
        Agent agent = new Agent(new Male());
        agent.findLove();
    }
}
