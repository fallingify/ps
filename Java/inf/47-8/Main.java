import java.util.*; 
//응급실
//Person 엔티티로 활용한다. 엔티티를 큐에 넣고 priority를 비교한다. 
class Person {
    int id; 
    int priority; 
    public Person(int id, int priority) {
        this.id = id; 
        this.priority = priority; 
    }
}

class Main{
    public int solution(int[] arr, int n, int m) {
        int answer = 0;  
        Queue<Person> q = new LinkedList<>(); 
        for(int i=0; i<n; i++) {
            q.add(new Person(i, arr[i])); 
        }
        //큐를 돌린다.
        while(!q.isEmpty()) {
            Person tmp = q.poll(); //맨 앞
            for(Person p : q) { // 그다음앞 
                if(p.priority > tmp.priority) {
                    q.offer(tmp); //맨뒤로 다시 삽입한다.
                    tmp = null; 
                    break; 
                } // 다시 돌린다.
            }
            if(tmp != null) {
                answer++; 
                if(tmp.id == m) return answer; 
            }
        }
        return answer; 
    }

    public static void main(String[] args) {
        Main T = new Main(); 
        Scanner kb = new Scanner(System.in); 
        int n = kb.nextInt(); 
        int[] arr = new int[n]; 
        int m = kb.nextInt(); 
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt(); 
        }
        System.out.println(T.solution(arr, n, m)); 

    }
}