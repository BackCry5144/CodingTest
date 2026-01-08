
// 백준 14891번: 톱니바퀴 (Gold 5)
import java.util.*;
import java.io.*;

public class BaekJoon_14891 {
    static final int GEAR_COUNT = 4;
    static final int GEAR_DTL_COUNT = 8;
    static int[][] gearInfo = new int[GEAR_COUNT][GEAR_DTL_COUNT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        for (int i = 0; i < GEAR_COUNT; i++) {
            // 톱니정보가 공백이 없음. br.readLine으로 한 라인씩 저장해야함
            String gearInfoLine = br.readLine();
            for (int j = 0; j < GEAR_DTL_COUNT; j++) {
                gearInfo[i][j] = gearInfoLine.charAt(j) - '0'; // ASCII를 활용한 문자 > 숫자 변환 꿀팁!!!
            }
        }

        // 회전 횟수 저장
        int rotateCount = Integer.parseInt(br.readLine());
        // rotateGear 재귀함수 만들기
        for (int i = 0; i < rotateCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotate(gearNum - 1, direction);
        }

        int score = 0;
        if (gearInfo[0][0] == 1)
            score += 1;
        if (gearInfo[1][0] == 1)
            score += 2;
        if (gearInfo[2][0] == 1)
            score += 4;
        if (gearInfo[3][0] == 1)
            score += 8;
        System.out.println(score);
    }

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
    public static void rotate(int gearNum, int direction) {
        rotateLeft(gearNum - 1, -direction);
        rotateRight(gearNum + 1, -direction);
        rotateGear(gearNum, direction);
    }

    public static void rotateLeft(int gearNum, int direction) {
        if (gearNum < 0 || gearNum > GEAR_COUNT - 1) {
            return;
        }

        // 오른쪽기어의 3시와 왼쪽기어(현재) 9시의 극 값 체크
        if (gearInfo[gearNum + 1][6] != gearInfo[gearNum][2]) {
            rotateLeft(gearNum - 1, -direction);
            rotateGear(gearNum, direction);
        }
    }

    public static void rotateRight(int gearNum, int direction) {
        if (gearNum > GEAR_COUNT - 1) {
            return;
        }

        // 오른쪽기어의 9시와 왼쪽기어(현재) 3시의 극 값 체크
        if (gearInfo[gearNum - 1][2] != gearInfo[gearNum][6]) {
            rotateRight(gearNum + 1, -direction);
            rotateGear(gearNum, direction);
        }
    }

    // 기어를 회전시키는 알고리즘
    public static void rotateGear(int gearNum, int direction) {
        int[] rotated = new int[GEAR_DTL_COUNT];
        for (int i = 0; i < GEAR_DTL_COUNT; i++) {
            rotated[i] = gearInfo[gearNum][(i - direction + 8) % 8];
        }
        // 계산된 결과를 원본에 덮어쓰기
        gearInfo[gearNum] = rotated;
    }
}
