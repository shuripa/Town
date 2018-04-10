import sun.util.calendar.ZoneInfo;

import java.util.Calendar;
import java.util.TimeZone;

public class HelloTown {
//    TimeZone tz = TimeZone.getTimeZone("GMT+02:00");

    public static void main(String[] args) {
        //Инициализация tz ситемной тайм зоной
        Calendar c = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        String town = "";


        if (args.length == 0){
            throw new RuntimeException("Не задан город");
        }

        if (args.length>0){
            town = args[0];
        }

        if (args.length>1) {
            //TODO: Необязательный параметр - реализовать протестировать
            tz = TimeZone.getTimeZone(args[1]);
            c = Calendar.getInstance(tz);
        }

        //TODO: Определение времени суток для города
//        System.out.println(c.toString());


//        System.out.println("TimeZone: " + tz.getDisplayName());
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+02:00"));
//        int hour = cal.get(Calendar.HOUR_OF_DAY);
//        int min = cal.get(Calendar.MINUTE);
//        int sec = cal.get(Calendar.SECOND);
//        System.out.println(hour + ":" + min + ":" + sec);


//        System.out.println("Системное тaйм-зона: " + TimeZone.getDefault());
//        System.out.println(tz.toString());
//        System.out.println(tz.getDisplayName());
        System.out.println("Время: " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
        System.out.println(town);
    }


}
