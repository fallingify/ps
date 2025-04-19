import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int N = Integer.parseInt(br.readLine()); 
        int[] dp = new int[N + 1];

        //dp[i] : 항의 개수 
        for(int i=1; i<=N; i++) {
            dp[i] = i; //dp[4] = 4
            for(int j=1; j*j <= i; j++) {
                if(dp[i] > dp[i-j*j] + 1) { 
                    dp[i] = dp[i - j * j] + 1; 
                }
            }
        } // for{} end

        System.out.println(dp[N]);
    } // Main{} end



    
}
