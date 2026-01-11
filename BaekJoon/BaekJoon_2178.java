
// 백준 2178번: 미로 탐색 (Silver 1)
import java.util.*;
import java.io.*;

public class BaekJoon_2178 {

    // 하, 우, 상, 좌
    private static final int[] dirRow = { 0, 1, 0, -1 };
    private static final int[] dirCol = { 1, 0, -1, 0 };

    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 문제 분석
        // 2. 손으로 풀어보기
        // 3. 슈도 코드 작성
        // 4. 실제 코드 작성

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String L = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = L.charAt(j) - '0';
            }
        }

        solutionBFS(0, 0);
    }

    public static void solutionBFS(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] curLoc = queue.poll();
            int curRow = curLoc[0];
            int curCol = curLoc[1];

            // 상하좌우 탐색 for문
            for (int k = 0; k < 4; k++) {

                // 상하좌우 변환 시 newRow 선언
                int newRow = curRow + dirRow[k];
                int newCol = curCol + dirCol[k];

                if (canMove(newRow, newCol)) {
                    visited[newRow][newCol] = true;
                    // 해당 좌표를 큐에 넣어서 다시 재귀하게 만들어줘야 하는데!!!
                    queue.offer(new int[] { newRow, newCol });
                    // A의 값을 바꾸고...
                    A[newRow][newCol] = A[curRow][curCol] + 1;
                }
            }

            // 상하좌우 각각 이동가능여부 체크
        }

        // 최종 값 출력
        System.out.println(A[N - 1][M - 1]);
    }

    public static boolean canMove(int newRow, int newCol) {

        // 새로운 좌표는 0보다 크고, N/M 보다 작아야함
        if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= M) {
            return false;
        }

        // 새로운 좌표는 이전에 방문하지 않았고, 값이 1이여야만 함
        if (visited[newRow][newCol] || A[newRow][newCol] == 0) {
            return false;
        }

        return true;
    }
}
