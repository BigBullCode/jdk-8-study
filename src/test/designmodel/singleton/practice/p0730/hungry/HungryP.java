package test.designmodel.singleton.practice.p0730.hungry;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 13:37
 */
public class HungryP {

    private static final HungryP INSTANCE = new HungryP();

    private HungryP() {

    }

    public HungryP getInstance() {
        return INSTANCE;
    }
}
