import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합에서 끝자리 0의 개수 구하기
 *
 * 핵심 아이디어:
 * - 끝자리 0의 개수 = (2, 5 쌍의 개수) → min(2의 개수, 5의 개수)
 * - nCm = n! / (m!(n-m)!)
 *   → 소인수 개수 = n!에서의 개수 - m!에서의 개수 - (n-m)!에서의 개수
 *
 * 소인수 개수 세는 방법:
 * - n!에서 k의 소인수 개수 = n / k + n / (k^2) + n / (k^3) + ...
 *   → 5의 배수, 25의 배수, 125의 배수 ... 모두 누적
 *   → while로 n을 줄여가며 간단히 계산 (k를 계속 곱하지 않아도 됨)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2의 소인수 개수 = n! - m! - (n-m)!
        int twoCount = getFactorCount(n, 2) - getFactorCount(m, 2) - getFactorCount(n - m, 2);

        // 5의 소인수 개수 = n! - m! - (n-m)!
        int fiveCount = getFactorCount(n, 5) - getFactorCount(m, 5) - getFactorCount(n - m, 5);

        // 0의 개수 = 2, 5 쌍의 개수 → 둘 중 최소값
        System.out.println(Math.min(twoCount, fiveCount));
    }

    /**
     * n!에서 소인수 k의 총 개수를 구하는 함수
     * 
     * 예: n=100, k=5
     * 100/5 = 20  (5의 배수)
     * 100/25 = 4  (25의 배수 → 추가 5 하나씩)
     * 100/125 = 0 (125는 100보다 크므로 끝)
     * 합계 = 24
     *
     * 핵심 아이디어:
     * - k, k^2, k^3 ... 단계별로 나누며 모두 누적
     * - k를 계속 곱하지 않고 n을 줄여가며 처리 (n /= k)
     */
    private static int getFactorCount(int n, int k) {
        int count = 0;

        while (n >= k) {
            count += n / k;
            n /= k;
        }

        return count;
    }
}
