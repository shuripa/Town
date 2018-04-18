import java.io.UnsupportedEncodingException;
import java.util.TimeZone;

public class GetGreetingWhisTwoArgs extends GetGreeting {
    public GetGreetingWhisTwoArgs(){
        super();
    }

    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        LOGGER.info("Submited two arguments");
        TimeZone tz = TimeZone.getTimeZone(args[1]);
        String hour = getHour(TimeZone.getTimeZone(args[1]));
        LOGGER.info("Town = " + args[0] + "; Time = "+ hour + "; Zone = " + tz.getID());
        String [] pars = {args[0], hour};
        return super.getGreeting(pars);
    }
}
