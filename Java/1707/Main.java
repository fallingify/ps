import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
1707 이분 그래프

이분그래프인지 아닌지 판별

Queue를 활용한 BFS로 문제

v, e = 정점과 간선의 갯수

al[] = 각 정점의 연결 정점을 저장하는 ArrayList

visit[] = 방문과 숫자를 관리(방문 전 = 0, 방문 후 = 1 or 2)
*/
public class Main {
    static int v, e;
    static int[] visited;
    static ArrayList<Integer>[] al;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            visited = new int[v + 1];
    
            al = new ArrayList[v+1];

			for(int i = 0; i <= v; i++)
				al[i] = new ArrayList<Integer>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                al[p1].add(p2);
                al[p2].add(p1);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : al[now]) {
                if (visited[next] == 0) {
                    visited[next] = 3 - visited[now]; // 1 → 2, 2 → 1
                    q.add(next);
                } else if (visited[next] == visited[now]) {
                    return false; // 같은 그룹이면 이분 그래프 아님
                }
            }
        }

        return true;
    }
}