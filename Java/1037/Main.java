import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //약수 개수         
        int[] elements = new int[N];

        for(int i=0; i<N; i++) {
            elements[i] = sc.nextInt();
        }

        int max  = elements[0];
        int min = elements[0];
        
        for(int i=1; i<N; i++) {
            if(max < elements[i]) max = elements[i];
            if(min > elements[i]) min = elements[i];
        }

       int result = max * min;
        System.out.println(result);

        sc.close();
        
        
        
        

        

    }
    
}
