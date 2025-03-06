import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt(); // 테스트 케이스 수

        while (testCases-- > 0) {
            int doc = sc.nextInt(), target = sc.nextInt();
            Queue<int[]> queue = new LinkedList<>(); // {문서의 인덱스, 중요도}
            
            for (int i = 0; i < doc; i++) {
                queue.offer(new int[]{i, sc.nextInt()});
            }

            int order = 0; // 출력 순서
            while (!queue.isEmpty()) {
                int[] cur = queue.poll(); // 현재 문서
                if (queue.stream().anyMatch(d -> d[1] > cur[1])) {
                    queue.offer(cur); // 뒤로 보냄
                } else {
                    order++; // 출력
                    if (cur[0] == target) { // 목표 문서라면
                        System.out.println(order);
                        break;
                    }
                }
            }
        }
    }
}

