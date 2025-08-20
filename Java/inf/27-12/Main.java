import java.util.*; 
//멘토링
class Main {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0; 

        for (int i = 1; i <= n; i++) {          // 멘토 후보 (학생 번호 1..n)
            for (int j = 1; j <= n; j++) {      // 멘티 후보
                int cnt = 0; 
                for (int k = 1; k <= m; k++) {  // 시험 수 (1..m)
                    int pi = 0, pj = 0; 
                    for (int s = 1; s <= n; s++) { // 등수/순위 (1..n)
                        if (arr[k][s] == i) pi = s; 
                        if (arr[k][s] == j) pj = s; 
                    }
                    if (pi < pj) cnt++; 
                }
                if (cnt == m) answer++;  
            }
        }
        return answer; 
    }



    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int m = kb.nextInt(); 

        int[][] arr = new int[m + 1][n + 1]; 
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr)); 

    }


}