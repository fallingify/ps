import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] queries = new int[N];


        for (int i = 0; i < N; i++) {
            queries[i] = scanner.nextInt();
        }
        

        int tmp;
        for (int i = 0; i < N - 1; i++) { 
            for (int j = 0; j < N - 1 - i; j++) {  
                if (queries[j] > queries[j + 1]) {  
                    tmp = queries[j];
                    queries[j] = queries[j + 1];
                    queries[j + 1] = tmp;
                }
            }
        }
        for (int num : queries) {
            System.out.println(num);  
        }

        scanner.close();
    }
}
