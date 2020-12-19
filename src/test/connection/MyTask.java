package test.connection;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;
/**
 * @Author: Zhangdongdong
 * @Date: 2020/12/16 18:25
 */
public class MyTask extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
    }

    @Override public void run() {
            TimeRun.run(urls);
    }
}

