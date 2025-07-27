import java.util.*; 

class Main {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>(); 
        for(String x : str) {
            char[] s = x.toCharArray(); 
            //문자배열로 만들어 인덱스 사용해서 적용하기 
            //lt, rt = length - 1
            //lt <  rt 이면 lt++, rt--
            int lt = 0, rt = x.length() -1; 
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt]; 
                s[rt] = tmp; 
                lt++; 
                rt--; 
            }
            String tmp = String.valueOf(s); 
            answer.add(tmp); 
        }

        return answer; 
    }

    public static void main(String[] args){
        Main T = new Main();    
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = kb.next(); 
        }
        for(String x : T.solution(n, str)) {
            System.out.println(x);

        }
        
    }


}