import org.junit.Test;
import static org.junit.Assert.*;

import java.util.TimeZone;

public class GreetingPrintTest {

    @Test
    public void testConstructorIdentifyTime(){
        GreetingPrint gtPrint;
        TimeZone tz;

        //1
        try {
            gtPrint = new GreetingPrint();
        }catch (RuntimeException e){
            assertTrue(e.getMessage().equals("Не задан город"));
        }

        //2
        gtPrint = new GreetingPrint("Kyiv");
        assertTrue(gtPrint.getTimeZone().equals(TimeZone.getDefault()));
        gtPrint = new GreetingPrint("Israel");
        assertTrue(gtPrint.getTimeZone().equals(TimeZone.getTimeZone("Israel")));
        gtPrint = new GreetingPrint("Iran");
        assertTrue(gtPrint.getTimeZone().equals(TimeZone.getTimeZone("Iran")));
        gtPrint = new GreetingPrint("Jamaica");
        assertTrue(gtPrint.getTimeZone().equals(TimeZone.getTimeZone("Jamaica")));

        //3
        gtPrint = new GreetingPrint("Kyiv", "GMT+02:00");
    }
}