import sun.util.calendar.ZoneInfo;

import java.util.Calendar;
import java.util.TimeZone;

public class HelloTown {

     public static void main(String[] args) {
         IdentifyTime idt;

         switch (args.length) {
             case 0:
                 idt = new IdentifyTime();
                 break;
             case 1:
                 idt = new IdentifyTime(args[0]);
                 break;
             case 2:
                 idt = new IdentifyTime(args[0], args[1]);
                 break;
         }
     }
}
