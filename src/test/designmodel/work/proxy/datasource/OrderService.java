package test.designmodel.work.proxy.datasource;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/11/13 15:46
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
