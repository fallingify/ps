import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
9466 팀 프로젝트
팀짜기이며 팀인원수에는 제한이 없다.

혼자도 가능하다. 저번 문제와 같이 순열사이클만 가능하다. 
팀을 이룰 수 없는 사람의 수를 구한다. 
 */

public class Main {
    static int[] link;           // 각 학생이 선택한 학생
    static boolean[] visited;    // 방문 여부
    static boolean[] finished;   // DFS가 끝난 노드인지
    static int cnt;        

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); //테스트 횟수 
        
        while(t-- > 0){ 
            int n = Integer.parseInt(br.readLine()); // 학생 수 
            link = new int[n + 1]; 
            visited = new boolean[n + 1]; 
            finished = new boolean[n + 1]; 
            cnt = 0; 
            
            //입력받기 
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            for(int i=0; i<n; i++) {
                link[i] = Integer.parseInt(st.nextToken()); 
            }

            //처리하기
            for(int i=1; i<= n; i++) {
                if(!visited[i]) {
                    dfs(i); 
                }
            }

            //팀에 속하지 않는 학생 수 클릭 
            System.out.println(n - cnt);
        }
    }


    static void dfs(int cur) {
        visited[cur] = true; 
        int next = link[cur]; 
        if(!visited[next]) {
            dfs(next); 
        } else {
            if(!finished[next]) {
                cnt++; 
                while(next != cur) {
                    next = link[next]; 
                     cnt++; 
                }
            }
        }
        finished[cur] = true; // 탐색 완료 표시 
    }
}
