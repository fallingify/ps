import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int[] distance; //누적

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        adj = (ArrayList<Node>[]) new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                int y = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(x, y));
            }
        }

        // 1차 BFS: 임의의 노드(1)로부터 가장 먼 노드 찾기
        bfs(1);
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[max] < distance[i]) max = i;
        }

        // 2차 BFS: max 노드에서 가장 먼 거리 구하기 
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(max);

        System.out.println(Arrays.stream(distance).max().getAsInt());
    }

    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void bfs(int index) {
        Queue<Node> queue = new LinkedList<>();
        visited[index] = true;
        queue.add(new Node(index, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node next : adj[current.vertex]) {
                if (!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    distance[next.vertex] = distance[current.vertex] + next.distance;
                    queue.add(next);
                }
            }
        }
    }

}
