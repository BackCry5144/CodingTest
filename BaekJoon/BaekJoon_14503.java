
// 백준 14503번: 로봇 청소기 (Gold 5)
import java.util.*;
import java.io.*;

public class BaekJoon_14503 {
    public static void main(String[] args) throws IOException {
        // 여기에 로봇 청소기 풀이를 작성할 예정입니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄을 읽어와서 공백으로 나눔

        // 방 크기 저장
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] room = new int[n][m];
        int cleanRoomCnt = 0;

        // 청소기 위치 저장
        st = new StringTokenizer(br.readLine());
        int curRow = Integer.parseInt(st.nextToken()); // Row
        int curCol = Integer.parseInt(st.nextToken()); // Column
        int curDirection = Integer.parseInt(st.nextToken());

        // 방 상태 저장(벽 or 청소 안됨)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4방향 row, Column값
        int[] dirRow = { -1, 0, 1, 0 };
        int[] dirCol = { 0, 1, 0, -1 };

        // 청소기의 현재 위치를 청소
        room[curRow][curCol] = 2;
        cleanRoomCnt++;

        while (true) {

            // 1. 현재 위치가 청소가 안 되어 있으면 청소한다.
            if (room[curRow][curCol] == 0) {
                room[curRow][curCol] = 2;
                cleanRoomCnt++;
            }

            // 4 방향 중 청소가 안된 방이 있는지 검색
            boolean found = false;
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dirRow[i];
                int nextCol = curCol + dirCol[i];

                // 다음 좌표가 마이너스가 아니고, 방크기보다는 작아야함.
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                    if (room[nextRow][nextCol] == 0) {
                        found = true;
                        break;
                    }
                }
            }

            // 청소를 안한 방이 있다!
            if (found) {
                // 반시계 방향 90도 회전한 NextRoom 좌표 계산
                curDirection = (curDirection + 3) % 4; // 90도 회전 방향

                // 현재 위치에서 90도 회전한 방향의 좌표 계산
                int nextRow = curRow + dirRow[curDirection];
                int nextCol = curCol + dirCol[curDirection];

                // 정면이 빈칸이면 전진
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                        && room[nextRow][nextCol] == 0) {
                    curRow = nextRow;
                    curCol = nextCol;
                }
            } else {
                // 후진 방향 좌표 계산
                int backRow = curRow - dirRow[curDirection];
                int backCol = curCol - dirCol[curDirection];

                // 후진 방향이 벽이면 종료
                if (room[backRow][backCol] == 1) {
                    break;
                } else {
                    curRow = backRow;
                    curCol = backCol;
                }
            }
        }

        System.out.println(cleanRoomCnt);
    }
}
