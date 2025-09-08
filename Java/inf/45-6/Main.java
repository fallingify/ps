import java.util.*; 
//공주구하기 
class Main {
    public int solution(int n, int m){
        int answer = 0; 
        Queue<Integer> q = new LinkedList<>(); 
        for(int i=1; i<=n; i++) {
            q.offer(i); 
        }

       
        while(q.size() != 1) {
            for(int j=0; j<m-1; j++) {
                q.offer(q.poll()); 
            }
            q.poll();            
        }
        answer = q.poll(); 

        return answer; 
    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int m = kb.nextInt(); 

        System.out.println(T.solution(n, m)); 

    }
}