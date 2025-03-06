import java.util.Scanner;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE; // Change to MAX_VALUE to track minimum differences.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // Number of players (must be even)

        matrix = new int[N][N];  // Synergy matrix
        visited = new boolean[N];  // Track which players are in team A

        // Fill the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        getCombination(0, 0);  // Start forming teams
        System.out.println(min);  // Output minimum difference
        sc.close();
    }

    // Recursive method to get combinations of teams
    public static void getCombination(int idx, int count) {
        if (count == N / 2) {  // When team A has N/2 players
            diff();  // Calculate the difference in synergy
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;  // Include player i in team A
                getCombination(i + 1, count + 1);  // Recurse for next player
                visited[i] = false;  // Backtrack
            }
        }
    }

    // Method to calculate difference in synergy between two teams
    public static void diff() {
        int oneTeam = 0;  // Synergy of team A
        int theOtherTeam = 0;  // Synergy of team B

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    oneTeam += matrix[i][j];  // Add synergy for team A
                } else if (!visited[i] && !visited[j]) {
                    theOtherTeam += matrix[i][j];  // Add synergy for team B
                }
            }
        }

        int val = Math.abs(oneTeam - theOtherTeam);  // Calculate difference
        min = Math.min(val, min);  // Track minimum difference
    }
}
