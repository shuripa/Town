import java.util.Calendar;
import java.util.TimeZone;

public class IdentifyTime {

    private Calendar c;
    private TimeZone tz;
    private String stz;
    private String town;

    private Integer hour;
    private Integer minute;


    public IdentifyTime() {
        throw new RuntimeException("Не задан город");
    }

    public IdentifyTime(String townName) {
        this.town = townName;
        TimeZone tz = isIdentifyTimeZone(townName);
        //Определение тайм-зоны
//        if (tz.equals(TimeZone.getDefault()))
//            System.out.println("Города нет в списке");
//        else {
//            System.out.println("Город есть в списке");
//        }
        //Получение времени
        Calendar c = Calendar.getInstance(tz);
//        String time = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
//        System.out.println(time);
//        stz = "";
        //Вывод сообщения
        this.hour = c.get(Calendar.HOUR_OF_DAY);
        this.minute = c.get(Calendar.MINUTE);
    }


    public IdentifyTime(String townName, String timeZone) {
        this.town = townName;
        this.stz = timeZone;
    }

    private void printHello() {

    }

    public TimeZone isIdentifyTimeZone(String town){
        Boolean isIdentify = false;
        String[] tzs = TimeZone.getAvailableIDs();
        String ttown = "";
        TimeZone gmt = TimeZone.getDefault();
        Calendar c;
//        String time;

        for (String tz : tzs){
//             System.out.println(tzs[i].lastIndexOf("/")+tzs[i]);
            ttown = tz.substring(tz.lastIndexOf("/") + 1, tz.length());
            if (ttown.equals(town)){
                gmt = TimeZone.getTimeZone(ttown);
            }
//            System.out.print(ttown + " / ");
//            TimeZone gmt = TimeZone.getTimeZone(ttown);
//            System.out.print(gmt.getRawOffset()/60/60/1000 + " / ");
//            c = Calendar.getInstance(TimeZone.getTimeZone(ttown));
//            time = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
//            System.out.println(time);
        }

        return gmt;
    }

}
