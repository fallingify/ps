import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 가장 긴 감소하는 부분 수열
 -> "11053 가장 긴 증가하는 부분 수열"와 정반대

수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 
가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10} 이고, 길이는 3이다.

 */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " "); 

        int[] seq = new int[n]; 
        int[] dp = new int[n]; 


        //배열 초기화
        for(int i=0; i<n; i++) {
            seq[i] = Integer.parseInt(st.nextToken()); 
        }

        
        //dp[i] : i번쨰를 넣었을때 가장 길이가 내림차순 수열(길이)
        for(int i=0; i<n; i++) {
            dp[i] = 1; 
            for(int j=0; j<i; j++) {
                if(seq[j] > seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; 
                } 
            }
        }

        int min =0; 
        for(int i=0; i<n; i++) {
            min = min > dp[i] ? min: dp[i]; 
        }
        
        System.out.println(min);

    }
}
