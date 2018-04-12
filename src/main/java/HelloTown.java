public class HelloTown {

     public static void main(String[] args) {
         GreetingPrint gtPrint;

         switch (args.length) {
             case 0:
                 gtPrint = new GreetingPrint();
                 break;
             case 1:
                 gtPrint = new GreetingPrint(args[0]);
                 break;
             case 2:
                 gtPrint = new GreetingPrint(args[0], args[1]);
                 break;
         }
     }
}
