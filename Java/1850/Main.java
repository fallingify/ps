import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 최대공약수
 * 
모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 
이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.

예를 들어, A가 111이고, B가 1111인 경우에 
A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
 */
public class Main { 

    public static long getGcd(long a, long b) {
        while(b != 0){
            long temp = b; 
            b = a % b; 
            a = temp; 
        }
        return a; 
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        StringBuilder sb = new StringBuilder(); 


        long a = Long.parseLong(st.nextToken()); 
        long b =Long.parseLong(st.nextToken()); 

        for(int i=0; i<getGcd(a, b); i++) 
            sb.append('1'); 

        System.out.println(sb);
    }   
    
}
