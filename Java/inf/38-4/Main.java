import java.util.*; 
//애나그램 찾기 
// 애나그램인데 원소구성만 동일하면됨
//슬라이싱 윈도우 사용
//투포인터 

class Main {
    public int solution(String s1, String s2) {
        int answer = 0, lt = 0; 
        int len = s2.length() - 1; 

        HashMap<Character, Integer> amap = new HashMap<>();  //는 비교대상
        HashMap<Character, Integer> bmap = new HashMap<>();  //는 기준

        for(char x : s2.toCharArray()) {
            bmap.put(x, bmap.getOrDefault(x, 0) + 1); 
        }

        for(int i=0; i<len; i++) {
           amap.put(s1.charAt(i), amap.getOrDefault(s1.charAt(i), 0) + 1); 
        }


        //시작점은 len부터 시작함
        //해시맵에는 키를 문자, 값을 개수로 넣음, 이떄 키는 주어진 문자열을 넣음
        for(int rt = len; rt< s1.length(); rt++) {
            amap.put(s1.charAt(rt), amap.getOrDefault(s1.charAt(rt), 0) + 1); 
            if(amap.equals(bmap)) answer++;  // 참이면 아나그램이다. 

            // rt를 증가시켰으면 lt도 이동해야한다. lt를 이동시키고 하나를 추가한디. 
            amap.put(s1.charAt(lt), amap.get(s1.charAt(lt)) - 1); 
            
            //bmap과 비교했을때 없는 문자열이면 remove해야하는데 lt를 뺸다.
            if(amap.get(s1.charAt(lt)) == 0) amap.remove(s1.charAt(lt)); 
            //lt를 하나 이동시킨다.
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
