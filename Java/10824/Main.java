import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        String a = st.nextToken(); 
        String b = st.nextToken(); 
        long first = Long.parseLong(a + b); 
        String c = st.nextToken(); 
        String d = st.nextToken(); 
        long second = Long.parseLong(c + d); 
        System.out.println(first + second);



    }
    
}
