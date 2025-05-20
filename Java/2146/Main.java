import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 뱍준 2146 다리만들기 
 * 음영칸 -> 육지 
 * 흰칸 -> 바다 
 * 섬끼리 연결하는 식으로 최단길이의 브릿지르 찾고 
 * 브릿지의 길이를 리턴한다. 
 * 
 * 1이면 땅
 * 0이면 바다 
 * 
 * 그래프의 값이 1인 곳을 탐색하면서 각 섬마다 특정 idx값을 부여하고 
 * 이미 방문한 육지는 재방문이 안되게 방문여부를 체크한다. 
 */
public class Main {
    static int n; 
    static int[][] graph; //섬 좌표 넣기 
    static int[] dx = {0, 0, 1, -1}; //탐색 반경
    static int[] dy = {1, -1, 0, 0};  //탐색 반경
    static boolean[][] visited;  //방문한곳 체크용


    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    visited = new boolean[n][n];
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            graph[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    int islandId = 2;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == 1 && !visited[i][j]) {
                groupIsland(i, j, islandId++);
            }
        }
    }

    int result = Integer.MAX_VALUE;
    for (int i = 2; i < islandId; i++) {
        result = Math.min(result, buildBridge(i));
    }

    System.out.println(result);
}

    //섬찾기 dfs
    static void groupIsland(int x, int y, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        graph[x][y] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = id;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    //다리 높기 -> 
    static int buildBridge(int id) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] bridgeVisited = new boolean[n][n];

        // 현재 섬의 모든 좌표 q에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == id) {
                    q.offer(new int[]{i, j, 0});
                    bridgeVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (graph[nx][ny] != 0 && graph[nx][ny] != id) {
                    // 다른 섬 도착
                    return dist;
                }
                if (!bridgeVisited[nx][ny] && graph[nx][ny] == 0) {
                    bridgeVisited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

