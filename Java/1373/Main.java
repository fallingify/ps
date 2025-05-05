import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 
2진수 8진수 

2진수가 주어졌을때, 8진수로 변환하는 프로그램

10000000길이까지 범위가 크다. 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BigInteger N = new BigInteger(br.readLine(), 2); //입력받은 문자열을 2진수로 변환
        String result = N.toString(8); //8진수로변환
        System.out.println(result);

    }
    
}
