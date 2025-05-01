import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 접미사 배열

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        String s = br.readLine();  //backjoon
        String[] str = new String[s.length()]; //글자수만큼 문자열 배열을 생성
        for(int i=0; i<s.length(); i++){
           str[i] = s.substring(i); 
        }

        Arrays.sort(str); 
        for(String k : str) {
            System.out.println(k);
        }

        
    }

}
