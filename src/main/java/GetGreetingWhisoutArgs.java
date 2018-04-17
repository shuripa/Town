import java.util.logging.Level;

public class GetGreetingWhisoutArgs extends GetGreeting {

    public GetGreetingWhisoutArgs(){
        super();
    }
    
    public String getGreeting(String [] args) {
        lf.log(Level.INFO, "Without argument");
        return "You should use arguments > Town [GMT+0]";
    }
}
