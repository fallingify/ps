import java.util.*; 
// k번쨰 큰 수 
// Treeset은 중복원소도 자동 정렬해준다. 
class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = -1; //k번째 수가 존재하지 않으면 -1을 출력해야힘.  
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());  //디폴트는 오름차순이다. 
        //조합만들기 
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int h = j+1; h<n; h++) {
                    Tset.add(arr[i] + arr[j] + arr[h]); 
                }
            }
        }
        int cnt = 0; 
        for(int x : Tset)  {
            cnt++; 
            // System.out.println(x); 
            if(cnt == k) {
                answer = x; 
            }
        }
        return answer; 
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

        System.out.println(T.solution(n, k, arr)); 

    }
}