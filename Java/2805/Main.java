import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 


        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        

               
        int[] arr =  new int[N]; 
        int maxHeight = 0; 
        st = new StringTokenizer(br.readLine(), " "); 
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
            if(arr[i] > maxHeight) {
                maxHeight = arr[i]; 
            }
        }

        int start = 0; 
        int end = maxHeight; 
        int result = 0; 

        //이진 탐색
        while(start < end)  {
            int mid = start + (end - start) / 2; 

            long sum = 0; 
            for(int i : arr) {
                if(i > mid) { //절단길이보다 높으면 자른다
                    sum += (i - mid); //짤라서 더한다. 
                }
            }

            if(sum >= M) {
                result = mid; 
                start = mid + 1; 
            } else {
                end = mid - 1; 
            }
        }

        System.out.println(result);


        

    }
    
}


