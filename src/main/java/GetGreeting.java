import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class GetGreeting {
    private final String N = "Night";
    private final String M = "Morning";
    private final String D = "Day";
    private final String E = "Evening";
    private final String [] timeOfDays = {N, N, N, N, N, N, M, M, M, D, D, D, D, D, D, D, D, D, D, E, E, E, E, N, N};
    static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Town.class.getSimpleName());

    public GetGreeting() {
        //Changed log4j logger
    }
    
    //Changed swithc-case
    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        String s = "Day";
        String town = args[0];
        Integer localHour = Integer.parseInt(args[1]);
        
        if (localHour> -1 && localHour < 25) s = timeOfDays[localHour];
        return encode(s, getRes(getLocale())) + town +"!";
    }

    public Locale getLocale (){
        Locale l = Locale.getDefault();
        LOGGER.info("Get system locale is done: " + l.getLanguage());
        return l;
    }

    public TimeZone getTimeZoneInTown(String town){
        String[] tz = TimeZone.getAvailableIDs();
        String tn = "";

        for (String t : tz){
            tn = t.substring(t.lastIndexOf("/") + 1, t.length());
            if (tn.equals(town)){
                LOGGER.info("Timezone is changed: " + t);
                return TimeZone.getTimeZone(t);
            }
        }
        LOGGER.info("Timezone is UTC");
        //Correction Time Zone
        return TimeZone.getTimeZone("UTC");
    }

    public String getHour(TimeZone tz){
        String h = "" + Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
        LOGGER.info("Get time is done: " + h);
        return h;
    }

    public ResourceBundle getRes(Locale locale) {
        ResourceBundle res = ResourceBundle.getBundle("greet", locale);
        LOGGER.info("Get res is done: " + res.getLocale().getLanguage());
        return res;
    }
    
    public String encode(String key, ResourceBundle localRes) throws UnsupportedEncodingException {
        String encode = new String(localRes.getString(key).getBytes("ISO-8859-1"), "ISO-8859-5");
        LOGGER.info("Encoding is done");
        return encode;
    }
}