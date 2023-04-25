import java.util.Scanner;
class Main{
    static void bmi(){
        double w, h, r;
        Scanner sca = new Scanner(System.in);
        System.out.println("Waga");
        w = sca.nextDouble();
        System.out.println("Wzrost (w metrach)");
        h = sca.nextDouble();
        r = w / Math.pow(h, 2);
        if(r < 18.5){
            System.out.println(String.format("%.1f", r) + " - Niedowaga");
        }
        else if(r > 18.5 && r < 24.9){
            System.out.println(String.format("%.1f", r) + " - Waga prawidłowa");
        }
        else if(r > 24.9){
            System.out.println(String.format("%.1f", r) + " - Nadwaga");
        }
        else System.out.println("Błędne dane!");
    }
    public static void main(String[] args){
        bmi();
    }
}