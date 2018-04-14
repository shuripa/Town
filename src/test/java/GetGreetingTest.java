import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.*;

import static org.junit.Assert.*;


public class GetGreetingTest {
    private static Logger lg;
    GetGreeting grt = new GetGreeting();
    TimeZone tz = TimeZone.getTimeZone("Pacific/Saipan");

    ResourceBundle res_en = ResourceBundle.getBundle("greet", new Locale("en"));
    ResourceBundle res_ru = ResourceBundle.getBundle("greet", new Locale("ru"));
    ResourceBundle res_xx = ResourceBundle.getBundle("greet", new Locale("xx"));

    @Before
    public static void init() {
        lg = Logger.getLogger(Town.class.getName());
        try {
            FileHandler fh = new FileHandler("town.log");
            lg.addHandler(fh);
        } catch (IOException e) {
            lg.log(Level.WARNING, "Нет доступа к лог-файлу town.log", e.getMessage());
        }
    }

    @Test
    public void getGreeting() throws UnsupportedEncodingException {
//        String s = new String(grt.getGreeting().getBytes(),);

//        assertEquals("??????. ????? ?? ?????.", grt.getGreeting());
    }

    @Test
    public void getGreeting1() {
    }

    @Test
    public void getGreeting2() {
    }

    @Test
    public void getGreeting3() throws UnsupportedEncodingException {
//        System.out.println(grt.getGreeting("Dnipro", 22, res_ru));
//        return new String(val.getBytes("ISO-8859-1"), "UTF-8");
//        String s = new String(grt.getGreeting("Dnipro", 22, res_ru).getBytes("UTF-8"), "ISO-8859-1");
//        System.out.println(s);
        lg.log(Level.INFO, "Начинается тест: getGreeting3()");
        assertEquals("Good morning, Kyiv!", grt.getGreeting("Kyiv", 6, res_en));
        assertEquals("Good night, Moscow!", grt.getGreeting("Moscow", 5, res_en));
        assertEquals("Добрый вечер, Dnipro!", grt.getGreeting("Dnipro", 22, res_ru));
//        assertEquals("?????? ????, Saipan!", grt.getGreeting("Saipan", 12, res_ru));
        lg.log(Level.INFO, "Пройден тест: getGreeting3()");
    }

    @Test
    public void getTimeZone() {
        assertEquals(grt.getTimeZone("Saipan"), tz);
        assertEquals(grt.getTimeZone("Kyiv"), TimeZone.getDefault());
    }

    @Test
    public void getHour() {
        int h = Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
        assertTrue(h == grt.getHour(tz));

    }

    @Test
    public void getRes() {
//        Locale loc1 = new Locale.Builder().setLanguage("ru").setRegion("UA").build();
//        Locale loc2 = new Locale.Builder().setLanguage("xx").setRegion("XX").build();
//        Locale loc3 = null;

//        assertEquals("?????? ?????, ", grt.getRes(loc1).getString("Evening"));
//        assertEquals("Good morning, ", grt.getRes(loc2).getString("Morning"));
//        assertEquals("Good day, ", grt.getRes(loc3).getString("Day"));

    }
}