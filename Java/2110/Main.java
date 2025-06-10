import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; 
    static int C; 
    static int N;

    //공유기를 N개 집에 설치하기 위해서는 최소거리를 유지해야한다. 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 

        N = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); //공유기 

        arr = new int[N]; 


        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(arr); 

        int low = 1; 
        int high = arr[N-1] - arr[0]; 
        int result = 0; 

        while(low <= high) {
            int mid = low + (high - low) / 2; 

            if(check(mid)) {
                result = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        System.out.println(result);
        br.close();  
    }


    //Greedy방식
    //최소거리를 mid로 할때 N개집에서 c공유기 설치가능한가?
    private static boolean check(int mid) {
        int count = 1; 
        int intalledHome = arr[0]; //첫번째 공유기는 무조건 첫번째 위치에

        for(int i=1; i<N; i++) { //그 다음 공유기를 설치한다. 
            if(arr[i] - intalledHome >= mid) { //어느 정도의 거리가 존재하는지 
                count++;  //설치 
                intalledHome = arr[i];  //설치된집 추가 
            }
        }

        return count >= C; //기준치 공유기를 다 설치했다면? boolean을 리턴한다. 
    }
    
}
