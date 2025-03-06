import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();
        for (String num: input){
            set.add(Integer.parseInt(num));

        }

        List<Integer> srtdList = new ArrayList<>(set);
        Collections.sort(srtdList);

        StringBuffer sb = new StringBuffer();

        for(int item: srtdList){
            sb.append(item).append(" ");
        }

        System.out.println(sb.toString().trim());






        

        




    
    }
    
}
