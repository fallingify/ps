import java.util.*; 
//최대 매출 | 슬라이딩 윈도우 
class Main {
    public void solution(int n, int k, int[] arr) {
        int answer = 0; 
        int sum = 0; 
        for(int i=0; i<k; i++) sum += arr[i]; 
        answer = sum; 

        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i - k]); 
            answer = Math.max(answer, sum); 
        }

        System.out.println(answer);
    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int k = kb.nextInt(); 

        int[] arr = new int[n]; 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        T.solution(n, k, arr);
    }
    
}
