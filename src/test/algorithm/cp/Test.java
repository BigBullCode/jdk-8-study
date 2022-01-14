package test.algorithm.cp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test{
    public static List<String> getList(String[][]a){
        Random r=new Random();
        List<String> strs=new ArrayList<String>();
        int n=1;
        //计算共有多少种情况 总数为所有数组长度的积
        for(int i=0;i<a.length;i++){
            n*=a[i].length;
        }
        for(int i=0;i<n;i++){
            String c="";
            for(int j=0;j<a.length;j++){
                //每一个数组里取一个随机元素
                int index=r.nextInt(a[j].length);//随机数的范围是这个数组的长度
                c+=a[j][index];
            }
            //判断集合中是否含有这个元素,有则总数+1,无则添加到这个集合中
            if(strs.contains(c)){
                n++;
            }else{
                strs.add(c);
            }
        }
        Collections.sort(strs);//最后排序一下
        return strs;
    }
    public static void main(String[] args) {
        /*String[][]a={{"1"},{"2"},{"3"},{"4"},{"5"}};
        List<String>strs=getList(a);
        for(String s:strs){
            System.out.println(s);
        }
        System.out.println("共有"+strs.size()+"个");*/
        int random = (int)(Math.random() * 10);
        System.out.println(random);
    }
}