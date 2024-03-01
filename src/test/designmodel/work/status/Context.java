package test.designmodel.work.status;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/13 14:40
 */
public class Context {

    private Status status;

    public Context(Status status) {
        this.status = status;
    }

    public void doSomeThing() {
        status.doSomething();
    }
}
