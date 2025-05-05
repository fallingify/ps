import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 
/**
진법 변환 2 <- REVIEW 무조건 : https://m.blog.naver.com/ajy7424/222520837654

10진법 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오. 
10진법을 넘어가는 수는 숫자로 표시하지 않는다. 
0 1 2 3 4 5 6 7 8 9 A B ... Z


숫자 N을 B진법으로 표시한다. 

60466175을 36진법으로 표시한다. 
숫자가 36을 넘어가면 A - Z로 표시한다. 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int B= Integer.parseInt(st.nextToken()); 

        StringBuilder sb = new StringBuilder(); 
        while(N > 0) {
            if(N % B >= 10) {
               sb.append((char) ((N % B) + 55)); 
               
            }else{
                sb.append(N%B); 
            }
            N /= B;  //자릴수 하났기 적용해나간다. 
        }
        sb.reverse(); 
        System.out.println(sb);
    }
}
