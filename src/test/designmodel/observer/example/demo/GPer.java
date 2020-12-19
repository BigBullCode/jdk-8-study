package test.designmodel.observer.example.demo;
import java.util.Observable;
/**
 * 监听器管理
 * @Author:
 * @Date: 2020/12/15 15:37
 */
public class GPer extends Observable {

    private String name = "新野酒会";
    private static GPer gPer = null;

    private GPer() {}

    public String getName() {
        return name;
    }
    public static GPer getInstance() {
        if (gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    public void  publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
