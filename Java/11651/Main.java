import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        int[][] arr = new int[N][2];

        for(int i=0; i< N ; i++) {
            for(int j=0; j<2; j++) {
                arr[i][j] = sc.nextInt();
            }22

        }


        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] != o2[1]) {
                return o1[1] - o2[1]; //다를때
            } else {
                return o1[0] - o2[0]; //같을떄
            }
        });

    


        
        for(int[] e:arr) {
            for(int f:e){
                System.out.print(f+" ");
            }
            System.out.println();
        }
        

        

        

    }

}