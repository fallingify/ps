import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack; 

/**
쇠 막대기


 */

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String line = br.readLine(); 
        Stack<Character> stack = new Stack<>(); 
        
        int cnt = 0; 
        char[] ch = line.toCharArray(); 
        for(int i=0; i<ch.length; i++){
            if(ch[i] == '(') {
                stack.push('(');
                continue; 
            }
            if(ch[i] == ')'){
                stack.pop(); 
                if(ch[i-1] == '(') {
                    cnt += stack.size(); 
                } else{
                    cnt++; 
                }
            }
        }

        bw.write(cnt + "\n"); //'\n' 을 해야 줄 단위가 마무리 되었구나 라고 알고 버퍼를 비우면서 출력함
        bw.flush();
        br.close();
        bw.close();
     

    }
    
}
