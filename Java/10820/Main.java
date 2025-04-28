import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String line = null; 
        while ((line = br.readLine()) != null){
            int count[] = new int[4]; 
            for (int i=0; i<line.length(); i++) {
                char c = line.charAt(i); 
                if (c >= 'a' && c <= 'z') { // 소문자 
                    count[0]++; 
                }
                else if (c >= 'A' && c <= 'Z') { // 대문자 
                    count[1]++; 
                }
                else if (c >= '0' && c <= '9') { // 숫자 
                    count[2]++; 
                }
                else {  //공백 
                    count[3]++; 
                }
            }
            System.out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3]);
        } //while()문 
        


    }
}
