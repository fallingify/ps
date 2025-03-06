import java.util.*;
/**
 *  다시 풀이 
 */
public class Main{
    public static int[] arr;
    public static int N;
    public static int success = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        N = sc.nextInt(); 
        arr = new int[N]; //어차피 같은 열 못높으므로 하나의 열로 

        dfs(0);
        System.out.println(success);
    }
        
    /**
     * BackTracking
     * @param depth
     */
    private static void dfs(int depth) {
        if(depth == N) {
            success++;
            return;
        }

        for(int i=0; i<N; i++) {
            arr[depth] = i; 
            if(Possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    /**
     * queen 배치 검사 
     * 같은 열 검사 
     * 대각선 검사 
     *  - 대각선 조건 : 행간 거리 == 열간 거리 
     * @param col
     * @return
     */
    private static boolean Possibility(int col){
        for(int i=0; i<col; i++) { //1 2 3 4 
            if(arr[col] == arr[i]){
                return false;
            } //같은 colume
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            } //abs() : 절대값 반환, 대각선 검사 
            //(col - i)  : 열 간 거리 
            //(arr[col] - arr[i]) : 행간 거리 
            //대각선에 있으면 행강거리와 열간 거리가 같음

        }
        return true;
    }   

}