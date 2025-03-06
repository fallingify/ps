

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String num : input) {
            int number = Integer.parseInt(num);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String query : arr) {
            int number = Integer.parseInt(query);
            sb.append(map.getOrDefault(number, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
