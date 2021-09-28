package test.algorithm.sort;
import java.util.Arrays;
/**
 * 快速排序
 * @Author: Zhangdongdong
 * @Date: 2021/8/24 9:30
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] attr = {7,4,5,9,1,8,5,1};
        quickSort(attr, 0, attr.length - 1);
        System.out.println(Arrays.toString(attr));
    }


    public static void quickSort(int[] arr, int low, int high) {
        // low,high 为每次处理数组时的首、尾元素索引

        // 当low==high是表示该序列只有一个元素，不必排序了
        if (low >= high) {
            return;
        }
        // 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
        int i = low, j = high, base = arr[low];
        while (i < j) {
            // 右边哨兵从后向前找
            while (arr[j] >= base && i < j) { //如果右侧大于基准，且左侧坐标大于右侧坐标，则右侧坐标左移前进一步
                j--;
            }
            // 左边哨兵从前向后找
            while (arr[i] <= base && i < j) {
                i++;
            }
            swap(arr, i, j); // 交换元素
        }
        swap(arr, low, j); // 基准元素与右哨兵交换

        // 递归调用，排序左子集合和右子集合
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
