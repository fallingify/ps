import java.util.*; 
import java.io.*; 


public class Solution {
    static int answer; 
    static int width; //가로 
    static int height; //세로 
    static int k; //배추개수 

    static int[] dx = {0, 0, 1, -1};  //동 서 남 북
    static int[] dy = {1, -1, 0, 0};  

    static boolean[][] visited; 
    static int[][] map; 

    public static void main(String[] args) throws Exception{
        new Solution();
        Solution.run(); 
    }

    public static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
 
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            answer = 0; 
            width = Integer.parseInt(st.nextToken());  // 가로 높이 맡기 
            height = Integer.parseInt(st.nextToken());  // 세로 높이 받기 
            visited = new boolean[width][height]; 
            map = new int[width][height]; 
            System.out.println(width + ", " + height); 


            k = Integer.parseInt(st.nextToken()); // 배추 개



            System.out.println("입력받기 "); 
            for(int p=0; p<k; p++) {
                st  = new StringTokenizer(br.readLine()); 
                int nowX = Integer.parseInt(st.nextToken()); 
                int nowY = Integer.parseInt(st.nextToken()); 
                System.out.println(" nowX, nowY :"+ nowX + ", " + nowY); 
                map[nowX][nowY] = 1; 
            }

            
            
            System.out.println("dfs돌기"); 
            for(int x=0; x<width; x++) {
                for(int y=0; y<height; y++) {
                    if(map[x][y] == 1 && !visited[x][y]) {
                        dfs(x,y); 
                        answer++; 
                        System.out.println("answer: "+ answer); 
                    }
                }
            }
            
 
            System.out.println(answer); 
        }


    }   



    //배추가 모여있는 곳에 배추 벌레 하나만 피룡함
    //일단 queue에서 엘리먼트를 하나씩 꺼낸다. 큐가 엠티가 될떄까지 
    //꺼내면 visited[][] 메트릭스에 방문표시를 해준다. 
    //원소의 동서남북을 탐색한다. 주면에 원소가 있다면  

    static void dfs(int x, int y) {
            visited[x][y] = true; 

            for(int d=0; d<4; d++) {
                int nextX = x + dx[d]; 
                int nextY = y + dy[d]; 

                if(nextX >= 0 && nextX < width &&  nextY >= 0 && nextY < height) { 
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        dfs(nextX, nextY); 
                    }

                }
            }
    }     
        

}



