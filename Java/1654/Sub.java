import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sub {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine(), " " ); 

        int K = Integer.parseInt(st.nextToken()); //입력값 
        int N = Integer.parseInt(st.nextToken()); //개수 

        //값 입력받기 
        int[] arr = new int[K]; 
        long max = 0; 

        //max값 구하기 
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
            if(max < arr[i]) {
                max = arr[i]; 
            }
        }
        
        max++; //max + 1; 
        long min = 0; 
        long mid = 0; 

        //이분탐색 : min == max 이면 끝
        while(min < max) {
            mid = (max + min) / 2; //중간값찾고 
            long count = 0; //개수카운트 
            for(int i=0; i<arr.length; i++) {
                count += (arr[i]/mid); 
            }
            if(count < N){
                max = mid; 
            } else {
                min = mid + 1; 
            }

        }
        System.out.println(min - 1);


    }
}
