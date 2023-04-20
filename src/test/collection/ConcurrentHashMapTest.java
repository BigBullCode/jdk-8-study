package test.collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/3/10 17:40
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String,String> map1 = new ConcurrentHashMap<>();
        Map<String,String> map2 = new ConcurrentHashMap<>();
        //多线程中，出现了线程问题
        Hashtable hashtable = new Hashtable();
        if (!hashtable.containsKey("a")) {

            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
