import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class GreetingPrint {

    private TimeZone tz;
    private String town;

    public GreetingPrint() {
        throw new RuntimeException("Не задан город");
    }

    public GreetingPrint(String townName) {
        town = townName;
        tz = identifyTimeZone(townName);
        printHello();
    }

    public GreetingPrint(String townName, String timeZone) {
        town = townName;
        tz = TimeZone.getTimeZone(timeZone);
        printHello();
    }

    public TimeZone getTimeZone(){
        return tz;
    }

    private TimeZone identifyTimeZone(String town){

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

    private void printHello() {
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

        System.out.println(greeting + town +"!");
    }
}
