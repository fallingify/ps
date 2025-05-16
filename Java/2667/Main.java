import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
2667 단지번호붙이기 


 */
public class Main {
    static int N, count; 
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> zip = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; 
        visited = new boolean[N][N]; 

        //2차원지도생성
        for(int i=0; i<N; i++) {
            String li = br.readLine(); 

            for(int j=0; j<N; j++){
                map[i][j] = li.charAt(j) - '0';  // 문자열로 받고 정수형배열로 전환
            }
        }

        //단지 찾기 
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] ==1 ) {
                    int size = dfs(i, j); 
                    zip.add(size); 
                }
            }
        }
        
        //출력? 오름차순으로 정렬한다
        Collections.sort(zip); 
        System.out.println(zip.size());
        for(int size: zip) {
            System.out.println(size);
        }

    }//main

    public static int dfs(int x, int y) {
        visited[x][y] = true; 
        int count = 1; 
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i]; 
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    count += dfs(nx, ny); 
                }
            }
        }
        
        return count; 
    }//dfs
    
}
