import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=t; i++) {
            int v = t - i;
            for(int j=0;j<v; j++){
                sb.append(" ");
            }

            for(int k=0; k<i; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();

    }    
}
