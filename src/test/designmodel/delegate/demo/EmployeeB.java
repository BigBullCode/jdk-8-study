package test.designmodel.delegate.demo;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:10
 */
public class EmployeeB implements IEmployee {

    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我开始做工作：" + command);
    }
}
