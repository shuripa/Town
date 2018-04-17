import java.io.UnsupportedEncodingException;
import java.util.TimeZone;
import java.util.logging.Level;

public class GetGreetingWhisTwoArgs extends GetGreeting{
    
    public GetGreetingWhisTwoArgs(){
        super();
    }
    
    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        lf.log(Level.INFO, "Submited two arguments");
        String town = args[0];
        String timeZone = args[1];
        String hour = getHour(TimeZone.getTimeZone(timeZone));
        String [] pars = {town, hour};
        lf.log(Level.INFO,"Town = " + town + "; Time = "+ hour);
        return super.getGreeting(pars);
    }
}
