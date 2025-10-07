import java.io.*; 
import java.util.*; 

public class Solution {
    static int width, height; 
    static char[][] map; 
    static boolean[][] visited; 
    static Queue<int[]> dog; 
    static Queue<int[]> fire; 
    static int answer; 

    //상 하 좌 우 
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 


    public static void main(String[] args) throws IOException{
        new Solution().run(); 
    }

    void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int tc = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder(); 

        while(tc-- > 0) {
            readCase(br);
            answer = solve(); 
            if(answer != -1) sb.append(answer).append('\n');
            else sb.append("IMPOSSIBLE").append('\n'); 
        }
        System.out.println(sb); 

    }


    void readCase(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        width = Integer.parseInt(st.nextToken()); 
        height = Integer.parseInt(st.nextToken()); 
        map = new char[height][width];
        dog = new LinkedList<>(); 
        fire = new LinkedList<>(); 
        visited = new boolean[height][width]; 

        for(int r=0; r<height; r++) {
            String line = br.readLine(); 
            for(int c=0; c<width; c++) {
                char ch = line.charAt(c); 
                map[r][c] = ch; 
                if(ch == '@') {
                    dog.add(new int[]{r, c, 0}); 
                    visited[r][c] = true; 
                } else if(ch == '*') {
                    fire.add(new int[]{r, c}); 
                }
            }
        }
    }

    int solve(){
        while(true) {
            int fs = fire.size(); 
            for(int i=0; i<fs; i++) {
                int[] cur = fire.poll(); 
                spread(cur[0], cur[1]); 
            }

            int ds = dog.size(); 
            if(ds == 0) return -1; //예외
            for(int i=0; i<ds; i++) {
                int[] cur = dog.poll(); 
                int r = cur[0], c = cur[1], time = cur[2]; 
                int res = escape(r, c, time); 
                if(res != -1) return res; 
            }
        }
    }


    static void spread(int r, int c) {
        for(int d=0; d<4; d++) {
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 

            if(!inBounds(nr, nc)) {
                continue; 
            }
            if(map[nr][nc] == '.' || map[nr][nc] == '@') {
                map[nr][nc] = '*'; 
                fire.add(new int[]{nr, nc}); 
            }
        }
    }

    static int escape(int r, int c, int time) {
        for(int d=0; d<4; d++) {
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 

            if(!inBounds(nr, nc)) {
                return time + 1; 
            }

            if(map[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true; 
                dog.add(new int[]{nr, nc, time + 1}); 
            }

        }
        return -1; 
    }

    static boolean inBounds(int r, int c) {
        return (0 <= r && r < height && 0 <= c && c < width); 
    }
}
