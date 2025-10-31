import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,cnt;
	static int square[][];
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	static void run()  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //행수
		m = Integer.parseInt(st.nextToken());  //열수 
		int k = Integer.parseInt(st.nextToken()); //입력값 
		
		square = new int[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//색칠한 영역
			for(int y=y1; y<y2; y++) { 
				for(int x=x1; x<x2; x++){ 
					square[y][x] = 1; 
				}
			}
		}
		
		//색칠하지 않은 부분
		ArrayList<Integer> sqrCnt = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(square[i][j] == 0) {
					cnt = 0; 
					dfs(i,j);
					sqrCnt.add(cnt);
				}
			}
		}
		Collections.sort(sqrCnt); 


		sb.append(sqrCnt.size()).append('\n'); 
		for(int i : sqrCnt)  {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
	//TD : NEED MEMORAZATION
	static void dfs(int x, int y) {
		square[x][y] = 1;
		cnt ++; 
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx<n && 0<=ny && ny < m) {
				if(square[nx][ny] == 0) {
					dfs(nx,ny);
				}
			}
		}
	}

}