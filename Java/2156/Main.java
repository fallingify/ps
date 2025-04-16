import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
포도주 시식

3개연속안되고 최대 2개 연속으로만 가능할떄 
최대 섭취 포도주 양

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        int[] arr = new int[N + 1];  // (1, 2, ..., N)
        int[] dp = new int[N + 1]; 

        // 배열 입력 
        
        for(int i = 1; i <= N; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }


        //맨 앞 초기화
        dp[1] = arr[1];     
        if(N > 1) {
            dp[2] = arr[1] + arr[2]; 
        }
        
        //dp[k] : k를 뽑을 때 최댓값
        for(int k=3; k <=N; k++) {
            //0 v (vs) v v
            dp[k] = Math.max(dp[k-1], 
                    Math.max(
                        dp[k-2] + arr[k], dp[k-3] + arr[k-1] + arr[k]
        
                    )
                ); 
        }
        System.out.println(dp[N]);

    

        
    }
    
}
