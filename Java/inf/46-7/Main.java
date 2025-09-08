import java.util.*;

class Main {
    public String solution(String s1, String s2){
        String answer = "YES"; 
        Queue<Character> q = new LinkedList<>();
    
        for(char c : s1.toCharArray())  {
            q.offer(c); 
        }
        for(char c : s2.toCharArray()) {
            if(q.contains(c)) {
                if(c != q.poll()) {
                    return "NO"; 
                }
            }
        }
        if(!q.isEmpty()) {
            return "NO"; 
        }

        return answer; 
    }


    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        String str1 = kb.next(); 
        String str2 = kb.next(); 
        System.out.println(T.solution(str1, str2));    
    }
}
