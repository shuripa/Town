import java.io.UnsupportedEncodingException;
import java.util.TimeZone;

public class GetGreetingWhisOneArg extends GetGreeting{

    public GetGreetingWhisOneArg (){
        super();
    }

    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        LOGGER.info("Submitted one argument");
        TimeZone tz = getTimeZoneInTown(args[0]);
        String hour = getHour(tz);
        LOGGER.info("Town = " + args[0] + "; Time = "+ hour + "; Zone = " + tz.getID());
        String [] pars = {args[0], hour};
        return super.getGreeting(pars);
    }
}
