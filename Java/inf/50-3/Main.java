import java.util.*; 
//삽입정렬
//오름차순
class Main {
    public int[] solution(int n, int[] arr) {
        for(int i=1; i<n; i++) {
            int tmp = arr[i]; 
            for(int j=i-1; j>=0; j--) { // 0부터 i번까지  
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j]; 
                } else {
                    break; 
                }  
            }
            arr[j + 1] = tmp; 
        
        }
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