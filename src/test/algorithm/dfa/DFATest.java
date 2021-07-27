package test.algorithm.dfa;
import org.apache.commons.lang3.CharUtils;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/6/25 14:20
 */
public class DFATest {

    /**
     * 识别特殊符号
     */
    private static boolean isSymbol(Character c) {
        int ic = (int) c;
        // 0x2E80-0x9FFF 东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }

    public static void main(String[] args) {
        char c = '》';
        System.out.println(isSymbol(c));
    }

}
