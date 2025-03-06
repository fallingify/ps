import java.util.Scanner;

public class Main {
    public static int[] queue;
    public static int size = 0;
 
    public static void main(String[] var0) {
       Scanner scanner = new Scanner(System.in);
       StringBuilder sb = new StringBuilder();
       int N = scanner.nextInt();

       queue = new int[N];
 
       for(int i = 0; i < N; ++i) {
          switch (scanner.next()) {
             case "push":
                push(scanner.nextInt());
                break;
             case "pop":
                sb.append(pop()).append('\n');
                break;
             case "size":
                sb.append(size()).append('\n');
                break;
             case "empty":
                sb.append(empty()).append('\n');
                break;
             case "front":
                sb.append(front()).append('\n');
                break;
             case "back":
                sb.append(back()).append("\n");
                break;

          }
       }
 
       System.out.println(sb);
    }
 


    public static void push(int item) {
        queue[size] = item;
        ++size;
     }
  
     public static int pop() {
        if (size == 0) {
           return -1;
        } else {
           int item = queue[0];
           for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
            }
           queue[size - 1] = 0;
           --size;
           return item;
        }
     }
  
     public static int size() {
        return size;
     }
  
     public static int empty() {
        return size == 0 ? 1 : 0;
     }
  
     public static int front() {
        return size == 0 ? -1 : queue[0];
     }

     public static int back() {
        return size == 0 ? -1 : queue[size-1];
     }
  
}
