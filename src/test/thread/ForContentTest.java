package test.thread;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**伪共享单线程性能测试
 * @Author: Zhangdongdong
 * @Date: 2020/9/10 14:36
 */
public class ForContentTest {

    static  final int LINE_NUM = 10240;
    static final int COLUM_NUM = 10240;

    public static void main(String[] args) {
        long [][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                array[i][j] = i*2+j; //根据伪共享，数组会将附近顺序的值放入同一个内存行，取时携带取出
//                array[j][i] = i*2+j; //打乱了取值顺序，破坏了访问的局部性
            }
        }

        long entTime = System.currentTimeMillis();
        System.out.println((entTime - startTime)/1000);
    }
}
