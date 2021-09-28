package test.algorithm.binarytest;
/**
 * 二进制相加
 * 题目 {https://leetcode-cn.com/problems/add-binary/}
 *
 * @Author: Zhangdongdong
 * @Date: 2021/7/27 10:03
 */
public class TwoBianryAdd {

    /**
     * 简单实现
     * 如果 aa 的位数是 nn，bb 的位数为 mm，这个算法的渐进时间复杂度为 O(n + m)O(n+m)。但是这里非常简单的实现基于 Python 和 Java 本身的高精度功能，在其他的语言中可能并不适用，并且在 Java 中：
     * <p>
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     * 因此，为了适用于长度较大的字符串计算，我们应该使用更加健壮的算法。
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

   /* public static void main(String[] args) {
        System.out.println(addBinary1("1111101010101010101010100000000000000000000001010101", "00010101010110100000000010101010101010101011"));
        //            System.out.println(Integer.parseInt("1", 11));
    }*/

    /**
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()); //取出最大长度，遍历该长度
        int carry = 0;
        for (int i = 1; i <= n; ++i) {
            carry += i <= a.length() ? (a.charAt(a.length() - i) - '0') : 0;
            carry += i <= b.length() ? (b.charAt(b.length() - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "0101";
        StringBuffer sb = new StringBuffer();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 1; i <= n; i++) {
            carry += i <= a.length() ? (a.charAt(a.length() - i) - '0') : 0;
            carry += i <= b.length() ? (b.charAt(b.length() - i) - '0') : 0;
            int i1 = carry % 2 + 0;
            sb.append(i1);
//            sb.append((char)carry % 2 + '0');
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();
        System.out.println(sb.toString());

    }

}
