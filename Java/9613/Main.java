import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
GCD 합

양의 정수 n개가 주어졌을 때,
가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder(); 
        int[] arr; 
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()); 
            int k = Integer.parseInt(st.nextToken()); 
            arr = new int[k]; 
            int idx = 0;
            while (k-- > 0) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(getGcdSum(arr)); 

            sb.append('\n'); 
            
        }
        System.out.println(sb);

    }

    public static int getGcd(int a, int b) {
        while(b != 0){
            int temp = b; 
            b = a % b; 
            a = temp; 
        }
        return a; 
    }
    private static long getGcdSum(int[] arr) {
        long result = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
               result += getGcd(arr[i], arr[j]);
            }
        }
        
        return result; 
    }
    
}


