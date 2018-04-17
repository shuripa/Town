//import org.junit.Test;
//import java.io.UnsupportedEncodingException;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.ResourceBundle;
//import java.util.TimeZone;
//import static org.junit.Assert.*;
//
//
//public class GetGreetingTest {
//    //TODO: Chek this.
//    GetGreeting grt = new GetGreeting();
//    TimeZone tz = TimeZone.getTimeZone("Pacific/Saipan");
//    int t;
//
//    ResourceBundle res_en = ResourceBundle.getBundle("greet", new Locale("en"));
//    ResourceBundle res_ru = ResourceBundle.getBundle("greet", new Locale("ru"));
//    ResourceBundle res_xx = ResourceBundle.getBundle("greet", new Locale("xx"));
//
//    @Test
//    public void getGreeting() {
//        assertEquals("You should use arguments > Town [GMT+0]", grt.getGreeting());
//    }
//
//    @Test
//    public void getGreeting1() throws UnsupportedEncodingException {
//        t = grt.getHour(grt.getTimeZoneInTown("Moscow"));
//        assertEquals(grt.getGreeting("Moscow", t, res_xx), grt.getGreeting("Moscow"));
//        //TODO: TimeZone tz = TimeZone.getTimeZone("UTC");
//        t = grt.getHour(TimeZone.getDefault());
//        assertEquals(grt.getGreeting("Dnipro", t, res_xx), grt.getGreeting("Dnipro"));
//    }
//
//    @Test
//    public void getGreeting2() throws UnsupportedEncodingException {
//        t = grt.getHour(TimeZone.getTimeZone("GMT+11"));
//        assertEquals(grt.getGreeting("Moscow", t, res_xx), grt.getGreeting("Moscow", "GMT+11"));
//        t = grt.getHour(TimeZone.getTimeZone("GMT-11"));
//        assertEquals(grt.getGreeting("Dnipro", t, res_xx), grt.getGreeting("Dnipro", "GMT-11"));
//    }
//
//    @Test
//    public void getGreeting3() throws UnsupportedEncodingException {
//        assertEquals("Добрый день, G-1!", grt.getGreeting("G-1", -1, res_ru));
//        assertEquals("Доброй ночи, G0!", grt.getGreeting("G0", 0, res_ru));
//        assertEquals("Good morning, G6!", grt.getGreeting("G6", 6, res_en));
//        assertEquals("Good day, G9!", grt.getGreeting("G9", 9, res_en));
//        assertEquals("Добрый вечер, G22!", grt.getGreeting("G22", 22, res_ru));
//        assertEquals("Доброй ночи, G24!", grt.getGreeting("G24", 24, res_ru));
//        assertEquals("Good day, G25!", grt.getGreeting("G25", 25, res_en));
//    }
//
//    @Test
//    public void getTimeZone() {
//        assertEquals(grt.getTimeZoneInTown("Saipan"), tz);
//        assertEquals(grt.getTimeZoneInTown("NoTown"), TimeZone.getDefault());
//    }
//
//    @Test
//    public void getHour() {
//        int h = Calendar.getInstance(tz).get(Calendar.HOUR_OF_DAY);
//        assertTrue(h == grt.getHour(tz));
//    }
//
//    @Test
//    public void getRes() {
//        assertEquals(res_ru, grt.getRes(new Locale("ru")));
//        assertEquals(res_en, grt.getRes(new Locale("en")));
//        assertEquals(res_xx, grt.getRes(new Locale("xx")));
//    }
//
//    @Test
//    public void encode() throws UnsupportedEncodingException {
//        assertEquals("Доброе утро, ", grt.encode("Morning", res_ru));
//        assertEquals("Good night, ", grt.encode("Night", res_en));
//    }
//}