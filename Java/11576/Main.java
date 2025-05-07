import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int decimal = 0;
		for (int i = N; i > 0; i--) {
			int input = Integer.parseInt(st.nextToken());
			decimal += (input * Math.pow(A, i - 1));
		}

		List<Integer> list = new ArrayList<>();
		while (decimal != 0) {
			list.add(decimal % B);
			decimal /= B;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}