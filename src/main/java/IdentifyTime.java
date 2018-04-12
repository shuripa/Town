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
