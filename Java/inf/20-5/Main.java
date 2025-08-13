import java.util.*; 
//소수출력
class Main {


    public int Solution(int n) {
        int answer = 0; 

        int[] ch = new int[n + 1];  
        for(int i=2; i<=n; i++) {
            if(ch[i] == 0) {
                answer++; 
                for(int j=i;  j<=n; j+=i) { //배수처리 
                    ch[j] = 1; 
                }


            }
        }



        return answer; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); 


        System.out.println(T.Solution(n));

    }
}