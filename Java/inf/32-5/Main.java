import java.util.*; 
//투 포인터 알고리즘 : 2 자연수의 합(리뷰)
class Main{
    public int solution(int n) {
        int answer = 0, lt = 0; 
        int[] arr = new int[n]; 

        int sum = 0; 
        int m = n / 2 + 1; 
        for(int i=0; i<m; i++) arr[i] = i + 1; 
        
        for(int rt =0; rt<m; rt++) {
            sum += arr[rt]; 
            if(sum == n) answer++; 
            while(sum >= n) {
                sum -= arr[lt++]; 
                if(sum == n) answer++; 
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        
        System.out.println(T.solution(n)); 
    }
}