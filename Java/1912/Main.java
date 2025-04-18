import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
연속합 

몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
단 음수도 포함되어 있다. 

연속한 수라는데 그냥 dp로 구하면 되고 합을 구하는 수는 연속하지 않아도 된다. 

아래방식은 buttom-up 방식이다. 

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st =new StringTokenizer(br.readLine(), " "); 
        int[] arr = new int[N];
        
        //음수부호체크하는 배열
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        //dp[i]: i번쨰 수가 들어간 배열의 합 중에서 가장 큰 수이며 연속되어 있는 수들의 합
        int[] dp = new int[N];
        dp[0] = arr[0]; 
        int max = arr[0]; 


        //i는 1부터 시작한다. 0부터 하면 inbountError가 발생한다
        for(int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); 
            max = Math.max(max, dp[i]); 
        }
        
        System.out.println(max);
        
    }
    
}
