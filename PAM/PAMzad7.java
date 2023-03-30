import java.util.Scanner;
class Main{
    static double zamiana(){
        double c, f;
        Scanner sca = new Scanner(System.in);
        System.out.println("Podaj wartość w Celsjuszach");
        c = sca.nextDouble();
        f = 1.8 * c + 32;
        return f;
    }
    public static void main(String[] args){
        System.out.println(zamiana());
    }
}