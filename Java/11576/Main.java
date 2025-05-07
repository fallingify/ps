import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
/*
11576 진법변환하기 

정이는 미래(A진법) 숫자를 자신이 쓰는 B진법으로 변환하는 프로그램을 만들고 싶다.

첫째 줄 -> 두 진법 A, B
둘째 줄 -> 자리수 개수 m(1<= m <= 25) 
셋째 줄 -> A진법 숫자의 각 자리 m개 (공백구분, 높은자리에서 낮은자리 순서)

흐름
- A진법 -> 10진법으로 변환
- 10진법 -> B진법으로 변환
- 각 자리 숫자를 공백 구분으로 출력
*/
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // A진법
		int B = Integer.parseInt(st.nextToken()); // B진법
		int N = Integer.parseInt(br.readLine());  // 자리수 개수 
		st = new StringTokenizer(br.readLine()); 

        // A진법 -> 10진법
		int decimal = 0;
		for (int i = N; i > 0; i--) {
			int input = Integer.parseInt(st.nextToken());
			decimal += (input * Math.pow(A, i - 1)); 
		}

        //10진법 -> B진법(stack을 사용) 
		Stack<Integer> stack = new Stack<>();
		while (decimal != 0) {
			stack.push(decimal % B);
			decimal /= B;
		}

        //출력
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" "); 
        }

		System.out.println(sb);
	}
}
