
import java.io.*;
import java.util.StringTokenizer; 
/**
스티커 

상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 
스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.

상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다.
즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.

모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다.
먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오. 

즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.

위의 그림의 경우에 점수가 50, 50, 100, 60인 스티커를 고르면, 점수는 260이 되고 이 것이 최대 점수이다. 
가장 높은 점수를 가지는 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.


 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine()); 


        while(T-- > 0){
        
            int N = Integer.parseInt(br.readLine());  // 한중
            int[][] arr = new int[2][N + 1];  // (1, 2, ..., N)
            int[][] dp = new int[2][N + 1]; 

            //배열 초기화
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } 


            //맨 앞 초기화
            dp[0][1] = arr[0][1];  
            dp[1][1] = arr[1][1]; 

            //dp[?][k] : k번째 스티커를 떼는 경우의 최대점수 
            //뜯긴 스티커의 대각선만 가능해짐 -> dp[not?][k-1],  dp[not?][k-2]은 가능함. 
            for(int k=2; k<=N; k++) {
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + arr[0][k];
				dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + arr[1][k];
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");

        } //end while
        System.out.println(sb);
    }//main
} //Main


