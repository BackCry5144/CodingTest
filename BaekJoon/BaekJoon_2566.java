import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 9 * 9 배열 생성(문제에서 무조건 9*9로 설정함)
        // for문 돌면서 입력 인자 저장
        // 배열을 순회하며, 최대값과 최대값의 좌표 저장(변수 선언 필요)
        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int i = 1; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int curValue = Integer.parseInt(st.nextToken());

                if (max < curValue) {
                    max = curValue;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
