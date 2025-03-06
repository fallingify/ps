import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int start = sc.nextInt();
        int end = sc.nextInt();

       for(int i = start; i <= end; i++) {
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
       }

       System.out.println(sb.toString().trim());

    }

    private static boolean isPrime(int num){
        if(num < 2) {
            return false; 
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true; 
    
    }
    
}
