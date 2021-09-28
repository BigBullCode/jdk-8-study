package test.algorithm.sort;
import java.util.Arrays;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/8/24 9:50
 */
public class QSTest1 {

    public static void sort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }
        //设置基准
        int base = arr[low];
        int i = low; int j = high; //左右哨兵
        while (i < j) {
            //右边哨兵从右往左移，移到比基准小或相等的位置
            while (arr[j] >= base && i < j) {
                j --;
            }
            //左哨兵从左往右移，找到比基准大或相等的位置
            while (arr[i] <= base && i < j) {
                i ++;
            }
            swap(arr, i, j);
        }
        //第一轮结束，替换j和基准的位置
        swap(arr, low, j);

        //第二轮 排序左侧的集合
        sort(arr, low, j - 1); //递归遍历左子集合
        //第三轮，递归排序右集合
        sort(arr, j + 1, high);
    }
    private static void swap(int[] arr, int i, int j) {
        //交换i和j的值
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] a = {92,7,4,8,6};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
