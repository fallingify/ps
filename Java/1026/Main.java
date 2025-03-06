import java.util.Scanner;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] query_A = new int[N];
        int[] query_B = new int[N];


        for(int i=0; i< N; i++) {
            query_A[i] = scanner.nextInt();
        }

        for(int i=0; i < N; i++) {
            query_B[i] = scanner.nextInt();

        }
        
        Arrays.sort(query_A);

        Integer[] indices = new Integer[N];
        for(int i=0; i<N; i++) {
            indices[i] = i;

        }

        //index로 표현 
        Arrays.sort(indices, (i, j) -> Integer.compare(query_B[j], query_B[i]));

        int result = 0; 
        for(int i = 0; i < N; i++) {
            result += query_A[i] * query_B[indices[i]];
        }

        System.out.println(result);

        scanner.close();




   
    }

    
}
