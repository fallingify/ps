import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // StringBuilder sb =new StringBuilder();

        for(int i=1; i<=t; i++) {
            for(int j=1; j<=t-i; j++){
                // sb.append(" ");
                System.out.printf(" ");

            } //공백출력 id와 반대 

            for(int j=1; j<=2*i-1; j++){
                if(i == t){
                    // sb.append("*");
                    System.out.printf("*");
                }  //맨마지막 줄
                else{
                    if(j ==1 || j== (2*i-1)) { 
                        // sb.append("*");
                        System.out.printf("*");
                    } //홀수번째는 별 출력
                    else {
                        // sb.append(" ");
                        System.out.printf(" ");
                    } //짝수번째는 공백 출력
                } //첫 줄부터 마지막줄-1까지 출력
           
                
            }
            // sb.append("\n");
            System.out.println(); //줄 바꿈
            // System.out.println(sb);


            br.close(); //버퍼 닫기 




        }

        
    }
}