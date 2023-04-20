package test.enumtest;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/5/17 10:18
 */
public enum  TestEnum {

    test("aaa");

    private String a;

    TestEnum(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
}
