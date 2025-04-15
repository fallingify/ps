import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();

        int t = Integer.parseInt(br.readLine());


        for(int j=0; j<t; j++) {
            
            int[] dp = new int[11];
            
            dp[1] = 1; 
            dp[2] = 2; 
            dp[3] = 4; 
            
            int n = Integer.parseInt(br.readLine());
            for(int i=4; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            st.append(dp[n]).append("\n");
        }//end
        
        
        System.out.println(st);
    }
}