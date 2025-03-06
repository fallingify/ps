
import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();

        
        Queue<Integer> josep = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            josep.offer(i);
        }
        

        StringBuilder result = new StringBuilder();
        result.append("<");
        
        while(!josep.isEmpty()){
            for(int i=0; i< K -1; i++){
                josep.offer(josep.poll());
                
            }

            result.append(josep.poll());
            if(!josep.isEmpty()){
                result.append(", ");
            }
        }

        result.append(">");
        System.out.println(result.toString());


    }
}
