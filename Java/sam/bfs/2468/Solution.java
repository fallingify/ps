import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우 
    static int[] dy = {0, 0, -1, 1};  //상하좌우 
    static int ans; 
    static int cnt; 
    static int max; 

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());        
                if(max < map[i][j])  {
                    max = map[i][j]; 
                }
            }
        }

        for(int i=0; i<max; i++) {
            cnt = 0; 
            visited = new boolean[n][n]; 
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(map[j][k] < i || visited[j][k]) continue; 
                    cnt++;
                    bfs(j, k, i); 
                }
            }
        }
        ans = ans < cnt ? cnt: ans; 
        System.out.println(ans); 
    }

    void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>(); 
        visited[x][y] = true; 
        q.add(new int[]{x, y}); 
        
        while(q.isEmpty()){
            int[] arr = q.poll(); 
            int cx = arr[0]; 
            int cy = arr[1]; 

            for(int d=0; d<4; d++) {
                int nx = cx + dx[d]; 
                int ny = cy + dy[d]; 
            
                if(nx < 0 || ny < 0 || nx > n || ny > n) continue; 
                if(visited[nx][ny] || map[nx][ny] < h) continue; 
                visited[nx][ny] = true; 
                q.add(new int[]{nx, ny}); 
            }
        }
    }



}
