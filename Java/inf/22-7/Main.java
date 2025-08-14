import java.util.*; 
//점수계산
class Main {
    public int solution(int num, int[] nums) {
        int answer = 0; 
        int cnt = 0; 
        int score = 0; 
        
        for(int x : nums) {
            if(x == 0) {
                cnt = 0; 
            } else { 
                score = ++cnt; 
            } 
             answer += score; 
        }
    
        return answer; 

    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); 
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        System.out.println(T.solution(n, arr));
    }
}