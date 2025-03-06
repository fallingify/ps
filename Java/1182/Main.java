import java.io.*;
import java.util.StringTokenizer;

/**
 *  다시 풀기 
 */

public class Main {
    static int N, S;
    static int[] numbers;
    static int count = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        findSubsequence(0, 0);

        if(S == 0){ count--; }

        System.out.println(count);
                
    }

          
    private static void findSubsequence(int index, int sum) {
        if(index == N) {
            if(sum == S) {
                count++;
            }
            return;
        }
        findSubsequence(index + 1, sum + numbers[index]);

        findSubsequence(index + 1, sum);

    }
        
}
