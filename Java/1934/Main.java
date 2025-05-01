import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 
 최소공배수 구하기 
 - 유클리드 호재법으로 사용하여 구한다. 
 */
public class Main {

    public static int getGcd(int a, int b) {
        while(b != 0){
            int temp = b; 
            b = a % b; 
            a = temp; 
        }
        return a; 
    }
    public static int getLcm(int a, int b) {
      return a * b / getGcd(a, b); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder(); 


        int n = Integer.parseInt(br.readLine()); 
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 

        
            sb.append(getLcm(a, b)).append('\n'); 
        }
        System.out.println(sb);
    }
    
}
