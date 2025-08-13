import java.util.*; 

class Main {

    public String solution(int n, int[] a, int[] b) {
        String answer = ""; 

        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) {
                answer+="D"; 
            } else if(a[i]==1 && b[i]==3) {
                 answer+="A"; 
            } else if(a[i]==2 && b[i]==1) {
                 answer+="A"; 
            } else if(a[i]==3 && b[i]==2) {
                answer+="A"; 
            } else {
                answer+="B"; 
            }
        }

        return answer; 
        


    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int[] arr1 = new int[n]; 
        int[] arr2 = new int[n]; 

        for(int i=0; i<n; i++) {
            arr1[i] = kb.nextInt(); 
        }

        for(int i=0; i<n; i++) {
            arr2[i] = kb.nextInt(); 
        }
        
        for(char x : T.solution(n, arr1, arr2).toCharArray()) {
            System.out.println(x);
        }
        
        

    }
}