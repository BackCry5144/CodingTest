
// 백준 14503번: 로봇 청소기
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

        // 청소기 위치 저장
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()); // Row
        int col = Integer.parseInt(st.nextToken()); // Column
        int direction = Integer.parseInt(st.nextToken());

        // 방 상태 저장(벽 or 청소 안됨)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소기의 현재 위치를 청소
        room[row][col] = 2;

        while (true) {
            // 주변 4칸 탐색
            int north = room[row - 1][col];
            int south = room[row + 1][col];
            int east = room[row][col + 1];
            int west = room[row][col - 1];

            // 4 방향 중 청소가 안된 방이 있는지 검색
            if (north != 0 || south != 0 || east != 0 || west != 0) {
                // 이제 회전을 하자.
                if (direction == 0) {
                    direction = 3;
                } else {
                    direction = direction - 1;
                }
            }
        }

        // BufferedReader를 사용하여 입력을 받는 연습을 시작합니다.
    }
}
