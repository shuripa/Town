import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class TownTest {
    Boolean b = Town.addLogger();
    
    @Test
    public void addLogger() {
        assertTrue(b);
    }

    @Test
    public void getGreeting() throws UnsupportedEncodingException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String []s = new String[]{};
        String result;

        assertTrue("You should use arguments > Town [GMT+0]".equals(Town.getGreeting(s)));

        s = new String[]{"AnyTown"};
        result = Town.getGreeting(s);
        result = result.substring(result.length()-8, result.length()-1);
        assertEquals("AnyTown", result);
        assertEquals("AnyTown", "AnyTown");

        //assertEquals("Any_Town", "Any Town");  
        s = new String[]{"Any Town"};
        result = Town.getGreeting(s);
        result = result.substring(result.length()-9, result.length()-1);
        assertEquals("Any_Town", result);

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