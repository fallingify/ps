import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder st =new StringBuilder(); 
        String line = br.readLine(); 
        st.append(line.length()); 
        System.out.println(st);
    }
}
