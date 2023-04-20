package test.designmodel.work.delegate.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:20
 */
public class Boss {

    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
