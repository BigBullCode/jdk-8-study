package test.collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/4/28 11:17
 */
public class ListTest {

    public static void main(String[] args) {
        /*List list1 = new ArrayList<Integer>();
        List list2 = new ArrayList<Integer>();
        List list3 = new ArrayList<Integer>();
        Collections.addAll(list1, 1,2,3,4);
        Collections.addAll(list2, 1,2,3,4);
        Collections.addAll(list3, 1,2,3,4);
        ListUtil.doing(list1, list2, list3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        List<String> strs = new ArrayList<>();
        strs.add("中国");
        strs.add("无敌");
        strs.add("平安");
        strs.add("平安1");
        strs.add("平安2");
        String str = "这是一首对祖国赞美的歌，唱的是喜乐";
        boolean b = strs.stream().anyMatch(a -> str.indexOf(a) != -1);
        System.out.println(b);

        List<String> list = strs.subList(0, 3);
        System.out.println(list);
        String[] abc = {"adsf", "asdfsa"};
        list.addAll(0, Arrays.asList(abc));
        System.out.println(list);*/

//        Person person = new Person();
//        List<String> list = new ArrayList<>();
//        Collections.addAll(list, "张飞", "关羽", "刘备");
       /* person.setList(list);
        System.out.println(person.toString());
        List<String> list1 = person.getList();
        list1.removeIf(str -> str.equals("关羽"));
        System.out.println(person.toString());*/
//        List<String> list1 = list.subList(0, 5);
//        System.out.println(list1);

        long l = System.currentTimeMillis();
        String str = Thread.currentThread().getId() + "";
        str += l;
        System.out.println(str);
        System.out.println(str.hashCode());



       /* String s = strToBinstr(str);
        System.out.println(s);
        String substring = s.substring(0, 15);
        byte[] bytes = substring.getBytes();
        String s1 = parseByte2HexStr(bytes);
        System.out.println(s1);*/
        Set<String> set = new HashSet<>();
        char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        /*for (int f = 0; f < 100; f++) {
            String result = "";
            Random ran = new Random();
            for (int i = 0; i < 6; i++) {
                int random = ran.nextInt(16);
                result += cs[random];
            }
            set.add(result);
//            System.out.println(result);
        }*/
//        System.out.println(set.size());
        /*String result = "";
        Random ran = new Random();
        for (int i = 0; i < 6; i++) {
            int random = ran.nextInt(999999999);
            String hex= Integer.toHexString(random);
            System.out.println(hex);
//            result += cs[random];
        }*/




    }

    public static String strToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]);
        }
        return result;
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

}
