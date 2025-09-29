import java.util.*; 
import java.io.*; 

public class Main {
    static int n, m; 
    static boolean[][] visited; 
    static int[][] map; 
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  //상 하 좌 우 
    static int count = 0; 

    public static void solution() throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 


        map = new int[n][m]; 
        visited = new boolean[n][m]; 
        
        for(int i=0; i<n; i++) {
            String str = br.readLine(); 
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0'; 
            }   
        }  

        visited[0][0] = true; 
        bfs(0, 0); 
        System.out.println(map[n-1][m-1]); 
    } 


   static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); 
        queue.add(new int[]{x, y}); 


        while(!queue.isEmpty()) {
            int[] arr = queue.poll(); 
            int nowX = arr[0]; 
            int nowY = arr[1]; 

            for(int[] d: pos) {
                int nextX = nowX + d[0]; 
                int nextY = nowY + d[1]; 

                if (nextX < 0 || nextX >= n || nextY < 0 
                || nextY >= m || visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
                    queue.add(new int[]{nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] +  1; 
                    visited[nextX][nextY] = true; 
                    
            }
        }
    }




    public static void main(String[] args) throws Exception{
        solution(); 
    }

}