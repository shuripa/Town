
import java.io.UnsupportedEncodingException;

public class Town {

     public static void main(String[] args) throws UnsupportedEncodingException {

         String greet = getGreeting(args);

         System.out.println(greet);
     }

    public static String getGreeting(String[] args) throws UnsupportedEncodingException {
        GetGreeting gt = new GetGreeting();
        String greet = "";

        switch (args.length) {
            case 0: greet = gt.getGreeting(); break;
            case 1: greet = gt.getGreeting(args[0]); break;
            case 2: greet = gt.getGreeting(args[0], args[1]); break;
            default:   greet = gt.getGreeting(args[0], args[1]); break;
        }
        return greet;
    }
}