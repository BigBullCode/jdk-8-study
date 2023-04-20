package test.date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
/**
 * 计算当前时间到零点的距离
 * @Author: Zhangdongdong
 * @Date: 2022/3/15 11:32
 */
public class TimeOffset {

    public static void main(String[] args) {
        java8();
        calendar();
        date();
    }
    private static void java8() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos()));
    }

    private static void calendar() {
        Calendar c = Calendar.getInstance();
        long now = c.getTimeInMillis();

        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long millis = c.getTimeInMillis() - now;
        System.out.println("calendar计算距离" + (millis/1000));
    }

    private static void date() {
        long hour = 60 * 60 * 1000;
        long time = System.currentTimeMillis();
        System.out.println(time);
        time += 8 * hour;
        System.out.println(time);
        time %= 24 * hour;
        System.out.printf("%02d:%02d\n", time / hour, time % hour / 60000);
        time = 24 * hour - time;
        System.out.printf("%02d:%02d\n", time / hour, time % hour / 60000);
    }
}
