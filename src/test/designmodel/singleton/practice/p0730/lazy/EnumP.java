package test.designmodel.singleton.practice.p0730.lazy;
import test.designmodel.singleton.register.EnumSingleton1;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/7/30 13:54
 */
public enum  EnumP {
    INSTANCE;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EnumP getInstance(){
        return INSTANCE;
    }
}
