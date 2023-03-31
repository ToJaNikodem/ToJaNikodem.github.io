import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = input.nextInt();
        System.out.println("Podałeś liczbę: "+ liczba);
        int suma = 0;
        while(liczba>0){
            if(liczba%2!=0){
                suma+=liczba%10;
            }
            liczba/=10;
        }
        System.out.println(("Suma jej cyfr nieparzystych: "+ suma));
    }
}