import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/**
가운데를 말해요 중간값 선정
짝수개면 중간에 위치한 2개중 작은값을 리턴한다
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    
    }
}   
    
