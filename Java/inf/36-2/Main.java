import java.util.*; 
//아나그램 
//해시맵 사용
//왜 map.put(x, map.get(x)-1);  -1을 하는건지 이해가 안된다. 
class Main {
    public String solution(String str1, String str2) {
        String answer = "YES"; 
        HashMap<Character, Integer> map = new HashMap<>(); 

        for(char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+ 1); 

        }
        for(char x : str2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) {
                return "NO";

            }
            map.put(x, map.get(x)-1); 
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