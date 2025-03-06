import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();  HashSet<Integer> queriesSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            queriesSet.add(scanner.nextInt());
        }

        int p = scanner.nextInt();  
        StringBuilder resultContainer = new StringBuilder();
        for (int i = 0; i < p; i++) {
            resultContainer.append(queriesSet.contains(scanner.nextInt()) ? "1 " : "0 ");
        }
        
        System.out.println(resultContainer.toString().trim());

        scanner.close();
    }
}
