import java.util.Scanner;

//10866
//https://www.acmicpc.net/problem/10866

public class Main {
    public static int[] deque;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt(); // Number of commands
        deque = new int[2 * N]; // Allocate space for worst-case scenario

        for (int i = 0; i < N; i++) {
            String command = scanner.next();
            switch (command) {
                case "push_front":
                    push_front(scanner.nextInt());
                    break;
                case "push_back":
                    push_back(scanner.nextInt());
                    break;
                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
        scanner.close();
    }

    public static void push_front(int item) {
        if (size > 0) {
            for (int i = size; i > 0; i--) {
                deque[i] = deque[i - 1];
            }
        }
        deque[0] = item;
        size++;
    }

    public static void push_back(int item) {
        deque[size] = item;
        size++;
    }

    public static int pop_front() {
        if (size == 0) {
            return -1;
        }
        int item = deque[0];
        for (int i = 0; i < size - 1; i++) {
            deque[i] = deque[i + 1];
        }
        size--;
        return item;
    }

    public static int pop_back() {
        if (size == 0) {
            return -1;
        }
        int item = deque[size - 1];
        size--;
        return item;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return size == 0 ? 1 : 0;
    }

    public static int front() {
        return size == 0 ? -1 : deque[0];
    }

    public static int back() {
        return size == 0 ? -1 : deque[size - 1];
    }
}
