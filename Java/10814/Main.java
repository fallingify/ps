import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
국영수 

성적높은순서대로 정렬한다.

1. 국어 점수가 감소하는 순서로
2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 
(단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)


 */
public class Main {

    static class Student{
        String name; 
        int kor; 
        int eng; 
        int math; 

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor; 
            this.eng = eng; 
            this.math = math; 
        }
    }

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       StringTokenizer st; 

       ArrayList<Student> list = new ArrayList<>(); 
       int N = Integer.parseInt(br.readLine()); 

       while(N-- > 0){
        st = new StringTokenizer(br.readLine()); 
        String name = st.nextToken(); 
        int kor = Integer.parseInt(st.nextToken()); 
        int eng = Integer.parseInt(st.nextToken()); 
        int math = Integer.parseInt(st.nextToken()); 

        list.add(new Student(name, kor, eng, math)); 
       }

       Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2){

                if(o1.kor == o2.kor) {
                    if(o1.eng == o2.eng){
                        if(o1.math == o2.math){
                            return o1.name.compareTo(o2.name); 
                        }
                        return o2.math - o1.math; 
                    }
                    return o1.eng - o2.eng; 
                }
                return o2.kor - o1.kor; 
            }
       }); 

       StringBuilder sb = new StringBuilder();
       for (Student student : list) {
           sb.append(student.name).append('\n');
       }

       System.out.println(sb);


        
        
    }
    
}
