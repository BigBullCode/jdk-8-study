package test.designmodel.work.proxy.datasource;
/**
 * 动态切换数据源-数据源路由对象
 * @Author: Zhangdongdong
 * @Date: 2023/11/13 15:51
 */
public class DynamicDataSourcEntry {
    //默认数据源
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    public DynamicDataSourcEntry() {
    }
    /**
     * 清除当前线程的数据源
     */
    public static void clear() {
        local.remove();
    }
    /**
     * 获取当前线程的数据源
     * @return
     */
    public static String get() {
        return local.get();
    }
    /**
     * 恢复当前切换的数据源
     */
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }
    /**
     * 设置当前线程的数据源
     * @param source
     */
    public static void set(String source) {
        local.set(source);
    }
    /**
     * 根据年份设置数据源
     * @param year
     */
    public static void set(int year) {
        local.set("DB_" + year);
    }
}
