import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 트리의 지름
 * 
 * 트리의 지름을 구하려면, 두 점 사이의 거리가 가장 긴 것을 말한다. 
 * 트리ㅣ 지름을 구는 프로그램을 작성하시오. 
 * 
 */
public class Main {
    //첫번째 줄 : 트리 정점의 개수v, v는 정점개수
    //간선정보입력, 1-v
    //정수 2개는 간선 정보, 하나는 정점 번호, 다른 하나는 그 정점까지의 거리 
    static ArrayList<ArrayList<Node>> adj;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    static class Node {
        int vertex;  
        int distance; 

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine()); 

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        //여기를 입력 수 개수에 맞게 자동으로 할당할 수 있어야 함. 
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int u = Integer.parseInt(st.nextToken()); 

            while(st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) { break; }
            
                int v = token;
                int dist = Integer.parseInt(st.nextToken());

                adj.get(u).add(new Node(v, dist));
                adj.get(v).add(new Node(u, dist)); 
            
            }
        }

        visited = new boolean[N + 1];
        maxDistance = 0; 
        farthestNode = 1; 
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }


    public static void dfs(int current, int distance) {
        visited[current] = true; 
        
        if(distance > maxDistance) {
            maxDistance = distance; 
            farthestNode = current; 
        }
        for(Node next : adj.get(current)) {
            if(!visited[next.vertex]) {
                dfs(next.vertex, distance + next.distance); 
            }
        }
    }
    
}

