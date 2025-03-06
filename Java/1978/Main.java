import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] elements = new int[N];
        for(int i=0; i<N; i++) {
            elements[i] = sc.nextInt();
        }

        int count = 0; 
        for (int i=0; i<N; i++) {
            if(isPrime(elements[i])) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();


    }
    
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i=2; i*i <= num;i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
}
