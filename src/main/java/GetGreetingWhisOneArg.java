import java.io.UnsupportedEncodingException;

public class GetGreetingWhisOneArg extends GetGreeting {
    
    public GetGreetingWhisOneArg(){
        super();
    }
    
    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        LOGGER.info("Submitted one argument");
        String town = args[0];
        String hour = getHour(getTimeZoneInTown(args[0]));
        String [] pars = {town, hour};
        LOGGER.info("Town = " + town + "; Time = "+ hour);
        return super.getGreeting(pars);
    }
}
