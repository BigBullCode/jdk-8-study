package test.algorithm;
import java.util.Arrays;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/16 11:19
 */
public class Day2021041601 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target && i != j) {
                    int[] ints = new int[]{i, j};
                    return ints;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int target = 7;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
