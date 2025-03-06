import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int sum = 0;
        String str =  br.readLine();
        
        for(int i=0; i<t; i++) {
            int a = str.charAt(i) - '0';
            sum += a;
        }
        System.out.println(sum);
        br.close();
    }
}
