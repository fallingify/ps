import java.util.*; 
//ㅍㅣㄴㅗㅂㅏㅊㅣ ㅅㅗㄴㅋㅗㄷㅣㅇ
class Main {
    public void Solution(int n){
        int a=1, b=1, c; 
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a + b; 
            System.out.print(c + " ");
            a = b; 
            b = c; 
        }
    }

    public static void main(String[] args) {
        Main T  = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        
       T.Solution(n); 

        

    }
}