package test.designmodel.singleton.register;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sun.tools.javac.code.Attribute;
import test.staticclass.Person;
/**
 * 枚举式单例
 * 避免反射破坏：
 * 无法通过反射创建枚举对象，因此，Enum从底层避免反射破坏单例
 * Constructor.newInstance()源码中
 *
 * 保证线程安全：枚举类反编译后，可以看到单例枚举类是一个final类，且创建该对象实例是在一个static静态语句块儿中进行的
 * 根据jvm的类加载机制，静态语句块儿只会在类被加载时执行一次，所以可以线程安全。因为它是final类，不能被继承，也就不能创建子类对象
 *
 *
 *
 *
 * @author Administrator
 *
 */
public enum EnumSingleton {

	INSTANCE,
	adfasd;
	private Person person;

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 全局访问点
	 * @return
	 */
	public static EnumSingleton getInstance() {
		return INSTANCE;
	}

	private EnumSingleton() {
		person = new Person();
	}

}
