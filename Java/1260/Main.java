import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
1260 DFS와 BFS


 */
public class Main {
    public static StringBuilder sb = new StringBuilder(); 
    public static int N, M, V; 
    public static boolean[] visited; 
    public static int[][] graph; 
    
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        V = Integer.parseInt(st.nextToken()); 

        int[] dfs = new int[N]; 
        int[] bfs = new int[N];

        //방문처리에 사용할 것들
        visited = new boolean[N+1]; 

        //ㄱ래프 표시 
        graph = new int[N+1][N+1]; 
        
       
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
     
            graph[a][b] = graph[b][a] = 1; 
            /**
             *여기부터
             */

        }

        dfs(V); 
        sb.append('\n'); 
        Arrays.fill(visited, false);
        bfs(V); 
        
        System.out.println(sb);
    }


    public static void dfs(int start) {
        visited[start] = true; 
        sb.append(start).append(' '); 

        for(int i=0; i<=N; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i); 
            }
        }

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(' ');


        while(!q.isEmpty()) {
            int V = q.poll(); 
            for(int i=1; i<=N; i++) {
                if(graph[V][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true; 
                    sb.append(i).append(' '); 
                }
            }
        }

    }


}
/*
1 - 2
| \ | 
3 - 4 

dfs : 1 -> 2 -> 4 -> 3
bfs : 1 -> 2 -> 3 -> 4
*/