// 백준 21608번: 상어 초등학교 (Gold 5)
package BaekJoon_Practice.Gold;

// 핵심 알고리즘: 구현 (Simulation)
import java.util.*;
import java.io.*;

public class BaekJoon_21608 {

    static int N;
    static int N2;
    static int[] order; // 앉는 순서
    static int[][] favorites; // 좋아하는 짝궁 정보
    static int[][] A; // 정답

    // 상,하,좌,우 좌표정의
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N * N
        N = Integer.parseInt(st.nextToken());
        N2 = N * N;
        // 정답 배열 초기화
        A = new int[N][N];

        order = new int[N2];
        favorites = new int[N2 + 1][4]; // Favorites는 1번부터 써보자

        for (int i = 0; i < N2; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;

            for (int j = 0; j < 4; j++) {
                favorites[student][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(calculateScore());
    }

    public static void solve() {
        // 순서대로 한명 씩 앉혀야함.
        for (int i = 0; i < N2; i++) {
            int curStudent = order[i];
            int[] favoriteStudents = favorites[curStudent];

            findSeat(curStudent, favoriteStudents);

        }
    }

    public static void findSeat(int curStudent, int[] favoriteStudents) {
        // 여기서 4방향으로 탐색이 필요할 것 같음
        // 빈자리가 아니면 다음으로,
        // 재귀를 통해 모든 자리를 순회하면서 각 자리에 점수를 메기고,
        // 가장 높은 점수 자리를 반환하도록 만든다.

        int bestR = -1, bestC = -1;
        int maxFavorites = -1; // 최대 인접 좋아하는 학생 수
        int maxEmpty = -1; // 최대 인접 빈 칸 수
        // 1. 모든 칸을 순회
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 빈자리가 아니면 패스
                if (A[r][c] != 0)
                    continue;
                int favCount = 0;
                int emptyCount = 0;
                // 2. 4방향 탐색하여 점수 계산
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i]; // 방향 배열 dx, dy 필요
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if (A[nr][nc] == 0) {
                            emptyCount++;
                        } else {
                            // 인접한 학생이 좋아하는 학생인지 확인
                            for (int fav : favoriteStudents) {
                                if (A[nr][nc] == fav) {
                                    favCount++;
                                    break;
                                }
                            }
                        }
                    }
                }
                // 3. 우선순위에 따라 자리 갱신 (조건 1 -> 조건 2 순서)
                if (favCount > maxFavorites) {
                    maxFavorites = favCount;
                    maxEmpty = emptyCount;
                    bestR = r;
                    bestC = c;
                } else if (favCount == maxFavorites) {
                    if (emptyCount > maxEmpty) {
                        maxEmpty = emptyCount;
                        bestR = r;
                        bestC = c;
                    }
                }
                // 조건 3, 4는 r, c 반복문 순서에 의해 자동으로 처리됨
            }
        }

        // 최종 선정된 자리에 학생을 앉힘
        A[bestR][bestC] = curStudent;
    }

    public static int calculateScore() {
        int totalScore = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int student = A[r][c];
                int[] favoriteStudents = favorites[student];
                int favCount = 0;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        for (int fav : favoriteStudents) {
                            if (A[nr][nc] == fav) {
                                favCount++;
                                break;
                            }
                        }
                    }
                }

                if (favCount == 1)
                    totalScore += 1;
                else if (favCount == 2)
                    totalScore += 10;
                else if (favCount == 3)
                    totalScore += 100;
                else if (favCount == 4)
                    totalScore += 1000;
            }
        }
        return totalScore;
    }
}
