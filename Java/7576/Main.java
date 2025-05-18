import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; 
    static int m; 
    static int[][] graph; 
    static boolean[][] visited;
    static int count = 0; 
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0}; 
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        m = Integer.parseInt(st.nextToken()); 
        n = Integer.parseInt(st.nextToken()); 

        graph = new int[n][m]; 
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); 
                if(graph[i][j] == 1) {
                    q.add(new int[]{i, j}); 
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] tmp = q.poll(); 
            int x = tmp[0];
            int y = tmp[1]; 

            for(int i=0; i<4; i++) {
                int nx = x + dx[i]; 
                int ny = y + dy[i]; 

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(graph[nx][ny] == 0){
                        q.add(new int[]{nx, ny});
                        graph[nx][ny] = graph[x][y] + 1; 
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0) {
                    return -1; 
                }
                count = Math.max(count, graph[i][j]); 
            }
        }

        if(count == 1) {
            return 0; 
        } else {
            return count - 1; 
        }
    }




    
} //main
