import java.util.*; 
//인형뽑기 
//이중배열의 원소들은 세로로 저장되지 않고 가로로 저장되므로 행렬의 열부분에서 pos잡는게 옳다. 
class Main {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; 
        Stack<Integer> stack = new Stack<>(); 
        for(int pos : moves) { // [1 5 3 5 1 2 1 4]
            for(int i=0; i<board.length; i++) { // 1-5
                if(board[i][pos - 1] != 0) {//board[0][0]
                    int tmp = board[i][pos - 1]; 
                    board[i][pos -1] = 0; 
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop(); 
                    }
                    else stack.push(tmp); 
                    break; 
                }
            }
            
        }
        return answer; 
    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 

        int n = kb.nextInt(); 
        int[][] arr1 = new int[n][n]; 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr1[i][j] = kb.nextInt(); 
            }
        }
        
        int m = kb.nextInt(); 
        int[] movies = new int[m]; 
        for(int l=0; l<m; l++) {
            movies[l] = kb.nextInt(); 
        }

        System.out.print(T.solution(arr1, movies));
    }
}