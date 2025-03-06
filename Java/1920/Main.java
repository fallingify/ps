import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextInt());
        }

        int M = scanner.nextInt();
        int[] queries = new int[M];
        
        for (int i = 0; i < M; i++) {
            queries[i] = scanner.nextInt();
        }
        
        for (int num : queries) {
            if (set.contains(num)) {
                System.out.println(1);  // 존재하면 1 출력
            } else {
                System.out.println(0);  // 존재하지 않으면 0 출력
            }
        }

        scanner.close();
    }
}
