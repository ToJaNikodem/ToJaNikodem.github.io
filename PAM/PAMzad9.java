import java.io.File;
import java.util.Scanner;
import java.lang.Math;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static int czyPierwsza(double p){
        if(p % 1 == 0){
            for(int i = 2; i < p; i++){
            if (p % i == 0){
                return 0;
            }
        }
        return 1;
        }
        else return 0;
    }
    public static double square(int n){
        double s = Math.sqrt(n);
        return s;
    }
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileWriter("odpowiedz.txt"))){
            File plik = new File("liczby.txt");
            Scanner odczyt = new Scanner(plik);
            while (odczyt.hasNextInt()){
                int liczba = odczyt.nextInt();
                if(czyPierwsza(square(liczba))==1){
                    out.println(liczba);
                }
            }
            odczyt.close();
        }
        catch(IOException e){
            System.out.print("Błąd");
        }
    }
}
