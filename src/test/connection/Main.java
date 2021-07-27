package test.connection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @Author: Zhangdongdong
 * @Date: 2020/12/16 16:06
 */
public class Main {

    /**
     * 白天用1000ms，下班用2000ms
     */
    private static int per = 1000;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, per*500);
        timer.schedule(new MyTask1(), 1000, per*360);
        timer.schedule(new MyTask2(), 1000, per*700);
        timer.schedule(new MyTask3(), 1000, per*380);
        timer.schedule(new MyTask4(), 1000, per*450);
        timer.schedule(new MyTask5(), 1000, per*400);
        timer.schedule(new MyTask6(), 1000, per*600);
        timer.schedule(new MyTask7(), 1000, per*300);

    }
}

class MyTask1 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
        urls = new String[]{
                "https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",
                "https://blog.csdn.net/like_java_/article/details/118490266?spm=1001.2014.3001.5501"
                /*"https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",
                "https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",
                "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",
                "https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",
                "https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"*/};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask6 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
//        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
        urls = new String[]{
               /* "https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",*/
                "https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",
                /*"https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",
                "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",
                "https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",
                "https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"*/};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask2 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
//        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
        urls = new String[]{
                /*"https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",
                "https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",*/
                "https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",
                "https://blog.csdn.net/like_java_/article/details/113249898?spm=1001.2014.3001.5501"
               /* "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",
                "https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",
                "https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"*/};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask3 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
//        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
        urls = new String[]{
                /*"https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",
                "https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",
                "https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",*/
                "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",
                /*"https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",
                "https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"*/};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask4 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
//        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
       urls = new String[]{
                /*"https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",
                "https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",
                "https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",
                "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",*/
                "https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",
                 /*"https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"*/};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask5 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
//        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111316197"};
        urls = new String[]{
                /*"https://blog.csdn.net/like_java_/article/details/107379083",
                "https://blog.csdn.net/like_java_/article/details/110136928",
                "https://blog.csdn.net/like_java_/article/details/110127205",
                "https://blog.csdn.net/like_java_/article/details/108595119",
                "https://blog.csdn.net/like_java_/article/details/108128022",
                "https://blog.csdn.net/like_java_/article/details/108080693",
                "https://blog.csdn.net/like_java_/article/details/108073418",
                "https://blog.csdn.net/like_java_/article/details/108072454",
                "https://blog.csdn.net/like_java_/article/details/107855233",
                "https://blog.csdn.net/like_java_/article/details/107792533",
                "https://blog.csdn.net/like_java_/article/details/107789023",
                "https://blog.csdn.net/like_java_/article/details/107788903",
                "https://blog.csdn.net/like_java_/article/details/107763910",
                "https://blog.csdn.net/like_java_/article/details/107661947",
                "https://blog.csdn.net/like_java_/article/details/107401409",*/
                "https://blog.csdn.net/like_java_/article/details/107381018",
                "https://blog.csdn.net/like_java_/article/details/105762523",
                "https://blog.csdn.net/like_java_/article/details/105369090",
                "https://blog.csdn.net/like_java_/article/details/105320914",
                "https://blog.csdn.net/like_java_/article/details/89183361",
                "https://blog.csdn.net/like_java_/article/details/86236086",
                "https://blog.csdn.net/like_java_/article/details/83022070",
                "https://blog.csdn.net/like_java_/article/details/82877764"};
    }

    @Override public void run() {
        TimeRun.run(urls);
    }
}
class MyTask7 extends TimerTask {

    private static String[] urls;

    private static String[] ips;

    private static String PORT = "9999";

    private static int num = 14540;

    static {
        urls = new String[]{"https://blog.csdn.net/like_java_/article/details/111376534"};
    }

    @Override public void run() {
        try {
            Thread.sleep((int)(Math.random()*100+1)*1000L);
            TimeRun.run(urls);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



