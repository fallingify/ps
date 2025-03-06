import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class kk {
    //테스트 케이스의 범위가 6 <= n <= 1000000
    //백만까지 크기가 10000001 인 배열을 static 으로 생성해야함
    final static int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    //SieveOfEratosthenes : 소수 찾기 
    //소수원소를 체크하여 배열을 반환한다
    //에라토스테네스의 체 : 소수들의 배수는 소수가 아님, 제거
    public static void SieveOfEratosthenes(boolean[] isPrime) {
        Arrays.fill(isPrime, true); //모두 소수로 가정
        isPrime[0] = isPrime[1] = false; 
    
        for(int i=2; i*i <= MAX; i++) { //0, 1 은 소수 아님
            if(isPrime[i]) {
                for(int j=i*i; j<=MAX; j+=i) {
                    isPrime[j] = false; 
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//읽기 용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //쓰기 용

        //소수 찾기 매소드
        SieveOfEratosthenes(isPrime);

        
        //num 이 0이 나올때 까지 실행
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break; 
           
            boolean found = false; 
            for(int i=2; i<=num/2; i++){ //소수 쌍 탐색
                if(isPrime[i] && isPrime[num -i] ) {
                    bw.write(num + " = " + i + " + " + (num - i) + "\n");
                    found = true;
                    break; 
                }
            }

           

            //result의 원소가 0일때는 문제에 해당하는 경우가 없다는 뜻
            if(!found) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }

    

        }
        bw.flush();
        bw.close();  

    }


}
