import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = Integer.parseInt(scanner.nextLine());
    int[] queries = new int[N];

    String[] input = scanner.nextLine().split(" ");
    for (int i = 0; i < N; i++) {
        queries[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(queries);

    StringBuilder sb = new StringBuilder();
    for (int num : queries) {
        sb.append(num).append("\n");
    }

    System.out.print(sb.toString());
    scanner.close();
  }
}
