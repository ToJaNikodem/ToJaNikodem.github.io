class Main {
    public static void main(String args[]) {
        for(int i=1;i<=10; i++){
            System.out.println(i+" ");
        }
        System.out.println();
        for(int i=100; i>=0; i-=5){
            if(i%2==0)
                continue;
            if(i==25)
                break;
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=1; i<=10; i++){
            for(int j=1; j<=11-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}