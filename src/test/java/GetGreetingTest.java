import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class GetGreetingTest {
    GetGreeting grt = new GetGreeting();
    TimeZone tz = TimeZone.getTimeZone("Pacific/Saipan");

    ResourceBundle res_en = ResourceBundle.getBundle("Greeting", Locale.getDefault());
    ResourceBundle res_ru = ResourceBundle.getBundle("Greeting_ru_UA", new Locale("ru", "UA"));

    @Test
    public void getGreeting() throws UnsupportedEncodingException {
//        String s = new String(grt.getGreeting().getBytes(),);

        assertEquals("Ошибка. Город не задан", grt.getGreeting());
    }

    @Test
    public void getGreeting1() {
    }

    @Test
    public void getGreeting2() {
    }

    @Test
    public void getGreeting3() {
//        System.out.println(grt.getGreeting("Dnipro", 22, res_ru));
        assertEquals("Good morning, Kyiv!", grt.getGreeting("Kyiv", 6, res_en));
        assertEquals("Good night, Moscow!", grt.getGreeting("Moscow", 5, res_en));
        assertEquals("Добрый вечер, Dnipro!", grt.getGreeting("Dnipro", 22, res_ru));
        assertEquals("Добрый день, Saipan!", grt.getGreeting("Saipan", 12, res_ru));
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
        Locale loc1 = new Locale.Builder().setLanguage("ru").setRegion("UA").build();
        Locale loc2 = new Locale.Builder().setLanguage("xx").setRegion("XX").build();
        Locale loc3 = null;
        assertEquals("Добрый вечер, ", grt.getRes(loc1).getString("Evening"));
        assertEquals("Good morning, ", grt.getRes(loc2).getString("Morning"));
        assertEquals("Good day, ", grt.getRes(loc3).getString("Day"));

    }
}