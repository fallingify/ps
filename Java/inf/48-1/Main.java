import java.util.*; 
//선택정렬 
//오름차순정렬하기  - idx사용
class Main {
    public int[] solution(int n, int[] arr) {
        
        //i<->j를 교환
        for(int i=0; i<n-1; i++) { //n전까지 (n-1)
            int idx = i;     
            for(int j = i+1; i<n; i++) { // i+1부터 마지막까지 팀섹히고 교환
                if (arr[j] < arr[idx]) {
                    idx = j; 
                }

                int tmp = arr[i]; 
                arr[i] = arr[idx]; 
                arr[idx] = tmp;   
            }
        }

        return arr;  
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }

        for(int x : T.solution(n, arr)) {
            System.out.print(x + " "); 
        }
    }
}