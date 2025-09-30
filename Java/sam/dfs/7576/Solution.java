import java.util.*; 
import java.io.*;


public class Solution {
    static int[][] board; 
    static int N, M; 
    static int answer = Integer.MIN_VALUE; 
    // 동 서 남 북 
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0}; 
    static Queue<int[]> queue = new LinkedList<>(); 

    
    public static void run() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        
        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); 
                if(board[i][j] == 1) {
                    queue.add(new int[]{i, j}); 
                }
            }
        } 

        bfs(); 
        isAllripen();

        System.out.println(answer);
    } 

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll(); 
            int nowX = tmp[0]; 
            int nowY = tmp[1]; 

            for(int d=0; d<4; d++) {
                int nextX = nowX + dx[d]; 
                int nextY = nowY + dy[d]; 

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY< M && board[nextX][nextY] == 0) {
                    queue.add(new int[]{nextX, nextY}); 
                    board[nextX][nextY] = board[nowX][nowY] + 1; 
                    answer = Math.max(answer, board[nextX][nextY]) - 1; 
                }
            }
        }
    }

    static void isAllripen() {
         for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    System.out.println(-1); 
                    return; 
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Solution().run(); 
    } 


}

