package test.extendss;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/11/15 11:26
 */
public class MainTest {

    public static Map<String, ReflectEntry> map = new HashMap<>();
    static {
        map.put("zhangsan", new ReflectEntry(new ZhangSan().getClass(), "setName", String.class, "getName", "getNameId"));
        map.put("lisi", new ReflectEntry(new Lisi().getClass(), "setAaa", String.class, "getAaa", "getAaaId"));
    }
    public static void main(String[] args) {
        //初始化测试数据
        String key = "lisi";
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName("张三");
        orderDetail.setNameId("aaa");
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setAaa("李四");
        orderDetail1.setAaaId("lisi");
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail1);
        List<String> resultList = new ArrayList<>();
        Collections.addAll(resultList, new String[]{"张三", "李四"});

        //开始
        List<Object> result = new ArrayList<>();
        ReflectEntry obj = map.get(key);
        try {
            Class<? extends Person> clazz = obj.getClazz();
            java.util.Optional<OrderDetail> optional = null;
            for (String str : resultList) {
                Object obj1 = clazz.newInstance(); //Person的子类
                Method method = clazz.getDeclaredMethod(obj.getTargetMethod(), obj.getParamType());
                method.invoke(obj1, str); //set独有属性
                optional = orderDetails.stream().filter(s -> {
                    try {
                        String getMethod = obj.getGetMethod();
                        Method method1 = s.getClass().getMethod(getMethod);
                        String  value = (String) method1.invoke(s);
                        return str.equals(value);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }).findAny();
                if (optional.isPresent()) {
                    Class<Person> superclass = (Class<Person>) clazz.getSuperclass(); // 获取父class
                    Method setId = superclass.getMethod("setId", String.class); //获取setId()方法
                    Method getIdMethod = optional.get().getClass().getDeclaredMethod(obj.getGetIdMethod());
                    String id = (String) getIdMethod.invoke(optional.get());
                    setId.invoke(obj1, id); //setId
                    result.add(obj1);
                }
            }
            System.out.println("sucess");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class OrderDetail {
        private String id;

        private String spec;

        private String specId;
        private String nameId;
        private String ageId;
        private String aaaId;

        private String name;
        private String aaa;
        public String getAaa() {
            return aaa;
        }
        public void setAaa(String aaa) {
            this.aaa = aaa;
        }
        private String area;

        public String getSpec() {
            return spec;
        }
        public void setSpec(String spec) {
            this.spec = spec;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getArea() {
            return area;
        }
        public void setArea(String area) {
            this.area = area;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }

        public String getSpecId() {
            return specId;
        }
        public void setSpecId(String specId) {
            this.specId = specId;
        }
        public String getNameId() {
            return nameId;
        }
        public void setNameId(String nameId) {
            this.nameId = nameId;
        }
        public String getAgeId() {
            return ageId;
        }
        public void setAgeId(String ageId) {
            this.ageId = ageId;
        }
        public String getAaaId() {
            return aaaId;
        }
        public void setAaaId(String aaaId) {
            this.aaaId = aaaId;
        }
    }

    static class ReflectEntry {

        private Class clazz;

        private String targetMethod;

        private Class paramType;

        private String getMethod;

        private String getIdMethod;

        public ReflectEntry(Class<? extends Person> clazz, String targetMethod, Class paramType, String getMethod) {
            this.clazz = clazz;
            this.targetMethod = targetMethod;
            this.paramType = paramType;
            this.getMethod = getMethod;
        }

        public ReflectEntry(Class clazz, String targetMethod, Class paramType, String getMethod, String getIdMethod) {
            this.clazz = clazz;
            this.targetMethod = targetMethod;
            this.paramType = paramType;
            this.getMethod = getMethod;
            this.getIdMethod = getIdMethod;
        }

        public String getGetIdMethod() {
            return getIdMethod;
        }
        public void setGetIdMethod(String getIdMethod) {
            this.getIdMethod = getIdMethod;
        }
        public Class getClazz() {
            return clazz;
        }
        public void setClazz(Class<? extends Person> clazz) {
            this.clazz = clazz;
        }
        public String getTargetMethod() {
            return targetMethod;
        }
        public void setTargetMethod(String targetMethod) {
            this.targetMethod = targetMethod;
        }

        public Class getParamType() {
            return paramType;
        }
        public void setParamType(Class paramType) {
            this.paramType = paramType;
        }

        public String getGetMethod() {
            return getMethod;
        }
        public void setGetMethod(String getMethod) {
            this.getMethod = getMethod;
        }
    }

   static class ZhangSan extends Person {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    static class Lisi extends Person {
        private String aaa;

        public String getAaa() {
            return aaa;
        }
        public void setAaa(String aaa) {
            this.aaa = aaa;
        }
    }

   static class Person {
        private String id;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
    }
}
