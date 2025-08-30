import java.util.*;
//올바른 괄호
//스택은 구덩이구조. 선입서눛ㄹ
class Main {
    public String solution(String s1){
        String answer = "YES"; 

        Stack<Character> sk = new Stack<>(); 

        for(char c : s1.toCharArray()) {
            if(c == '(') { //여는 괄호이면 푸시 
               sk.push(c); 
            } else { //닫는 괄호이면 팝
                if(sk.isEmpty()) { //이상한 경유 
                    return "NO"; 
                }
                sk.pop(); //비어있지 않은경우 팝시킨다. 
            }
            //닫는 괄호보다 여는 괄호가 많은 경우 
           

        } //비어있지 않으면 문제 
        if(!sk.isEmpty()) {
            return answer = "NO"; 
        }   

        return answer; 
        
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 

        String n = kb.next(); 
        System.out.println(T.solution(n)); 


    }
}