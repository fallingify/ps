import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // dp테이블 생성 및 초기화
        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        } 

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(dp[n]);
        }
        


    }
}
