import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 팩토리얼0 의 개수 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());  // 10 

        int cnt = 0;
        //5의 개수 세기  
        for(int i=5; i<= n ; i*=5) {
            cnt += n / i; 
        }
        System.out.println(cnt);


 
    }
    
}


