import java.io.*;
import java.util.*;

public class Main {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Interval> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A.add(new Interval(x, y));
        }

        int M = Integer.parseInt(br.readLine());
        List<Interval> B = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            B.add(new Interval(z, w));
        }

        int maxOverlap = 0;
        int bestShift = Integer.MAX_VALUE;

        // 가능한 모든 이동 거리 t = A구간 시작 - B구간 시작
        Set<Integer> shifts = new HashSet<>();
        for (Interval a : A) {
            for (Interval b : B) {
                shifts.add(a.start - b.start);
            }
        }

        // 각 shift에 대해 A와 B를 겹쳐보고 최대 겹침 계산
        for (int shift : shifts) {
            int totalOverlap = 0;

            for (Interval a : A) {
                for (Interval b : B) {
                    int shiftedStart = b.start + shift;
                    int shiftedEnd = b.end + shift;

                    int overlapStart = Math.max(a.start, shiftedStart);
                    int overlapEnd = Math.min(a.end, shiftedEnd);

                    if (overlapStart <= overlapEnd) {
                        totalOverlap += (overlapEnd - overlapStart + 1);
                    }
                }
            }

            // 더 많은 겹침이거나, 같다면 더 작은 shift
            if (totalOverlap > maxOverlap || (totalOverlap == maxOverlap && shift < bestShift)) {
                maxOverlap = totalOverlap;
                bestShift = shift;
            }
        }

        System.out.println(bestShift);
    }
}
