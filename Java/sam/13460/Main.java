import java.io.*;
import java.util.*; 


public class Main {
    static int n ; 
    static int m; 
    static int[] dx = {1, -1, 0, 0}; 
    static int[] dy = {0, 0, 1, -1};

    static char[][] board;

    static class Glass {
        int redX; 
        int redY; 
        int blueX; 
        int blueY; 
        int cnt; 

        public Glass(){}
        
        public Glass(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX; 
            this.redY = redY; 
            this.blueX = blueX; 
            this.blueY = blueY; 
            this.cnt = cnt; 
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        board = new char[n][m]; 
        
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray(); 
        }

        Glass gls = new Glass(); 

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(board[i][j] == 'R') {
                    gls.redX = i; 
                    gls.redY = j; 
                    board[i][j] = '.'; 
                }
                if(board[i][j] == 'B') {
                    gls.blueX = i; 
                    gls.blueY = j; 
                    board[i][j] ='.'; 
                }
            }
        }
        System.out.println(bfs(gls));
    }
    
    static int bfs(Glass gls) {
        Queue<Glass> q = new LinkedList<>(); 
        Set<String> visited = new HashSet<>(); 
        q.offer(gls); 
        visited.add(gls.redX + " " + gls.redY + " " + gls.blueX + " " + gls.blueY); 
        


        while(!q.isEmpty()) {
            Glass out = q.poll(); 
            
            //기울이기 - 10번이내로
            if(out.cnt == 10) {
                continue; 
            }

            // 탐색
            for(int d=0; d<4; d++) {
                int redX = out.redX; 
                int redY = out.redY; 
                int blueX = out.blueX; 
                int blueY = out.blueY; 
                boolean exitRed = false; 
                boolean exitBlue = false; 

                //빨간구슬
                while(true) {
                    int newRedX = redX + dx[d]; 
                    int newRedY = redY + dy[d]; 
                    if(board[newRedX][newRedY] == '#') {
                        break; 
                    }
                    if(board[newRedX][newRedY] == 'O') {
                        exitRed = true; 
                        break; 
                    }
                    redX = newRedX; 
                    redY = newRedY; 

                }

                //파란구슬
                while(true) {
                    int newBlueX = blueX + dx[d]; 
                    int newBlueY = blueY + dy[d]; 
                    if(board[newBlueX][newBlueY] == '#') {
                        break; 
                    }

                    if(board[newBlueX][newBlueY] == 'O') {
                        exitBlue = true; 
                        break; 
                    }

                    blueX = newBlueX; 
                    blueY = newBlueY; 
                }

                if(exitBlue) continue;  // 실패 
                if(exitRed) {
                    return gls.cnt + 1; 
                }

               if(redX == blueX && redY == blueY) {
                    if(d == 0) redX = redX > blueX ? redX - 1: redX; 
                    else if(d == 1) blueX = redX < blueX ? blueX + 1 : blueX; 
                    else if(d == 2) redY = redY > blueY ? redY - 1 : redY; 
                    else if(d == 3) blueY = redY < blueY ? blueY + 1 : blueY; 
               }

               String state = redX + " " + redY + " " + blueX + " " + blueY; 
               if(!visited.contains(state)) {
                visited.add(state); 
                q.offer(new Glass(redX, redY, blueX, blueY, out.cnt + 1)); 
               }
            }
        }
        return -1; 
    }    
}