import java.io.*;
import java.util.*;

//오르막 수: 각 자릿수가 비내림차순인 수 

public class Main {
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int MOD = 10007; 
		
		int[] dp = new int[10]; 
		for (int i = 0; i < 10; i++) {
			dp[i] = 1; 
		} 

		for(int i=2; i<=N; i++) {
			for(int j=1; j<10; j++) {
				dp[j] = (dp[j] + dp[j-1]) % MOD; 
			}
		}
		

		int answer = 0; 
		for(int val: dp) {
			answer = (answer + val) % MOD; 
		}
		System.out.println(answer % 10007);
	}
        
        
 }
