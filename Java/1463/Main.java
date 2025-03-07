import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    static Integer[] dp; //연산횟수를 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0; 

        System.out.println(recur(N));


    }
    
    static int recur(int N) {
        if(dp[N] == null){
            //최소공약수인 6으로 나눠떨어지는 경우 ->  연산최소목적을 위해 비교
            if(N % 6 == 0) {
                dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2))) + 1;  //연산했으니까 + 1
            }
            else if(N % 3 == 0) {
                dp[N] = Math.min(recur(N/3), recur(N-1)) + 1; 
            }
            else if(N % 2 == 0) {
                dp[N] = Math.min(recur(N/2), recur(N-1)) + 1; 
            }
            else{
                dp[N] = recur(N-1) + 1; 
            } 
        }
        return dp[N]; //연산횟수리턴
    
    }
}
