import java.util.*; 
import java.io.*; 

class Main {
    static int n;
    static String str; 
    static int story;  // 건물 층수 
    static int from; //출발 층수 
    static int to; //도착 층수 
    static int up; //한번에 올라가는 층수 
    static int down; //한번에 내려가는 층수 
    static int dist; 
    static int cnt; 

    public static void main(String[] args) throws IOException{
        new Main().run(); 
    }

    static void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        story = Integer.parseInt(st.nextToken()); 
        from = Integer.parseInt(st.nextToken()); 
        to = Integer.parseInt(st.nextToken()); 
        up = Integer.parseInt(st.nextToken()); 
        down  = Integer.parseInt(st.nextToken()); 


        if(to > from) {
            dist = to - from; 
            cnt = 1; 
            while(dist > up * cnt && up > 0) {  
                cnt++; 
            } 
            dist = up * cnt - dist; 

            int count = 1; 
            while(dist >= down*count && down > 0 && dist > 0) {
                dist -= down*count;   
                if(dist == 0) {
                    cnt += count; 
                    break; 
                }
                cnt++; 
                count++;  
            }

        } 
        if (to < from){
            dist = from - to; 
            cnt = 1; 
            while(dist > down * cnt && down > 0) {
                cnt++; 
            }     
            dist = down * cnt - dist; 
            int count = 1;
            while(dist >= up * count && up > 0 && dist > 0) {
                dist -= up* count; 
                if(dist == 0) {
                    cnt += count; 
                    break; 
                }
                cnt++; 
                count++; 
            }
        } 

        if(dist == 0){
            System.out.println(cnt); 
        } else {
            System.out.println("use the stairs"); 
        }
       

    }



}