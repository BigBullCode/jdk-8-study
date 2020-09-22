package test.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Zhangdongdong
 * @Date: 2020/8/28 10:02
 */
public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now().withYear(2021).withMonth(1).withDayOfMonth(31);

//        new LocalDate(2021,01,01);
        LocalDate last1Date = now.minusMonths(1);



        LocalDate last2Date = now.minusMonths(2);
        LocalDate last3Date = now.minusMonths(3);


        System.out.println(last1Date + "\n" + last2Date + "\n" + last3Date);

        String s1 = last1Date.toString();
        String s2 = last2Date.toString();
        String s3 = last3Date.toString();
        String s11 = s1.substring(0, s1.lastIndexOf("-"));
        String s22 = s2.substring(0, s2.lastIndexOf("-"));
        String s33 = s2.substring(0, s2.lastIndexOf("-"));

        System.out.println(s11+s22+s33);

        System.out.println(now.minusMonths(13));

        LocalDate localDate = LocalDate.now().withYear(2021).withMonth(3).withDayOfMonth(12);
        LocalDate localDate1 = LocalDate.now().withYear(2022).withMonth(4).withDayOfMonth(12);

        System.out.println(localDate.getDayOfYear() == localDate1.getDayOfYear());

    }


}
