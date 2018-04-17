import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;

public class Town {
    //Changed swithc-case
    private static final Logger LOGGER = Logger.getLogger(Town.class.getSimpleName());
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, UnsupportedEncodingException {
        LOGGER.info("started");
        String[] clName = {"GetGreetingWhisoutArgs", "GetGreetingWhisOneArg", "GetGreetingWhisTwoArgs"};
        int cnt = (args.length >2) ? 2: args.length;
        //Correction Name
        if (args.length > 1)  args[0] = args[0].replace(' ', '_');
        
        GetGreeting grt = (GetGreeting) Class.forName(clName[cnt]).getConstructor().newInstance();
        String result = grt.getGreeting(args);
        LOGGER.info("ended");
        LOGGER.info("--------------------------------");
        System.out.println(result);
    }
}

