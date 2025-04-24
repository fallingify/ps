import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
 /**
    나이순 정렬

    온라인 저지에 가입한 사람들의 나이와 이름이 가입한
    순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로,
    나이가 같으면 먼저 가입한 사람이 앞에
    오는 순서로 정렬하는 프로그램을 작성하시오.

  */
    static class Member{
        int age; 
        String name; 

        Member(int age, String name){
            this.age = age;
            this.name = name; 
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 


        ArrayList<Member> list = new ArrayList<>();  //동적할당된다. 
        int n = Integer.parseInt(br.readLine()); 

        while(n-- > 0){
            st = new StringTokenizer(br.readLine()); 
            int age = Integer.parseInt(st.nextToken()); 
            String name = st.nextToken(); 
    
            list.add(new Member(age, name)); 
        }

        Collections.sort(list,
            new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2){
                if(o1.age == o2.age) {
                    return 0; // 입력받은 그대로 
                }
                return o1.age - o2.age;  //오름차순
                
                }
            }
        ); 
        
        for (Member member : list) {
            System.out.println(member.age + " " + member.name);
        }

        
    }//end of Main
} //end of Main
            