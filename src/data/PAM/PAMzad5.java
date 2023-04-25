class Kolo {
   double radius = 0;
   int color = 0;
   float area = 0;

   Kolo() {
      area = 5;
   }

   Kolo(int kolor, double promien) {
      color = kolor;
      radius = promien;
   }

   public double Oblicz_Pole() {
      return Math.PI * (radius * radius);
   }

   public void Ustaw_Promien(float r) {
      radius = r;
   }

   public void Ustaw_Kolor(int c) {
      color = c;
   }
}

class Main {

   static boolean Porownaj_Kola(float r1, float r2, int c1, int c2) {
      if (r1 == r2 && c1 == c2) {
         return true;
      }
      return false;
   }

   public static void main(String[] args) {
      Kolo kolo1 = new Kolo();
      Kolo kolo2 = new Kolo();

      if (Porownaj_Kola(kolo1.area, kolo2.area, kolo1.color, kolo2.color)) {
         System.out.println("Koła są takie same!");
      } else {
         System.out.println("Koła nie są takie same!");
      }

      kolo1.Ustaw_Kolor(1);
      kolo2.Ustaw_Kolor(1);

      if (Porownaj_Kola(kolo1.area, kolo2.area, kolo1.color, kolo2.color)) {
         System.out.println("Koła są takie same!");
      } else {
         System.out.println("Koła nie są takie same!");
      }

      kolo1.Ustaw_Kolor(3);
      kolo2.Ustaw_Kolor(2);

      if (Porownaj_Kola(kolo1.area, kolo2.area, kolo1.color, kolo2.color)) {
         System.out.println("Koła są takie same!");
      } else {
         System.out.println("Koła nie są takie same!");
      }
   }
}