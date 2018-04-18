import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

@SuppressWarnings({"ALL", "ClassInDefaultPackage"})
public class Town {
    //Changed swithc-case
    private static Logger LOGGER;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, UnsupportedEncodingException {
        try {
            LOGGER = Logger.getLogger(Town.class.getSimpleName());
            LOGGER.info("started");
        }catch (Exception e){
            System.out.println("" + e.getMessage());
        }
        
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
