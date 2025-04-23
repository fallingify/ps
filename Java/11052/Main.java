import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
카드 구매하기 


카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, 
... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면
 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다. 
 따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다. 카드가 i개 포함된 카드팩의 가격은 Pi원이다.

예를 들어, 카드팩이 총 4가지 종류가 있고,
 P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 
 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다. 2개 들어있는 카드팩을 2번 사면 된다.

P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 
카드가 1개 들어있는 카드팩을 4번 사면 20원이고, 이 경우가 민규가 지불해야 하는 금액의 최댓값이다.

마지막으로, P1 = 3, P2 = 5, P3 = 15, P4 = 16인 경우에는 
3개 들어있는 카드팩과 1개 들어있는 카드팩을 구매해 18원을 지불하는 것이 최댓값이다.

카드 팩의 가격이 주어졌을 때, 
N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오.
 N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
 */
public class Main {    

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  //구매하려고 하는 카드개수 

        // seq[i] : i개가 들어있는 카드팩의 가격
        int[] price = new int[N+1]; 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            price[i] = Integer.parseInt(st.nextToken()); 
        }
        int[] dp = new int[N + 1];

        //dp[i] : i개 살떄 최대비용
        //dp[4]
        // = max(dp[3] + price[1], dp[2] + price[2], dp[1] + price[3], dp[0] + price[4])
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
            }
        }

        System.out.println(dp[N]);
      
    }
    public static void main(String[] args) throws Exception {
        new Main().solution(); 

    }
}
