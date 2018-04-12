import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.*;

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
//        assertTrue(idTime.identifyTimeZone().equals("GMT+02:00"));
        idTime = new IdentifyTime("Dnipro");
//        assertTrue(idTime.identifyTimeZone().equals("GMT+02:00"));

    }
}