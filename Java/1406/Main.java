import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException, InputMismatchException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        // Split the initial string into characters and push to the left stack
        for (char ch : str.toCharArray()) {
            left.push(String.valueOf(ch));
        }

        // Process each command
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char operation = command.charAt(0);

            switch (operation) {
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    char ch2 = command.charAt(2);
                    left.push(String.valueOf(ch2));
                    break;
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        
        StringBuilder result = new StringBuilder();
        while (!right.isEmpty()) {
            result.append(right.pop());
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
