import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        StringBuilder sb = new StringBuilder();



        int t = Integer.parseInt(br.readLine());
        
    
        for(int i=0;i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            

            int j = i+1;
            sb.append("Case #" + j + ": " + a + " + " + b + " = ").append(a + b).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
    
}
