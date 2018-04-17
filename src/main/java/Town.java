import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

public class Town {
    //Changed swithc-case
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, UnsupportedEncodingException {
        String[] clName = {"GetGreetingWhisoutArgs", "GetGreetingWhisOneArg", "GetGreetingWhisTwoArgs"};
        int cnt = (args.length >2) ? 2: args.length;
        //Correction Name
        if (args.length > 1)  args[0] = args[0].replace(' ', '_');
        
        GetGreeting grt = (GetGreeting) Class.forName(clName[cnt]).getConstructor().newInstance();
        String result = grt.getGreeting(args);
        System.out.println(result); 
    }
}