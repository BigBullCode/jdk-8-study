package test.designmodel.observer.example.demo;
import java.util.Observable;
import java.util.Observer;
/**
 * 监听器
 * @Author:
 * @Date: 2020/12/15 15:40
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;

        Question question = (Question) arg;

        System.out.println("==========================");
        System.out.println(name + "老师，您好！\n" +
                "您收到了一份来自“" + gPer.getName() + "”的提问，希望您解答，问题内容如下：\n"
        + question.getContent() + "\n" +
                "提问者：" + question.getUserName());
    }
}
