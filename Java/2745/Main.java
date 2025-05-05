import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
진법변환 
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔서 출력한다. 
10이 넘어가는 숫자는 A - Z로 표기되어 있다. 원래 숫자로 다시 되돌려야 한다. 

*/ 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        StringBuilder sb = new StringBuilder(st.nextToken()); //zzzzz
        String N = sb.reverse().toString();  //zzzzz, 나중에 다른수나올 수 도 있으므로 뒤집는다
        int B = Integer.parseInt(st.nextToken()); //36진법, 36보다 큰수는 변환한다

        int n; //계산과정에서 나오는 수들을 담음
        int sum = 0;  //최종결과
        for(int i=0; i<N.length(); i++) {//입력 수를 한 자리씩 처리 
            // A-Z일때 -55를 뺴고 숫자로 만든다. 
            if(N.charAt(i) >= 'A' && N.charAt(i) <= 'Z'){
                n = N.charAt(i) - 55; 
            }else{  //숫자인경우 0을 빼고 숫자로 만든다. 
                n = N.charAt(i) - '0'; 
            }  //더한다. 
            sum += (n * Math.pow(B, i));  //pow(a, b) a의 b제곱인수,왜냐면 진법수이므로 36진수로 생성해야하기 때문이다.
        } 
        System.out.println(sum);
      
    }   
    
}
