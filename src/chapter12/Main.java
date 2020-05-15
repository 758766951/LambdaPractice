package chapter12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class Main {
    public static void main(String[] args) {
        /**
         * 1.LocalDate类的实例是一个不可变对象，它只提供了简单的日期，并不含当天的时间信息。
         * 使用工厂方法从系统时钟中获取当前的日期，LocalDate.now()
         * 使用TemporalField接口也读取LocalDate的值，ChronoField枚举实现了这一接口
         * year: 2014
         * year2: 2014
         * month: MARCH
         * month2: 3
         * day: 18
         * day2: 18
         * DayOfWeek: TUESDAY
         * lengthOfMonth: 31
         * sLeapYear: false
         * today: 2020-05-11
         */
        //通过静态工厂方法of创建一个LocalDate实例
//        LocalDate date = LocalDate.of(2014, 3, 18);
//        int year = date.getYear();
//        int year2 = date.get(ChronoField.YEAR);
//
//        Month month = date.getMonth();
//        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
//
//        int day = date.getDayOfMonth();
//        int day2 = date.get(ChronoField.DAY_OF_MONTH);
//
//        DayOfWeek dow = date.getDayOfWeek();
//        int len = date.lengthOfMonth();
//        boolean leap = date.isLeapYear();
//        LocalDate today = LocalDate.now();
//
//        System.out.println("year: "+year);
//        System.out.println("year2: "+year2);
//        System.out.println("month: "+month);
//        System.out.println("month2: "+month2);
//        System.out.println("day: "+day);
//        System.out.println("day2: "+day2);
//        System.out.println("DayOfWeek: "+dow);
//        System.out.println("lengthOfMonth: "+len);
//        System.out.println("sLeapYear: "+leap);
//        System.out.println("today: "+today);

        /**
         * 2.LocalTime类，同LocalDate一样，也提供了一些getter方法访问日期变量的值
         * LocalDate和LocalTime都可以通过解析代表它们的字符串创建。
         * hour: 13
         * minute: 45
         * second: 20
         * date: 2014-03-18
         * time2: 13:45:20
         */
//        LocalTime time = LocalTime.of(13, 45, 20);
//        int hour = time.getHour();
//        int minute = time.getMinute();
//        int second = time.getSecond();
//
//        LocalDate date = LocalDate.parse("2014-03-18");
//        LocalTime time2 = LocalTime.parse("13:45:20");
//
//        System.out.println("hour: "+hour);
//        System.out.println("minute: "+minute);
//        System.out.println("second: "+second);
//        System.out.println("date: "+date);
//        System.out.println("time2: "+time2);

        /**
         * 3. 合并日期和时间
         * LocalDateTime，是LocalDate和LocalTime的合体。它同时表示了日期和时间，但不带有时区信息，
         * 可以直接创建，也可以通过合并日期和时间对象构造
         * 可以使用toLocalDate或者toLocalTime方法，从LocalDateTime中提取LocalDate或者LocalTime组件
         * dt1: 2014-03-18T13:45:20
         * dt2: 2014-03-18T13:45:20
         * dt3: 2014-03-18T13:45:20
         * dt4: 2014-03-18T13:45:20
         * dt5: 2014-03-18T13:45:20
         * date1: 2014-03-18
         * time1: 13:45:20
         */
//        LocalDate date = LocalDate.parse("2014-03-18");
//        LocalTime time = LocalTime.parse("13:45:20");
//        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
//        LocalDateTime dt2 = LocalDateTime.of(date, time);
//        LocalDateTime dt3 = date.atTime(13, 45, 20);
//        LocalDateTime dt4 = date.atTime(time);
//        LocalDateTime dt5 = time.atDate(date);
//
//        LocalDate date1 = dt1.toLocalDate();
//        LocalTime time1 = dt1.toLocalTime();
//
//        System.out.println("dt1: "+dt1);
//        System.out.println("dt2: "+dt2);
//        System.out.println("dt3: "+dt3);
//        System.out.println("dt4: "+dt4);
//        System.out.println("dt5: "+dt5);
//        System.out.println("date1: "+date1);
//        System.out.println("time1: "+time1);

        /**
         * 4、机器的日期和时间格式
         *java.time.Instant类，对时间建模，基本上它是以Unix元年时间（传统的设定为UTC时区1970年1月1日午夜时分）开始所经历的秒数进行计算。
         *通过静态工厂方法ofEpochSecond传递一个代表秒数的值创建一个该类的实例
         * ofEpochSecond重载的版本会调整纳秒参数，它接收第二个以纳秒为单位的参数值，确保保存的纳秒分片在0到999 999999之间。
         * instant1: 1970-01-01T00:00:03Z
         * instant2: 1970-01-01T00:00:03Z
         * instant3: 1970-01-01T00:00:03Z
         * instant4: 1970-01-01T00:00:03Z
         */
//        Instant instant1 =  Instant.ofEpochSecond(3);
//        Instant instant2 =  Instant.ofEpochSecond(3, 0);
//        Instant instant3 =  Instant.ofEpochSecond(2, 1_000_000_000);
//        Instant instant4 =  Instant.ofEpochSecond(4, -1_000_000_000);
//        System.out.println("instant1: "+instant1.toString());
//        System.out.println("instant2: "+instant2.toString());
//        System.out.println("instant3: "+instant3.toString());
//        System.out.println("instant4: "+instant4.toString());

        /**
         * 5、创建间隔时间
         * Temporal接口定义了如何读取和操纵为时间建模的对象的值。目前为止，我们看到的所有类都实现了Temporal接口
         * 创建两个Temporal对象之间的duration。Duration类的静态工厂方法between就是为这个目的而设计的。你可以创建两个LocalTimes对象、两个LocalDateTimes对象，或者两个Instant对象之间的duration。
         * Period 类,以年、月或者日的方式对多个时间单位建模。Duration类主要用于以秒和纳秒衡量时间的长短。
         */
//        LocalTime time1 = LocalTime.of(18, 1, 17);
//        LocalTime time2 = LocalTime.of(12, 2, 47);
//        LocalDateTime dateTime1 = LocalDateTime.now();
//        LocalDateTime dateTime2 = LocalDateTime.of(LocalDate.now(),time2);
//        Instant instant1 =  Instant.ofEpochSecond(3);
//        Instant instant2 =  Instant.ofEpochSecond(5, 0);
//
//        Duration d1 = Duration.between(time1, time2);
//        Duration d2 = Duration.between(dateTime1, dateTime2);
//        Duration d3 = Duration.between(instant1, instant2);
//        System.out.println(d1);//PT-5H-58M-30S
//        System.out.println(d2);//PT-9H-11M-11.216S
//        System.out.println(d3);//PT2S
//
//        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),LocalDate.of(2014, 3, 18));
//        System.out.println(tenDays);//P10D
//
//        Duration threeMinutes = Duration.ofMinutes(3);
//        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
//        Period tenDays1 = Period.ofDays(10);
//        Period threeWeeks = Period.ofWeeks(3);
//        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
//        System.out.println(threeMinutes);//PT3M
//        System.out.println(threeMinutes1);//PT3M
//        System.out.println(tenDays1);//P10D
//        System.out.println(threeWeeks);//P21D
//        System.out.println(twoYearsSixMonthsOneDay);//P2Y6M1D

        /**
         * 6、操纵、解析和格式化日期
         * 以比较直观的方式操纵LocalDate的属性，使用withAttribute方法
         * 以声明的方式操纵LocalDate对象，使用plusWeeks、minusYears、plus等方法
         * 使用 TemporalAdjuster进行一些更加复杂的操作，使用重载版本的with方法，向其传递一个提供了更多定制化选择的TemporalAdjuster对象
         *
         */
//        以比较直观的方式操纵LocalDate的属性
//        LocalDate date1 = LocalDate.of(2014, 3, 18);
//        LocalDate date2 = date1.withYear(2011);
//        LocalDate date3 = date2.withDayOfMonth(25);
//        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
//        System.out.println(date4);//2011-09-25
////        以相对方式修改LocalDate对象的属性
//        LocalDate date5 = LocalDate.of(2014, 3, 18);
//        LocalDate date6 = date5.plusWeeks(1);
//        LocalDate date7 = date6.minusYears(3);
//        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);
//        System.out.println(date8);//2011-09-25

//        使用预定义的TemporalAdjuster
        LocalDate date9 = LocalDate.of(2014, 3, 18);
//        LocalDate date10 = date9.with(nextOrSame(DayOfWeek.SUNDAY));
//        LocalDate date11 = date10.with(lastDayOfMonth());
//        System.out.println(date10);//2014-03-23
//        System.out.println(date11);//2014-03-31

        //自定义TemporalAdjusters，计算明天的日期，同时过滤掉周六和周日这些节假日
//        写法1：以类封装实现TemporalAdjusters接口
//        LocalDate date12 = (LocalDate)new NextWorkingDay().adjustInto(date9);
//        System.out.println(date12);//2014-03-19
////        写法2：以Lambda表达式的方式向该adjuster接口传递行为
//        LocalDate date13 = date9.with(temporal -> {
//            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
//            int dayToAdd = 1;
//            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
//            else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
//            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
//        });
//        System.out.println(date13);//2014-03-19
//        //写法3：TemporalAdjusters类的静态工厂方法ofDateAdjuster，它接受一个UnaryOperator<LocalDate>类型的参数
//        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
//                temporal -> {
//                    DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
//                    int dayToAdd = 1;
//                    if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
//                    if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
//                    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
//                });
//        LocalDate date14 = date9.with(nextWorkingDay);
//        System.out.println(date14);//2014-03-19

        /**
         * 7、打印输出及解析日期-时间对象 java.time.format包
         * DateTimeFormatter实例,用于以一定的格式创建代表特定日期或时间的字符串
         * 所有的DateTimeFormatter实例都是线程安全的。能够以单例模式创建格式器实例，并能在多个线程间共享这些实例。
         * DateTimeFormatterBuilder类还提供了更复杂的格式器， 提供了非常强大的解析功能，比如区分大小写的解析、柔性解析
         *
         */
//        LocalDate date = LocalDate.of(2014, 3, 18);
//        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
//        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
//        System.out.println(s1);//20140318
//        System.out.println(s2);//2014-03-18
//
//        LocalDate date1 = LocalDate.parse("20140318",DateTimeFormatter.BASIC_ISO_DATE);
//        LocalDate date2 = LocalDate.parse("2014-03-18",DateTimeFormatter.ISO_LOCAL_DATE);
//        System.out.println(date1);//2014-03-18
//        System.out.println(date2);//2014-03-18

//        按照某个模式创建DateTimeFormatter
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate date3 = LocalDate.of(2014, 3, 18);
//        String formattedDate = date3.format(formatter);
//        LocalDate date4 = LocalDate.parse(formattedDate, formatter);
//        System.out.println(date4);//2014-03-18

//        创建一个本地化的DateTimeFormatter
//        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
//        LocalDate date5 = LocalDate.of(2014, 3, 18);
//        String formattedDate = date5.format(italianFormatter); // 18. marzo 2014
//        LocalDate date6 = LocalDate.parse(formattedDate, italianFormatter);
//        System.out.println(date6);//2014-03-18

//        使用DateTimeFormatterBuilder构造一个DateTimeFormatter
//        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
//                .appendText(ChronoField.DAY_OF_MONTH)
//                .appendLiteral(". ")
//                .appendText(ChronoField.MONTH_OF_YEAR)
//                .appendLiteral(" ")
//                .appendText(ChronoField.YEAR)
//                .parseCaseInsensitive()
//                .toFormatter(Locale.ITALIAN);
//        LocalDate date5 = LocalDate.of(2014, 3, 18);
//        String formattedDate = date5.format(italianFormatter); // 18. marzo 2014
//        LocalDate date6 = LocalDate.parse(formattedDate, italianFormatter);
//        System.out.println(date6);//2014-03-18

//      Date ---- String
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
        System.out.println(str);//2020年05月11日 22:48:22
//      String ---- Date
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
        System.out.println(date);//2020-05-11T22:48:22

    }

}
