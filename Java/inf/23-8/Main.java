import java.util.*; 
//등수 구하기 
class Main {

    public ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        int[] ranks = new int[num]; 

        for(int i=0; i<num; i++) {
            ranks[i] = 1; 
            for(int j=0; j<num; j++) {
                if(arr[j] > arr[i]) {
                   ranks[i]++;  
                } 
            }
            answer.add(ranks[i]); 
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
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
        



    }
}