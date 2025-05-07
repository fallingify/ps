import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		if (N == 0) { // N이 0이먄 -2진법도 0
			System.out.println(0);
		} else {
            // -2진법
			while (N != 1) { // N = 1일때까지 반복
				sb.append(Math.abs(N % -2)); //현재값을 -2로 니눈나머지
				N = (int) Math.ceil((double) N / (-2)); //나눈 몫을 올림처리하여 계산

			}

			sb.append(N);

			sb.reverse(); 
			System.out.println(sb);
		}

    }
}