
// 백준 14891번: 톱니바퀴 (Gold 5)
import java.util.*;
import java.io.*;

public class BaekJoon_14891 {
    static final int GEAR_COUNT = 4;
    static final int GEAR_DTL_COUNT = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
         * 입력 구조
         * 1. 1번 톱니바퀴
         * 2. 2번 톱니바퀴
         * 3. 3번 톱니바퀴
         * 4. 4번 톱니바퀴
         * 5. 총 회전 횟수(1 ~ 100)
         * 6. 각 회전 방법 - 총 회전 횟수에 따라 변동 됨(첫번째 : 톱니바퀴 번호, 두번째 : 방향 1은 시계, -1은 반시계)
         */

        // 입력 처리 1~4번 톱니바퀴 정보 저장
        int[][] gearInfo = new int[GEAR_COUNT][GEAR_DTL_COUNT];

        if (st.hasMoreElements()) {
            for (int i = 0; i < GEAR_COUNT; i++) {
                // 톱니정보가 공백이 없음. br.readLine으로 한 라인씩 저장해야함
                // st = new StringTokenizer(br.readLine());
                String gearInfoLine = br.readLine();
                for (int j = 0; j < GEAR_DTL_COUNT; j++) {
                    gearInfo[i][j] = gearInfoLine.charAt(j) - '0'; // ASCII를 활용한 문자 > 숫자 변환 꿀팁!!!
                }
            }
        }

        // 회전 횟수 저장
        st = new StringTokenizer(br.readLine());
        int rotateCount = Integer.parseInt(st.nextToken());

        // rotateGear 재귀함수 만들기
        for (int i = 0; i < rotateCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotateGear(gearNum, direction);
        }
    }

    public static void rotateGear(int gearNum, int direction) {
        // 1. 입력받은 기어를 direction에 맞게 회전시킨다(배열의 값을 이동시킴)
        // 2. 입력받은 기어의 양옆의 기어가 몇 번인지 확인한다.
        // 3. 현재기어 2번 인덱스 값과 왼쪽 기어 6번 인덱스 값을 확인
        // 3-1. 값이 같으면 처리 로직 없음
        // 3-2. 값이 다르면, 왼쪽 기어를 입력받은 Direction의 반대로 회전시킨다
        // 3-2-1. 재귀를 통해 2번으로 이동하여 다시 로직 수행
        // 4. 현재기어 6번 인덱스 값과 오른쪽 기어 2번 인덱스 값을 확인
        // 4-1. 값이 같으면 처리 로직 없음
        // 4-2. 값이 다르면, 왼쪽 기어를 입력받은 Direction의 반대로 회전시킨다
        // 4-2-1. 재귀를 통해 2번으로 이동하여 다시 로직 수행
        // 5. 재귀함수의 종료는 양옆에 더 이상 회전시킬 수 있는 톱니가 없을 때 까지를 조건으로 한다.
    }
}
