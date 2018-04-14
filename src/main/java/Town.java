import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Town {

     public static void main(String[] args) throws UnsupportedEncodingException {
         Logger lg = Logger.getLogger(Town.class.getName());

         try {
            FileHandler fh = new FileHandler("town.log",500,1,true);
            lg.addHandler(fh);
         }catch (IOException e){
             lg.log(Level.WARNING, "Нет доступа к лог-файлу town.log", e.getMessage());
         }

         GetGreeting gt = new GetGreeting();
         String greet = "";

         switch (args.length) {
             case 0:
                 lg.log(Level.INFO, "Аргументов нет");
                 greet = gt.getGreeting();
                 break;
             case 1:
                 lg.log(Level.INFO, "Один аргумент");
                 greet = gt.getGreeting(args[0]);
                 break;
             case 2:
                 lg.log(Level.INFO, "Два аргумента");
                 greet = gt.getGreeting(args[0], args[1]);
                 break;
         }
         System.out.println(greet);
     }
}
