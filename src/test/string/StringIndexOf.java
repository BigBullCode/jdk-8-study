package test.string;
import org.apache.commons.lang3.StringUtils;
import test.collection.Person;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2021/5/6 15:37
 */
public class StringIndexOf {

    public static void main(String[] args) {


       String a = "aaa";
       String b = "aaa";
        System.out.println(true && true || false);

        if (false) {
            System.out.println("1");
        }
        else if (true) {
            System.out.println("2");
        }




//        System.out.println(a.equals("aaa") && (b == null) || b.equals("aaa"));
//        System.out.println(a.substring(0, a.length() - 1));
//        System.out.println(a.split(","));
        /*String a= "\n" + "中标公告详细页面 \n" + "您当前位置： 保定市 保定市 采购公告 中标公告 \n" + "公告代码： 0413060020200630008 采购方式： 公开招标 \n" + "项目名称： 市政府机关院保安公司保障服务 \n" + "项目联系人： 张瑞勤 联系方式: 0312-3088671 代理机构： 保定市政府采购办公室 \n" + "行政区划名称： 保定市 \n" + "保定市机关事务管理局（机关）市政府机关院保安公司保障服务（二次）中标公告 \n" + "(中标公告期限为1个工作日) \n" + "发布时间： 2020-06-30 \n" + "采购项目编号： BDGK2020021 \n" + "采购人名称： 保定市机关事务管理局（机关） \n" + "采购人联系方式： 0312-3088671 \n" + "采购人地址 ： 保定市区 \n" + "采购代理机构全称 ： 保定市政府采购办公室 \n" + "采购代理机构地址 ： 保定市乐凯北大街红星美凯龙旁市民服务中心 \n" + "采购代理机构联系方式 ： 0312-5075337 \n" + "项目实施地点 ： 采购人指定地点 \n" + "采购内容： 市政府机关院保安公司保障服务 \n" + "采购公告期： 2020年06月01日 \n" + "品目分类 采购项目包组 供应商组织机构代码 供应商名称 供应商地址 主要标的名称 标的基本情况 规格型号 数量 单价 金额（元） 优惠率 服务要求 \n" + "服务 A 91130602MA08N3E310 保定市鸿森保安服务有限公司 竞秀区胜利北巷26-20号 保定市机关事务管理局市政府机关院保安公司保障服务项目（二次） 一、服务内容: \n" + "机关门口保安 3 号楼保安及周转楼保安 \n" + "（一）工作职责： 1、负责市政府机关大院及周转房正常保卫秩序； \n" + "2、负责对进出车辆、人员的检查、登记； \n" + "3、负责院内夜间每小时巡逻一次； \n" + "4、负责市政府机关大院的消防工作； \n" + "5、负责市政府机关大院的综合治理； \n" + "6、负责市政府机关大门口的安全稳定； \n" + "7、负责保卫处交代的其他工作； \n" + "（二）工作时间及倒班安排： 早中晚 24 小时三班等。 5047920 签订合同起三年等。 \n" + "定标日期： 2020年06月22日 \n" + "开标地点： 保定市乐凯北大街市民服务中心第一开标室 \n" + "评标地点： 保定市乐凯北大街市民服务中心第十七评标室 \n" + "本公告发布媒体： 河北省政府采购网、河北省公共资源交易服务平台 \n" + "传真电话： \n" + "受理质疑电话： 0312-3088671 \n" + "备注： \n" + "评审委员会成员名单： 杨继光（主任）、闫超英、张瑞勤、沈杰、孙聪。 \n" + "代理费用收费标准： 0 \n" + "代理费用收费金额： 0 \n" + "招标文件正文 \n" + "主办单位:河北省财政厅 | Email:hebzfcg@sina.com | 地址:中华南大街48号 | 邮编:050051 \n" + "技术支持:河北省财政厅信息中心 | 技术支持电话：（0311）66651000 联系方式 \n" + "冀ICP备13016076号-2 网站标识码: 1300000065 网站地图 \n" + "冀公网安备 13010402001602 \n" + "<表格前>\n" + "品目分类是_服务;采购项目包组是_A;供应商组织机构代码是_91130602MA08N3E310;供应商名称是_保定市鸿森保安服务有限公司;供应商地址是_竞秀区胜利北巷26-20号;主要标的名称是_保定市机关事务管理局市政府机关院保安公司保障服务项目（二次）;标的基本情况是_一、服务内容:机关门口保安 3 号楼保安及周转楼保安（一）工作职责： 1、负责市政府机关大院及周转房正常保卫秩序；2、负责对进出车辆、人员的检查、登记；3、负责院内夜间每小时巡逻一次；4、负责市政府机关大院的消防工作；5、负责市政府机关大院的综合治理；6、负责市政府机关大门口的安全稳定；7、负责保卫处交代的其他工作；（二）工作时间及倒班安排： 早中晚 24 小时三班等。;规格型号是_nan;数量是_nan;单价是_nan;金额（元）是_5047920;优惠率是_nan;服务要求是_签订合同起三年等。_;。\n" + "<表格后>\n";

        System.out.println(a.lastIndexOf("供应商名称"));
        System.out.println(a.lastIndexOf("保定市鸿森保安服务有限公司"));

        //1204

        String b = "品目分类是_服务;采购项目包组是_A;供应商组织机构代码是_91130602MA08N3E310;供应商名称是_保定市鸿森保安服务有限公司;供应商地址是_竞秀区胜利北巷26-20号;主要标的名称是_保定市机关事务管理局市政府机关院保安公司保障服务项目（二次）;标的基本情况是_一、服务内容:机关门口保安 3 号楼保安及周转楼保安（一）工作职责： 1、负责市政府机关大院及周转房正常保卫秩序；2、负责对进出车辆、人员的检查、登记；3、负责院内夜间每小时巡逻一次；4、负责市政府机关大院的消防工作；5、负责市政府机关大院的综合治理；6、负责市政府机关大门口的安全稳定；7、负责保卫处交代的其他工作；（二）工作时间及倒班安排： 早中晚 24 小时三班等。;规格型号是_nan;数量是_nan;单价是_nan;金额（元）是_5047920;优惠率是_nan;服务要求是_签订合同起三年等。_;。\n";
        System.out.println(a.indexOf(b));
        System.out.println(b.indexOf("供应商名称"));*/

       /* String a = "北京中联天盛建筑工程有限公司";
        String b = "建筑工程有限公司";
        System.out.println(a.contains(b));*/


        Person person = new Person();
        person.setAge(1);
        person.setName("王五");
        List<Person> list = new ArrayList<>();
        list.add(person);
        Person person1 = new Person();
        person1.setName("李四");
        person1.setAge(null);
        list.add(person1);

        Person person2 = new Person();
        person2.setAge(null);
        person2.setName(null);
        list.add(person2);

        if (list.stream().anyMatch(person3 -> StringUtils.isBlank(person3.getName()) && person3.getAge() == null)) {
            System.out.println("aaa");
        };
    }
}
