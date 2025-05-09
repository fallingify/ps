import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**

조합에서 0의 개수 구하기 
- 끝자리 0의 개수는 2,5의 쌍이 몇 개 있는지 구해서 
- n!의 개수 = m!의 개수 - (n - m)!의 개수로 계산
- 최종적으로 min


적용개념
- 원리 1: 10은 2, 5의 곱으로 생겨난다. -> 둘 중 적은 개수가 쌍의 개수가 된다. 
- 원라 2: 이항계수는를 팩토리얼로 nCm = n! / m!(n-m)!. 
        n!의 소인수 개수 - m!의 소인수개수 - (n-m)!의 소인수 개수 
- 원리 3: 팩토리얼에서 소인수 개수를 구하는 방법을 적용


팩토리얼에서 소인수 개수 구하기 
n! = 1 .. n 인데 일일이 구하면 비효율적이므로 세는 공식을 적용합니다.
예 ) n! 안에 5의 개수? 
    n/5 -> 5의 배수 1개씩
    n/25 -> 25의 배수 1개씩
    N/125 -> 125의 배수 

*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        

        // nCm = n! / m!(n-m)! 인데 여기서는 개수를 따지는 것이므로 
        // 각 팩토리얼에서 2의 소인수가 몇 개인지 세서 n! - m! - (n-m)! 계산
        int twoCnt = get(n, 2) - get(m, 2) - get(n - m, 2);


        // 각 팩토리얼에서 5의 소인수가 몇 개인지 세서 n! - m! - (n-m)! 계산
        int fiveCnt = get(n, 5) - get(m, 5) - get(n - m, 5);
        

         // 0은 2와 5의 짝으로 만들어지므로 두 개수 중 작은 값이 정답
        System.out.println(Math.min(twoCnt, fiveCnt));
    }
    
    //n! 에서 소인수 k의 개수를 구하는 함수 
    // 100, 5
    // 100, 100/5=20, 5의배수 개수 20개
    // 20, 20/5=4, 25의 배수 
    //k를 계속해서 키울수는 없으니까 n을 줄여나가는 방식 
    //이렇게 n자체를 줄여나가면 
    //k를 직접 키울 필요없이 
    //실질적으로 k제곱수로 나누는 효과임
    private static int get(int n, int k) {
        int cnt = 0;
        
        while(n >= k) {
            cnt += n / k;
            n /= k;
        }
        
        return cnt;
    }
}