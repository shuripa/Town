import java.util.Calendar;
import java.util.TimeZone;

public class IdentifyTime {

    private TimeZone tz;
    private String stz;
    private String town;
    private Calendar c;

    private Integer hour;
    private Integer minute;


    public IdentifyTime() {
        throw new RuntimeException("Не задан город");
    }

    public IdentifyTime(String townName) {
        town = townName;
        tz = isIdentifyTimeZone(townName);
        c = Calendar.getInstance(tz);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        printHello();
    }


    public IdentifyTime(String townName, String timeZone) {
        town = townName;
        stz = timeZone;
    }

    private void printHello() {
        System.out.println("Hello " + town);
    }

    private TimeZone isIdentifyTimeZone(String town){

        String[] tzs = TimeZone.getAvailableIDs();
        String ttown = "";
        TimeZone gmt = TimeZone.getDefault();

        for (String tz : tzs){
            ttown = tz.substring(tz.lastIndexOf("/") + 1, tz.length());
            if (ttown.equals(town)){
                gmt = TimeZone.getTimeZone(ttown);
            }
        }

        return gmt;
    }

}
