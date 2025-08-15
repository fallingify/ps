import java.util.*; 

class Main {
    public int solution(int num, int[][] arr) {
        int answer = Integer.MIN_VALUE; 
        int sum_row = 0, sum_col = 0; 
        
        for(int i=0; i<num; i++) {
            sum_row = sum_col = 0; 
            for(int j=0; j<num; j++) {
                sum_row += arr[i][j]; 
                sum_col += arr[j][i]; 
            }
            answer = Math.max(answer, sum_row); 
            answer = Math.max(answer, sum_col); 
        }
       
        sum_row = sum_col = 0; 
        for(int i=0; i<num; i++) {
            sum_row += arr[i][i]; 
            sum_col += arr[i][num-i-1]; 
        }

        answer = Math.max(answer, sum_row); 
        answer = Math.max(answer, sum_col); 

        return answer; 

    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int[][] metrics = new int[n][n]; 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                metrics[i][j] = kb.nextInt(); 
            }
        }


        System.out.println(T.solution(n, metrics)); 


    }
}