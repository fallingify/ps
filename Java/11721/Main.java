import java.io.*; 


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();


        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() == 10){
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.println(sb);
        br.close();

    }
}
