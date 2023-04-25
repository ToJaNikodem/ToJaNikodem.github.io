import java.io.File;
import java.util.Scanner;
import java.lang.Math;
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
        return 0;
    }
	public static void main(String[] args) {
		
        File plik = new File("dane4.txt");
        int l = 0;
        try (Scanner odczyt = new Scanner(plik)) {
            int liczba = odczyt.nextInt();
            int min = liczba, max = liczba;
            while (odczyt.hasNextInt()){
                if(czyPierwsza(liczba)==1){
                    l++;
                    if(liczba>max){
                        max = liczba;
                    }
                    if(liczba<min){
                        min = liczba;
                    }
                }
                liczba = odczyt.nextInt();
            }
            System.out.println("Ilośc pierwszych: " + l);
            System.out.println("Liczba min: " + min);
            System.out.println("Liczba max: " + max);
            odczyt.close();
        }catch (IOException e) {
            System.out.println("Błąd");
        }
        
	}
}
