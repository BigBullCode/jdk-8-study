package test.designmodel.singleton.register;

import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {

	
	public static void main(String[] args) {

		/*EnumSingleton instance = EnumSingleton.getInstance();
		EnumSingleton instance1 = EnumSingleton.getInstance();
		try {
			instance.setData(new Object());
			instance.setData(new Pojo());
			instance.setData(new Pojo());
			Class clazz = EnumSingleton.class;
			Constructor c = clazz.getDeclaredConstructor(String.class, int.class);//由于Enum源码可知，Enum需有参构造
			c.setAccessible(true);
			Object o = c.newInstance();
			//这里会报错：无法通过反射创建枚举对象，因此，Enum从底层避免反射破坏单例
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/

		EnumSingleton.INSTANCE.setData("111");
		System.out.println(EnumSingleton.INSTANCE.getData());
		System.out.println(EnumSingleton.getInstance().getData());
		EnumSingleton.getInstance().setData("aaa");
		System.out.println(EnumSingleton.INSTANCE.getData());
		System.out.println(EnumSingleton.getInstance().getData());
		EnumSingleton.adfasd.setData("12312312");
		System.out.println(EnumSingleton.INSTANCE.getData());
		System.out.println(EnumSingleton.adfasd.getData());
	}
}
