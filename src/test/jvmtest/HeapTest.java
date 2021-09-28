package test.jvmtest;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 16:18
 */
public class HeapTest {

    public static void main(String[] args) throws InterruptedException {
        List<HeapTest> list = new ArrayList<>();
        List<HeapTest> list1 = new ArrayList<>();
        List<HeapTest> list2 = new ArrayList<>();
        while (true) {
            list.add(new HeapTest());
            list1.add(new HeapTest());
            list2.add(new HeapTest());
        }
    }
}
