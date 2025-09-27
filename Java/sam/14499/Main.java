import java.util.*;
import java.io.*;

public class Main {
    // 1=동, 2=서, 3=북, 4=남
    static int[] dx = {0, 0, 0, -1,  1}; // 행 변화량 (x)
    static int[] dy = {0, 1, -1, 0,  0}; // 열 변화량 (y)

    static int onX, onY, k, height, width;
    static int[] dice = new int[7]; // 인덱스 1~6 사용: 1=윗, 6=아랫, 2=북, 5=남, 3=동, 4=서
    static int[][] map;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());  // N (행)
        width  = Integer.parseInt(st.nextToken());  // M (열)
        onX    = Integer.parseInt(st.nextToken());  // 시작 r
        onY    = Integer.parseInt(st.nextToken());  // 시작 c
        k      = Integer.parseInt(st.nextToken());  // 명령 개수

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int cmd = 0; cmd < k; cmd++) {
            int dir = Integer.parseInt(st.nextToken());
            if (move(dir)) {                 // 성공한 이동만 출력
                sb.append(dice[1]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    // 이동 성공 시 true, 범위 밖이면 false
    static boolean move(int dir) {
        int nx = onX + dx[dir];
        int ny = onY + dy[dir];

        // 범위 체크 (밖이면 명령 무시)
        if (nx < 0 || ny < 0 || nx >= height || ny >= width) {
            return false;
        }

        // 주사위 회전
        roll(dir);

        // 위치 갱신
        onX = nx;
        onY = ny;

        // 지도 <-> 주사위 바닥면 값 복사 규칙
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[6];
        } else {
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
        return true;
    }

    // dir: 1=E, 2=W, 3=N, 4=S
    static void roll(int dir) {
        int t = dice[1], b = dice[6], n = dice[2], s = dice[5], e = dice[3], w = dice[4];

        switch (dir) {
            case 1: // 동
                dice[1] = w;   // top <- west
                dice[6] = e;   // bottom <- east
                dice[3] = t;   // east <- top
                dice[4] = b;   // west <- bottom
                break;
            case 2: // 서
                dice[1] = e;   // top <- east
                dice[6] = w;   // bottom <- west
                dice[3] = b;   // east <- bottom
                dice[4] = t;   // west <- top
                break;
            case 3: // 북
                dice[1] = s;   // top <- south
                dice[6] = n;   // bottom <- north
                dice[2] = t;   // north <- top
                dice[5] = b;   // south <- bottom
                break;
            case 4: // 남
                dice[1] = n;   // top <- north
                dice[6] = s;   // bottom <- south
                dice[2] = b;   // north <- bottom
                dice[5] = t;   // south <- top
                break;
        }
        // 나머지 면(회전과 무관한)은 값 유지
    }
}
