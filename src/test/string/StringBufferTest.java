package test.string;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/9/2 13:49
 */
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("asdfas").append("\n\r").append("bbbb");
        System.out.println(sb);
        
        getStr(sb.toString(), sb.toString());

    }

    private static void getStr(String... str) {
        System.out.println(str[1]);
    }


}
