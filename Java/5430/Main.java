import java.io.*;
import java.util.*;

/**
 * BufferedReader는 예외처리가 필수적임 throw 날림
 * br.readLine() -> String
 * 
 * Deque<Integer>
 * pollFirst()
 * 
 * Iterator<Integer> 
 * iterator()
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            String cmd = br.readLine(); // 명령어
            int n = Integer.parseInt(br.readLine()); // 원소 개수
            String input = br.readLine(); // 배열 입력

            Deque<Integer> dq = parseArray(input, n);

            boolean isError = false;
            boolean isReversed = false;

            for (char c : cmd.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (!deleteDeque(dq, isReversed)) {
                        isError = true;
                        break;
                    }
                }
            }

            result.append(isError ? "error\n" : formatResult(dq, isReversed));
        }

        System.out.print(result);
    }

    // 배열을 Deque로 변환
    public static Deque<Integer> parseArray(String input, int n) {
        Deque<Integer> deque = new LinkedList<>();
        if (n > 0) {
            String[] elements = input.substring(1, input.length() - 1).split(",");
            for (String e : elements) {
                deque.add(Integer.parseInt(e.trim()));
            }
        }
        return deque;
    }

    // 삭제 연산
    private static boolean deleteDeque(Deque<Integer> deque, boolean isReversed) {
        if (deque.isEmpty()) return false;
        if (isReversed) deque.pollLast();
        else deque.pollFirst();
        return true;
    }

    // 결과 포맷팅
    private static String formatResult(Deque<Integer> deque, boolean isReversed) {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Integer> iterator = isReversed ? deque.descendingIterator() : deque.iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}
