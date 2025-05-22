import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 트리의 부모찾기 
 * 루트없는 트리가 주어지고 , 각 노드의 부모를 구한다. 
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int u = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 
            adj.get(u).add(v); 
            adj.get(v).add(u); 

        }
        int[] parent = new int[N + 1]; 
        Queue<Integer> q = new LinkedList<>(); 
        boolean[] visited = new boolean[N + 1]; 

        q.offer(1); 
        visited[1] = true; 

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i: adj.get(cur)) {
                if(!visited[i]) {
                    visited[i] = true; 
                    parent[i] = cur; 
                    q.offer(i); 
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
        br.close();

        
    }
    
}
