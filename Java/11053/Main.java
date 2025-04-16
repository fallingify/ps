import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
가장 긴 증가하는 부분 수열

수열입력받고
수열이 최대로 기면서 증가하는 원소나열인 걸로 선택

 */

// bottom-up 방식 

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in))); 
        int N = Integer.parseInt(br.readLine()); 

        int[] dp = new int[N]; 
        int[] seq = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        
        //배열 초기화
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken()); 
        }
		
        //dp 
        for(int i=0; i<N;  i++) {
            dp[i] = 1; 
            for(int j=0; j<i; j++){
                // seq[j] < seq[i] : 원소가 오름차순인지
                // dp[i] < dp[j] + 1 : 아직 추가 안했다면
                if(seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; 
                } 
            }
        }

        //max : 최대길이 
        //dp끼리 또 비교 
        int max = 0; 
        for(int i=0; i<N; i++) {
            max = dp[i] > max? dp[i] : max; 
        }
        System.out.println(max);


    }
    
}
