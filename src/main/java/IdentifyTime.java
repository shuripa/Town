import java.util.Calendar;
import java.util.TimeZone;

public class IdentifyTime {

    private static Calendar c;
    private static TimeZone tz;
    private static String stz;
    private static String town;


    public IdentifyTime() {
        throw new RuntimeException("Не задан город");
    }

    public IdentifyTime(String townName) {
        this.town = townName;
        stz = "";
    }

    public IdentifyTime(String townName, String timeZone) {
        this.town = townName;
        this.stz = timeZone;
    }

    public TimeZone identifyTimeZone(){
        return TimeZone.getDefault();
    }

}



//Example string

//    TimeZone tz = TimeZone.getTimeZone("GMT+02:00");
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