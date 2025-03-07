import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++) {
            for(int j=t-i; j>=1; j--){
                sb.append(" ");
            } //공백
            
            for(int k=1; k<=i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=t-1; i>=1; i--) {
            for(int j=i; j<=t-1; j++){
                sb.append(" ");
            } //공백
            for(int k=i; k>=1; k--){
                sb.append("*");
            }//별
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    
}
