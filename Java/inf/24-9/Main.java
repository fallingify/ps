import java.util.*; 

class Main {
    public int solution(int num, int[][] arr) {
        int answer = Integer.MIN_VALUE; 
        int sum1 = 0, sum2 = 0; 
        
        for(int i=0; i<num; i++) {
            sum1 = sum2 = 0; 
            for(int j=0; j<num; j++) {
                sum1 += arr[i][j]; 
                sum2 += arr[j][i]; 
            }
            answer = Math.max(answer, sum1); 
            answer = Math.max(answer, sum2); 
        }
       
        sum1 = sum2 = 0; 
        for(int i=0; i<num; i++) {
            sum1 += arr[i][i]; 
            sum2 += arr[i][num-i-1]; 
        }



        answer = Math.max(answer, sum1); 
        answer = Math.max(answer, sum2); 

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