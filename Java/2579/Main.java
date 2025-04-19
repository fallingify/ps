import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
계단 오르기 

계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에서 위치한 도착점까지 가는 게임이다. 
<그림1> 과 같이 각각의 계단에는 일정한 점수가 쓰여 있는 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다. 

예를 들어 <그림2>와 같이 시작점에서 첫번째, 두번째 

주의 : 연속해서 3번 못함
첫번째는 무조건 
마지막도 무조건
 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N+1]; 

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        

        int[] dp = new int[N+1]; 
        dp[1] = arr[1]; 

        //2계단씩, 1계식
        if (N >= 2) dp[2] = arr[1] + arr[2]; // 두 번째 계단은 첫+두 계단
        
        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        
        }

        int max = dp[0]; 
 

        System.out.println(dp[N]);

    
        // 마지막을 밟으려면 
        // arr[N] + arr[N-1] + arr[N-3] -> dp[n-1] + arr[n-2] + arr[n-4]
        // 이거나
        // arr[N] + arr[N-2] + arr[N-3]; -> 


    }
}
