import java.util.*; 
//구간별 개수 출력하기 
//구간별 원소의 종류를 출력 -> 해시맵을 사용하면된다.
// 슬라이딩 윈도우 
class Main {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i=0; i<k-1; i++) {
            map.put(arr[i],  map.getOrDefault(arr[i], 0)+ 1); 
        }
        
        int lt = 0;
        for(int rt = k-1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+ 1); 
            answer.add(map.size()); 
            map.put(arr[lt], map.get(arr[lt]) - 1); 
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]); 
            lt++; 
        }
        return answer; 
        
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); int k = kb.nextInt(); 
        int[] arr = new int[n]; 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        for(int x : T.solution(n, k, arr)) {
            System.out.print(x + " "); 

        }

    }

}