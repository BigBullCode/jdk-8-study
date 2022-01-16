package test.jvm;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/12/12 20:47
 */
public enum AAA {

    AAA(new HashMap<>(), "aaa");

    private Map map;
    private String value;

    AAA(Map map, String value) {
        this.map = map;
        this.value = value;
    }
}
