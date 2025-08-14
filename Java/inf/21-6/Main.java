import java.util.*; 


class Main {
    public boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i=2; i<n; i++) {
            if(n % i == 0) return false; 
        }
        return true; 
    }

    public ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        for(int i=0; i<num; i++) {
            int rev = 0; 
            int tmp = arr[i]; 
            while(tmp > 0){
                int t = tmp % 10; 
                rev = rev * 10 + t; 
                tmp = tmp / 10; 
            }
            if(isPrime(rev)) answer.add(rev); 
            
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
        for(int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
       
    }

}