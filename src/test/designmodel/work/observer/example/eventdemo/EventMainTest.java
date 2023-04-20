package test.designmodel.work.observer.example.eventdemo;
/**
 * @Author: Zhangdongdong
 * @Date: 2020/12/15 16:41
 */
public class EventMainTest {

    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        try {
            //注册事件
            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.ON_CLICK, callback);
            mouse.addLisenter(MouseEventType.ON_MOVE, callback);
            mouse.addLisenter(MouseEventType.ON_WHEEL, callback);
            mouse.addLisenter(MouseEventType.ON_OVER, callback);
            mouse.click();
            mouse.blur();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
