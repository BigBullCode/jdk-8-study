package test.algorithm.cp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/12/21 9:02
 */
public class CPTest {

    static final Integer conNum = 3; //连续数字个数
    static final Integer HIGH_RATE_RED = 1; //高频红球标准，出现2次以上
    static final Integer LIKE = 3; //与最近号码相似度，匹配2个以上过滤
    static final Integer BLUE_RE = 3; //出现次数以上的蓝球过滤
    static Integer UP_BLUE; //出现次数以上的蓝球过滤
    static List<List<Integer>> lists = new LinkedList<>();
    static Map<Integer, Integer> blueMap = new HashMap<>();
    static Set<Integer> blues = new HashSet<>();
//    static List<Integer> list = new ArrayList<>();

    static {
        Collections.addAll(lists
                ,new ArrayList<>(Arrays.asList(new Integer[]{3,6,9,15,22,31,2})) //2022-1-13周四
                ,new ArrayList<>(Arrays.asList(new Integer[]{7,10,12,16,19,31,16})) //2022-1-11周二  一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{5,19,24,28,30,32,14})) //2022-1-9周日
                ,new ArrayList<>(Arrays.asList(new Integer[]{2,5,16,17,18,30,6})) //2022-1-6周四
                ,new ArrayList<>(Arrays.asList(new Integer[]{2,12,21,23,25,31,8})) //2022-1-4周二
                ,new ArrayList<>(Arrays.asList(new Integer[]{6,13,15,17,20,21,3})) //2022-1-2周日  一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{9,14,20,21,24,26,4})) //2021-12-30周四  一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{5,10,15,18,19,32,5})) //2021-12-28周二
                ,new ArrayList<>(Arrays.asList(new Integer[]{10,12,15,17,19,20,8})) //2021-12-26周日  一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{5,10,11,13,27,28,9})) //2021-12-23周四   一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{7,9,21,22,26,32,3})) //2021-12-21周二    一等奖
                ,new ArrayList<>(Arrays.asList(new Integer[]{4,7,10,14,16,26,9})) //12-19周日
                ,new ArrayList<>(Arrays.asList(new Integer[]{2, 5, 13, 15, 23, 26, 7}))//12-16周四
                ,new ArrayList<>(Arrays.asList(new Integer[]{1, 9, 11, 13, 20, 29, 9}))//12-14周二
                ,new ArrayList<>(Arrays.asList(new Integer[]{4,7,17,19,20,24,16}))//12-12周日
                ,new ArrayList<>(Arrays.asList(new Integer[]{1,14,19,23,26,30,10}))//12-09周四
                ,new ArrayList<>(Arrays.asList(new Integer[]{5,10,16,26,27,33,1}))//12-07周二
                ,new ArrayList<>(Arrays.asList(new Integer[]{12,14,19,23,24,27,1}))//12-05周日
                ,new ArrayList<>(Arrays.asList(new Integer[]{11,14,15,16,27,32,9}))//12-02周四
                ,new ArrayList<>(Arrays.asList(new Integer[]{3,7,10,14,21,24,1}))//11-30周二
//                ,new ArrayList<>(Arrays.asList(new Integer[]{2,6,9,15,19,28,16}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{3,10,17,19,21,31,4}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{1,2,16,19,25,31,8}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{1,3,12,19,27,31,10}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{1,4,6,14,20,28,8}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{8,11,18,19,20,24,1}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{8,9,15,24,26,30,6}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{4,15,21,27,28,29,10}))
//                ,new ArrayList<>(Arrays.asList(new Integer[]{5,17,20,21,23,33,4}))
//                ,Arrays.asList(new Integer[]{7,15,16,20,27,29,7})
                );
        boolean filter = false; //最近一个篮球是否要过滤
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> ints = lists.get(i);
            if (i == 0) {
                UP_BLUE = ints.get(6);
            }
            if (i == 1) {
                int blue2 = ints.get(6);
                if (UP_BLUE == blue2) {
                    System.out.println("最近两次篮球一致，过滤");
                    filter = true;
                }
            }
            Integer blue = ints.get(6);
            if (blueMap.get(blue) != null) {
                blueMap.put(blue, blueMap.get(blue) + 1);
            }
            else {
                blueMap.put(blue, 1);
            }
            ints.remove(6);
        }
        System.out.println("最近一次蓝球为：" + UP_BLUE + "; 是否需要过滤： " + filter);
        for (Map.Entry<Integer, Integer> entry : blueMap.entrySet()) {
            System.out.println("蓝球【" + entry.getKey() + "】 最近" + lists.size() + "期出现【" + entry.getValue() + "】次");
            if (UP_BLUE != entry.getKey() && entry.getValue() <= BLUE_RE) {
                blues.add(entry.getKey());
            }
            else if (UP_BLUE == entry.getKey() && entry.getValue() <= BLUE_RE && !filter) {
                blues.add(entry.getKey());
            }
        }
        System.out.println("高频篮球：" + blues);
//        blues.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10}));
//        list.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));  //高频率红球
    }



    public static void main(String[] args) {
        List<Integer> rateReds = getHighRateReds();
        System.out.println("高频红球：" + rateReds);
        List<List<Integer>> reds = getRedList(rateReds);
        System.out.println("红球组合数量：" + reds.size());
        List<List<Integer>> targets = getTargetList(reds);
        System.out.println("红蓝球组合数量：" + targets.size());
        String filePath = "F:\\testFile\\cp.txt";
        exportToFile(targets, filePath); //号码集合保存到本地
        System.out.println("随机选择15注:");
        List<List<Integer>> choiceNums = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            List<Integer> ints = targets.get((int) (Math.random() * targets.size()));
            choiceNums.add(ints);
        }
        String choiceFilePath = "F:\\testFile\\cp1.txt";
        exportToFile1(choiceNums, choiceFilePath);
        for (List<Integer> choiceNum : choiceNums) {
            Integer blue = choiceNum.get(6);
            choiceNum.remove(6);
            String s = "红球：" + choiceNum + " 蓝球：" + blue;
            String target = s.replaceAll("[\\[\\]]", "");
            System.out.println(target);
        }
    }
    private static void exportToFile1(List<List<Integer>> choiceNums, String choiceFilePath) {
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = null;
            for (List<Integer> target : choiceNums) {
                writer = new FileWriter(choiceFilePath, true);
                writer.write("\r\n");
                writer.write(Arrays.toString(target.toArray()));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getHighRateReds() {
        List<Integer> reds = new ArrayList<>();
        for (List<Integer> list : lists) {
            reds.addAll(list);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer red : reds) {
            if (map.get(red) != null) { //如果已经放入了map，则将value +1
                map.put(red, map.get(red) + 1);
            }
            else {
                map.put(red, 1);
            }
        }
        List<Integer> rateReds = new ArrayList<>();
        LinkedHashMap<Integer, Integer> linkMap = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (x1, x2) -> x2, LinkedHashMap::new));
        List<List<Integer>> list2 = lists.subList(0, 2); //最近两条重复的红球过滤掉
        for (Map.Entry<Integer, Integer> entry : linkMap.entrySet()) {
            Integer value = entry.getValue();
            if (value > HIGH_RATE_RED) {
                System.out.println("红球:" + entry.getKey() + " 过去" + CPTest.lists.size() + "期出现次数为:" + entry.getValue());
                int a = 0;
                for (List<Integer> integers : list2) {
                    if (integers.contains(entry.getKey())) {
                        a ++;
                    }
                }
                if (a >= 2) {
                    System.out.println("篮球" + entry.getKey() + " 最近两次均出现，过滤掉");
                    continue;
                }
                rateReds.add(entry.getKey());
            }
        }
        Collections.sort(rateReds);
        return rateReds;
    }

    /**
     * 取出红球组合
     * @return
     * @param rateReds
     */
    private static List<List<Integer>> getRedList(List<Integer> rateReds) {
        List<List<Integer>> sum = new ArrayList<>();
        List<Integer> target = null;

        for (int i = 0; i < rateReds.size(); i++) {
            for (int j = i + 1; j < rateReds.size(); j++) {
                for (int k = j + 1; k < rateReds.size(); k++) {
                    for (int l = k + 1; l < rateReds.size(); l++) {
                        for (int m = l + 1; m < rateReds.size(); m++) {
                            for (int n = m + 1; n < rateReds.size(); n++) {
                                target = new ArrayList<>();
                                target.add(0, rateReds.get(i));
                                target.add(1, rateReds.get(j));
                                target.add(2, rateReds.get(k));
                                target.add(3, rateReds.get(l));
                                target.add(4, rateReds.get(m));
                                target.add(5, rateReds.get(n));

                                boolean filter = filter(target);
                                if (filter) {
                                    continue;
                                }
//                                System.out.println(target);
                                sum.add(target);
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 过滤
     * @param target
     * @return
     */
    private static boolean filter(List<Integer> target) {
        ArrayList<Integer> integers = null;
        for (int i = 0; i < lists.size(); i++) {
            integers = new ArrayList<>();
            List<Integer> ints = lists.get(i);
            integers.addAll(ints);
            integers.retainAll(target);
            if (integers.size() > LIKE) { //与历史存在较大重复则去掉
                return true;
            }
        }

        //如果当前组合内存在三个及以上连号，则过滤
        boolean r = filterNums(target);
        if (target.get(5) < 20 || target.get(0) >= 20) { //最大值小于20或最小值大于20，很少出现，过滤
            return true;
        }
        return r;
    }

    private static boolean filterNums(List<Integer> target) {
        int sum = 1;
        for (int i = 0; i < target.size() - 1; i++) {
            if (sum == conNum) {
                return true;
            }
            int integer = target.get(i);
            int integer1 = target.get(i + 1);
            if (integer1 - integer == 1) { //如果数字连续，则记录
                sum ++;
            }
            else {
                sum = 1;
            }
        }
        if (sum == conNum) {
            return true;
        }
        return false;
    }

    /**
     * 组合蓝球
     * @param reds
     * @return
     */
    private static List<List<Integer>> getTargetList(List<List<Integer>> reds) {
        List<List<Integer>> targets = new ArrayList<>();
        List<Integer> list = null;
        for (Integer blue : blues) {
            for (List<Integer> redList : reds) {
                list = new ArrayList<>();
                list.addAll(redList);
                list.add(blue);
//                System.out.println(list);
                targets.add(list);
            }
        }
        return targets;
    }

    private static void exportToFile(List<List<Integer>> targets, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.isFile()) {
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);
            for (List<Integer> target : targets) {
                bWriter.write(Arrays.toString(target.toArray()));
                bWriter.newLine();
                bWriter.flush();
            }
            bWriter.close();
            System.out.println("数据写出成功");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
