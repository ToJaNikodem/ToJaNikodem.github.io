import java.io.*;

public class Main {
   public static void main(String[] args) {
      String line = "";
      FileInputStream plikWejscie = null;
      try {
         plikWejscie = new FileInputStream("dane.txt");
      } catch (FileNotFoundException e) {
         System.out.println("Brak pliku.");
         System.exit(-1);
      }

      FileOutputStream wyjscie = null;
      try {
         wyjscie = new FileOutputStream("wyjscie.txt");
         System.out.println("Plik został utworzony.");
      } catch (FileNotFoundException e) {
         System.out.println("Błąd przy otwieraniu pliku.");
         System.exit(-1);
      }

      BufferedReader br = new BufferedReader(new InputStreamReader(plikWejscie));
      DataOutputStream out = new DataOutputStream(wyjscie);

      try {
         while (true) {
            if ((line = br.readLine()) == null || line.equals("quit"))
               break;
            out.writeBytes(line + "\n");
         }
      } catch (IOException e) {
         System.out.println("Błąd wejścia/wyjścia");
      }

   }
}