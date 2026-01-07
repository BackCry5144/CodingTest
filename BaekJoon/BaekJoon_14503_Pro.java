
// 백준 14503번: 로봇 청소기 - Pro Version
import java.util.*;
import java.io.*;

/**
 * 1. 로봇 청소기의 상태(좌표, 방향)와 행동(이동, 회전, 청소)을 캡슐화한 Robot 클래스 정의
 * 2. 방의 상태와 좌표 유효성 검사를 담당하는 Grid 클래스 정의
 * 3. 가독성을 위해 방향(Direction) 상수를 의미 있게 정의
 */
public class BaekJoon_14503_Pro {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);

        int n = fr.nextInt();
        int m = fr.nextInt();

        int r = fr.nextInt();
        int c = fr.nextInt();
        int d = fr.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = fr.nextInt();
            }
        }

        // 로봇 청소기 구동 시뮬레이터 실행
        CleaningSimulator simulator = new CleaningSimulator(n, m, map);
        int result = simulator.run(r, c, d);

        System.out.println(result);
    }
}

class CleaningSimulator {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int CLEANED = 2;

    // 북, 동, 남, 서 (0, 1, 2, 3) 순서에 따른 dr, dc
    private static final int[] DR = { -1, 0, 1, 0 };
    private static final int[] DC = { 0, 1, 0, -1 };

    private final int n, m;
    private final int[][] grid;

    public CleaningSimulator(int n, int m, int[][] grid) {
        this.n = n;
        this.m = m;
        this.grid = grid;
    }

    public int run(int startR, int startC, int startDir) {
        int r = startR;
        int c = startC;
        int d = startDir;
        int cleanCount = 0;

        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (grid[r][c] == EMPTY) {
                grid[r][c] = CLEANED;
                cleanCount++;
            }

            // 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            boolean hasEmptySpace = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + DR[i];
                int nc = c + DC[i];
                if (isValid(nr, nc) && grid[nr][nc] == EMPTY) {
                    hasEmptySpace = true;
                    break;
                }
            }

            if (hasEmptySpace) {
                // 3. 현재 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                for (int i = 0; i < 4; i++) {
                    // 반시계 방향으로 90도 회전
                    d = (d + 3) % 4;
                    int nr = r + DR[d];
                    int nc = c + DC[d];

                    // 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                    if (isValid(nr, nc) && grid[nr][nc] == EMPTY) {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
            } else {
                // 2. 현재 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                // 바라보는 방향을 유지한 채로 한 칸 후진
                int br = r - DR[d];
                int bc = c - DC[d];

                // 후진할 수 있다면 (벽이 아니라면) 후진
                if (isValid(br, bc) && grid[br][bc] != WALL) {
                    r = br;
                    c = bc;
                } else {
                    // 후진할 수 없다면 작동을 멈춘다
                    break;
                }
            }
        }

        return cleanCount;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
