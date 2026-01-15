// 백준 2178번: 미로 탐색 (Silver 1)
package BaekJoon_Practice.Silver;

import java.io.*;
import java.util.*;

public class BaekJoon_2178 {
    // 하, 우, 상, 좌
    private static final int[] dirRow = { 0, 1, 0, -1 };
    private static final int[] dirCol = { 1, 0, -1, 0 };
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N+1*M+1 배열 생성(0안 쓸거임!)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        moveBFS(0, 0);
    }

    static void moveBFS(int startRow, int startCol) {
        // 시작하면 노드 방문 표시
        visited[startRow][startCol] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });

        while (!queue.isEmpty()) {
            int[] curLocation = queue.poll();
            int newRow = curLocation[0];
            int newCol = curLocation[1];

            if (canMove(newRow, newCol)) {
                visited[newRow][newCol] = true;
                queue.offer(new int[] { newRow, newCol });

            }
        }
    }

    static void moveDFS() {

    }

    static boolean canMove(int row, int col) {

        if (row < 0 || row < N || col < 0 || col < M) {
            return false;
        }

        if (visited[row][col] || A[row][col] == 0) {
            return false;
        }
        return true;
    }
}
