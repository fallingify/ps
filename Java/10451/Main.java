import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
순열사이클 만들기 
정수 N개로 이루어진 순열을 나타내는 방법

순열사이클이란? 출발노드와 도착노드가 같은 사이클
 */
public class Main {
    static ArrayList<Integer> array;
    static boolean[] visited; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int T = Integer.parseInt(br.readLine()); 

        for(int i=0; i<T; i++) {
            int cnt = 0; 
            int N = Integer.parseInt(br.readLine()); 
            int arr[] = new int[N+1]; 

            StringTokenizer st = new StringTokenizer(br.readLine()); 

            //값 입력받기 
            for(int j=1; j<arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken()); 
            }
            //방문한지 안한지 
            boolean visited[] = new boolean[N+1]; 

            //dfs로 탐색
            for(int a=1; a<=N; a++){
                if(!visited[a]){ //방문한 적인 없는 노드 
                    visited[a] = true; //방문한다. 
                    int next = arr[a]; //해당값을 얻어서 

                    while(true){
                        if(visited[next]) { 
                            cnt++; 
                            break; 
                        }
                        else{
                            visited[next] = true; 
                            next = arr[next]; 
                        }
                    }
                    
                }
            }
            System.out.println(cnt);
        }
    }


}