
import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import static org.junit.Assert.*;


@SuppressWarnings({"ALL", "ClassInDefaultPackage"})
public class GetGreetingTest {
    GetGreeting grt = new GetGreeting();
    GetGreetingWhisoutArgs grtNone = new GetGreetingWhisoutArgs();
    GetGreetingWhisOneArg grtOne = new GetGreetingWhisOneArg();
    GetGreetingWhisTwoArgs grtTwo = new GetGreetingWhisTwoArgs();
    TimeZone tz = TimeZone.getTimeZone("Pacific/Saipan");
    TimeZone tzUTC = TimeZone.getTimeZone("UTC");
    String t;
    String h;

    ResourceBundle res_en = ResourceBundle.getBundle("greet", new Locale("en"));
    ResourceBundle res_ru = ResourceBundle.getBundle("greet", new Locale("ru"));
    ResourceBundle res_xx = ResourceBundle.getBundle("greet", new Locale("xx"));
    String[] args;
    String[] sdef =  new String[]{};
    String[] sone1 =  new String[]{"Moscow"};
    String[] sone2 =  new String[]{"Dnipro"};
    String[] stwo1 =  new String[]{"Moscow", "GMT+11"};
    String[] stwo2 =  new String[]{"Dnipro", "GMT-11"};

    
    @Test
    public void GetGreetingWhisoutArgs() {
        assertEquals("You should use arguments > Town [GMT+0]", grtNone.getGreeting(sdef));
    }

    @Test
    public void GetGreetingWhisOneArg() throws UnsupportedEncodingException {
        t = grtOne.getHour(grtOne.getTimeZoneInTown("Moscow"));
        args =  new String[]{"Moscow", t};
        assertEquals(grtOne.getGreeting(args), grtOne.getGreeting(sone1));

        t = grtOne.getHour(TimeZone.getTimeZone("UTC"));
        args =  new String[]{"Dnipro", t};
        assertEquals(grtOne.getGreeting(args), grtOne.getGreeting(sone2));
    }

    @Test
    public void GetGreetingWhisTwoArgs() throws UnsupportedEncodingException {
        t = grtTwo.getHour(TimeZone.getTimeZone("GMT+11"));
        args = new String[]{"Moscow", "GMT+11"};
        assertEquals(grtTwo.getGreeting(args), grtTwo.getGreeting(stwo1));
        t = grtTwo.getHour(TimeZone.getTimeZone("GMT-11"));
        args = new String[]{"Dnipro", "GMT-11"};
        assertEquals(grtTwo.getGreeting(args), grtTwo.getGreeting(stwo2));
    }

//    @Test
//    public void Greeting.GetGreetingWhisTwoArgs() throws UnsupportedEncodingException {
//        assertEquals("Добрый день, G-1!", grt.getGreeting("G-1", -1, res_ru));
//        assertEquals("Доброй ночи, G0!", grt.getGreeting("G0", 0, res_ru));
//        assertEquals("Good morning, G6!", grt.getGreeting("G6", 6, res_en));
//        assertEquals("Good day, G9!", grt.getGreeting("G9", 9, res_en));
//        assertEquals("Добрый вечер, G22!", grt.getGreeting("G22", 22, res_ru));
//        assertEquals("Доброй ночи, G24!", grt.getGreeting("G24", 24, res_ru));
//        assertEquals("Good day, G25!", grt.getGreeting("G25", 25, res_en));
//    }

    @Test
    public void getTimeZone() {
        assertEquals(grt.getTimeZoneInTown("Saipan"), tz);
        //"UTC"
        assertEquals(grt.getTimeZoneInTown("NoTown"), TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void getHour() {
        h ="" + Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
        assertEquals(h, grt.getHour(tz));
        h ="" + Calendar.getInstance(tzUTC).get(Calendar.HOUR_OF_DAY);
        assertEquals(h, grt.getHour(tzUTC));
    }

    @Test
    public void getRes() {
        assertEquals(res_ru, grt.getRes(new Locale("ru")));
        assertEquals(res_en, grt.getRes(new Locale("en")));
        assertEquals(res_xx, grt.getRes(new Locale("xx")));
    }

    @Test
    public void encode() throws UnsupportedEncodingException {
        assertEquals("Доброе утро, ", grt.encode("Morning", res_ru));
        assertEquals("Good night, ", grt.encode("Night", res_en));
    }
}