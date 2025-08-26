import java.util.*; 
// 최대 길이 1 연속 부분 수열
// 최대값 비교은 Math.max(비교1, 비교2)
// 투 포인터는 rt는 계속 증가 lt로 조절한다. 
class Main {
    public int solution(int m, int[] arr) {
        int answer = 0; 
        //m은 주어진 제한 횟수 
        int cnt = 0; //바꾼 횟수 
        int lt = 0; 
        //rt작업돌때마다 while문으로 lt이동작업수행한다.
        for(int rt=0; rt<arr.length; rt++) {
            if(arr[rt] == 0) {  cnt++; }
            //바꾸고 이동한다. 근데 실제로 바꿀필요는 x, cnt증가하고 m이랑 비교해야함
            while(cnt > m) { // 주어진 횟수보다 많이 바꿧으므로 lt를 이동한다. 
                if(arr[lt] == 0) cnt--;  
                lt++; 
            }
            answer = Math.max(answer, rt - lt + 1); 
        }
        
        return answer; 
    }
      
    

    
    public static void main(String[] args) {
        Main T = new Main() ;
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int m = kb.nextInt(); 
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        System.out.println(T.solution(m, arr));


    }
}