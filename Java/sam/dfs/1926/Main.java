import java.util.*; 
import java.io.*; 

public class Main {
    static int n, m;
    static int[][] graph; 
    static boolean[][] visited; 
    static int count; 
    static List<Integer> answer = new ArrayList<>(); 

    //상 하 좌 우 - 행렬기준을 (n열, m행) -> x == c, y == r
    static int[][] pos = {
        {0, -1}, 
        {0, 1}, 
        {-1, 0}, 
        {1, 0}
    }; 

    static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        
        graph = new int[n][m];    
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 새로운점에서 bfs를 수행할떄마다 count을 0으로 초기화한다
                if(graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;  
                    bfs(i, j); 
                    answer.add(count); 
                }
            }
        }

        Collections.sort(answer); 
        System.out.println(answer.size()); 
        System.out.println(answer.get(answer.size() - 1)); 
    }
    
    static void bfs(int x, int y) {
        visited[x][y] = true; 
        Queue<int[]> queue = new LinkedList<>(); 
        queue.add(new int[]{x, y}); 
        count = 1; 

        while(!queue.isEmpty()) {
            int[] arr = queue.poll(); 
            int nowX = arr[0]; 
            int nowY = arr[1]; 

            for(int[] d: pos) {
                int nx = nowX + d[0]; 
                int ny = nowY + d[1];  

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //되는 조건 a
                if(nx >= 0 && nx <= n &&  ny >= 0 && ny <= m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true; 
                    queue.add(new int[]{nx, ny}); 
                    count++; 
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution(); 
    }


}