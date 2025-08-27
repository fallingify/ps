import java.util.*; 
// 연속된 자연수의 합
// cnt는 연속된 자연수의 개수(몇개로 나눴는지)
// 다시 풀기 
class Main {
    public int solution(int n) {
        int answer=0, cnt = 1; 
        n--; 
        while(n>0){
            cnt++; 
            n=n-cnt; 
            if(n % cnt == 0) {
                //System.out.println(n + " " + cnt);
                answer++; 
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