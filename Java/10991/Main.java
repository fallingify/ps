import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) { 
            for(int j=n; j>i; j--) { //n-1번
                sb.append(" ");
            }
            for(int j=0; j<2*i -1; j++) { 
                if(j % 2 == 0) {
                    sb.append("*");
                }
                if(j % 2 == 1) {
                    sb.append("/");
                }
            } 
            sb.append("\n");
        }
        System.out.println(sb);
    
    }
    
}

