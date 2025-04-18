import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
가장 긴 바이토닉 부분 수열 (길이 측정)

바이토직중에 가장 긴 수열을 구해서 그 길이를 리턴한다. 

바이토닉 정렬 
제일 큰 수를 기준으로 왼쪽 -> 오름차순
제일 큰 수를 기준으로 오른쪽 -> (뒤에서 부터) 오름차순
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st =new StringTokenizer(br.readLine(), " "); 

        int[] seq = new int[N]; 
        //배열 초기화
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken()); 
        }


        //dp[i] : 오름차순 " seq[i] > seq[j] "
        int[] rdp = new int[N];
        for(int i=0; i<N; i++) {
            rdp[i] = 1; 
            //정상으로 오름차순
            for(int j=0; j<i; j++) {
                if(seq[i] > seq[j] && rdp[i] < rdp[j] + 1 ) {
                    rdp[i] = rdp[j] + 1; 
                }
            }
        } 


        //dp[i] : 오름차순 " seq[i] < seq[j] "
        int[] kdp = new int[N]; 
        for(int i=N-1; i>=0; i--){
            kdp[i] = 1; 
            for(int j=N-1; j>i; j--){
                if(seq[i] > seq[j] && kdp[i] < kdp[j] + 1 ) {
                    kdp[i] = kdp[j] + 1; 
                }
            }
        }



		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < rdp[i] + kdp[i]) {
				max = rdp[i] + kdp[i];
			}
		}


        System.out.println(max-1);

    }
}
