import java.util.*; 
import java.io.*; 

public class Solution{
    static int answer; 
    static int subin = 0; 
    static int target = 0;  //수빈, 동생 
    static int visited[] = new int[100001]; 
    static Queue<Integer>  queue = new LinkedList<>(); 

    static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        subin = Integer.parseInt(st.nextToken()); 
        target = Integer.parseInt(st.nextToken()); 

        queue.offer(subin); 
        visited[subin] = 1; 
        bfs(); 
        System.out.println(answer); 
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int n = queue.poll(); 
            if(n == target) {
                answer = visited[n] - 1; 
                break; 
            }
            if(n-1>=0 && visited[n-1] == 0) {
                visited[n-1] = visited[n] + 1; 
                queue.add(n - 1); 
            }
            if(n+1 <= 100001 && visited[n+1] == 0) {
                visited[n+1] = visited[n] + 1; 
                queue.add(n + 1); 
            }
            if(n*2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = visited[n] +1; 
                queue.add(n * 2); 
            }
        }
    }


    public static void main(String[] args) throws Exception{
        new Solution().run(); 
    }


}