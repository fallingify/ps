import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        ArrayList<Integer> list = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder(); 
    
        int A = Integer.parseInt(st.nextToken()); 
        int p = Integer.parseInt(st.nextToken()); 
        list.add(A); 

        while(true) {
            int tmp = list.get(list.size() - 1); 
            int sum = 0; 

            while(tmp != 0){
                sum += (int) Math.pow(tmp % 10, p); // 뒷자리부터
                tmp /= 10; //그다음자리로 이동할 수 있음

            }
           
            //이미 있으면 반복수열 전까지 스탑
            if(list.contains(sum)) {
                int cnt = list.indexOf(sum); // 인덱스는 -1로 되기 때문에 반복수열전까지의 개수를 알려준다. 
                sb.append(cnt).append('\n'); 
                break; 
            }
            else{
                list.add(sum);
            }
        }
        System.out.println(sb);

    }
    
}
