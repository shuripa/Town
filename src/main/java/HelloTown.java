public class HelloTown {

     public static void main(String[] args) {
         GetGreeting getgt = new GetGreeting();
         String greet = "";

         switch (args.length) {
             case 0:
                 greet = getgt.getGreeting();
                 break;
             case 1:
                 greet = getgt.getGreeting(args[0]);
                 break;
             case 2:
                 greet = getgt.getGreeting(args[0], args[1]);
                 break;
         }
         System.out.println(greet);
     }
}
