import java.util.*; 

class Main {
    public int solution(String s1) {
        int answer = 0;   

        Stack<Integer> sk = new Stack<>(); 
        for(char x : s1.toCharArray()) {
            if(Character.isDigit(x)) sk.push(x - 48); 
            else {
                int rt = sk.pop(); 
                int lt = sk.pop(); 
                if(x == '+') sk.push(lt + rt); 
                if(x == '-') sk.push(lt - rt); 
                if(x == '*') sk.push(lt * rt); 
                if(x == '/') sk.push(lt / rt); 


            }

        }
        answer = sk.get(0); 
    
        return answer; 


    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        String str = kb.next(); 
        System.out.println(T.solution(str));

    }

}