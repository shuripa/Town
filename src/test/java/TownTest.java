import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class TownTest {

    @Test
    public void getGreeting() throws UnsupportedEncodingException {
        String [] s= new String[]{};
        String result;
                
        assertTrue("You should use arguments > Town [GMT+0]".equals(Town.getGreeting(s)));
        
        s = new String[]{"AnyTown"};
        result = Town.getGreeting(s);
        result = result.substring(result.length()-8, result.length()-1);
        assertEquals("AnyTown", result);

        s = new String[]{"AnyTown", "GMT+0"};
        result = Town.getGreeting(s);
        result = result.substring(result.length()-8, result.length()-1);
        assertEquals("AnyTown", result);
        
        s= new String[]{"AnyTown", "GMT+0", "OtherTown"};
        result = Town.getGreeting(s);
        result = result.substring(result.length()-8, result.length()-1);
        assertEquals("AnyTown", result);

    }
}