import java.util.*;     
// 다시 풀기 
// 해시맵 풀이
// 횟수가 많은 문자를 리턴한다. 
class Main {
    public char solution(int n, String s) {
        char answer = ' '; 
        HashMap<Character, Integer> map = new HashMap<>(); 

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }

        int max = Integer.MIN_VALUE; 
        for(char c : map.keySet()) {
            // System.out.println(x);
                if (map.get(c) > max) {
                    max = map.get(c); 
                    answer = c; 
                }
        }
        return answer; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        String str = kb.next(); 
        System.out.println(T.solution(n, str)); 
         
    }
}