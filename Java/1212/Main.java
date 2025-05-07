import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
8진수 2진수

8진수를 받아서 2진수로 변환한다. 
입력값을 문자열로 받아서 하나씩 쪼개어준다.

쪼개어진 입력값을 하나씩 Integer.toBinaryString에 넣어서 2진수를
StringBuilder에 넣어준다. 이때 처음 입력받은 문자는 따로 처리해준다.

 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine(); 
        StringBuilder sb = new StringBuilder(); 

        for(int i=0; i<before.length(); i++) {
            int after = before.charAt(i) - '0'; //숫자로 만들기 
            String str = Integer.toBinaryString(after); //숫자를 2진수 문자로변환
            if(str.length() == 3) {
                sb.append(str); 
            } 
            else if(str.length() == 2 && i != 0) {
                sb.append('0' + str); 
            }
            else if(str.length() == 1 && i != 0) {
                sb.append("00" + str); 
            }
            else {
                sb.append(str); 
            }
        }   
        System.out.println(sb);
    }
    
}
