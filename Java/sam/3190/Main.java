import java.util.*; 
import java.io.*;


//https://backhero.tistory.com/25 
//좌표설정부터 헷갈림
//행 -> y
//열 -> x
public class Main {
    static int N, K, L; 
    static boolean[][] apple, current; 
    static Deque<int[]> snake = new ArrayDeque<>(); 
    static Map<Integer, Character> turns = new HashMap<>(); 

    //북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {-1, 0, 1, 0}; 

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        N = Integer.parseInt(br.readLine()); 
        K = Integer.parseInt(br.readLine()); 
        apple = new boolean[N][N];
        current = new boolean[N][N]; 

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int r = Integer.parseInt(st.nextToken()) - 1; 
            int c =  Integer.parseInt(st.nextToken()) - 1; 
            apple[r][c] = true;  
        }


        L = Integer.parseInt(br.readLine()); 
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int sec = Integer.parseInt(st.nextToken()); 
            char dir = st.nextToken().charAt(0); 
            turns.put(sec,dir); 
        }
        
        snake.addFirst(new int[]{0, 0}); 
        current[0][0] = true; 


        System.out.println(move());
    }


    public static int move() {
        int dir = 1; //북에서 시작이므로 동으로 초기화한다
        int time = 0;

        while(true) {
            time = time + 1; 

            int[] head = snake.peekFirst(); 
            int nr = head[0] + dy[dir];  //다음 행
            int nc = head[1] + dx[dir];  //다음 열

            if (isWallCollision(nr, nc) || isBodyCollision(nr, nc)) {
                return time;
            }

            //머리이동하면 current를 체크한다. 
            snake.addFirst(new int[]{nr, nc});
            current[nr][nc] = true; 

            //사과있는곳은 먹으니까 false로 변경한다. 
            //사과없는곳은 그냥 지나가고 꼬리가 +1된다. 꼬리업데이트한다. 
            if(apple[nr][nc]) {
                apple[nr][nc] = false; 
            } else {
                int[] tail = snake.removeLast(); 
                current[tail[0]][tail[1]] = false; 

            }

            //get으로 map에서 원소추출하고 널인지 검사, 좌(북 : 0)-우(남 : 3) 판단
            Character turn = turns.get(time); 
            if(turn != null) {
                if (turn == 'L') dir = (dir + 3) % 4;  //0넣으면 3나와야함(북 -> 서)
                else if (turn == 'D') dir = (dir + 1) % 4;//0넣으면 1나와야함(북 -> 동)
            }
           
        }

    }

    //자기몸이랑 충돌
    public static boolean isBodyCollision(int row, int col) {
        if (!current[row][col]) return false; //충돌x
        int[] tail = snake.peekLast(); //충돌o
        boolean eating = apple[row][col];
        // 사과 없고, 꼬리가 곧 빠질 자리라면 충돌 아님
        return !(tail != null && !eating && tail[0] == row && tail[1] == col);
    }


    //벽충돌
    public static boolean isWallCollision(int row, int col) {
        return (row < 0 || row >= N || col < 0 || col >= N);
    }
}