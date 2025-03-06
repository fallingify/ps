import java.util.*;


public class Main {
    static int N, M; 
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Point> chickenList = new ArrayList<>();
    static ArrayList<Point> houseList = new ArrayList<>();
    static boolean[] visited;

    public static class Point {
        int x; 
        int y; 

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) houseList.add(new Point(i, j));
                if(board[i][j] == 2) chickenList.add(new Point(i, j));


            }
        }-

        visited = new boolean[chickenList.size()];
        backtracking(0, 0);
        System.out.println(min);


    }

    public static void backtracking(int count, int idx){
        if(count == M) {
            int total = 0;  //?
            for(int i=0; i<houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j=0; j<chickenList.size(); j++) {
                    if(visited[j] == true) {
                        int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
                        + Math.abs(houseList.get(i).y - houseList.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }   
                total += sum;
            }

            min = Math.min(total, min);
            return;
        }

        for(int i = idx; i < chickenList.size(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                backtracking(count + 1, i + 1);
                visited[i] = false;
            }
        }

        
    }

}
