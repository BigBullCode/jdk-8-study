package test.designmodel.build.singleton.register;
/**
 * 最简单的枚举式单例
 *
 *  * 避免反射破坏：
 *  * 无法通过反射创建枚举对象，因此，Enum从底层避免反射破坏单例
 *  * Constructor.newInstance()源码中
 *  *
 *  * 保证线程安全：枚举类反编译后，可以看到单例枚举类是一个final类，且创建该对象实例是在一个static静态语句块儿中进行的
 *  * 根据jvm的类加载机制，静态语句块儿只会在类被加载时执行一次，所以可以线程安全。因为它是final类，不能被继承，也就不能创建子类对象
 *  *编译后：
 *     public final class  EnumSingleton extends Enum< EnumSingleton> {
 *         public static final  EnumSingleton  ENUMSINGLETON; final类
 *         public static  EnumSingleton[] values();
 *         public static  EnumSingleton valueOf(String s);
 *         static {}; //初始化单例在静态代码块执行。
 *     }
 *
 * 防止反序列化：
 * 马士兵：由枚举类源码可知，枚举类没有构造方法，就算是拿到class，也无法获取对象，只能获取INSTANCE，通过INSTANCE获取的枚举类，仍是唯一的。
 *
 *  完美答案：Java的序列化专门对枚举的序列化做了规定，在序列化时，只是将枚举对象的name属性输出到结果中，
 *  在反序列化时通过java.lang.Enum的valueOf方法根据名字查找对象，
 *  而不是新建一个新的对象，所以防止了反序列化对单例的破坏。
 * ObjectInputStream#readObject验证。
 * readObject判断到枚举类时，调用的了这个方法java.io.ObjectInputStream#readEnum
 * @Author: Zhangdongdong
 * @Date: 2021/7/28 10:10
 */
public enum EnumSingleton1 {

    INSTANCE;
    public EnumSingleton1 getInstance(){
        return INSTANCE;
    }

}
