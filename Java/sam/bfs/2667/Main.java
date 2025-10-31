import java.util.*;
import java.io.*; 

class Main {
    static int n; 
    static int[][] map; 
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0}; 
    static int sqrCnt = 0; 
    static int cnt = 0; 
    static ArrayList<Integer> ary = new ArrayList<>(); 


    public static void main(String[] args) throws Exception{
        new Main().run(); 
    }
    static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine()); 
        map = new int[n][n]; 

        for(int i=0; i<n; i++) {
            String line = br.readLine(); 
            char[] chrs = line.toCharArray(); 
            for(int j=0; j<n; j++) {
                int element = chrs[j] - '0'; 
                map[i][j] = element;  
            }
        }

        for(int k=0; k<n; k++) {
            for(int j=0; j<n;j++) {
                if(map[k][j] == 1) {
                    sqrCnt++; 
                    cnt = 1; 
                    dfs(k, j); 
                    ary.add(cnt-1); 
                }
            } 
        }
    
        Collections.sort(ary); 
        System.out.println(sqrCnt);
        for(int i : ary){
            System.out.println(i);
        }
    }

    static void dfs(int x, int y) {
        if(map[x][y] == 0) {
            return; 
        }
        map[x][y] = 0; 
        cnt++; 

        for(int d=0; d<4; d++) {
            int nextX = x + dx[d]; 
            int nextY = y + dy[d]; 
            if(0<= nextX && nextX < n && 0 <= nextY && nextY < n) {
                dfs(nextX, nextY); 
                
                
            }
        }
    }}

        
    





