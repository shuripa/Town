import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class GetGreeting {


    public String getGreeting() {
        return "??????. ????? ?? ?????.";
    }

    public String getGreeting(String townName) {
        int lh = getHour(getTimeZone(townName));
        return getGreeting(townName, lh, getRes(Locale.getDefault()));
    }

    public String getGreeting(String townName, String timeZone) {
        int lh = getHour(TimeZone.getTimeZone(timeZone));
        return getGreeting(townName, lh, getRes(Locale.getDefault()));
    }

    public String getGreeting(String town, int localHour, ResourceBundle localRes) {
        String greeting="";

        switch (localHour){
            case 6:
            case 7:
            case 8: greeting = localRes.getString("Morning"); break;
            case 19:
            case 20:
            case 21:
            case 22: greeting = localRes.getString("Evening"); break;
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:greeting = localRes.getString("Night"); break;
            default: greeting = localRes.getString("Day"); break;
        }
        greeting += town +"!";
        return greeting;
    }

    public TimeZone getTimeZone(String town){
        String[] tzs = TimeZone.getAvailableIDs();
        String ttown = "";

        for (String t : tzs){
            ttown = t.substring(t.lastIndexOf("/") + 1, t.length());
            if (ttown.equals(town)){
                return TimeZone.getTimeZone(t);
            }
        }
        return TimeZone.getDefault();
    }

    public int getHour(TimeZone tz){
        return Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
    }

    public ResourceBundle getRes(Locale locale) {
        try {
            if (locale.getDisplayLanguage().equals("???????")){
                return ResourceBundle.getBundle("Greeting_ru_Ua", locale);
            } else
                return ResourceBundle.getBundle("Greeting", locale);
        }catch (NullPointerException e) {
            return ResourceBundle.getBundle("Greeting", Locale.getDefault());
        }
    }
}