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
/*
풀이과정
15
1개숫자로  -> 없음
2개숫자로 -> 1 + 2 = 3, 2개니까 (15-3)/2 = 6, 1 + 6 // 2+6 answer++; 
3개숫자로 -> 1 + 2 + 3 = 6, 3개니까 (12-6)/3 = 2, 정수맞음, 1 + (2) + 2 + (2) + 3 + (2) => 3 + 4 + 5, answer++; 
4개숫자로 -> 1+2+3+4 =10, 4개니까 6 - 10? 분배불가 
5개숫자로 -> 1+2+3+4+5=15니까 그냥 이대로 간다. answer++
그래서 총 3을 리턴하게 된다. 
이걸 코드로 작성하면 이중포문으로 되어 n제곱 시간복잡도가 나온다. 근데 이러면안되고 while문돌려서 로그n 시간복잡도가 나오도록 해야한다. 

 */