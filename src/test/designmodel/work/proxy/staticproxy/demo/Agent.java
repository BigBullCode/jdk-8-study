package test.designmodel.work.proxy.staticproxy.demo;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/10/20 19:44
 */
public class Agent {

    private Male male;

    public Agent(Male male) {
        this.male = male;
    }

    public void findLove() {
        System.out.println("中间人介绍");
        this.male.findLove();
        System.out.println("同意交往！");
    }
}
