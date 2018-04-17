import java.io.UnsupportedEncodingException;
import java.util.TimeZone;

public class GetGreetingWhisTwoArgs extends GetGreeting{
    
    public GetGreetingWhisTwoArgs(){
        super();
    }
    
    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        LOGGER.info("Submited two arguments");
        String town = args[0];
        String timeZone = args[1];
        String hour = getHour(TimeZone.getTimeZone(timeZone));
        String [] pars = {town, hour};
        LOGGER.info("Town = " + town + "; Time = "+ hour);
        return super.getGreeting(pars);
    }
}
