public class GetGreetingWhisoutArgs extends GetGreeting {
    public GetGreetingWhisoutArgs(){
        super();
    }

    public String getGreeting(String [] args) {
        LOGGER.info("Without argument");
        return "You should use arguments > Town [GMT+0]";
    }
}
