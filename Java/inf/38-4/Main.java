import java.util.*; 
//애나그램 찾기 
//슬라이싱 윈도우 사용
//투포인터 

class Main {
    public int solution(String s1, String s2) {
        int answer = 0, lt = 0; 
        int len = s2.length() - 1; 

        HashMap<Character, Integer> amap = new HashMap<>(); 
        HashMap<Character, Integer> bmap = new HashMap<>(); 

        for(char x : s2.toCharArray()) {
            bmap.put(x, bmap.getOrDefault(x, 0) + 1); 
        }

        for(int i=0; i<len; i++) {
           amap.put(s1.charAt(i), amap.getOrDefault(s1.charAt(i), 0) + 1); 
        }


        for(int rt = len; rt< s1.length(); rt++) {
            amap.put(s1.charAt(rt), amap.getOrDefault(s1.charAt(rt), 0) + 1); 
            if(amap.equals(bmap)) answer++; 
            amap.put(s1.charAt(lt), amap.get(s1.charAt(lt)) - 1); 
            if(amap.get(s1.charAt(lt)) == 0) amap.remove(s1.charAt(lt)); 
            lt++; 

        }

        return answer; 


    }
    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        String s1 = kb.next(); 
        String s2 =kb.next(); 
        
        System.out.println(T.solution(s1, s2)); 
    }

}
