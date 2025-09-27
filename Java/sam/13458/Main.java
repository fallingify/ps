import java.util.*; 
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution(); 
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());  //반개수 입력받기 
        int[] arr = new int[n]; //각 반당 인원수 입력받기 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //입력받기 
        }
        st = new StringTokenizer(br.readLine()); 
        int b = Integer.parseInt(st.nextToken());  //총감독
        int c = Integer.parseInt(st.nextToken());  //부감독
    
        long sum = n; //경우의 수 
        for(int i=0; i<n; i++) {
            int cur = arr[i] - b; //총 감독은 시험장당 1명 있어야 한다. b는 총감독이 볼 수 있는 응시자수를 말한다. 
            if(cur <= 0) continue; //0이면 다음 클래스로 넘어간다.
            if(cur % c == 0) {
                sum += cur / c; 
            } else {
                sum += cur / c + 1;  //c로 나눠서 진다면 c보다 작으므로 + 1만 하면 된다. 
            }
        }
        System.out.println(sum); 

    }   
}
