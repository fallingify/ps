import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxH = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxH) maxH = map[i][j];
            }
        }

        int ans = 0;
        for (int h = 0; h <= maxH; h++) {
            visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    void bfs(int sx, int sy, int h) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > h) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
