package test.designmodel.proxy.dynamicproxy.jdcproxy.principle;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**用于生成源码的工具类
 * @Author: Zhangdongdong
 * @Date: 2020/10/26 21:04
 */
public class MyProxy {

    public static final String  ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?> [] interfaces, MyInvocationHandler h) {

        try {
            //1.动态生成源码.java文件
            String src = generateSrc(interfaces);

            //2.java文件输出磁盘
            String filePath = MyProxy.class.getResource("").getPath();

            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //3.把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //编译生成的.class文件加载到JVM中
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            //返回字节码重组后的新的代理对象
            return c.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(MyProxy.class.getPackage() + "," + ln)
                .append("import" + interfaces[0].getName() + "," + ln)
                .append("import java.lang.reflect.* ;" + ln)
                .append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln)
                .append("MyInvocationhandler h;" + ln)
                .append("public $Proxy0(MyInvocationHandler h) {" + ln)
                .append("this.h = h;")
                .append("}" + ln);

        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames= new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class<?> clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i >0 && i < params.length - 1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

        }
        return null;
    }

    private static String toLowerFirstCase(String simpleName) {
        return null;
    }
}
