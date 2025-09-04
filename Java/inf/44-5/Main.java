import java.util.*; 
//쇠막대기
//() : 레이저는 증가없고 sk의 사이즈를 만든다. 
//( : 는 증가없고 그냥 sk에 넣는다.
//) : 는 +1씩 증가 
class Main {
    public int solution(String s1) {
        int answer = 0; 
        Stack<Character> sk = new Stack<>(); 
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == '(') { //그냥 스택에 넣는다. 
                sk.push('('); 
            } else {
                sk.pop(); //여는 괄호가 아니면 팝한다. 
                if(s1.charAt(i - 1) == '(') answer += sk.size(); //레이저인경우, 이전 원소를 charAt로 구한다. 
                else answer++; //닫는괄호인경우 
            }
        }
        return answer; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        String s1 = kb.next(); 
        System.out.println(T.solution(s1)); 
    }
}