package test.designmodel.observer.example.eventdemo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/**
 * 监听器，观察者的桥梁
 * @Author: Zhangdongdong
 * @Date: 2020/12/15 16:11
 */
public class EventLisenter {

    //jdk底层的lisenter通常也是这种设计
    protected Map<String, Event> events = new HashMap<>();

    //通过事件名称和一个目标对象来触发事件
    public void addLisenter(String eventType, Object target) {
        try {
            String upperEventType = "on" + toUpperFirstCase(eventType);
            this.addLisenter(eventType, target, target.getClass().getMethod(upperEventType, Event.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void addLisenter(String eventType, Object target, Method callBack) {
        //注册事件
        events.put(eventType, new Event(target, callBack));
    }

    /**
     * 触发，只要有动作就触发
     * @param
     * @return
     */
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            //发起回调
            if (event.getCallback() != null) {
                //用反射调用它的回调函数
                event.getCallback().invoke(event.getTarget(), event);
                //也可以优化为策略模式组合，设置为不同的事件监听内执行各种回调函数
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            System.out.println("事件" + trigger + "未注册");
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }


    private String toUpperFirstCase(String eventType) {

        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
