import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        // 시작점 (aX1, aY1) → 끝점 (aX2, aY2)
        double aX1 = Double.parseDouble(st.nextToken());
        double aY1 = Double.parseDouble(st.nextToken());
        double aX2 = Double.parseDouble(st.nextToken());
        double aY2 = Double.parseDouble(st.nextToken());

        // 시작점 (cX1, cY1) → 끝점 (cX2, cY2)
        double cX1 = Double.parseDouble(st.nextToken());
        double cY1 = Double.parseDouble(st.nextToken());
        double cX2 = Double.parseDouble(st.nextToken());
        double cY2 = Double.parseDouble(st.nextToken());

        // 민호의 이동 벡터 (속도 벡터)
        double vaX = aX2 - aX1;
        double vaY = aY2 - aY1;

        // 강호의 이동 벡터 (속도 벡터)
        double vcX = cX2 - cX1;
        double vcY = cY2 - cY1;

        // 상대 속도 벡터: 민호 - 강호
        double dx = vaX - vcX;
        double dy = vaY - vcY;

        // 시작점 간 위치 벡터: 민호 - 강호
        double px = aX1 - cX1;
        double py = aY1 - cY1;
        
        // 거리 제곱 함수의 미분 분모
        double denominator = dx * dx + dy * dy;
        double t; 

        // 상대 속도가 0이면(= 항상 같은 거리), t = 0일 때 거리로 고정
        if(denominator == 0) {
            t = 0; 

        } else {
           t = -(px * dx + py * dy) / denominator;
            t = Math.max(0, Math.min(1, t)); 
        }


        // t 시점에 민호와 강호의 좌표 계산
        double ax = aX1 + vaX * t;
        double ay = aY1 + vaY * t;
        double cx = cX1 + vcX * t;
        double cy = cY1 + vcY * t;


         // 두 점 사이 거리 계산 후 출력 (소수점 10자리까지)
        System.out.printf("%.10f\n", getDistance(ax, ay, cx, cy));
    }

    
    // 두 좌표 간의 거리 계산 함수 
    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.hypot(x2 - x1, y2 - y1); // sqrt((x2 - x1)^2 + (y2 - y1)^2)
    }


    
}
