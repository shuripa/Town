import org.junit.Test;
import static org.junit.Assert.*;

import java.util.TimeZone;

public class IdentifyTimeTest {

    @Test
    public void testConstructorIdentifyTime(){
        IdentifyTime idTime;
        TimeZone tz;

        //1
        try {
            idTime = new IdentifyTime();
        }catch (RuntimeException e){
            assertTrue(e.getMessage().equals("Не задан город"));
        }

        //2
        idTime = new IdentifyTime("Kyiv");
        assertTrue(idTime.getTimeZone().equals(TimeZone.getDefault()));
        idTime = new IdentifyTime("Israel");
        assertTrue(idTime.getTimeZone().equals(TimeZone.getTimeZone("Israel")));
        idTime = new IdentifyTime("Iran");
        assertTrue(idTime.getTimeZone().equals(TimeZone.getTimeZone("Iran")));
        idTime = new IdentifyTime("Jamaica");
        assertTrue(idTime.getTimeZone().equals(TimeZone.getTimeZone("Jamaica")));

        //3
        idTime = new IdentifyTime("Kyiv", "GMT+02:00");
    }
}