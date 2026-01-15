
// 백준 21608번: 상어 초등학교 (Gold 5)
// 핵심 알고리즘: 구현 (Simulation)
import java.util.*;
import java.io.*;

public class BaekJoon_21608 {

    static int N;
    static int N2;
    static int[] order; // 앉는 순서
    static int[][] favorites; // 좋아하는 짝궁 정보
    static int[][] A; // 정답

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

        solve(0, 0);
    }

    public static void solve() {

        // N * N 칸 순회 필요?
        // if 이미 앉은 칸은 넘어가야함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] > 0) { // 0보다 크면, 위치에 앉아있는상태.
                }
            }
        }
        // 조건 1,2,3에 따라 앉을 수 있는 칸을 저장해야할 거 같음

    }
}
