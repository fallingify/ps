import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[t];
        for(int i=0; i<t; i++) {    
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = arr[0];
        int max = arr[0]; 
        for(int i=1; i<t; i++) {
            if(min > arr[i]){ min = arr[i]; }
            if(max < arr[i]){ max = arr[i]; }
        }
        
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
        br.close();
        


    }
    
}
