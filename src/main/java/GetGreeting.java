import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class GetGreeting {

    public String getGreeting() {
        return "Ошибка. Город не задан";
    }

    public String getGreeting(String townName) {
        return getGreeting(townName, identifyTimeZone(townName));
    }

    public String getGreeting(String townName, String timeZone) {
        return getGreeting(townName, TimeZone.getTimeZone(timeZone));
    }

    private String getGreeting(String town, TimeZone tz) {
        Calendar c = Calendar.getInstance(tz);
        String greeting="";
        Locale ruLocle = new Locale("ru", "UA");
        ResourceBundle res = ResourceBundle.getBundle("Greeting", Locale.getDefault());

        if ("русский".equals(Locale.getDefault().getDisplayLanguage()))
            res = ResourceBundle.getBundle("Greeting_ru_Ua", ruLocle);

        switch (c.get(Calendar.HOUR_OF_DAY)){
            case 6:
            case 7:
            case 8: greeting = res.getString("Morning"); break;
            case 19:
            case 20:
            case 21:
            case 22: greeting = res.getString("Evening"); break;
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:greeting = res.getString("Night"); break;
            default: greeting = res.getString("Day"); break;
        }
        greeting += town +"!";
        return greeting;
    }

    private TimeZone identifyTimeZone(String town){
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
}
