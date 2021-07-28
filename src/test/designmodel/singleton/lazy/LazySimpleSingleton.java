package test.designmodel.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * 懒汉式单例：
 * 优点：节省了内存，线程安全
 * 缺点：性能下降
 * @author Administrator
 *
 */
public class LazySimpleSingleton {
	private static volatile LazySimpleSingleton instance;
	//隐藏构造方法，将无参构造设置为私有，会出现被反射攻击的问题，因此重写私有无参构造
//	private LazySimpleSingleton() {}
	/**
	 * 该方法为单例构造实例方法，但是会出现线程问题--线程不安全
	 * 两个线程，都去调用getInstance()
	 * 当两个线程同时进入instance==null的判断，便会重复创建两次
	 * 加速，会造成性能下降
	 * @return
	 */
	public static synchronized LazySimpleSingleton getInstance() {
		if (instance == null) {
			instance = new LazySimpleSingleton();
		}
		return instance;
	}
	
	/**
	 * 同步代码块，同样无法解决性能问题
	 * @return
	 */
	public static synchronized LazySimpleSingleton getInstanceLockCode() {
		//只在这里加锁，只是将阻塞移到了这里，还是无法解决性能问题
		synchronized(LazySimpleSingleton.class) { 
			
			if (instance == null) {
				instance = new LazySimpleSingleton();
			}
		}
		return instance;
	}
	
	/**
	 * 同步代码块双重判断，能够有效解决线程安全的性能问题
	 * 
	 * 会产生指令重排序问题，需要在对象初始化加上volatile解决指令重排序问题
	 * 
	 * 缺点：代码繁杂
	 * @return
	 */
	public static synchronized LazySimpleSingleton getInstanceLockCodeDoubleCheck() {
		//检查是否要阻塞
		if (instance == null) {
			synchronized(LazySimpleSingleton.class) { 
				//检查是否要重新创建实例
				if (instance == null) {
					instance = new LazySimpleSingleton();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 代码优化:静态内部类方式优化
	 * 
	 * 优点：利用了java语法特点，性能高，避免了内存浪费
	 * 缺点：能够被反射破坏
	 * 
	 * 加载方式：1.加载classPath的class文件，
	 * LazySimpleSingleton.class : 最先加载此文件，当加载到此方法时，需要用到内部类，才会去加载内部类的class文件，所以可以完美实现懒汉式单例的线程安全性能问题
	 * LazySimpleSingleton$LazyHolder.class :
	 * @return
	 */
	public static synchronized LazySimpleSingleton getInstanceInnerClass() {
		return LazyHolder.INSTANCE;
	}
	/**
	 * 静态内部类
	 * @author Administrator
	 *
	 */
	private static class LazyHolder{
		private static final LazySimpleSingleton INSTANCE = new LazySimpleSingleton();
	}
	
	//以上的写法均能被反射破坏
	
	/**
	 * 反射攻击
	 */
	public void reflectAttack() {
		
		try {
			Class<?> clazz = LazySimpleSingleton.class;
			Constructor<?> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);
			Object newInstance = c.newInstance(); //反射获取实例
			Object newInstance2 = c.newInstance(); //打破单例规则
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 为解决反射破坏，在私有构造内进行单例判断即可
	 * 
	 * 缺点：在代码中抛出异常，代码需优化，可使用注册式单例
	 */
	private LazySimpleSingleton() {
		if (LazyHolder.INSTANCE != null) {
			throw new RuntimeException("不允许非法访问");
		}
	}

	/**
	 * 防止序列化破坏单例
	 * 1. 在通过序列化读取为对象时，用到了ObjectInputStream.readObject()方法
	 * 2.readObject()方法内部调用了一个readObject0方法
	 * 3.readObject0方法内有一个 checkResolve方法
	 * 4.checkResolve内用一个readOrdinaryObject方法，内有个判断方法为：hasReadResolveMethod()，用于判断单例对象内部有没有resolve方法
	 * 5.如果没有resolve方法，将会调用newInstance()方法，创建新的对象，破坏单例。
	 * 6.如果有resolve方法，首先会去调用invokeReadResolve(obj)方法
	 * 6.invokeReadResolve(obj)方法，通过反射机制，调用单例对象的resolve方法：readResolveMethod.invoke(obj,new Object[] null),得到对象并返回
	 * 7.hasReadResolveMethod()方法在得到invokeReadResolve(obj)方法返回值后，赋值给单例对象。
	 * 8.因此，如果在单例对象内有resolve()方法时，通过反序列化创建实例化对象时，始终是通过resolve方法获取的单例对象
	 * @return
	 */
	private LazySimpleSingleton readResovle() {return LazyHolder.INSTANCE;}
	
	
}
