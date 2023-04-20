package test.designmodel.work.delegate.demo;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/12 15:16
 */
public class Leader/* implements IEmployee */{

    private Map<String, IEmployee> targets = new HashMap<>();

    String workA = "登录";
    String workB = "加密";

    public Leader() {

        targets.put(workA, new EmployeeA());
        targets.put(workB, new EmployeeB());
    }

//    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
