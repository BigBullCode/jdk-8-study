package test.reflect;
import java.lang.reflect.Method;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/6 11:18
 */
public class ReflectTest {

    public static void main(String[] args) {
        try {
            Object abc = Class.forName("test.reflect.ABC").newInstance();
            Method method = Class.forName("test.reflect.ABC").getDeclaredMethod("getName");
            Object invoke = method.invoke(abc);
            System.out.println(invoke);
        }
        catch (Exception e) {
//            e.printStackTrace();
            e.getCause().printStackTrace();
            e.getCause().getMessage();
        }
    }
}
