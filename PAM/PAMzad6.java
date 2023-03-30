import java.util.Scanner;

class Main {
   public static void main(String[] args) {
      class Punkt {
         static int x = 0;
         static int y = 0;

         static void incr() {
            Scanner a = new Scanner(System.in);
            System.out.println("Którą wartość chcesz zwiększyć? (x/y)");
            String chosenVar = a.nextLine();
            if (chosenVar.equals("x")) {
               x++;
            } else if (chosenVar.equals("y")) {
               y++;
            } else {
               System.out.println("Wrong input!");
            }
            System.out.println("x=" + Punkt.x);
            System.out.println("y=" + Punkt.y);
         };

         static void freeChange() {
            Scanner a = new Scanner(System.in);
            System.out.println("Którą wartość chcesz zmienić? (x/y)");
            String chosenVar = a.nextLine();
            Scanner b = new Scanner(System.in);
            System.out.println("Chcesz dodać czy odjąc wartość? (+/-)");
            String chosenAction = b.nextLine();
            Scanner c = new Scanner(System.in);
            System.out.println("Ile chcesz dodać/odjąć?");
            int chosenValue = c.nextInt();
            if (chosenVar.equals("x")) {
               if (chosenAction.equals("+")) {
                  x += chosenValue;
               } else if (chosenAction.equals("-")) {
                  x -= chosenValue;
               } else {
                  System.out.println("Złe dane!");
               }
            } else if (chosenVar.equals("y")) {
               if (chosenAction.equals("+")) {
                  y += chosenValue;
               } else if (chosenAction.equals("-")) {
                  y -= chosenValue;
               } else {
                  System.out.println("Złe dane!");
               }
            } else
               System.out.println("Złe dane!");
            System.out.println("x=" + Punkt.x);
            System.out.println("y=" + Punkt.y);
         };

         static int showx() {
            return Punkt.x;
         }

         static int showy() {
            return Punkt.y;
         }

         static void showBoth() {
            System.out.println("x=" + Punkt.x);
            System.out.println("y=" + Punkt.y);
         }
      }
      class test {
         static void test() {
            Punkt.incr();
            Punkt.freeChange();
            System.out.println(Punkt.showx());
            System.out.println(Punkt.showy());
            Punkt.showBoth();
         }
      }
      test.test();
   }
}