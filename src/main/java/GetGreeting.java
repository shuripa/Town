import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.*;

public class GetGreeting {
    final String N = "Night";
    final String M = "Morning";
    final String D = "Day";
    final String E = "Evening";
    final String [] timeOfDays = {N, N, N, N, N, N, M, M, M, D, D, D, D, D, D, D, D, D, D, E, E, E, E, N, N};
    final Logger lf;
    int hour;
    ResourceBundle res;

    public GetGreeting() {
        //TODO: Change logger
        lf = Logger.getLogger(Town.class.getName());
        
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT][%4$-7s]  %5$-50s{%2$s}%n");
        try {
            FileHandler fh = new FileHandler("town.log",10000,1,true);
            fh.setFormatter(new SimpleFormatter());
            lf.addHandler(fh);
        }catch (IOException e){
            lf.log(Level.WARNING, "Don't access file town.log", e.getMessage());
        }
        res = getRes(getLocale());
    }
        
    public String getGreeting() {
        lf.log(Level.INFO, "Without argument");
        return "You should use arguments > Town [GMT+0]";
    }

    public String getGreeting(String town) throws UnsupportedEncodingException{
        lf.log(Level.INFO, "Submitted one argument");
        hour = getHour(getTimeZoneInTown(town));
        lf.log(Level.INFO,"Town = " + town + "; Time = "+ hour + "; " + "Res = " + res.getLocale().getLanguage());
        return getGreeting(town, hour, res);
    }

    public String getGreeting(String town, String timeZone) throws UnsupportedEncodingException{
        lf.log(Level.INFO, "Submited two arguments");
        hour = getHour(TimeZone.getTimeZone(timeZone));
        lf.log(Level.INFO,"Town = " + town + "; Time = "+ hour + "; " + "Res = " + res.getLocale().getLanguage());
        return getGreeting(town, hour, res);
    }
    
    //TODO: Changed swithc-case
    public String getGreeting(String town, int localHour, ResourceBundle localRes) throws UnsupportedEncodingException {
        String s = "Day";
        if (localHour> -1 && localHour < 25) s = timeOfDays[localHour];
        return getEncode(s, localRes) + town +"!";
    }

    public TimeZone getTimeZoneInTown(String town){
        String[] tz = TimeZone.getAvailableIDs();
        String tn = "";

        for (String t : tz){
            tn = t.substring(t.lastIndexOf("/") + 1, t.length());
            if (tn.equals(town)){
                
                lf.log(Level.INFO, "Timezone is changed: " + t);
                return TimeZone.getTimeZone(t);
            }
        }
        lf.log(Level.INFO, "Timezone is default");
        return TimeZone.getDefault();
    }

    public int getHour(TimeZone tz){
        int h = Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
        lf.log(Level.INFO, "Get time is done: " + h);
        return h;
    }

    public ResourceBundle getRes(Locale locale) {
        ResourceBundle res = ResourceBundle.getBundle("greet", locale);
        lf.log(Level.INFO, "Get res is done: " + res.getLocale().getLanguage());
        return res;
    }

    public String getEncode(String key, ResourceBundle localRes) throws UnsupportedEncodingException {
        String encode = new String(localRes.getString(key).getBytes("ISO-8859-1"), "ISO-8859-5");
        lf.log(Level.INFO, "Encoding is done");
        return encode;
    }
    
    public Locale getLocale (){
        Locale l = Locale.getDefault();
        lf.log(Level.INFO, "Get system locale is done: " + l.getLanguage());
        return l;
    }

}