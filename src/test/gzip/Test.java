package test.gzip;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/3/30 9:26
 */
public class Test {

    public static void main(String[] args) {
        String message = "This is a test message that needs to be compressed.";

        try {
            // 创建一个文件输出流，将其连接到GZIPOutputStream的构造器中
            FileOutputStream fos = new FileOutputStream("compressedMessage.txt.gz");
            GZIPOutputStream gzos = new GZIPOutputStream(fos);

            // 将需要压缩的数据写入GZIPOutputStream中
            gzos.write(message.getBytes());

            // 关闭GZIPOutputStream，以便输出流中的数据被压缩
            gzos.close();

            System.out.println("Message compressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
