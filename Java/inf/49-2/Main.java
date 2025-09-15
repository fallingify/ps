import java.util.*; 
//버블정렬
//오름차순정렬이면 1턴 돌때마다 큰 값이 마지막에 위치하게 된다. 
class Main{
    public int[] solution(int n, int[]arr) {
        for(int i=0; i<n-1; i++) { // (n-1)
            for(int j=0; j<n-1-i; j++) { //돌때마다 횟수--
                if(arr[j] > arr[j+1]) { 
                    int tmp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = tmp; 
                }
            }
        }
        return arr; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int[] arr = new int[n]; 
        for(int i=0;i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x +  " "); 
        }



    }

}
