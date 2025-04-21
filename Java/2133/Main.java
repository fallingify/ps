import java.io.*; 
/* 
타일 채우기 

3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine()); 

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[N+1]; 
        dp[0] = 1; 
        dp[2] = 3;

        for(int i=4; i<=N; i+=2) {
            dp[i]=dp[i - 2]*3;
            for(int j=0; j<=i - 4; j+=2) {
                dp[i]+=dp[j]*2;
            }
        }

        System.out.println(dp[N]);


    }
}
