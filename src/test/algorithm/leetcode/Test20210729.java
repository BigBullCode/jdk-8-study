package test.algorithm.leetcode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/29 16:00
 */
public class Test20210729 {

    /*public static boolean isValid(String s) {
        boolean isvalid = true;
        if (s.length() % 2 != 0) {
            isvalid = false;
            return isvalid;
        }
        Character[] left = {'(', '{', '['};
        Character[] right = {')', '}', ']'};
        //1.第一个一定是左括号
        //2.左括号后面一位，左括号A与右括号A中间可以为空或者存在完整的括号，不可以存在左括号A- 左括号B - 右括号A - 右括号B

        char[] chars = s.toCharArray();
        char firstLeft = chars[0];
        List<Character> charList = Arrays.asList(left);
        if (!charList.contains(firstLeft)) {
            isvalid = false;
            return isvalid;
        }
        List<Integer> rIndexs = new ArrayList<>();
        String sub = s;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (Arrays.asList(right).contains(aChar)) {
                if (!rIndexs.contains(i)) {
                    isvalid = false;
                    return isvalid;
                }
                else {
                    sub = s.substring(i + 1);
                    continue;
                }
            }
            int i1 = Arrays.asList(left).indexOf(aChar);
            if (i1 == -1) {
                isvalid = false;
                return isvalid;
            }
            char firstR = right[i1]; //需要对应的右侧括号
            if (!s.contains(String.valueOf(firstR))) {
                isvalid = false;
                return isvalid;
            }
            //存在右括号，然后看括号内的内容
            //如果中间内容个数为奇数，则返回false
            int rIndex = sub.indexOf(firstR) + i;
            if (rIndex < i) {
                isvalid = false;
                return isvalid;
            }

            if (i + 1 != rIndex) {
                String substring = s.substring(i + 1, rIndex);
                if (substring.length() % 2 != 0) {
                    isvalid = false;
                    return isvalid;
                }
                //如果中间只有左括号，或全是右括号，false
                if (!Arrays.asList(left).stream().anyMatch(leftstr -> substring.contains(String.valueOf(leftstr))) || !Arrays.asList(right).stream().anyMatch(leftstr -> substring.contains(String.valueOf(leftstr)))) {
                    isvalid = false;
                    return isvalid;
                }
            }
            rIndexs.add(rIndex);
            sub = s.substring(i + 1);

        }
        return isvalid;
    }
*/
    public static void main(String[] args) {
        String[] ss = {"()[]{}", "()", "()()", "(([]){})"};
        for (int i = 0; i < ss.length; i++) {
            boolean valid = isValid(ss[i]);
            System.out.println(valid);
        }

        /*String s = "(([]){})";
        boolean valid = isValid(s);
        System.out.println(valid);*/
    }


    private static boolean isValid(String s) {
        Stack<Character> leftStack = new Stack<>();
        if (StringUtils.isBlank(s) || s.length() % 2 != 0) {
            return false;
        }
        Character[] left = {'(', '{', '['};
        Character[] right = {')', '}', ']'};
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Arrays.asList(left).contains(aChar)) {
                leftStack.push(aChar);
                continue;
            }
            if (leftStack.isEmpty() || Arrays.asList(right).indexOf(aChar) != Arrays.asList(left).indexOf(leftStack.peek())) {
                return false;
            }
            leftStack.pop();
        }
        return leftStack.isEmpty();
    }
}
