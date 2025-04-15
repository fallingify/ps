
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Main {
    final static long MOD = 1_000_000_000;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(br.readLine());    
        int[][] dp = new int[N + 1][10]; 
        

        for(int i=1; i<10; i++) {
            dp[1][i] = 1; 
        }
        

        for(int i=2; i<=N; i++) {
            
            for(int j=0; j<10; j++) {

                if(j == 0) {
                    dp[i][0] = (int) (dp[i-1][1] % MOD); 
                }
                else if(j == 9){
                    dp[i][9] = (int) (dp[i-1][8] % MOD); 
                }
                else {
                    dp[i][j] =(int) (( dp[i-1][j-1]  + dp[i-1][j+1]) % MOD); 
                }
            }
        }

        long result = 0; 

        for(int i=0; i<10; i++) {
            result += dp[N][i]; 
        }

        System.out.println(result % MOD);
    }
}


/**
 *  dp[i][0]는 경우의 수를 담는 배열이며, 
 *  i는 숫자의 자릿수를 의미한다. 
 */