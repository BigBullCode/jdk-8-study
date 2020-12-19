package test.designmodel.observer.example.demo;
/**
 * @Author:
 * @Date: 2020/12/15 15:47
 */
public class MainTest {

    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher lone = new Teacher("卧龙");
        Teacher bird = new Teacher("凤雏");

        gPer.addObserver(lone);
        gPer.addObserver(bird);

        //业务逻辑代码
        Question question = new Question();
        question.setContent("卧龙凤雏得一可得天下?");
        question.setUserName("刘备");
        gPer.publishQuestion(question);
    }
}
