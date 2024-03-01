package test.designmodel.work.proxy.datasource;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/13 15:59
 */
public class OrderServiceStaticProxy implements IOrderService{
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order, String username) {
        String year = yearFormat.format(order.getCreateTime());
        System.out.println("OrderServiceStaticProxy: " + username + " create order " + order.getId() + " at " + year);
        return orderService.createOrder(order);
    }


    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到[DB_" + dbRouter + "]数据源进行处理");
        DynamicDataSourcEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    public void before() {
        System.out.println("OrderServiceStaticProxy: before");
    }

    public void after() {
        System.out.println("OrderServiceStaticProxy: after");
    }
}
