import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

@SuppressWarnings({"ALL", "ClassInDefaultPackage"})
public class Town {
    //Logger - log4j
    private static Logger LOGGER;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, UnsupportedEncodingException {
        addLogger();
        System.out.println(Town.getGreeting(args));
    }

    static String getGreeting(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, UnsupportedEncodingException {
        //Delete swithc-case
        String[] clName = {"GetGreetingWhisoutArgs", "GetGreetingWhisOneArg", "GetGreetingWhisTwoArgs"};
        int cnt = (args.length >2) ? 2: args.length;
        //Correction Name by two varints enter: "Los Angeles" and Los_Angeles
        if (args.length > 0)  args[0] = args[0].replace(' ', '_');
        
        GetGreeting grt = (GetGreeting) Class.forName(clName[cnt]).getConstructor().newInstance();
        LOGGER.info("ended");
        LOGGER.info("--------------------------------");
        String result = grt.getGreeting(args);
        return result;
    }

    static Boolean addLogger() {
        try {
            LOGGER = Logger.getLogger(Town.class.getSimpleName());
            LOGGER.info("started");
            return true;
        }catch (Exception e){
            System.out.println("" + e.getMessage());
            return false;
        }
    }
}
