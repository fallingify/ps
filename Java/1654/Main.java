import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 랜선 자르기  - 이분 탐색
 * -> 사용할 N개의 랜선이 필요
 * -> 이미 가지고 있는 랜선 k개, 이 랜선의 길이는 상이함
 * -> N개를 만들때 이떄의 랜선의 길이
 * -> 이분탐색 : 구간 내의 중앙 위치의 값을 기준으로 key 값과 비교한 뒤, 상한선을 내릴 것인지, 하한선을 올릴 것인지 
 * --> mid = (lower + high) / 2
 * 
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 

        int K = Integer.parseInt(st.nextToken()); //k개의 랜선이 있고 4
        int N = Integer.parseInt(st.nextToken()); //동일한 길이의 랜선 n개를 만들려고 한다. 11

        //이떄 랜선의 길이를 최대로 하는 길이를 구하기 위해 
        int[] arr = new int[K]; //입력값을 담기 위한 배열 802, 743, 457, 539
        long max = 0; 
        

        //반복을 통해 랜선의 개수가 11개이면서 길이는 최대이어야하므로 
        //길이를 먼저 주고, 랜선의 개수가 11개인지 아닌지 판단한다. 
        //11개이면, 다른 시도를 통해 다른 경우에서 최대값이 존재하는지를 판단한다. 
        //이때는 이분탐색을 사용해야한다. 
        //원래 이분탐색에서는 특정값에 대한 배열 특정 인덱스였지만, 내가 해야할 것은 길이를 찾는것이다. 
        //이따라서 이분탐색에서의 범위는 인덱스가 아닌 랜선의 길이를 의미한다. 

        //입력과 동시에 해당 랜선의 길이가 최대값인지 확인하고 max를 갱신한다. 
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
            if(max < arr[i]) {
                max = arr[i]; 
            }
        }

        //배열의 이분탐색과 비교해보면, 배열에서 이분탐색을 할 때, 중간값은 인덱스의 lo, hi의 중앙 인덱스를 참조했다. 
        //여기서는 랜선의 길이이므로 똑같이 사용할 수 있다. 구해야할 중간값은 중간길이인 셈이다. 
        //그 다음으로 중요한 것은 어떤 것을 기준으로 범위를 좁힐지이다. 배열의 경우 특정 값이 key값과 각 순회단게에서 
        //구해진 mid값을 통한 arr[mid]의 비교를 통해 lo나 hi를 좁혀나갔다. 
        //여기서는 key값이 입력값N이다. 즉 만들고자 하는랜선의 개수이다. 
        //배열에서는 원소 값을 비교했다면, 이 문제에서는 개수 비교이다. 

        max++; //max에서 +1
        long min = 0; 
        long mid = 0; 

        //정리하면, 배열에서는 특정 값에 대한 특정 인덱스를 찾는 것이라면, 여기서는 특정 개수에 대한 특정길이를 찾는 것이다. 

        //이분탐색방법에는 2개 방식이 있는데, 상한upperbound 하한lowerbound이다.
        //상한은 특정 값을 초과하는 첫 위치를 반환
        //하한은 특정 값 이상인 첫 위치를 반환
        //여기서 중요한 것은 배열에 중복값이 있는 경우이다. [2, 3, 4, 4, 6]이때 상한은 6(인덱스4), 하한은 4(인덱스2)가된다. 
        //따라서 중복 원소에서 가장 끝 값을 찾고자 하면 upperbound - 1로 하면된다. 
        //가장 왼쪽 값을 찾으면 그냥 반환하면 된댜. 여기서는 최대 길이를 찾아야하므로 uppperbound - 1로 한다. 

        //0만 있다면, min=0 max=0이되어 이분탐색을 수행하지 않으며
        //upperbound 리턴값은 1
        //해결방법은 자연수탐색범위를 0~max+1
        //입력받는 랜선의 최대길이를 +1을 max값으로 잡아야한다. 

        //이분탐색
        while(min < max) { //min과 max가 같아질 때까지 반복, min=0, max는 입력값중 가장 긴것으로 한다. 

            mid = (max + min) / 2; //중간길이(중간을 구한다) 

            // mid = (max + min) / 2 여기에서 중간값을 구할때 값의 범위가 크면 overflow가 될 수 있다. 
            // 중간 지점 = 시작점 + (거리 차) / 2
            long count = 0; 

            //1)개수카운드하기 
            //구해진 중간 길이를 잘러서  몇개의 랜선이 나오는지 구한다. 
            for(int i=0; i<arr.length; i++) { 
                count += (arr[i]/mid); 
            }

            //2)upperbound형식의 이분탐색이다. 최대 길이구하기 
            //mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
            //자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다. 
            //그외 잘라야하는 길이를 늘려야 하므로 최소 길이를 늘린다. 
            if(count < N){
                max = mid;  
            } else { //중복원소의 경우 else에서 처리된다
                min = mid + 1; 
            }
        }

        //uppderbound로 얻어진 값에 -1의 최대 길이가 된다. 
        System.out.println(min - 1);
    }
}