import java.util.Scanner;

class Main {
   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int choice = 4;
      while (choice != 0) {
         System.out.println("Telewizor v.0.1");
         System.out.println("\t0 - zakończ działanie");
         System.out.println("\t1 - zwiększ głośnośc o 5%");
         System.out.println("\t2 - zmniejsz głośność o 5%");
         System.out.println("\t3 - ustaw numer kanału");
         choice = scan.nextInt();
         System.out.println("Wybrałeś: " + choice);

         switch (choice) {
            case 1:
               TV.volumeUp();
               break;
            case 2:
               TV.volumeDown();
               break;
            case 3:
               TV.channelSel();
               break;
         }
      }
   }
}

class TV {
   static int volume = 0;
   static int channel = 0;

   static Scanner scan = new Scanner(System.in);

   static void volumeUp() {
      if (volume < 100) {
         volume += 5;
         System.out.print("Zwiększono głośność na " + volume + "%\n");
      } else {
         System.out.print("Obecnie jest ustawiona nawyższa głośnośc (100%)\n");
      }

   }

   static void volumeDown() {
      if (volume > 0) {
         volume -= 5;
         System.out.print("Zmniejszono głośność na " + volume + "%\n");
      } else {
         System.out.print("Obecnie jest ustawiona najniższa głośnośc (0%)\n");
      }
   }

   static void channelSel() {
      System.out.print("Wybierz numer kanału od 1 do 4\n");
      String choice = scan.nextLine();
      if(Integer.parseInt(choice)>=1 && Integer.parseInt(choice)<=4){
         switch (Integer.parseInt(choice)){
            case 1:
               channel = 1;
               System.out.print("Zmieniono na kanał nr 1\n");
               break;
            case 2:
               channel = 2;
               System.out.print("Zmieniono na kanał nr 2\n");
               break;
            case 3:
               channel = 3;
               System.out.print("Zmieniono na kanał nr 3\n");
               break;
            case 4:
               channel = 4;
               System.out.print("Zmieniono na kanał nr 4\n");
               break;
         }
      }else{
         System.out.print("Niepoprawny numer kanału!\n");
      }
      
   }
}
