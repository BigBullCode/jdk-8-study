package test.algorithm.cp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/12/22 10:51
 */
public class ZhongJiangTest {

    public static void main(String[] args) {
        List<Integer> targetList = new ArrayList<>();
//        targetList.addAll(Arrays.asList(new Integer[]{5,10,11,13,27,28,9}));
//        targetList.addAll(Arrays.asList(new Integer[]{9,14,20,21,24,26,4}));
//        targetList.addAll(Arrays.asList(new Integer[]{6,13,15,17,20,21,3})); //20220102
//        targetList.addAll(Arrays.asList(new Integer[]{2,12,21,23,25,31,8})); //20220104
//        targetList.addAll(Arrays.asList(new Integer[]{2,5,16,17,18,30,6})); //20220106
//        targetList.addAll(Arrays.asList(new Integer[]{5,19,24,28,30,32,14})); //20220109
//        targetList.addAll(Arrays.asList(new Integer[]{7,10,12,16,19,31,16})); //20220111
//        targetList.addAll(Arrays.asList(new Integer[]{3,6,9,15,22,31,2})); //20220113
//        targetList.addAll(Arrays.asList(new Integer[]{1,20,22,23,25,28,16})); //20220116
//        targetList.addAll(Arrays.asList(new Integer[]{2,3,7,9,20,21,13})); //20220118
//        targetList.addAll(Arrays.asList(new Integer[]{4,5,17,19,25,28,16})); //20220123
        targetList.addAll(Arrays.asList(new Integer[]{12,18,19,20,21,32,15})); //20220120

        List<List<Integer>> list = new ArrayList<>();
        String fileName = "F:\\testFile\\cp.txt";
        getList(fileName, list);
        getMoney(targetList, list);
//        System.out.println("组合数量：" + list.size());

        System.out.println("\n计算已购买彩票中奖情况========");
        List<List<Integer>> choiceList = new ArrayList<>();
        String choiceName = "F:\\testFile\\cp-2022-01-21.txt";
        getList(choiceName, choiceList);
        getMoney(targetList, choiceList);
    }
    private static void getMoney(List<Integer> targetList, List<List<Integer>> list) {
        List<List<Integer>> first = new ArrayList<>();
        List<List<Integer>> two = new ArrayList<>();
        List<List<Integer>> three = new ArrayList<>();
        List<List<Integer>> four = new ArrayList<>();
        List<List<Integer>> five = new ArrayList<>();
        List<List<Integer>> six = new ArrayList<>();
        for (List<Integer> ints : list) {
            int red = 0;
            int blue = ints.get(6);
            int targetBule = targetList.get(6);
            List<Integer> reds = ints.subList(0, 6);
            List<Integer> targetReds = targetList.subList(0, 6);
            reds.retainAll(targetReds);
            if (reds.size() == 6) {
                red = 6;
            }
            else if (reds.size() == 5) {
                red = 5;
            }
            else if (reds.size() == 4) {
                red = 4;
            }
            else if (reds.size() == 3) {
                red = 3;
            }
            if (blue == targetBule) {
                if (red == 6) { //6+1一等奖
                    first.add(ints);
                }
                else if (red == 5) { //5+1 三等奖
                    three.add(ints);
                }
                else if (red == 4) { //4+1 四等奖
                    four.add(ints);
                }
                else if (red == 3) {
                    five.add(ints);
                }
                else {
                    six.add(ints);
                }
            }
            else if (red == 6) { //6+0 二等奖
                two.add(ints);
            }
            else if (red == 5) { //5+0 四等奖
                four.add(ints);
            }
            else if (red == 4) {
                five.add(ints);
            }
        }
        int num1 = first.size() * 8000000;
        int num2 = two.size() * 150000;
        int num3 = three.size() * 3000;
        int num4 = four.size() * 200;
        int num5 = five.size() * 10;
        int num6 = six.size() * 5;
        int sum = num1 + num2 + num3 + num4 + num5 + num6;
        System.out.println("一等奖中奖数量" + first.size() + "; 奖金约【" + num1 + "】元");
        System.out.println("二等奖中奖数量" + two.size() + "; 奖金约【" + num2 + "】元");
        System.out.println("三等奖中奖数量" + three.size() + "; 奖金约【" + num3 + "】元");
        System.out.println("四等奖中奖数量" + four.size() + "; 奖金约【" + num4 + "】元");
        System.out.println("五等奖中奖数量" + five.size() + "; 奖金约【" + num5 + "】元");
        System.out.println("六等奖中奖数量" + six.size() + "; 奖金约【" + num6 + "】元");
        int money = sum - list.size() * 2;
        System.out.println("总需购买注数为：" + list.size() +
                ";总需投入金额为：" + list.size() * 2 + " 元；"
                + "\n总中奖金额约为：" + sum + "元; \n净收益约为：" + money + "元（未计算特别奖）");
    }
    private static void getList(String fileName, List<List<Integer>> list) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            List<Integer> intList;
            while ((str = bf.readLine()) != null) {
                String intStr = str.substring(1, str.length() - 1);
                String[] ints = intStr.replace(" ", "").trim().split(",");
                intList = new ArrayList<>();
                for (String anInt : ints) {
                    intList.add(Integer.parseInt(anInt));
                }
                if (intList.size() != 7) {
                    System.out.println("组合数量不正确：" + intList);
                }
                list.add(intList);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
