package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited; 
    static ArrayList<Integer>[] graph; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int node = Integer.parseInt(br.readLine()); 
        int edge = Integer.parseInt(br.readLine()); 

        graph = new ArrayList[node + 1];
        visited = new boolean[node + 1]; 
        
        //그래프 초기화
        for(int i=1; i<=node; i++) {    graph[i] = new ArrayList<>();   }

        //간선 입력 받기 
        //예 : 단방향이면? from에 to추가 
        //예 : 양방향이먄? to에 from 추가
        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine()); 
            int from = Integer.parseInt(st.nextToken()); 
            int to = Integer.parseInt(st.nextToken()); 

            graph[from].add(to); //단방향이면 이것만
            graph[to].add(from); //양방향이면 이것도 
        }

       for(int i=1; i<=node; i++) {
            if(!visited[i]) {
                dfs(i); 
            }
       }
       //i는 모든 노드를 순회
       //visited[i]가 false이면 -> 아직 연결요소 안 들렀다는 뜻
       //dfs(i)로 새 탐색을 시작

    }//main

    static void dfs(int cur) {
        visited[cur] = true; //지나간곳은 찍고 간다
        for(int next: graph[cur]) { //현재 위치에서 길 찾기 
            if(!visited[next]) { 
                dfs(next); 
            }//안가본곳이면들어간다
        }
    }//dfs
    //dfs(1) -> dfs(2) -> dfs(3) -> .. 이런식으로


}
