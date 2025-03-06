import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int N = scanner.nextInt();
        scanner.nextLine();
        
        //String::length : 메소드 참조
        //thenComparing : 추가조합
        Comparator<String> comparator = Comparator
        .comparingInt(String::length)
        .thenComparing(Comparator.naturalOrder());

        TreeSet<String> tree = new TreeSet<String>(comparator);

        for(int i=0; i<N; i++) {
            tree.add(scanner.nextLine());
        }
                    
        for (String string : tree) {
            System.out.println(string);
        }

        
    }
    
}
