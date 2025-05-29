import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] adj;
    static int[] dist;

    public static int[] bfs(int start, int n) {
        Arrays.fill(dist, -1); // Reset distances to -1 (unvisited)

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge e : adj[curr]) {
                if (dist[e.to] == -1) {
                    dist[e.to] = dist[curr] + e.weight;
                    q.offer(e.to);
                    if (dist[e.to] > maxDist) {
                        maxDist = dist[e.to];
                        farthestNode = e.to;
                    }
                }
            }
        }
        return new int[]{farthestNode, maxDist};
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = (ArrayList<Edge>[]) new ArrayList[n + 1]; // Generic array with cast
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        int[] firstBFS = bfs(1, n);
        int[] secondBFS = bfs(firstBFS[0], n);

        System.out.println(secondBFS[1]); // Tree diameter
    }
}
