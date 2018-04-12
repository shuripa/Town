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
//        assertTrue(idTime.isIdentifyTimeZone("Kyiv"));
//        assertTrue(idTime.isIdentifyTimeZone("Kyiv"));
        idTime = new IdentifyTime("Israel");
//        assertTrue(idTime.isIdentifyTimeZone().equals("GMT+02:00"));
        idTime = new IdentifyTime("Iran");
        idTime = new IdentifyTime("Jamaica");


    }
}