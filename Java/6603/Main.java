import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;

            String[] inputs = line.split(" ");
            int k = Integer.parseInt(inputs[0]);
            int[] S = new int[k];

            // 집합 S 초기화
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(inputs[i + 1]);
            }

            List<int[]> combinations = new ArrayList<>();
            generateCombinations(S, new int[6], 0, 0, combinations);

            // 결과 조합 출력
            for (int[] combination : combinations) {
                for (int i = 0; i < combination.length; i++) {
                    sb.append(combination[i]);
                    if (i < combination.length - 1) sb.append(" ");
                }
                sb.append("\n");
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 조합 생성 메서드
    private static void generateCombinations(int[] S, int[] combination, int start, int depth, List<int[]> result) {
        if (depth == 6) {
            result.add(combination.clone());
            return;
        }

        for (int i = start; i < S.length; i++) {
            combination[depth] = S[i];
            generateCombinations(S, combination, i + 1, depth + 1, result);
        }
    }
}
