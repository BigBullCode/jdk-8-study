package test.connection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2020/12/18 11:08
 */
public class TimeRun {

    public static void run(String[] urls) {
        // 设置代理IP 这种代理方式失败会以本机ip继续执行请求
        //        System.getProperties().setProperty("proxySet", "true");
        //        System.getProperties().setProperty("http.proxyHost", "175.42.68.111");
        //        System.getProperties().setProperty("http.proxyPort", "9999");
        try {
            System.out.println("定时任务执行！ 执行时间：" + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            Long start = System.currentTimeMillis();

            HttpURLConnection conn = null;
            for (String url : urls) {
                URL realUrl = new URL(url);
                //                Proxy proxy = getIpProxy();
                //                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("1.196.177.100", 9999)); //请求失败会报异常
                conn = (HttpURLConnection) realUrl.openConnection();
                //设置post方法
                conn.setRequestMethod("GET");
                //不使用缓存
                conn.setUseCaches(false);
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                //读取超时时间
                conn.setReadTimeout(20000);
                //连接超时时间
                conn.setConnectTimeout(30000);
                //这一句很重要，设置不要302自动跳转，后面会讲解到
                conn.setInstanceFollowRedirects(false);

                int responseCode = conn.getResponseCode();

                Map<String, List<String>> headerFields = conn.getHeaderFields();
               /* System.out.println(
                        "线程三访问网站" + url.substring(url.lastIndexOf("/")) + "成功 :"
                                + responseCode);*/
                conn.disconnect();
                Map<String, List<String>> requestProperties = conn
                        .getRequestProperties();
            }
            System.out.println("所有博客均已访问，博客数量为" + urls.length + " 执行时间为：" + (System.currentTimeMillis() - start)/1000 + "s");
            /*num += Integer.valueOf(urls.length);
            System.out.println("截止" + LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " 总阅读量应为：" + num);*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
