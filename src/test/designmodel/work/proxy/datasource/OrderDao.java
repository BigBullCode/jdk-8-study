package test.designmodel.work.proxy.datasource;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/13 15:45
 */
public class OrderDao {

    public int insert(Order order) {
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
