import java.util.*;
import java.io.*; 


public class Solution {

    static int n, m;    
    static int answer = 0; 
    static int[] dx = {0, 0, 1, -1}; //동서남북
    static int[] dy = {1, -1, 0, 0};  
    static char[][] board; 
    static int[][] times; 
    static Queue<int[]> queue = new LinkedList<>(); 
    static Queue<int[] > fire = new LinkedList<>(); 
    static boolean isEscape = false; 


    static void run() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        board = new char[n][m]; 
        times = new int[n][m]; 

        for(int i=0; i < n; i++) {
            String str = br.readLine(); 
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(i);

                if(board[i][j] == 'J') {
                    times[i][j] = 1; 
                    
                    if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                        System.out.println(1); 
                        return; 
                    }
                    queue.offer(new int[]{i, j}); 
                } 
                if(board[i][j] == 'F') {
                    fire.offer(new int[]{i, j}); 
                }
            }
        }


        //불정도를 넣어둔다. 
        while(!fire.isEmpty()) {
            queue.offer(fire.poll()); 
        }

        bfs(); 
    
        if(!isEscape) {
            System.out.println("IMPOSSIBLE"); 
        } else {
            System.out.println(answer);
        }   
        
    }

    static boolean isFire(int nowX, int nowY) {
        for(int i=0; i<4; i++) {
            int nextX = nowX + dx[i]; 
            int nextY = nowY + dy[i]; 
            if(0 < nextX && nextX < n && 0 < nextY && nextY < m) {
                if(board[nextX][nextY] == 'F') {
                    return true; 
                }
            }

         
        }
        return false; 

    }
    static void bfs() {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll(); 
            int nowX = curr[0]; 
            int nowY = curr[1]; 

            for(int d=0; d<4; d++) {
                int nextX = nowX + dx[d]; 
                int nextY = nowY + dy[d]; 

                if(nextX > 0 && nextY > 0 && nextX < n && nextY < m) {
                    if(board[nowX][nowY] == 'J' && board[nowX][nowY] == '.') {
                        times[nextX][nextY] = times[nowX][nowY] + 1; 
                        board[nextX][nextY] = 'J'; 
                        queue.offer(new int[]{nextX, nextY}); 


                        if(nextX == 0 || nextX >= n || nextY == 0 || nextY >= m) {
                            answer = times[nextX][nextY]; 

                            if(isFire(nextX, nextY)) {
                                return; 
                            }
                        }
                    } else if((board[nowX][nowY] == 'F') && (board[nextX][nextY]== '.') || (board[nextX][nextY] == 'J')) {
                        board[nextX][nextY] = 'F'; 
                        queue.offer(new int[]{nextX, nextY}); 
                    }


                }
            }

        }

    }


    public static void main(String[] args) throws Exception{
        new Solution().run(); 
    }
  
    



}
