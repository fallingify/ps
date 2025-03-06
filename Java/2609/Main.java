import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 첫 번째 숫자
        int M = sc.nextInt();  // 두 번째 숫자

        int gcdFactor = 1;  // 공약수를 저장할 변수 (초기값 1)



        gcdFactor = GCD(N, M);

         
        // 최소공배수(LCM) 계산
        int lcm = (N * M) / gcdFactor;  // LCM = (N * M) / GCD

        System.out.println(gcdFactor);  // 공약수 출력
        System.out.println(lcm);  // 최소공배수 출력

        sc.close();  // Scanner 닫기
    }

    private static int GCD(int N, int M){ // 3 15 -> (15, 5)
        if(N % M == 0){
            return M;
        }
        return GCD(M, N % M); // (15, 5)
    }
}
