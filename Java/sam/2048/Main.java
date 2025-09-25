import java.util.*; 
import java.io.*; 

//백트래킹
public class Main {
    static int n; 
    static int[][] map; 
    static int answer; 

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine()); 
        map = new int[n][n]; 
        StringTokenizer st; 
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, map[i][j]); 
            }
        }
        
        settle(0); // 5번 이동이 제한됨
        System.out.println(answer); 

    }

    public static void settle(int times){
        if(times >=5) {
            findMax();
            return; 
        }
        int[][] copied = new int[n][n]; 

        //이동전 상태 저장하기 
        for(int i=0; i<n; i++) {
            copied[i] = map[i].clone(); 
        }

        //이동하기 - 북남동서
        for(int dir=0; dir<4; dir++) {
            sum(dir); //게임판기울이기
            settle(times + 1); //재귀, 백트래킹
            for(int i=0; i<n; i++) {  //백트래킹하면 마지막은 돌려놓는다
                map[i] = copied[i].clone(); 
            }
        }
    }

    //북 동 남 서 
    public static void sum(int dir) {
        if(dir == 0) {//북
            for(int c = 0; c<n; c++) {
                LinkedList<Integer> list = new LinkedList<>(); 
                for(int r=0;r<n; r++) {
                    if(map[r][c] != 0) list.add(map[r][c]); 
                    map[r][c] = 0; 
                }
                int idxX = 0; 
                while(!list.isEmpty()) {
                    int cur = list.poll(); 
                    if(!list.isEmpty() && cur == list.peek()) {
                        map[idxX++][c] = cur * 2; 
                        list.poll(); //같으니까 제거 
                    } 
                    else {
                        map[idxX++][c] = cur; //이동
                    }
                }
            }

        }
        else if(dir == 1) {//동
            for(int r=0; r<n; r++) {
                LinkedList<Integer> list = new LinkedList<>(); 
                int idx = 0; 
                for(int c=n-1; c>=0; c--) {
                    if(map[r][c] != 0) list.add(map[r][c]); 
                    map[r][c] = 0; 
                }
                int idxY = n - 1; 
                while(!list.isEmpty()) {
                    int cur = list.poll(); 
                    if(!list.isEmpty() && cur == list.peek()) {
                        map[r][idxY--] = cur * 2; 
                        list.poll(); 
                    } 
                    else {
                        map[r][idxY--] = cur; 
                    }
                }
            }
        }
        else if(dir == 2) {//남
             for(int c = 0; c<n; c++) {
                LinkedList<Integer> list = new LinkedList<>(); 
                for(int r=n-1;r>=0; r--) {
                    if(map[r][c] != 0) list.add(map[r][c]); 
                    map[r][c] = 0; 
                }
                int idxX = n-1; 
                while(!list.isEmpty()) {
                    int cur = list.poll(); 
                    if(!list.isEmpty() && cur == list.peek()) {
                        map[idxX--][c] = cur * 2; 
                        list.poll(); 
                    } else {
                        map[idxX--][c] = cur; 
                    }
                }
            }
        } 
        else {//서
            for(int r = 0; r<n; r++) {
                LinkedList<Integer> list = new LinkedList<>(); 
                for(int c = 0; c<n; c++) {
                    if(map[r][c] != 0) list.add(map[r][c]); 
                    map[r][c] = 0; 
                }
                int idxY = 0; 
                while(!list.isEmpty()) {
                    int cur = list.poll(); 
                    if(!list.isEmpty() && cur == list.peek()) {
                        map[r][idxY++] = cur * 2; 
                        list.poll(); 
                    } else {
                        map[r][idxY++] = cur; 
                    }
                }
            }
        }
    }


    //본게임(북동남서)
    //행렬은 r가 커지면 아래로, c이 커지면 우측으로 넓어짐
    /** 
    public static void move(int dir) {
        switch (dir) {
            case 0: //북 - 상하이동이므로 row를 건드려야 함, 옮겨질장소부터 시작해서 옮긴다. (북 -> 남방향탐색)
                for(int c=0; c < n; c++) {
                    for(int r=0; r<n; r++) {
                        if(map[r][c] == 0) {
                            int delta = 1; 
                            while(r + delta < n) {
                                if(map[r + delta][c] == 0) { //0이면 delta 증가
                                    delta = delta + 1; 
                                    continue; 
                                }
                                if(map[r + delta][c] != 0) { //원소가 있으면
                                    map[r][c] = map[r + delta][c]; //아래 -> 위(북)이동
                                    map[r + delta][c] = 0; //이동
                                    break;
                                }
                            }
                        }
                    }
                }
                break; 
            case 1://동 - 좌우이동으몰 col을 이동시키는것,옮겨질장소부터 위치시작함(동 -> 서 방향 탐색)
                for(int r=0; r<n; r++){
                    for(int c=n-1; c>=0; c--) {
                        if(map[r][c] == 0) {
                            int delta = 1; 
                            while(c - delta >= 0) {
                                if(map[r][c - delta] == 0) {//0이면 delta 증가
                                    delta = delta + 1; 
                                    continue; 
                                }
                                if(map[r][c - delta] != 0) { //원소가 있으면
                                    map[r][c] = map[r][c - delta]; //이동
                                    map[r][c - delta] = 0; //이동
                                    break;
                                }

                            }
                        }
                    }
                }
                break; 
            case 2: //남 - (북과 반대방향으로 탐색), 옮겨질 장소에서 시작함. (남 -> 북 방향 탐색)
                for(int c=0; c<n; c++) {
                    for(int r=n-1; r>=0; r--) {
                        if(map[r][c] == 0) {
                            int delta = 1; 
                            while(r - delta >= 0) {
                                if(map[r - delta][c] == 0) { //비어있는값이면 delta를 늘린다.
                                    delta = delta + 1; 
                                    continue; 
                                }
                                if(map[r - delta][c] != 0) {
                                    map[r][c] = map[r - delta][c]; 
                                    map[r - delta][c] = 0; 
                                    break; 
                                }
                            }

                        }
                        
                    }
                }
                break; 
            case 3: //서 -동과 반대로 함, 이동될 위치에서 시작하며 탐색한다(서 -> 동)
                 for(int r=0; r<n; r++){
                    for(int c=0; c<n; c++) {
                        if(map[r][c] == 0) {
                            int delta = 1; 
                            while(c + delta >= 0) {
                                if(map[r][c + delta] == 0) {//0이면 delta 증가
                                    delta = delta + 1; 
                                    continue; 
                                }
                                if(map[r][c + delta] != 0) { //원소가 있으면
                                    map[r][c] = map[r][c + delta]; //이동
                                    map[r][c + delta] = 0; //이동
                                    break;
                                }

                            }
                        }
                    }
                }
                break; 
        }
    }
    */
    


    //최대값 구하기  
    public static void findMax() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer = Math.max(answer, map[i][j]); 
            }
        }
    }
    






}