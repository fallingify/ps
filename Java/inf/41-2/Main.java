import java.util.*; 
// 괄호에 있는 문자를 리턴하는 문제 
class Main {
    public String solution(String s1) {
        String answer = "";  
        Stack<Character> sk = new Stack<>(); 

        for(char x : s1.toCharArray()) {
            if(x == ')') {
                while(sk.pop() != '('); 
            }
            else sk.push(x); 
        }

        for(int i=0; i<sk.size(); i++) {
            answer += sk.get(i); 
        }
        return answer; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        String str = kb.next(); 
        System.out.println(T.solution(str));


    }
}