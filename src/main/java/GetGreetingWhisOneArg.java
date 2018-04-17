import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

public class GetGreetingWhisOneArg extends GetGreeting {
    
    public GetGreetingWhisOneArg(){
        super();
    }
    
    public String getGreeting(String [] args) throws UnsupportedEncodingException {
        lf.log(Level.INFO, "Submitted one argument");
        String town = args[0];
        String hour = getHour(getTimeZoneInTown(args[0]));
        String [] pars = {town, hour};
        lf.log(Level.INFO,"Town = " + town + "; Time = "+ hour);
        return super.getGreeting(pars);
    }
}
